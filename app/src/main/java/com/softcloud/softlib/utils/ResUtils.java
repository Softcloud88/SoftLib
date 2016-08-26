package com.softcloud.softlib.utils;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.annotation.XmlRes;
import android.support.v4.content.ContextCompat;

import com.softcloud.softlib.BaseApplication;

/**
 * Created by j-renzhexin on 2016/8/26.
 */
public class ResUtils {

    private static final Context context = BaseApplication.getInstance();

    public static int getResID(String type, String name) {
        Resources resource = context.getResources();
        String pkgName = context.getPackageName();
        return resource.getIdentifier(name, type, pkgName);

    }

    public static Resources getResources() {
        return context.getResources();
    }

    public static String getString(@StringRes int resId) {
        return context.getString(resId);
    }

    public static int getColor(@ColorRes int resId) {
        return ContextCompat.getColor(context, resId);
    }

    public static Drawable getDrawable(@DrawableRes int id) {
        return ContextCompat.getDrawable(context, id);
    }

    public static XmlResourceParser getXmlResParser(@XmlRes int id) {
        return getResources().getXml(id);
    }
}
