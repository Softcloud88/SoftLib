package com.softcloud.softframe.base.fragment;

import android.os.Bundle;
import android.view.View;

import com.softcloud.softframe.base.presenter.IPresenter;
import com.softcloud.softframe.base.view.IBaseView;

/**
 * Created by j-renzhexin on 2016/11/1.
 */

public abstract class SoftMvpFragment <Presenter extends IPresenter<IView>, IView extends IBaseView> extends SoftBaseFragment {

    protected Presenter presenter;
    protected IView view;

    @Override
    protected void onViewInit(View rootView, Bundle savedInstanceState) {
        presenter = initPresenter();
        view = initMvpView(presenter);
        presenter.bindView(view);
        initPageData(presenter);
    }

    protected abstract Presenter initPresenter();

    protected Presenter getPresenter() {
        return presenter;
    }

    protected abstract IView initMvpView(Presenter presenter);

    protected IView getMvpView() {
        return view;
    }

    protected abstract void initPageData(Presenter presenter);

    @Override
    public void onStart() {
        super.onStart();
        getPresenter().onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().onResume();
    }

    @Override
    public void onPause() {
        getPresenter().onPause();
        super.onPause();
    }

    @Override
    public void onStop() {
        getPresenter().onStop();
        super.onStop();
    }

    @Override
    public void onDestroy() {
        getPresenter().onDestroy();
        super.onDestroy();
    }
}
