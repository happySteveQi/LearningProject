package com.example.learning.model;

import com.example.learning.model.bean.WelcomeBean;
import com.example.learning.model.db.DBHelper;
import com.example.learning.model.http.HttpHelper;
import com.example.learning.model.prefs.SpHelper;

import io.reactivex.Flowable;

public class DataManager implements SpHelper, DBHelper, HttpHelper {
    HttpHelper mHttpHelper;
    DBHelper mDbHelper;
    SpHelper mSpHelper;

    public DataManager(HttpHelper httpHelper,DBHelper dbHelper,SpHelper spHelper){
        mHttpHelper = httpHelper;
        mDbHelper = dbHelper;
        mSpHelper = spHelper;
    }
    /********* Database **********/
    @Override
    public void insertNewsId(int id) {

    }

    @Override
    public boolean queryNewsId(int id) {
        return false;
    }
    /*************** Network request*****************/
    @Override
    public Flowable<WelcomeBean> fetchWelcomeInfo(String res) {
        return mHttpHelper.fetchWelcomeInfo(res);
    }
    /******************** SharedPreferences *************************/
    @Override
    public boolean getNightModeState() {
        return false;
    }
}
