package com.example.learning.model;

import com.example.learning.model.bean.VersionBean;
import com.example.learning.model.bean.WelcomeBean;
import com.example.learning.model.db.DBHelper;
import com.example.learning.model.http.HttpHelper;
import com.example.learning.model.http.response.MyHttpResponse;
import com.example.learning.model.prefs.SpHelper;

import io.reactivex.Flowable;

public class DataManager implements SpHelper, DBHelper, HttpHelper {
    HttpHelper mHttpHelper;
    DBHelper mDbHelper;
    SpHelper mSpHelper;

    public DataManager(HttpHelper httpHelper, DBHelper dbHelper, SpHelper spHelper) {
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

    @Override
    public Flowable<MyHttpResponse<VersionBean>> fetchVersionInfo() {
        return mHttpHelper.fetchVersionInfo();
    }

    /******************** SharedPreferences *************************/
    @Override
    public boolean getNightModeState() {
        return false;
    }

    @Override
    public void setNightModeState(boolean state) {
        mSpHelper.setNightModeState(state);
    }

    @Override
    public void setCurrentItem(int item) {
        mSpHelper.setCurrentItem(item);
    }

    @Override
    public int getCurrentItem() {
        return mSpHelper.getCurrentItem();
    }

    @Override
    public void setVersionPoint(boolean isFirst) {
        mSpHelper.setVersionPoint(isFirst);
    }

    @Override
    public boolean getVersionPoint() {
        return mSpHelper.getVersionPoint();
    }
}
