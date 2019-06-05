package com.example.learning.model.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.learning.App;

import javax.inject.Inject;

public class SpHelperImpl implements SpHelper {

    private static final String SHAREDPREFERENCES_NAME = "my_sp";

    private final SharedPreferences mSPrefs;
    @Inject
    public SpHelperImpl() {
        mSPrefs = App.getInstance().getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
    }
    @Override
    public boolean getNightModeState() {
        return false;
    }
}
