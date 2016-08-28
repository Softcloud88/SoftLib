package com.softcloud.softlib.baseView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import com.softcloud.softlib.utils.ActivityManager;

/**
 * Created by j-renzhexin on 2016/8/25.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(getLayoutResId());
        rootView = findViewById(getLayoutResId());
        setupView(savedInstanceState);
    }

    protected abstract int getLayoutResId();

    protected abstract void setupView(Bundle savedInstanceState);

    @Override
    protected void onDestroy() {
        ActivityManager.getInstance().removeActivity(this);
        super.onDestroy();
    }

    protected void launch(Class<? extends Activity> clazz) {
        launch(clazz, null);
    }

    protected void launch(Class<? extends Activity> clazz, Bundle args) {
        launch(clazz, args, 0);
    }

    protected void launch(Class<? extends Activity> clazz, Bundle args, int requestCode) {
        Intent intent = new Intent(this, clazz);
        if (args != null) {
            intent.putExtras(args);
        }
        if (requestCode != 0) {
            startActivityForResult(intent, requestCode);
        } else {
            startActivity(intent);
        }
    }

    protected void launchFragment(Class<? extends Fragment> clazzFragment) {
        launchFragment(clazzFragment, null);
    }

    protected void launchFragment(Class<? extends Fragment> clazzFragment, Bundle args) {
        launchFragment(clazzFragment, 0, args);
    }

    protected void launchFragment(Class<? extends Fragment> clazzFragment, int requestCode, Bundle args) {
        ReusingActivity.launchFragment(this, clazzFragment, requestCode, args);
    }
}
