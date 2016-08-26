package com.softcloud.softlib.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j-renzhexin on 2016/8/25.
 */
public class ActivityManager {

    private ActivityManager() {}

    private static class SingletonHolder {
        private static final ActivityManager INSTANCE = new ActivityManager();
    }

    public static ActivityManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private List<Activity> activities;

    public List<Activity> getActivities() {
        if (activities == null) {
            activities = new ArrayList<>();
        }
        return activities;
    }

    public void addActivity(Activity activity) {
        getActivities().add(activity);
    }

    public void removeActivity(Activity activity) {
        getActivities().remove(activity);
    }

    public void finishAll() {
        for (Activity activity : getActivities()) {
            removeActivity(activity);
            activity.finish();
        }
    }
}
