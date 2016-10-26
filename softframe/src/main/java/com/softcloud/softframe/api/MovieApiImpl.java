package com.softcloud.softframe.api;

import com.softcloud.softframe.model.Top250MovieModel;
import com.softcloud.softframe.network.ApiManager;
import com.softcloud.softframe.network.RequestCallback;
import com.softcloud.softframe.network.RequestManager;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by j-renzhexin on 2016/8/29.
 */
public class MovieApiImpl implements MovieApi {

    private ApiManager apiManager;

    public MovieApiImpl(ApiManager apiManager) {
        this.apiManager = apiManager;
    }

    @Override
    public Subscription getTopMovies(int start, int count, final RequestCallback<Top250MovieModel> callback) {
        Subscription subscription = RequestManager.getService(MovieService.class).getTopMovie(start, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Top250MovieModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (!isUnsubscribed()) {
                            callback.onError(e);
                        }
                    }

                    @Override
                    public void onNext(Top250MovieModel top250MovieModel) {
                        if (top250MovieModel.isSuccess()) {
                            callback.onSuccess(top250MovieModel);
                        } else {
                            callback.onFailed(top250MovieModel);
                        }
                    }
                });
        apiManager.add(subscription);
        return subscription;
    }
}
