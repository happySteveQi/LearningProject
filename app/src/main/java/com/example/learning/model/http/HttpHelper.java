package com.example.learning.model.http;

import com.example.learning.model.bean.VersionBean;
import com.example.learning.model.bean.WelcomeBean;
import com.example.learning.model.http.response.MyHttpResponse;

import io.reactivex.Flowable;

public interface HttpHelper {

    Flowable<WelcomeBean> fetchWelcomeInfo(String res);

    Flowable<MyHttpResponse<VersionBean>> fetchVersionInfo();
}
