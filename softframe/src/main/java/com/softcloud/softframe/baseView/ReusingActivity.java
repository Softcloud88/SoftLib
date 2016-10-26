package com.softcloud.softframe.baseView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.softcloud.softframe.R;
import com.softcloud.softframe.utils.ArgumentHelper;
import com.softcloud.softframe.utils.LogUtils;

/**
 * Created by j-renzhexin on 2016/8/26.
 */
public class ReusingActivity extends BaseActivity {

    private static final String ARGUMENT_KEY_FRAGMENT_NAME = "argument_key_clazz_fragment";
    private static final String ARGUMENT_KEY_BUNDLE = "argument_key_bundle";


    private static final String TAG_LOG = "reusing_activity";

    @Override
    protected void setupView(Bundle savedInstanceState) {
        String fragmentName = ArgumentHelper.getSerializable(getIntent(), ARGUMENT_KEY_FRAGMENT_NAME);
        Fragment fragment;
        try {
            fragment = android.support.v4.app.Fragment.instantiate(this
                    , fragmentName, getIntent().getBundleExtra(ARGUMENT_KEY_BUNDLE));
            loadFragment(fragment);
        } catch (Exception e) {
            LogUtils.d(TAG_LOG, e.getMessage());
            finish();
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_reusing;
    }

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
        launchFragment(activity, clazzFragment, null);
    }

    public static void launchFragment(Activity activity, Class<? extends Fragment> clazzFragment, Bundle args) {
        launchFragment(activity, clazzFragment, 0, args);
    }

    public static void launchFragment(Activity activity, Class<? extends Fragment> clazzFragment, int requestCode, Bundle args) {
        Intent intent = new Intent(activity, ReusingActivity.class);
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
