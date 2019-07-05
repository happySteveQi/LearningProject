package com.example.learning.model.http;

import com.example.learning.model.bean.VersionBean;
import com.example.learning.model.bean.WelcomeBean;
import com.example.learning.model.http.api.MyApi;
import com.example.learning.model.http.api.WechatApis;
import com.example.learning.model.http.api.ZhihuApis;
import com.example.learning.model.http.response.MyHttpResponse;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class RetrofitHelper implements HttpHelper {

    private ZhihuApis mZhihuApiService;
    private MyApi mMyApiService;
//    private WechatApis mWechatApiService;

    @Inject
    public RetrofitHelper(ZhihuApis zhihuApiService) {
        this.mZhihuApiService = zhihuApiService;
//        this.mWechatApiService = wechatApiService;
    }
    @Override
    public Flowable<WelcomeBean> fetchWelcomeInfo(String res) {
        return mZhihuApiService.getWelcomeInfo(res);
    }

    @Override
    public Flowable<MyHttpResponse<VersionBean>> fetchVersionInfo() {
        return mMyApiService.getVersionInfo();
    }
}
