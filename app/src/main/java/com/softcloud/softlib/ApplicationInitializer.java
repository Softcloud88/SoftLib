package com.softcloud.softlib;

import android.content.Context;

/**
 * Created by j-renzhexin on 2016/8/26.
 */
public class ApplicationInitializer {

    private ApplicationInitializer(){}

    private static class SingletonHolder {
        private static final ApplicationInitializer INSTANCE = new ApplicationInitializer();
    }

    public ApplicationInitializer getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void initialze(Context context) {

    }
}
