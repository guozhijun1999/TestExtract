package com.example.testnavigation.global;

import android.app.Application;

import com.example.testnavigation.utils.PreferencesHelper;

public class App extends Application {
    public static App sApp;
    private PreferencesHelper ph;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        ph = new PreferencesHelper(getApplication(), "test");
    }

    public static App getApplication() {
        return sApp;
    }

    public PreferencesHelper getPreferencesHelper() {
        return ph;
    }

    public float getFontScale() {
        int currentIndex = ph.getValueInt("currentIndex", 1);
        return 1 + currentIndex * 0.1f;
    }
}
