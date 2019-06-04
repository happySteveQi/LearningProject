package com.example.learning.model.http;

import com.example.learning.model.bean.WelcomeBean;

import io.reactivex.Flowable;

public interface HttpHelper {

    Flowable<WelcomeBean> fetchWelcomeInfo(String res);
}
