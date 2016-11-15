package com.lingchen.testlib.dagger.module;

import com.lingchen.testlib.net.ComApi;
import com.lingchen.testlib.net.ComInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Author    lingchen
 * Email     838878458@qq.com
 * Time      2016/11/14
 * Function  提供网络接口
 */
@Module
public class ApiModule {

    @Singleton
    @Provides
    public ComApi getComApi(Retrofit retrofit) {
        ComInterface comInterface = retrofit.create(ComInterface.class);
        return new ComApi(comInterface);
    }
}
