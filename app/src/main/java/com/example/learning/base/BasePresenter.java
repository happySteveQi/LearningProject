package com.example.learning.base;

/**
 * Time:2019/5/30
 * <p>
 * Author:44483
 * <p>
 * Description:
 */
public interface BasePresenter <T extends BaseView>{

    void attachView(T view);

    void detachView();
}
