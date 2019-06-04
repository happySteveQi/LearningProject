package com.example.learning.di.component;

import android.app.Activity;

import com.example.learning.di.module.FragmentModule;
import com.example.learning.di.scope.FragmentScope;

import dagger.Component;

@FragmentScope
@Component(dependencies = AppComponent.class,modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();

//    void inject();
}
