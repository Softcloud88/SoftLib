package com.softcloud.softlib.test.api;

import com.softcloud.softlib.network.ApiManager;

/**
 * Created by j-renzhexin on 2016/8/29.
 */
public class ApiFactoryImpl implements ApiFactory {

    private ApiManager apiManager;

    public ApiFactoryImpl(ApiManager apiManager) {
        this.apiManager = apiManager;
    }

    @Override
    public MovieApi getMovieApi() {
        return new MovieApiImpl(apiManager);
    }
}
