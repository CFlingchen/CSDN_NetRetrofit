package com.lingchen.testlib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lingchen.testlib.net.ComApi;
import com.lingchen.testlib.test.DaggerMainComponent;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;

/**
 * Author    lingchen
 * Email     838878458@qq.com
 * Time      2016/11/4
 * Function  所有界面基类
 */

public class BaseActivity extends AppCompatActivity {
    //添加@Inject注解，表示这个mPoetry是需要注入的
    @Inject
    Poetry mPoetry;

    @Inject
    protected ComApi mComApi;
    private ListCompositeDisposable listCompositeDisposable = new ListCompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 使用Dagger2生成的类 生成组件进行构造，并注入
        DaggerMainComponent.builder()
                .build()
                .inject(this);
    }

    protected void addDisposable(Disposable disposable) {
        if (disposable != null && !disposable.isDisposed()) {
            listCompositeDisposable.add(disposable);
        }
    }

    protected void reDisposable(Disposable disposable) {
        if (disposable != null) {
            listCompositeDisposable.remove(disposable);
        }
    }

    protected void clear() {
        if (!listCompositeDisposable.isDisposed()) {
            listCompositeDisposable.clear();
        }
    }

    @Override
    protected void onDestroy() {
        clear();
        super.onDestroy();
    }
}
