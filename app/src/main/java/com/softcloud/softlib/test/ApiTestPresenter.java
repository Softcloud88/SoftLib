package com.softcloud.softlib.test;

import com.softcloud.softlib.network.RequestManager;
import com.softcloud.softlib.presenter.BasePresenter;
import com.softcloud.softlib.test.api.MovieService;
import com.softcloud.softlib.test.model.Top250MovieModel;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
        Subscription topMoviesRequest = RequestManager.getService(MovieService.class)
                .getTopMovie(0,2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Top250MovieModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (!isUnsubscribed()) {
                            view.toast("error");
                        }
                    }

                    @Override
                    public void onNext(Top250MovieModel top250MovieModel) {
                        view.renderMoviesInfo(top250MovieModel);
                    }
                });
        addSubscription(topMoviesRequest);
    }
}
