package com.example.learning.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Time:2019/5/30
 * <p>
 * Author:44483
 * <p>
 * Description: 基于 Rx 的 presenter ,控制生命周期
 */
public class RxPresenter <T extends BaseView> implements BasePresenter<T>{

    protected T mView;
    protected CompositeDisposable mCompositeDisposable;

    protected void unSubscribe(){
        if (mCompositeDisposable != null){
            mCompositeDisposable.clear();
        }
    }

    protected void addSubscribe(Disposable subscirption){
        if (mCompositeDisposable == null){
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscirption);
    }
    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
    }
}
