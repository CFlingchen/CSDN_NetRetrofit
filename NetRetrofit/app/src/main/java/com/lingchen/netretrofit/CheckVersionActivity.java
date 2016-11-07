package com.lingchen.netretrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.lingchen.netretrofit.net.ComApi;
import com.lingchen.netretrofit.net.ResBaseModel;
import com.lingchen.netretrofit.net.model.VersionModel;

import io.reactivex.functions.Consumer;

/**
 * Author    lingchen
 * Email     838878458@qq.com
 * Time      2016/11/4
 * Function  测试校验版本
 * http://bobo.yimwing.com/api/version/android_new
 */

public class CheckVersionActivity extends BaseActivity {
    private static final String TAG = "CheckVersionActivity";
    private TextView resultTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_version);
        resultTv = (TextView) findViewById(R.id.tv_result);
    }

    /*//开始请求
    public void start(View view) {
        Call<ResBaseModel<VersionModel>> call = ComApi.getInstance().checkVersionCall();
        call.enqueue(new Callback<ResBaseModel<VersionModel>>() {//异步请求
            @Override
            public void onResponse(Call<ResBaseModel<VersionModel>> call, final Response<ResBaseModel<VersionModel>> response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (response.isSuccessful() && response.body().isSuccess()) {
                            resultTv.setText(response.body().getData().getUpdateContent());
                        } else {
                            resultTv.setText("失败");
                        }
                    }
                });
            }

            @Override
            public void onFailure(Call<ResBaseModel<VersionModel>> call, final Throwable t) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        resultTv.setText(t.getMessage());
                    }
                });
            }
        });
    }*/

    /*//开始请求
    public void start(View view) {
        Flowable.create(new FlowableOnSubscribe<ResBaseModel<VersionModel>>() {
            @Override
            public void subscribe(final FlowableEmitter<ResBaseModel<VersionModel>> e) throws Exception {
                Call<ResBaseModel<VersionModel>> call = ComApi.getInstance().checkVersionCall();
                call.enqueue(new Callback<ResBaseModel<VersionModel>>() {//异步请求
                    @Override
                    public void onResponse(Call<ResBaseModel<VersionModel>> call, final Response<ResBaseModel<VersionModel>> response) {
                        if (!e.isCancelled()) {
                            e.onNext(response.body());
                        }
                        call.cancel();
                        e.onComplete();
                    }

                    @Override
                    public void onFailure(Call<ResBaseModel<VersionModel>> call, final Throwable t) {
                        if (!e.isCancelled()) {
                            e.onError(t);
                        }
                        call.cancel();
                        e.onComplete();
                    }
                });
            }
        }, BackpressureStrategy.BUFFER)
                .doOnNext(new Consumer<ResBaseModel<VersionModel>>() {
                    @Override
                    public void accept(ResBaseModel<VersionModel> versionModelResBaseModel) throws Exception {

                        if (versionModelResBaseModel.isSuccess()) {
                            resultTv.setText(versionModelResBaseModel.getData().getUpdateContent());
                        } else {
                            resultTv.setText("请求失败");
                        }
                    }
                })
                .subscribeOn(new IoScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        resultTv.setText(throwable.getMessage());
                    }
                })
                .onErrorResumeNext(Flowable.<ResBaseModel<VersionModel>>empty())
                .subscribe();
    }*/


    //开始请求
    public void start(View view) {
        //交给父类管理生命周期
        addDisposable(ComApi.getInstance().checkVersion()
                .doOnNext(new Consumer<ResBaseModel<VersionModel>>() {
                    @Override
                    public void accept(ResBaseModel<VersionModel> versionModelResBaseModel) throws Exception {
                        if (versionModelResBaseModel.isSuccess()) {
                            resultTv.setText(versionModelResBaseModel.getData().getUpdateContent());
                        } else {
                            resultTv.setText("请求失败");
                        }
                    }
                })
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        resultTv.setText(throwable.getMessage());
                    }
                })
                .subscribe());
        /*//延迟0.1s取消
        resultTv.postDelayed(new Runnable() {
            @Override
            public void run() {
                clear();
            }
        }, 200);*/
    }

}
