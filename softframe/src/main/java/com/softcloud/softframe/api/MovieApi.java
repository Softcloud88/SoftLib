package com.softcloud.softframe.api;


import com.softcloud.softframe.model.Top250MovieModel;
import com.softcloud.softframe.network.RequestCallback;

import rx.Subscription;

/**
 * Created by j-renzhexin on 2016/8/29.
 */
public interface MovieApi {
    Subscription getTopMovies(int start, int count, RequestCallback<Top250MovieModel> callback);
}
