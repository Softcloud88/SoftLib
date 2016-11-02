package com.softcloud.softframe.base.presenter;

import com.softcloud.softframe.base.view.IBaseView;

/**
 * Created by j-renzhexin on 2016/10/31.
 */

public interface IPresenter<T extends IBaseView> {
    void bindView(T view);

    void onStart();

    void onRestart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();
}
