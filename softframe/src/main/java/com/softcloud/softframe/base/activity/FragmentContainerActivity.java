package com.softcloud.softframe.base.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

import com.softcloud.softframe.R;
import com.softcloud.softframe.utils.ArgumentHelper;

/**
 * Created by j-renzhexin on 2016/11/1.
 */

public class FragmentContainerActivity extends SoftBaseActivity {

    private static final String TAG_LOG = "reusing_activity";
    private static final String ARGUMENT_KEY_FRAGMENT_NAME = "argument_key_fragment_name";
    private static final String ARGUMENT_KEY_BUNDLE = "argument_key_bundle";

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_fragment_container;
    }

    @Override
    protected void setupView(View rootView, Bundle savedInstanceState) {
        String fragmentName = ArgumentHelper.getSerializable(getIntent(), ARGUMENT_KEY_FRAGMENT_NAME);
        Fragment fragment;
        try {
            fragment = Fragment.instantiate(this
                    , fragmentName, getIntent().getBundleExtra(ARGUMENT_KEY_BUNDLE));
            loadFragment(fragment);
        } catch (Exception e) {
            Log.d(TAG_LOG, e.getMessage());
            finish();
        }
    }

    @Override
    protected void onViewInit(View rootView, Bundle savedInstanceState) {}

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getFragments() != null && fragmentManager.getFragments().contains(fragment)) {
            fragmentManager.getFragments().remove(fragment);
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_container, fragment);
        transaction.commitAllowingStateLoss();
    }

    public static void launchFragment(Activity activity, Class<? extends Fragment> clazzFragment) {
        launchFragment(activity,clazzFragment, null);
    }

    public static void launchFragment(Activity activity, Class<? extends Fragment> clazzFragment, Bundle args) {
        launchFragment(activity, clazzFragment, 0, args);
    }

    public static void launchFragment(Activity activity, Class<? extends Fragment> clazzFragment, int requestCode, Bundle args) {
        Intent intent = new Intent(activity, FragmentContainerActivity.class);
        intent.putExtra(ARGUMENT_KEY_FRAGMENT_NAME, clazzFragment.getName());
        if (args != null) {
            intent.putExtra(ARGUMENT_KEY_BUNDLE, args);
        }
        if (requestCode == 0) {
            activity.startActivity(intent);
        } else {
            activity.startActivityForResult(intent, requestCode);
        }
    }
}
