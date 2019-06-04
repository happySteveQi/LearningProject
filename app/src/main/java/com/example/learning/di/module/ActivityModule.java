package com.example.learning.di.module;

import android.app.Activity;

import com.example.learning.di.component.AppComponent;
import com.example.learning.di.scope.ActivityScope;

import javax.inject.Scope;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}
