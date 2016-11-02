package com.softcloud.softframe.base.view;

import in.srain.cube.views.loadmore.LoadMoreContainer;

/**
 * Created by j-renzhexin on 2016/10/31.
 */

public interface ILoadMoreView extends IPtrView {
    boolean isCanLoadMore();
    void resetLoadMoreStatus();
    void onLoadMore(LoadMoreContainer loadMoreContainer);
    void loadMoreFinish(boolean emptyResult, boolean hasMore);
}
