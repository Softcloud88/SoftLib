package com.softcloud.softframe.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.softcloud.softframe.R;
import com.softcloud.softframe.utils.ViewHelper;

/**
 * Created by j-renzhexin on 2016/10/31.
 */

public class SoftLoadLayout extends FrameLayout {

    private static final int CONTENT_VIEW_INDEX = 0;
    private View contentView;
    private View loadingView;
    private View emptyView;
    private View errorView;

    public SoftLoadLayout(Context context) {
        this(context, null);
    }

    public SoftLoadLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SoftLoadLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initContentView();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SoftLoadLayout);
        int emptyLayoutRes = typedArray.getResourceId(R.styleable.SoftLoadLayout_emptyLayout, 0);
        int loadingLayoutRes = typedArray.getResourceId(R.styleable.SoftLoadLayout_loadingLayout, 0);
        int errorLayoutRes = typedArray.getResourceId(R.styleable.SoftLoadLayout_errorLayout, 0);
        typedArray.recycle();
        setEmptyLayout(emptyLayoutRes);
        setLoadingLayout(loadingLayoutRes);
        setErrorLayout(errorLayoutRes);
    }

    private void initContentView() {
        if (getChildCount() != 1) {
            throw new IllegalStateException("LoadLayout must has one and only one content view!");
        }
        contentView = getChildAt(0);
    }

    //region related to view set
    public View setContentLayout(@NonNull View contentView) {
        if (this.contentView != contentView) {
            removeView(this.contentView);
            this.contentView = contentView;
            addView(this.contentView, CONTENT_VIEW_INDEX);
        }
        return this.contentView;
    }

    public View setEmptyLayout(@LayoutRes int layoutRes) {
        return setEmptyLayout(inflate(getContext(), layoutRes, this));
    }

    public View setEmptyLayout(@NonNull View emptyView) {
        if (this.emptyView != emptyView) {
            removeView(this.emptyView);
            this.emptyView = emptyView;
            addView(this.emptyView);
        }
        return this.emptyView;
    }

    public View setErrorLayout(@LayoutRes int layoutRes) {
        return setErrorLayout(inflate(getContext(), layoutRes, this));
    }

    public View setErrorLayout(@NonNull View errorView) {
        if (this.errorView != errorView) {
            removeView(this.errorView);
            this.errorView = errorView;
            addView(this.errorView);
        }
        return this.errorView;
    }

    public View setLoadingLayout(@LayoutRes int layoutRes) {
        return setLoadingLayout(inflate(getContext(), layoutRes, this));
    }

    public View setLoadingLayout(@NonNull View loadingView) {
        if (this.loadingView != loadingView) {
            removeView(this.loadingView);
            this.loadingView = loadingView;
            addView(this.loadingView);
        }
        return this.loadingView;
    }
    //endregion

    public View showContent() {
        ViewHelper.setVisibility(contentView, VISIBLE);
        ViewHelper.setVisibility(errorView, GONE);
        ViewHelper.setVisibility(loadingView, GONE);
        ViewHelper.setVisibility(emptyView, GONE);
        return contentView;
    }

    public View showLoading() {
        ViewHelper.setVisibility(contentView, GONE);
        ViewHelper.setVisibility(errorView, GONE);
        ViewHelper.setVisibility(loadingView, VISIBLE);
        ViewHelper.setVisibility(emptyView, GONE);
        return loadingView;
    }

    public View showError() {
        ViewHelper.setVisibility(contentView, GONE);
        ViewHelper.setVisibility(errorView, VISIBLE);
        ViewHelper.setVisibility(loadingView, GONE);
        ViewHelper.setVisibility(emptyView, GONE);
        return errorView;
    }

    public View showEmpty() {
        ViewHelper.setVisibility(contentView, GONE);
        ViewHelper.setVisibility(errorView, GONE);
        ViewHelper.setVisibility(loadingView, GONE);
        ViewHelper.setVisibility(emptyView, VISIBLE);
        return emptyView;
    }

    public void setLoadingClickListener(OnClickListener listener) {
        ViewHelper.setOnClickListener(loadingView, listener);
    }

    public void setEmptyClickListener(OnClickListener listener) {
        ViewHelper.setOnClickListener(emptyView, listener);
    }

    public void setErrorClickListener(OnClickListener listener) {
        ViewHelper.setOnClickListener(errorView, listener);
    }
}
