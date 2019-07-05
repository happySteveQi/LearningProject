package com.example.learning.model.http.api;

import com.example.learning.model.bean.VersionBean;
import com.example.learning.model.http.response.MyHttpResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Time:2019/6/11
 * <p>
 * Author:44483
 * <p>
 * Description: Here just apply unavailable url
 */
public interface MyApi {

    String HOST = "http://codeest.me/api/geeknews/";

    String APK_DOWNLOAD_URL = "http://codeest.me/apk/geeknews.apk";

    @GET("version")
    Flowable<MyHttpResponse<VersionBean>> getVersionInfo();
}
