package com.example.learning.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Time:2019/6/12
 * <p>
 * Author:44483
 * <p>
 * Description:
 */
public class SnackbarUtil {

    public static void showLong(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    }

    public static void showShort(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }
}
