package com.softcloud.softframe.base.view;

import android.support.annotation.IdRes;
import android.view.View;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by j-renzhexin on 2016/11/1.
 */

public abstract class PtrViewImpl extends LoadViewImpl implements IPtrView {

    public PtrViewImpl(View rootView) {
        super(rootView);
        initPtrView();
    }

    private PtrClassicFrameLayout ptrClassicFrameLayout;

    protected abstract @IdRes int getPtrResId();

    protected abstract View getCheckRefreshView();

    protected void initPtrView() {
        ptrClassicFrameLayout = (PtrClassicFrameLayout) rootView.findViewById(getPtrResId());
        if (ptrClassicFrameLayout == null) {
            throw new IllegalStateException("cannot find ptr layout!");
        }
        ptrClassicFrameLayout.setLoadingMinTime(1000);
        ptrClassicFrameLayout.setLastUpdateTimeRelateObject(this);
        ptrClassicFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return isCanPullToRefresh() && PtrDefaultHandler.checkContentCanBePulledDown(frame, getCheckRefreshView(), header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                PtrViewImpl.this.onRefreshBegin();
            }
        });
        ptrClassicFrameLayout.setPullToRefresh(false);
        ptrClassicFrameLayout.setKeepHeaderWhenRefresh(true);
        ptrClassicFrameLayout.setDurationToClose(200);
    }

    protected PtrClassicFrameLayout getPtrFrameLayout() {
        if (ptrClassicFrameLayout == null) {
            initPtrView();
        }
        return ptrClassicFrameLayout;
    }

    protected abstract boolean isCanPullToRefresh();

    protected abstract void onRefreshBegin();

    @Override
    public void refreshComplete() {
        getPtrFrameLayout().refreshComplete();
    }
}
