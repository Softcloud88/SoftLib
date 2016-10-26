package com.softcloud.softlib.test;

import com.softcloud.softframe.baseView.IBasePresenter;
import com.softcloud.softframe.baseView.IBaseView;
import com.softcloud.softframe.model.Top250MovieModel;

/**
 * Created by j-renzhexin on 2016/8/29.
 */
public interface ApiTestContract {

    interface View extends IBaseView {
        void renderMoviesInfo(Top250MovieModel moviesModel);
    }

    interface Presenter extends IBasePresenter {
        void initData();
    }
}
