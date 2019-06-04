package com.example.learning.di.component;

import com.example.learning.App;
import com.example.learning.di.module.AppModule;
import com.example.learning.di.module.HttpModule;
import com.example.learning.model.DataManager;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    App getContext();//提供app的Context

//    DataManager getDataManager(); //数据中心
}
