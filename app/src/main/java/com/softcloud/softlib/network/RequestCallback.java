package com.softcloud.softlib.network;

import com.softcloud.softlib.test.model.BaseModel;

/**
 * Created by j-renzhexin on 2016/8/29.
 */
public interface RequestCallback<T extends BaseModel> {
    void onSuccess(T model);
    void onFailed(T model);
    void onError(Throwable e);
}
