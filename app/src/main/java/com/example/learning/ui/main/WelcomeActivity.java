package com.example.learning.ui.main;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.learning.R;
import com.example.learning.base.BaseActivity;
import com.example.learning.base.contract.WelcomeContract;
import com.example.learning.component.ImageLoader;
import com.example.learning.model.bean.WelcomeBean;
import com.example.learning.presenter.main.WelcomePresenter;
import com.example.learning.utils.ToastUtils;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Time:2019/5/31
 * <p>
 * Author:44483
 * <p>
 * Description:
 */
public class WelcomeActivity extends BaseActivity<WelcomePresenter> implements WelcomeContract.View {

    @BindView(R.id.iv_welcome_bg)
    ImageView iv_welcome_bg;
    @BindView(R.id.tv_welcome_author)
    TextView tv_welcome_author;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void showContent(WelcomeBean welcomeBean) {
        ImageLoader.load(this, welcomeBean.getImg(), iv_welcome_bg);
        iv_welcome_bg.animate().scaleX(1.12f)
                .scaleY(1.12f).setDuration(2000).setStartDelay(100)
                .start();
        tv_welcome_author.setText(welcomeBean.getText());
    }

    @Override
    protected void initDataAndEvent() {
        mPresenter.getWelcomeData();
    }

    @Override
    public void jumpToMain() {
        ToastUtils.getSingleton().showToast("Jump to Main Activity !!! ");
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
    }

}
