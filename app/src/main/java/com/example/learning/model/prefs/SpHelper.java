package com.example.learning.model.prefs;

public interface SpHelper {

    boolean getNightModeState();

    void setNightModeState(boolean state);

    void setCurrentItem(int item);

    int getCurrentItem();

    void setVersionPoint(boolean isFirst);

    boolean getVersionPoint();
}
