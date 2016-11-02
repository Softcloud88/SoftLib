package com.softcloud.softframe.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.softcloud.softframe.base.SoftBaseApplication;

/**
 * Created by j-renzhexin on 2016/10/28.
 */

public class ResHelper {

    @SuppressWarnings("deprecation")
    public static int getColor(int resColor){
        return ContextCompat.getColor(SoftBaseApplication.getSoftApp(), resColor);
    }


    public static String getString(int resId) {
        return SoftBaseApplication.getSoftApp().getString(resId);
    }

    public static Resources getResources() {
        return SoftBaseApplication.getSoftApp().getResources();
    }

    public static Drawable getDrawable(int drawableResId) {
        return ContextCompat.getDrawable(SoftBaseApplication.getSoftApp(), drawableResId);
    }

}
