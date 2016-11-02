package com.softcloud.softframe.base.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.softcloud.softframe.R;
import com.softcloud.softframe.base.activity.FragmentContainerActivity;
import com.softcloud.softframe.base.view.IBaseView;
import com.softcloud.softframe.utils.IntentHelper;

/**
 * Created by j-renzhexin on 2016/10/31.
 */

public abstract class SoftBaseFragment extends Fragment implements IBaseView{

    protected LayoutInflater inflater;
    protected View rootView;
    private MaterialDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        rootView = inflater.inflate(getFragmentLayoutId(), container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupView(savedInstanceState);
        onViewInit(rootView, savedInstanceState);
    }

    protected abstract int getFragmentLayoutId();

    protected abstract void setupView(Bundle savedInstanceState);

    protected abstract void onViewInit(View rootView, Bundle savedInstanceState);

    protected View findViewById(int resId) {
        return rootView != null ? rootView.findViewById(resId) : null;
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    protected MaterialDialog getProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new MaterialDialog.Builder(getContext())
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
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    protected void launchToActivity(Class<? extends Activity> clazz) {
        launchToActivity(clazz, null);
    }

    protected void launchToActivity(Class<? extends Activity> clazz, Bundle args) {
        launchToActivity(clazz, args, 0);
    }

    protected void launchToActivity(Class<? extends Activity> clazz, Bundle args, int requestCode) {
        Intent intent = IntentHelper.createIntent(getActivity(), clazz, false);
        if (args != null) {
            intent.putExtras(args);
        }
        if (requestCode != 0) {
            startActivityForResult(intent, requestCode);
        } else {
            startActivity(intent);
        }
    }

    protected void launchToFragment(Class<? extends Fragment> clazzFragment) {
        launchToFragment(clazzFragment, null);
    }

    protected void launchToFragment(Class<? extends Fragment> clazzFragment, Bundle args) {
        launchToFragment(clazzFragment, 0, args);
    }

    protected void launchToFragment(Class<? extends Fragment> clazzFragment, int requestCode, Bundle args) {
        FragmentContainerActivity.launchFragment(getActivity(), clazzFragment, requestCode, args);
    }
}
