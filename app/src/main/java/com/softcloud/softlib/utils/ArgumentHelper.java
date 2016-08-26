package com.softcloud.softlib.utils;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by j-renzhexin on 2016/8/26.
 */
public class ArgumentHelper {
    private static final String LOG_TAG = "ArgumentHelper";

    public static boolean getBoolean(Bundle args, String key, boolean defaultValue) {
        if (args == null) {
            return defaultValue;
        } else {
            return args.getBoolean(key, defaultValue);
        }
    }

    public static int getInt(Bundle args, String key, int defaultValue) {
        if (args == null) {
            return defaultValue;
        } else {
            return args.getInt(key, defaultValue);
        }
    }

    public static float getFloat(Bundle args, String key, float defaultValue) {
        if (args == null) {
            return defaultValue;
        } else {
            return args.getFloat(key, defaultValue);
        }
    }

    public static String getString(Bundle args, String key, String defaultValue) {
        if (args == null) {
            return defaultValue;
        } else {
            return args.getString(key, defaultValue);
        }
    }

    public static CharSequence getCharSequence(Bundle args, String key, CharSequence defaultValue) {
        if (args == null) {
            return defaultValue;
        } else {
            return args.getCharSequence(key, defaultValue);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T getSerializable(Bundle args, String key) {
        if (args == null) {
            return null;
        } else {
            T res = null;
            try {
                res = (T) args.getSerializable(key);
            } catch (Exception e) {
                LogUtils.d(LOG_TAG, e.getMessage());
            }
            return res;
        }
    }

    public static boolean getBoolean(Intent data, String key, boolean defaultValue) {
        if (data == null) {
            return defaultValue;
        } else {
            return data.getBooleanExtra(key, defaultValue);
        }
    }

    public static int getInt(Intent data, String key, int defaultValue) {
        if (data == null) {
            return defaultValue;
        } else {
            return data.getIntExtra(key, defaultValue);
        }
    }

    public static float getFloat(Intent data, String key, float defaultValue) {
        if (data == null) {
            return defaultValue;
        } else {
            return data.getFloatExtra(key, defaultValue);
        }
    }

    public static String getString(Intent data, String key) {
        if (data == null) {
            return "";
        } else {
            return data.getStringExtra(key);
        }
    }

    public static CharSequence getCharSequence(Intent date, String key) {
        if (date == null) {
            return "";
        } else {
            return date.getCharSequenceExtra(key);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T getSerializable(Intent data, String key) {
        if (data == null) {
            return null;
        } else {
            T res = null;
            try {
                res = (T) data.getSerializableExtra(key);
            } catch (Exception e) {
                LogUtils.d(LOG_TAG, e.getMessage());
            }
            return res;
        }
    }
}
