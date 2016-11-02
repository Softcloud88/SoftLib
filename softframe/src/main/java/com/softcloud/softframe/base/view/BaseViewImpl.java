package com.softcloud.softframe.base.view;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.softcloud.softframe.R;
import com.softcloud.softframe.base.view.IBaseView;

/**
 * Created by j-renzhexin on 2016/10/31.
 */

public class BaseViewImpl implements IBaseView {

    protected View rootView;
    private Activity activity;

    private MaterialDialog progressDialog;

    public BaseViewImpl(View rootView) {
        this.rootView = rootView;
        this.activity = (Activity) rootView.getContext();
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    protected MaterialDialog getProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new MaterialDialog.Builder(activity)
                    .content(R.string.please_wait)
                    .progress(true, 0)
                    .progressIndeterminateStyle(false)
                    .contentColorRes(R.color.white)
                    .canceledOnTouchOutside(false)
                    .cancelable(true)
                    .build();
        }
        return progressDialog;
    }

    @Override
    public void showProgressDialog() {
        if (!getProgressDialog().isShowing()) {
            showProgressDialog(false);
        }
    }

    @Override
    public void showProgressDialog(boolean cancelable) {
        getProgressDialog().setCanceledOnTouchOutside(cancelable);
        getProgressDialog().show();
    }

    @Override
    public void hideProgressDialog() {
        if (getProgressDialog().isShowing()) {
            getProgressDialog().dismiss();
        }
    }

    @Override
    public void toastMsg(String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Activity getActivity() {
        return activity;
    }
}
