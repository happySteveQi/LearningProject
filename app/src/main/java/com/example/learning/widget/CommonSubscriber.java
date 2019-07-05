package com.example.learning.widget;

import android.text.TextUtils;

import com.example.learning.base.BaseView;
import com.example.learning.model.http.exception.ApiException;
import com.example.learning.utils.LogUtil;

import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;

/**
 * Time:2019/6/6
 * <p>
 * Author:44483
 * <p>
 * Description:
 */
public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {
    private BaseView mView;
    private String mErrorMsg;
    private boolean showErrorState = true;

    protected CommonSubscriber(BaseView view) {
        this.mView = view;
    }

    protected CommonSubscriber(BaseView view, String errorMsg) {
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected CommonSubscriber(BaseView view, boolean showErrorState) {
        this.mView = view;
        this.showErrorState = showErrorState;
    }

    protected CommonSubscriber(BaseView view, String errorMsg, boolean showErrorState) {
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.showErrorState = showErrorState;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        if (mView == null) {
            return;
        }
        if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {
            mView.showErrorMsg(mErrorMsg);
        } else if (e instanceof ApiException) {
            mView.showErrorMsg(e.toString());
        } else if (e instanceof HttpException) {
            mView.showErrorMsg("数据加载失败");
            LogUtil.e(e.toString());
        } else {
            LogUtil.e(e.toString());
            mView.showErrorMsg("未知错误");
        }
        if (showErrorState) {
            mView.stateError();
        }
    }
}
