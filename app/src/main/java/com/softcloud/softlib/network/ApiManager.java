package com.softcloud.softlib.network;

import rx.Subscription;

/**
 * Created by j-renzhexin on 2016/8/29.
 */
public interface ApiManager {
    void add(Subscription subscription);
    void cancel(Subscription subscription);
    void cancelAll();
}
