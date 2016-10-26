package com.softcloud.softframe.utils;

/**
 * Created by j-renzhexin on 2016/8/26.
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
            LogUtils.d(LOG_TAG, e.getMessage());
        }
        return res;
    }

    public static int getInt(String value, int defVal) {
        int res = defVal;
        try {
            res = Integer.valueOf(value);
        } catch (Exception e) {
            LogUtils.d(LOG_TAG, e.getMessage());
        }
        return res;
    }

    public static double getDouble(String value) {
        double res = 0;
        try {
            res = Double.valueOf(value);
        } catch (Exception e) {
            LogUtils.d(LOG_TAG, e.getMessage());
        }
        return res;
    }

    public static float getFloat(String value) {
        float res = 0;
        try {
            res = Float.valueOf(value);
        } catch (Exception e) {
            LogUtils.d(LOG_TAG, e.getMessage());
        }
        return res;
    }
}
