package com.softcloud.softlib.test.api;

import com.softcloud.softlib.network.RequestCallback;
import com.softcloud.softlib.test.model.Top250MovieModel;

import rx.Subscription;

/**
 * Created by j-renzhexin on 2016/8/29.
 */
public interface MovieApi {
    Subscription getTopMovies(int start, int count, RequestCallback<Top250MovieModel> callback);
}
