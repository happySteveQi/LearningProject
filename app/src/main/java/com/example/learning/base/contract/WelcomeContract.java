package com.example.learning.base.contract;

import com.example.learning.base.BasePresenter;
import com.example.learning.base.BaseView;
import com.example.learning.model.bean.WelcomeBean;

/**
 * Time:2019/5/30
 * <p>
 * Author:44483
 * <p>
 * Description:
 */
public interface WelcomeContract {
    interface View extends BaseView{

        void showContent(WelcomeBean welcomeBean);

        void jumpToMain();
    }
    interface Presenter extends BasePresenter<View>{

        void getWelcomeData();

    }
}
