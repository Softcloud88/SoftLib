package com.softcloud.softframe.base.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.softcloud.softframe.R;
import com.softcloud.softframe.base.view.IBaseView;

/**
 * Created by j-renzhexin on 2016/10/27.
 */

public abstract class SoftBaseActivity extends AppCompatActivity implements IBaseView  {

    private MaterialDialog progressDialog;
    protected View rootView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewResId());
        rootView = getWindow().getDecorView();
        setupView(rootView, savedInstanceState);
        onViewInit(rootView, savedInstanceState);
    }

    protected abstract @LayoutRes int getContentViewResId();

    protected abstract void setupView(View rootView, Bundle savedInstanceState);

    protected abstract void onViewInit(View rootView, Bundle savedInstanceState);

    @Override
    public View getRootView() {
        if (rootView == null) {
            rootView = getWindow().getDecorView();
        }
        return rootView;
    }

    protected MaterialDialog getProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new MaterialDialog.Builder(this)
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
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
