package com.lingchen.netretrofit.net;

import android.support.annotation.NonNull;
import android.util.Log;

import org.reactivestreams.Publisher;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.IoScheduler;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author    lingchen
 * Email     838878458@qq.com
 * Time      2016/11/4
 * Function  通用接口基类
 * 封装线程调度
 */

public class BaseComApi {
    private static final String TAG = "BaseComApi";

    /**
     * 自己封装的方法，来减少代码亮
     *
     * @param call retrofit的call
     * @param <T>  泛型
     * @return Flowable
     */
    public static <T> Flowable<T> create(@NonNull final Call<T> call) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(final FlowableEmitter<T> e) throws Exception {
                call.enqueue(new Callback<T>() {
                    @Override
                    public void onResponse(Call<T> call, Response<T> response) {
                        Log.e(TAG, "onResponse: ");
                        if (!e.isCancelled()) {
                            Log.e(TAG, "onResponse: no cancel");
                            e.onNext(response.body());
                            e.onComplete();
                        }
                        call.cancel();
                    }

                    @Override
                    public void onFailure(Call<T> call, Throwable t) {
                        Log.e(TAG, "onFailure: ");
                        if (!e.isCancelled()) {
                            Log.e(TAG, "onResponse: no cancel");
                            e.onError(t);
                            e.onComplete();
                        }
                        call.cancel();
                    }
                });
            }
        }, BackpressureStrategy.BUFFER);
    }

    /**
     * 后台线程执行同步，主线程执行异步操作
     * 并且拦截所有错误，不让app崩溃
     *
     * @param <T> 数据类型
     * @return Transformer
     */
    public static <T> FlowableTransformer<T, T> background() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                return upstream.subscribeOn(new IoScheduler())
                        .observeOn(AndroidSchedulers.mainThread())
                        .onErrorResumeNext(Flowable.<T>empty());
            }
        };
    }

}
