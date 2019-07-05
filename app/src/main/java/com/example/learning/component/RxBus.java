package com.example.learning.component;

import com.example.learning.utils.RxUtils;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;

/**
 * Time:2019/6/6
 * <p>
 * Author:44483
 * <p>
 * Description:
 */
public class RxBus {
    private final FlowableProcessor<Object> mRxBus;
    //只会发送订阅之后的Flowable数据
    private RxBus() {
        mRxBus = PublishProcessor.create().toSerialized();
    }

    private static class RxBusHolder {
        private static RxBus INSTANCE = new RxBus();
    }

    public static RxBus getInstance() {
        return RxBusHolder.INSTANCE;
    }
    //提供一个新的事件
    public void post(Object object){
        mRxBus.onNext(object);
    }
    public <T>Flowable<T> toFlowable(Class<T> eventType){
        return mRxBus.ofType(eventType);
    }
    public <T>Disposable toDefaultFlowable(Class<T> eventType, Consumer<T> act){
        return mRxBus.ofType(eventType).compose(RxUtils.<T>rxSchedulerHelper()).subscribe(act);
    }
}
