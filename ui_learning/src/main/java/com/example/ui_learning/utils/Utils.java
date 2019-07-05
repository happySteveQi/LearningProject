package com.example.ui_learning.utils;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Description:
 *
 * @author Steve_qi
 * @date: 2019/7/5
 */
public class Utils {
    public static float dp2px(float dp){
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp, Resources.getSystem().getDisplayMetrics());
    }
}
