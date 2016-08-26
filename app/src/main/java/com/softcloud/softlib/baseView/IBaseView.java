package com.softcloud.softlib.baseView;

import com.softcloud.softlib.presenter.BasePresenter;

/**
 * Created by j-renzhexin on 2016/8/26.
 */
public interface IBaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
