package com.example.learning.model.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.learning.App;
import com.example.learning.utils.Constants;

import javax.inject.Inject;

public class SpHelperImpl implements SpHelper {

    private static final String SHAREDPREFERENCES_NAME = "my_sp";

    private static final boolean DEFAULT_VERSION_POINT = false;

    private static final int DEFAULT_CURRENT_ITEM = Constants.TYPE_ZHIHU;
    private final SharedPreferences mSPrefs;

    @Inject
    public SpHelperImpl() {
        mSPrefs = App.getInstance().getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
    }
    @Override
    public boolean getNightModeState() {
        return false;
    }

    @Override
    public void setNightModeState(boolean state) {
        mSPrefs.edit().putBoolean(Constants.SP_NIGHT_MODE,state).apply();
    }

    @Override
    public void setCurrentItem(int item) {
        mSPrefs.edit().putInt(Constants.SP_CURRENT_ITEM,item).apply();
    }

    @Override
    public int getCurrentItem() {
        return mSPrefs.getInt(Constants.SP_CURRENT_ITEM,DEFAULT_CURRENT_ITEM);
    }

    @Override
    public void setVersionPoint(boolean isFirst) {
        mSPrefs.edit().putBoolean(Constants.SP_VERSION_POINT,isFirst);
    }

    @Override
    public boolean getVersionPoint() {
        return mSPrefs.getBoolean(Constants.SP_VERSION_POINT,DEFAULT_VERSION_POINT);
    }
}
