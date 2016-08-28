package com.softcloud.softlib.test;

import android.os.Bundle;
import android.view.View;

import com.softcloud.softlib.R;
import com.softcloud.softlib.baseView.BaseActivity;
import com.softcloud.softlib.utils.ViewAccessor;

public class HomeActivity extends BaseActivity {

    private View rootView;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_home;
    }

    @Override
    protected void setupView(Bundle savedInstanceState) {
        rootView = findViewById(R.id.v_root);
        ViewAccessor.create(rootView).setOnClickListener(R.id.btn_to_test, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchFragment(ApiTestFragment.class);
            }
        });
    }

}
