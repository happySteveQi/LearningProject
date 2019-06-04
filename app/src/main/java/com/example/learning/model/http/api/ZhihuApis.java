package com.example.learning.model.http.api;

import com.example.learning.model.bean.WelcomeBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ZhihuApis {

    String HOST = "http://news-at.zhihu.com/api/4/";

    @GET("start-image/{res}")
    Flowable<WelcomeBean> getWelcomeInfo(@Path("res") String res);
}
