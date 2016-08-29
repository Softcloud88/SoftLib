package com.softcloud.softlib.test.api;

/**
 * Created by j-renzhexin on 2016/8/29.
 */
public class ApiFactoryImpl implements ApiFactory {
    @Override
    public MovieApi getMovieApi() {
        return new MovieApiImpl();
    }
}
