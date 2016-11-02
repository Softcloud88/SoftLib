package com.softcloud.softframe.base.view;

import android.support.annotation.IdRes;
import android.view.View;

import in.srain.cube.views.loadmore.LoadMoreContainer;
import in.srain.cube.views.loadmore.LoadMoreHandler;
import in.srain.cube.views.loadmore.LoadMoreListViewContainer;

/**
 * Created by j-renzhexin on 2016/11/1.
 */

public abstract class LoadMoreViewImpl extends PtrViewImpl implements ILoadMoreView {

    public LoadMoreViewImpl(View rootView) {
        super(rootView);
    }

    private LoadMoreListViewContainer loadMoreListViewContainer;

    protected abstract @IdRes
    int getLoadMoreContainerResId();

    private void initLoadMoreContainer() {
        loadMoreListViewContainer = (LoadMoreListViewContainer) rootView.findViewById(getLoadMoreContainerResId());
        if (loadMoreListViewContainer == null) {
            return;
        }
        loadMoreListViewContainer.useDefaultHeader();
        loadMoreListViewContainer.setLoadMoreHandler(new LoadMoreHandler() {
            @Override
            public void onLoadMore(LoadMoreContainer loadMoreContainer) {
                LoadMoreViewImpl.this.onLoadMore(loadMoreContainer);
            }
        });
        if (!isCanLoadMore()) {
            loadMoreListViewContainer.loadMoreFinish(true, false);
        }
    }

    @Override
    public void resetLoadMoreStatus() {
        getLoadMoreListViewContainer().loadMoreFinish(false, isCanLoadMore());
    }

    @Override
    public void loadMoreFinish(boolean emptyResult, boolean hasMore) {
        getLoadMoreListViewContainer().loadMoreFinish(emptyResult, hasMore);
    }

    protected LoadMoreListViewContainer getLoadMoreListViewContainer() {
        if (loadMoreListViewContainer == null) {
            initLoadMoreContainer();
        }
        return loadMoreListViewContainer;
    }
}
