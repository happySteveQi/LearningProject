package com.example.learning.di.module;

import android.provider.SyncStateContract;

import com.example.learning.BuildConfig;
import com.example.learning.di.qualifier.WechatUrl;
import com.example.learning.di.qualifier.ZhihuUrl;
import com.example.learning.model.http.api.WechatApis;
import com.example.learning.model.http.api.ZhihuApis;
import com.example.learning.utils.Constants;
import com.example.learning.utils.SystemUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpModule {

    @Singleton
    @Provides
    public Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    public OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    @ZhihuUrl
    Retrofit provideZhihuRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ZhihuApis.HOST);
    }

    @Singleton
    @Provides
    @WechatUrl
    Retrofit provideWechatRetrofit(Retrofit.Builder builder, OkHttpClient client){
        return createRetrofit(builder,client, WechatApis.HOST);
    }
    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient okHttpClient, String url) {
        return builder.baseUrl(url)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    @Singleton
    @Provides
    ZhihuApis provideZhihuService(@ZhihuUrl Retrofit retrofit){
        return retrofit.create(ZhihuApis.class);
    }

    @Singleton
    @Provides
    WechatApis provideWechatService(@WechatUrl Retrofit retrofit){
        return retrofit.create(WechatApis.class);
    }

    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder){
        if (BuildConfig.DEBUG){
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
        }
        File cacheFile = new File(Constants.PATH_CACHE);
        Cache cache = new Cache(cacheFile,1024 * 1024 * 50);
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!SystemUtils.isNetworkConnected()){
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (SystemUtils.isNetworkConnected()){
                    int maxAge = 0;
                    response.newBuilder()
                            .header("Cache-Control","public,max-age="+maxAge)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };
        // Set Cache
        builder.addNetworkInterceptor(cacheInterceptor);
        builder.addInterceptor(cacheInterceptor);
        builder.cache(cache);

        // Set time limit
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20,TimeUnit.SECONDS);
        builder.writeTimeout(20,TimeUnit.SECONDS);

        // error retry
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }
}
