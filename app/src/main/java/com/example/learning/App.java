package com.example.learning;

import android.app.Activity;
import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.example.learning.component.InitializeService;
import com.example.learning.di.component.AppComponent;
import com.example.learning.di.component.DaggerAppComponent;
import com.example.learning.di.module.AppModule;
import com.example.learning.di.module.HttpModule;

import java.util.HashSet;
import java.util.Set;

import io.realm.Realm;

public class App extends Application {
    private static App mInstance;
    public static AppComponent appComponent;
    private Set<Activity> allActivities;

    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }
    public static synchronized App getInstance(){
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        // 初始化屏幕宽高
        initScreenSize();

        //初始化数据库
        Realm.init(getApplicationContext());

        //在子线程中完成其他初始化
        InitializeService.start(this);
    }

    private void initScreenSize() {

    }

    public static AppComponent getAppComponent() {
        if (appComponent == null){
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(mInstance))
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }

    public void addActivity(Activity activity){
        if (allActivities == null){
            allActivities = new HashSet<>();
        }
        allActivities.add(activity);
    }
    public void removeActivity(Activity activity){
        if (allActivities != null){
            allActivities.remove(activity);
        }
    }
}
