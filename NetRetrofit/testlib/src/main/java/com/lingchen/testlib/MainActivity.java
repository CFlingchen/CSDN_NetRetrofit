package com.lingchen.testlib;

import android.widget.TextView;

public class MainActivity extends BaseActivity {
    private TextView mTextView;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mTextView = (TextView) findViewById(R.id.tv_poetry);
    }

    @Override
    protected void initData() {
        addDisposable(mComApi.checkVersion()
                .doOnNext(versionModelResBaseModel -> {
                    if (versionModelResBaseModel.isSuccess()) {
                        mTextView.setText(versionModelResBaseModel.getData().getUpdateContent());
                    } else {
                        mTextView.setText("请求失败");
                    }
                })
                .doOnError(throwable -> mTextView.setText(throwable.getMessage()))
                .subscribe());
    }
}
