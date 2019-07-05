package com.example.learning.utils;

import com.example.learning.BuildConfig;
import com.orhanobut.logger.Logger;

/**
 * Time:2019/6/11
 * <p>
 * Author:44483
 * <p>
 * Description: Thie class is wrapped Log Tool
 */
public class LogUtil {

    public static boolean IS_DEBUG = BuildConfig.DEBUG;
    private static final String TAG = BuildConfig.APPLICATION_ID;

    public static void e(String tag,Object o){
        if (IS_DEBUG){
            Logger.e(tag,o);
        }
    }
    public static void e(Object o) {
        LogUtil.e(TAG,o);
    }

    public static void w(String tag,Object o) {
        if(IS_DEBUG) {
            Logger.w(tag, o);
        }
    }

    public static void w(Object o) {
        LogUtil.w(TAG,o);
    }

    public static void d(String msg) {
        if(IS_DEBUG) {
            Logger.d(msg);
        }
    }

    public static void i(String msg) {
        if(IS_DEBUG) {
            Logger.i(msg);
        }
    }
}
