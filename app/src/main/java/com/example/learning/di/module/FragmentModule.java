package com.example.learning.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.example.learning.App;
import com.example.learning.di.scope.FragmentScope;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {
    private Fragment mFragment;

    FragmentModule(Fragment fragment) {
        this.mFragment = fragment;
    }

    @FragmentScope
    @Provides
    public Activity provideActivity() {
        return mFragment.getActivity();
    }

}
