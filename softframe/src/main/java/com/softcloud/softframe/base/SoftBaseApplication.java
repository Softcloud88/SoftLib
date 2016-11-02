package com.softcloud.softframe.base;

import android.app.Application;

/**
 * Created by j-renzhexin on 2016/10/27.
 */

public abstract class SoftBaseApplication extends Application {

    private static SoftBaseApplication INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        initApplicationWhenCreate();
    }

    public static SoftBaseApplication getSoftApp() {
        return INSTANCE;
    }

    protected abstract void initApplicationWhenCreate();
}
