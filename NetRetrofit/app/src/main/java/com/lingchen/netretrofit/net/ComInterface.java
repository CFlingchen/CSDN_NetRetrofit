package com.lingchen.netretrofit.net;

import com.lingchen.netretrofit.net.model.VersionModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Author    lingchen
 * Email     838878458@qq.com
 * Time      2016/11/4
 * Function  网络接口 Retrofit().create（）
 */

public interface ComInterface {


    @GET("/api/version/android_new")
    Call<ResBaseModel<VersionModel>> checkVersion();
}
