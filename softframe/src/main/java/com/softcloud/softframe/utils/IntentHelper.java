package com.softcloud.softframe.utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by j-renzhexin on 2016/11/1.
 */

public class IntentHelper {

    public static Intent createIntent(Context context, Class<?> activityCls, boolean setClearTop) {
        Intent intent = new Intent();
        intent.setClass(context, activityCls);
        if (setClearTop) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
        return intent;
    }
}
