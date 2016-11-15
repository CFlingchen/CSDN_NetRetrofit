package com.lingchen.testlib.net;

import com.lingchen.netlibrary.net.BaseComApi;
import com.lingchen.netlibrary.net.ResBaseModel;
import com.lingchen.netlibrary.net.model.VersionModel;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import retrofit2.Retrofit;

/**
 * Author    lingchen
 * Email     838878458@qq.com
 * Time      2016/11/14
 * Function  网络接口
 */
public class ComApi extends BaseComApi {
    private ComInterface mComInterface;

    public ComApi(ComInterface comInterface) {
        mComInterface = comInterface;
    }

    /**
     * 检测版本
     */
    public Flowable<ResBaseModel<VersionModel>> checkVersion() {
        return create(mComInterface.checkVersion())
                .compose(BaseComApi.background());
    }
}
