package com.softcloud.softlib;

import android.app.Application;

/**
 * Created by j-renzhexin on 2016/8/26.
 */
public class BaseApplication extends Application {

    private static BaseApplication sInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        ApplicationInitializer.getInstance().initialze(this);
    }

    public static BaseApplication getInstance() {
        return sInstance;
    }
}
