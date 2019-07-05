package com.example.learning.utils;

import com.example.learning.model.http.exception.ApiException;
import com.example.learning.model.http.response.MyHttpResponse;
import com.example.learning.model.http.response.WXHttpResponse;

import org.reactivestreams.Publisher;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Time:2019/5/30
 * <p>
 * Author:44483
 * <p>
 * Description:
 */
public class RxUtils {

    public static <T> FlowableTransformer<T, T> rxSchedulerHelper() { // compose 简化线程
        return new FlowableTransformer<T, T>() {
            @Override
            public Flowable<T> apply(Flowable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> FlowableTransformer<WXHttpResponse<T>, T> handleWXResult() {
        return new FlowableTransformer<WXHttpResponse<T>, T>() {
            @Override
            public Flowable<T> apply(Flowable<WXHttpResponse<T>> httpResponseFlowable) {
                return httpResponseFlowable.flatMap(new Function<WXHttpResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(WXHttpResponse<T> twxHttpResponse) throws Exception {
                        if (twxHttpResponse.getCode() == 200) {
                            return createData(twxHttpResponse.getNewslist());
                        } else {
                            return Flowable.error(new ApiException(twxHttpResponse.getMsg(), twxHttpResponse.getCode()));
                        }
                    }
                });
            }
        };
    }

    public static <T> FlowableTransformer<MyHttpResponse<T>, T> handleMyResult() {
        return new FlowableTransformer<MyHttpResponse<T>, T>() {
            @Override
            public Flowable<T> apply(Flowable<MyHttpResponse<T>> httpResponseFlowable) {
                return httpResponseFlowable.flatMap(new Function<MyHttpResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(MyHttpResponse<T> tMyHttpResponse) {
                        if (tMyHttpResponse.getCode() == 200) {
                            return createData(tMyHttpResponse.getData());
                        } else {
                            return Flowable.error(new ApiException(tMyHttpResponse.getMessage(), tMyHttpResponse.getCode()));
                        }

                    }
                });
            }
        };
    }

    public static <T> Flowable<T> createData(final T t) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }

}
