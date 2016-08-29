package com.softcloud.softlib.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by j-renzhexin on 2016/8/29.
 */
public class RequestManager {

    public static <T> T getService(final Class<T> service) {
        return new Retrofit.Builder()
                .baseUrl(NetworkConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build().create(service);
    }


}
