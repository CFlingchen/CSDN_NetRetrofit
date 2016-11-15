package com.lingchen.netlibrary.net;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author    lingchen
 * Email     838878458@qq.com
 * Time      2016/11/4
 * Function  网络客户端
 */
public class NetClient {

    /**
     * 获取Retrofit适配器。
     *
     * @return 网络适配器
     */
    public static Retrofit newRetrofit(String baseUrl) {
        return new Retrofit.Builder().baseUrl(baseUrl).client(getClient().build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * 获取 OkHttpClient
     *
     * @return OkHttpClient
     */
    public static OkHttpClient.Builder getClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor());//日志
    }
}
