package com.example.learning.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.learning.App;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Time:2019/5/30
 * <p>
 * Author:44483
 * <p>
 * Description:
 */
public abstract class SimpleActivity extends SupportActivity {

    protected Activity mActivity;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
        mActivity = this;
        onViewCreated();
        App.getInstance().addActivity(this);
        initDataAndEvent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().removeActivity(this);
        mUnbinder.unbind();
    }



    protected void onViewCreated(){};

    protected abstract int getLayoutId();
    protected abstract void initDataAndEvent();

}
