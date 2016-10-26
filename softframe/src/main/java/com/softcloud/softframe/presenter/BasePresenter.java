package com.softcloud.softframe.presenter;

import com.softcloud.softframe.baseView.IBasePresenter;
import com.softcloud.softframe.network.ApiManager;
import com.softcloud.softframe.api.ApiFactory;
import com.softcloud.softframe.api.ApiFactoryImpl;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by j-renzhexin on 2016/8/26.
 */
public class BasePresenter implements ApiManager, IBasePresenter {

    private CompositeSubscription compositeSubscription;
    private ApiFactory apiFactory;

    private rx.subscriptions.CompositeSubscription getCompositeSubscription() {
        return compositeSubscription != null ? compositeSubscription : new CompositeSubscription();
    }

    @Override
    public void add(Subscription subscription) {
        getCompositeSubscription().add(subscription);
    }

    @Override
    public void cancel(Subscription subscription) {
        getCompositeSubscription().remove(subscription);
    }

    @Override
    public void cancelAll() {
        getCompositeSubscription().unsubscribe();
    }

    @Override
    public void onDetach() {
        cancelAll();
    }

    protected ApiFactory getApiFactory() {
        if (apiFactory == null) {
            apiFactory = new ApiFactoryImpl(this);
        }
        return apiFactory;
    }
}
