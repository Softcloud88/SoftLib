package com.softcloud.softframe.base.view;

import android.support.annotation.IdRes;
import android.view.View;

import com.softcloud.softframe.widgets.SoftLoadLayout;

/**
 * Created by j-renzhexin on 2016/10/31.
 */

public abstract class LoadViewImpl extends BaseViewImpl implements ILoadView {

    private SoftLoadLayout softLoadLayout;

    public LoadViewImpl(View rootView) {
        super(rootView);
    }

    protected abstract @IdRes int getLoadLayoutResId();

    @Override
    public View showLoading() {
        if (getLoadLayout() != null) {
            return getLoadLayout().showLoading();
        } else {
            return null;
        }
    }

    @Override
    public View showLoadedContent() {
        if (getLoadLayout() != null) {
            return getLoadLayout().showContent();
        } else {
            return null;
        }
    }

    @Override
    public View showLoadEmpty() {
        if (getLoadLayout() != null) {
            return getLoadLayout().showEmpty();
        } else {
            return null;
        }
    }

    @Override
    public View showLoadError() {
        if (getLoadLayout() != null) {
            return getLoadLayout().showError();
        } else {
            return null;
        }
    }

    private SoftLoadLayout getLoadLayout() {
        if (softLoadLayout == null) {
            softLoadLayout = (SoftLoadLayout) rootView.findViewById(getLoadLayoutResId());
        }
        return softLoadLayout;
    }
}
