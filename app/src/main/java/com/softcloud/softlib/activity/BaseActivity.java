package com.softcloud.softlib.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by j-renzhexin on 2016/8/25.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentResId());
    }

    protected abstract int getContentResId();
}
