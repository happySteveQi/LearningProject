package com.example.learning.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import com.example.learning.App;

/**
 * Time:2019/6/4
 * <p>
 * Author:44483
 * <p>
 * Description:
 */
public class SystemUtils {

    /**
     * 检查是否有可用网络
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }
}
