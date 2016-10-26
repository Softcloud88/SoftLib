package com.softcloud.softlib.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.softcloud.softlib.R;
import com.softcloud.softframe.baseView.BaseFragment;
import com.softcloud.softframe.baseView.IBasePresenter;
import com.softcloud.softframe.model.Top250MovieModel;
import com.softcloud.softframe.utils.ViewAccessor;

/**
 * Created by Softcloud on 16/8/28.
 */
public class ApiTestFragment extends BaseFragment implements ApiTestContract.View{

    @Override
    protected IBasePresenter initPresenter() {
        return ApiTestPresenter.getInstance(this);
    }

    private ApiTestPresenter getPresenter() {
        if (presenter == null) {
            presenter = initPresenter();
        }
        return (ApiTestPresenter) presenter;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_api_test;
    }

    @Override
    protected void setupView(LayoutInflater inflater, View rootView, Bundle savedInstanceState) {
        getPresenter().initData();
    }

    @Override
    public void renderMoviesInfo(Top250MovieModel moviesModel) {
        ViewAccessor.create(rootView).setText(R.id.tv_test, moviesModel.getSubjects().get(0).getTitle());
    }
}
