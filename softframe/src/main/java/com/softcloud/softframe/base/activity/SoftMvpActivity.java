package com.softcloud.softframe.base.activity;

import android.os.Bundle;
import android.view.View;

import com.softcloud.softframe.base.presenter.IPresenter;
import com.softcloud.softframe.base.view.IBaseView;

/**
 * Created by j-renzhexin on 2016/11/1.
 */

public abstract class SoftMvpActivity<Presenter extends IPresenter<IView>, IView extends IBaseView> extends SoftBaseActivity {

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
    protected void onStart() {
        super.onStart();
        getPresenter().onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getPresenter().onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().onResume();
    }

    @Override
    protected void onPause() {
        getPresenter().onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        getPresenter().onStop();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        getPresenter().onDestroy();
        super.onDestroy();
    }
}
