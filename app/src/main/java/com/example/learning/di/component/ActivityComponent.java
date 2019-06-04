package com.example.learning.di.component;

import android.app.Activity;

import com.example.learning.di.module.ActivityModule;
import com.example.learning.di.scope.ActivityScope;
import com.example.learning.ui.main.WelcomeActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(WelcomeActivity welcomeActivity);

}
