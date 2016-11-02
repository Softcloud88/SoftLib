package com.softcloud.softframe.base.presenter;

import com.softcloud.softframe.base.view.IBaseView;

/**
 * Created by j-renzhexin on 2016/10/31.
 */

public abstract class BasePresenter<T extends IBaseView> implements IPresenter<T> {

    protected T view;

    public void bindView(T view) {
        this.view = view;
    }

    public void onStart() {
    }

    public void onRestart() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onStop() {
    }

    public void onDestroy() {
    }
}
