package com.softcloud.softframe.utils;

import android.util.Log;

/**
 * Created by j-renzhexin on 2016/10/28.
 */

public class SafeCast {
    private static final String LOG_TAG = "type cast";

    public static String getString(int value) {
        return String.valueOf(value);
    }

    public static String getString(double value) {
        return String.valueOf(value);
    }

    public static String getString(float value) {
        return String.valueOf(value);
    }

    public static int getInt(String value) {
        int res = 0;
        try {
            res = Integer.valueOf(value);
        } catch (Exception e) {
            log(e);
        }
        return res;
    }

    public static int getInt(String value, int defVal) {
        int res = defVal;
        try {
            res = Integer.valueOf(value);
        } catch (Exception e) {
            log(e);
        }
        return res;
    }

    public static double getDouble(String value) {
        double res = 0;
        try {
            res = Double.valueOf(value);
        } catch (Exception e) {
            log(e);
        }
        return res;
    }

    public static float getFloat(String value) {
        float res = 0;
        try {
            res = Float.valueOf(value);
        } catch (Exception e) {
            log(e);
        }
        return res;
    }

    private static void log(Exception e) {
        Log.d(LOG_TAG, e.getMessage());
    }
}
