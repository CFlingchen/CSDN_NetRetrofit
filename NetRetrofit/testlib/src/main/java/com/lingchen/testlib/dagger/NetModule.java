package com.lingchen.testlib.dagger;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author    lingchen
 * Email     838878458@qq.com
 * Time      2016/11/14
 * Function  网络相关
 */
@Module
public class NetModule {
    //暂时放在这里
    private static final String URL = "http://bobo.yimwing.com";

    @Singleton
    @Provides
    public Retrofit getRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    public OkHttpClient getClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.writeTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(300, TimeUnit.SECONDS);
        builder.addInterceptor(new HttpLoggingInterceptor());
        return builder.build();
    }

}
