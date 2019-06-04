package com.example.learning.base;

/**
 * Time:2019/5/30
 * <p>
 * Author:44483
 * <p>
 * Description: View 基类
 */
public interface BaseView {

    void showErrorMsg(String msg);

    void useNightMode(boolean isNight);

    // different State
    void stateError();

    void stateEmpty();

    void stateLoading();

    void stateMain();
}
