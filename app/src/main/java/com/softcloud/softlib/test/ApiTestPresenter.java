package com.softcloud.softlib.test;

import com.softcloud.softlib.network.RequestCallback;
import com.softcloud.softlib.presenter.BasePresenter;
import com.softcloud.softlib.test.model.Top250MovieModel;

/**
 * Created by j-renzhexin on 2016/8/29.
 */
public class ApiTestPresenter extends BasePresenter {

    private ApiTestContract.View view;

    public static ApiTestPresenter getInstance(ApiTestContract.View view) {
        ApiTestPresenter instance = new ApiTestPresenter();
        instance.view = view;
        return instance;
    }

    public void initData() {
        addSubscription(getApiFactory().getMovieApi().getTopMovies(0, 2, new RequestCallback<Top250MovieModel>() {
            @Override
            public void onSuccess(Top250MovieModel model) {
                view.renderMoviesInfo(model);
            }

            @Override
            public void onFailed(Top250MovieModel model) {

            }

            @Override
            public void onError(Throwable e) {
                view.toast("网络错误");
            }
        }));
    }
}
