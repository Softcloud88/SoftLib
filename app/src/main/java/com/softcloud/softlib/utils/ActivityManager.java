package com.softcloud.softlib.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j-renzhexin on 2016/8/25.
 */
public class ActivityManager {

    private static ActivityManager sInstance;

    private ActivityManager() {}

    private List<Activity> activities;

    public synchronized static ActivityManager getInstance() {
        if (sInstance == null) {
            sInstance = new ActivityManager();
        }
        return sInstance;
    }

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
