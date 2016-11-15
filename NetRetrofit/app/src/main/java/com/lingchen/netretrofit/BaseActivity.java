package com.lingchen.netretrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;

/**
 * Author    lingchen
 * Email     838878458@qq.com
 * Time      2016/11/4
 * Function  所有界面基类
 */

public class BaseActivity extends AppCompatActivity {
    private ListCompositeDisposable listCompositeDisposable = new ListCompositeDisposable();

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
