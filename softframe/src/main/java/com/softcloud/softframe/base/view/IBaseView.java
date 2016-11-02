package com.softcloud.softframe.base.view;

import android.app.Activity;
import android.view.View;

/**
 * Created by j-renzhexin on 2016/10/27.
 */

public interface IBaseView {
    View getRootView();

    void showProgressDialog();

    void showProgressDialog(boolean cancelable);

    void hideProgressDialog();

    void toastMsg(String msg);

    String getSimpleName(); // used for log tag

    Activity getActivity();
}
