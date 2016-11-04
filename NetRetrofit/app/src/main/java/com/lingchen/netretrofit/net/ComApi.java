package com.lingchen.netretrofit.net;

import com.lingchen.netretrofit.net.model.VersionModel;

import io.reactivex.Flowable;
import retrofit2.Call;

/**
 * Author    lingchen
 * Email     838878458@qq.com
 * Time      2016/11/4
 * Function  网络通用接口
 */

public class ComApi extends BaseComApi {

    public static ComApi comApi;
    private ComInterface mComInterface;

    public static ComApi getInstance() {
        synchronized (ComApi.class) {
            if (comApi == null) {
                comApi = new ComApi();
            }
        }
        return comApi;
    }

    private ComApi() {
        mComInterface = NetClient.newRetrofit().create(ComInterface.class);
    }


    /**
     * 检测版本
     *
     * @return 回调
     */
    public Call<ResBaseModel<VersionModel>> checkVersionCall() {
        return mComInterface.checkVersion();
    }


    /**
     * 检测版本
     */
    public Flowable<ResBaseModel<VersionModel>> checkVersion() {
        return create(mComInterface.checkVersion())
                .compose(BaseComApi.<ResBaseModel<VersionModel>>background());
    }


}
