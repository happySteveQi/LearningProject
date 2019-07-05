package com.example.learning.ui.main;

import android.os.Bundle;

import com.example.learning.R;
import com.example.learning.base.BaseActivity;
import com.example.learning.base.contract.MainContract;
import com.example.learning.presenter.main.MainPresenter;
import com.example.learning.utils.Constants;

import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    private int hideFragment = Constants.TYPE_ZHIHU;
    private int showFragment = Constants.TYPE_ZHIHU;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            mPresenter.setNightModeState(false);
        } else {
            showFragment = mPresenter.getCurrentItem();
            hideFragment = Constants.TYPE_ZHIHU;

            showHideFragment(getTargetFragment(showFragment));
        }
    }

    private SupportFragment getTargetFragment(int showFragment) {
        return null;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void showUpdateDialog(String versionContent) {

    }

    @Override
    public void startDownloadService() {

    }
}
