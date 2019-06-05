package com.example.learning.base;

import android.support.v7.app.AppCompatDelegate;

import com.example.learning.App;
import com.example.learning.di.component.ActivityComponent;
import com.example.learning.di.module.ActivityModule;
import com.example.learning.di.component.DaggerActivityComponent;

import javax.inject.Inject;

public abstract class BaseActivity<T extends BasePresenter> extends SimpleActivity implements BaseView{

    @Inject
    protected T mPresenter;


    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    protected ActivityComponent getActivityComponent(){
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }
    @Override
    protected void onViewCreated(){
        super.onViewCreated();
        initInject();
        if (mPresenter != null){
            mPresenter.attachView(this);
        }
    }
    @Override
    protected void onDestroy() {
        if (mPresenter != null)
            mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showErrorMsg(String msg) {

    }

    @Override
    public void useNightMode(boolean isNight) {
        if (isNight) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        }
        recreate();
    }

    @Override
    public void stateError() {

    }

    @Override
    public void stateEmpty() {

    }

    @Override
    public void stateLoading() {

    }

    @Override
    public void stateMain() {

    }

    @Override
    protected void initDataAndEvent() {

    }

    protected abstract int getLayoutId();
    protected abstract void initInject();
}
