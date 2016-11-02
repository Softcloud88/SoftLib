package com.softcloud.softframe.base.view;

import android.view.View;

/**
 * Created by j-renzhexin on 2016/10/27.
 */

public interface ILoadView extends IBaseView {
    View showLoading();

    View showLoadedContent();

    View showLoadEmpty();

    View showLoadError();

}
