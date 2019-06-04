package com.example.learning.component;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.learning.App;

/**
 * Time:2019/6/3
 * <p>
 * Author:44483
 * <p>
 * Description:
 */
public class ImageLoader {
    public static void load(Context context, String url, ImageView iv) {    //使用Glide加载圆形ImageView(如头像)时，不要使用占位图
//        if (!App.getAppComponent().preferencesHelper().getNoImageState()) {
            Glide.with(context).load(url).crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);
//        }
    }
}
