package com.example.learning.presenter.main;

import com.example.learning.base.BasePresenter;
import com.example.learning.base.BaseView;
import com.example.learning.base.RxPresenter;
import com.example.learning.base.contract.WelcomeContract;
import com.example.learning.model.DataManager;
import com.example.learning.model.bean.WelcomeBean;
import com.example.learning.utils.RxUtils;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.functions.Consumer;

/**
 * Time:2019/5/30
 * <p>
 * Author:44483
 * <p>
 * Description:
 */
public class WelcomePresenter extends RxPresenter<WelcomeContract.View> implements WelcomeContract.Presenter {

    private static final String RES = "1080*1776";

    private static final int COUNT_DOWN_TIME = 2200;

    private DataManager mDataManager;

    @Inject
    public WelcomePresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    @Override
    public void getWelcomeData() {
        addSubscribe(mDataManager.fetchWelcomeInfo(RES)
            .compose(RxUtils.<WelcomeBean>rxSchedulerHelper())
                .subscribe(new Consumer<WelcomeBean>() {
                    @Override
                    public void accept(WelcomeBean welcomeBean) {
                        mView.showContent(welcomeBean);
                        startCountDown();
                    }


                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        mView.jumpToMain();
                    }
                })
        );
    }

    private void startCountDown() {
        addSubscribe(Flowable.timer(COUNT_DOWN_TIME, TimeUnit.MILLISECONDS)
            .compose(RxUtils.<Long>rxSchedulerHelper())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong){
                        mView.jumpToMain();
                    }
                })
        );
    }
}
