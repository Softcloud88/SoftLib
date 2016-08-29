package com.softcloud.softlib.presenter;

import com.softcloud.softlib.baseView.IBasePresenter;
import com.softcloud.softlib.network.ApiManager;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by j-renzhexin on 2016/8/26.
 */
public class BasePresenter implements ApiManager, IBasePresenter {

    private CompositeSubscription compositeSubscription;

    protected void addSubscription(Subscription subscription) {
        getCompositeSubscription().add(subscription);
    }

    private rx.subscriptions.CompositeSubscription getCompositeSubscription() {
        return compositeSubscription != null ? compositeSubscription : new CompositeSubscription();
    }

    @Override
    public void cancelAll() {
        getCompositeSubscription().unsubscribe();
    }

    @Override
    public void onDetach() {
        cancelAll();
    }
}
