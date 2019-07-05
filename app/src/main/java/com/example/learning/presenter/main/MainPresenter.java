package com.example.learning.presenter.main;

import com.example.learning.base.RxPresenter;
import com.example.learning.base.contract.MainContract;
import com.example.learning.component.RxBus;
import com.example.learning.model.DataManager;
import com.example.learning.model.bean.VersionBean;
import com.example.learning.model.event.NightModeEvent;
import com.example.learning.model.http.response.MyHttpResponse;
import com.example.learning.utils.RxUtils;
import com.example.learning.widget.CommonSubscriber;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * Time:2019/6/6
 * <p>
 * Author:44483
 * <p>
 * Description:
 */
public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {
    private DataManager mDataManager;

    @Inject
    public MainPresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    @Override
    public void attachView(MainContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    private void registerEvent() {
        addSubscribe(RxBus.getInstance().toFlowable(NightModeEvent.class)
                .compose(RxUtils.<NightModeEvent>rxSchedulerHelper())
                .map(new Function<NightModeEvent, Boolean>() {
                    @Override
                    public Boolean apply(NightModeEvent nightModeEvent) {
                        return nightModeEvent.getNightMode();
                    }
                })
                .subscribeWith(new CommonSubscriber<Boolean>(mView, "切换模式失败") {

                    @Override
                    public void onNext(Boolean aBoolean) {
                        mView.useNightMode(aBoolean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        registerEvent();
                    }
                })
        );
    }

    public void checkVersion(final String currentVersion) {
        addSubscribe(mDataManager.fetchVersionInfo()
                .compose(RxUtils.<MyHttpResponse<VersionBean>>rxSchedulerHelper())
                .compose(RxUtils.<VersionBean>handleMyResult())
                .filter(new Predicate<VersionBean>() {
                    @Override
                    public boolean test(VersionBean versionBean) throws Exception {
                        return Integer.valueOf(currentVersion.replace(".", "")) < Integer.valueOf(versionBean.getCode().replace(".", ""));
                    }
                })
                .map(new Function<VersionBean, String>() {
                    @Override
                    public String apply(VersionBean versionBean) throws Exception {
                        StringBuilder content = new StringBuilder("版本号：v");
                        content.append(versionBean.getCode())
                                .append("\r\n")
                                .append("版本大小：")
                                .append(versionBean.getSize())
                                .append("\r\n")
                                .append("更新内容：\r\n")
                                .append(versionBean.getDes().replace("\\r\\n", "\r\n"));
                        return content.toString();
                    }
                })
                .subscribeWith(new CommonSubscriber<String>(mView) {
                    @Override
                    public void onNext(String s) {
                        mView.showUpdateDialog(s);
                    }
                })
        );
    }

    @Override
    public void setNightModeState(boolean b) {
        mDataManager.setNightModeState(b);
    }

    @Override
    public void setCurrentItem(int index) {
        mDataManager.setCurrentItem(index);
    }

    @Override
    public int getCurrentItem() {
        return mDataManager.getCurrentItem();
    }

    @Override
    public void setVersionPoint(boolean b) {
        mDataManager.setVersionPoint(b);
    }

    @Override
    public boolean getVersionPoint() {
        return mDataManager.getVersionPoint();
    }

}
