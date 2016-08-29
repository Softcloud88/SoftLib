package com.softcloud.softlib.test;

import com.softcloud.softlib.baseView.IBasePresenter;
import com.softcloud.softlib.baseView.IBaseView;
import com.softcloud.softlib.test.model.Top250MovieModel;

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
