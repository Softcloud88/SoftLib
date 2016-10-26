package com.softcloud.softframe.api;


import com.softcloud.softframe.model.Top250MovieModel;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Softcloud on 16/8/28.
 */
public interface MovieService {

    @GET("movie/top250")
    Observable<Top250MovieModel> getTopMovie(@Query("start") int start, @Query("count") int count);
}
