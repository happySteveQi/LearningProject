package com.example.learning.base.contract;

import com.example.learning.base.BasePresenter;
import com.example.learning.base.BaseView;

/**
 * Time:2019/6/6
 * <p>
 * Author:44483
 * <p>
 * Description:
 */
public interface MainContract {
    interface View extends BaseView {

        void showUpdateDialog(String versionContent);

        void startDownloadService();
    }

    interface Presenter extends BasePresenter<View> {

        void checkVersion(String currentVersion);

        void setNightModeState(boolean b);

        void setCurrentItem(int index);

        int getCurrentItem();

        void setVersionPoint(boolean b);

        boolean getVersionPoint();
    }
}
