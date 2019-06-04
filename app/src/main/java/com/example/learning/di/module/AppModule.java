package com.example.learning.di.module;


import com.example.learning.App;
import com.example.learning.model.DataManager;
import com.example.learning.model.db.DBHelper;
import com.example.learning.model.db.RealmHelper;
import com.example.learning.model.http.HttpHelper;
import com.example.learning.model.http.RetrofitHelper;
import com.example.learning.model.prefs.SpHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public App provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, DBHelper dbHelper, SpHelper spHelper) {
        return new DataManager(httpHelper, dbHelper, spHelper);
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

    @Provides
    @Singleton
    DBHelper provideDBHelper(RealmHelper realmHelper) {
        return realmHelper;
    }

    @Provides
    @Singleton
    SpHelper providePreferencesHelper(SpHelper spHelper) {
        return spHelper;
    }

}
