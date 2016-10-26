package com.softcloud.softframe.baseView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by j-renzhexin on 2016/8/26.
 */
public abstract class BaseFragment extends Fragment implements IBaseView{

    protected LayoutInflater inflater;
    protected View rootView;
    protected IBasePresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
    }

    protected abstract  IBasePresenter initPresenter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        rootView = inflater.inflate(getLayoutResId(), container, false);
        setupView(inflater, rootView, savedInstanceState);
        return rootView;
    }

    protected abstract int getLayoutResId();

    protected abstract void setupView(LayoutInflater inflater, View rootView, Bundle savedInstanceState);

    @Override
    public void onDestroy() {
        if (presenter != null) {
            presenter.onDetach();
            presenter = null;
        }
        super.onDestroy();
    }

    protected void launch(Class<? extends Activity> clazz) {
        launch(clazz, null);
    }

    protected void launch(Class<? extends Activity> clazz, Bundle args) {
        launch(clazz, args, 0);
    }

    protected void launch(Class<? extends Activity> clazz, Bundle args, int requestCode) {
        Intent intent = new Intent(getActivity(), clazz);
        if (args != null) {
            intent.putExtras(args);
        }
        if (requestCode != 0) {
            startActivityForResult(intent, requestCode);
        } else {
            startActivity(intent);
        }
    }

    protected void launchFragment(Class<? extends BaseFragment> clazzFragment) {
        launchFragment(clazzFragment, null);
    }

    protected void launchFragment(Class<? extends BaseFragment> clazzFragment, Bundle args) {
        launchFragment(clazzFragment, 0, args);
    }

    protected void launchFragment(Class<? extends BaseFragment> clazzFragment, int requestCode, Bundle args) {
        ReusingActivity.launchFragment(getActivity(), clazzFragment, requestCode, args);
    }

    @Override
    public void toast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
