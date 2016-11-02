package com.softcloud.softlib.test;

import android.os.Bundle;
import android.view.View;

import com.softcloud.softframe.base.activity.SoftBaseActivity;
import com.softcloud.softframe.utils.ViewAccessor;
import com.softcloud.softlib.R;

public class HomeActivity extends SoftBaseActivity {

    private View rootView;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_home;
    }

    @Override
    protected void setupView(View rootView, Bundle savedInstanceState) {
        rootView = findViewById(R.id.v_root);
        ViewAccessor.create(rootView).setOnClickListener(R.id.btn_to_test, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // launchFragment(ApiTestFragment.class);
            }
        });
    }

    @Override
    protected void onViewInit(View rootView, Bundle savedInstanceState) {

    }
}
