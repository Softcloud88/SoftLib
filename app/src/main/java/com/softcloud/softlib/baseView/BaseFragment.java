package com.softcloud.softlib.baseView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by j-renzhexin on 2016/8/26.
 */
public abstract class BaseFragment extends Fragment implements IBaseView{

    private LayoutInflater inflater;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        rootView = inflater.inflate(getLayoutResId(), container, false);
        return rootView;
    }

    protected abstract int getLayoutResId();

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
}
