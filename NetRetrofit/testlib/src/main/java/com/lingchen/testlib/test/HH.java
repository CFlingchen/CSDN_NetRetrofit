package com.lingchen.testlib.test;

import android.os.Bundle;
import android.widget.TextView;

import com.lingchen.testlib.BaseActivity;
import com.lingchen.testlib.R;

/**
 * Author    lingchen
 * Email     838878458@qq.com
 * Time      2016/11/14
 * Function  ...
 */

public class HH extends BaseActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hh);
        initView();
    }

    private void initView() {
        mTextView = (TextView) findViewById(R.id.tv_poetry);

        mComApi.checkVersion()
                .doOnNext(versionModelResBaseModel -> {
                    if (versionModelResBaseModel.isSuccess()) {
                        mTextView.setText(versionModelResBaseModel.getData().getUpdateContent());
                    } else {
                        mTextView.setText("请求失败");
                    }
                })
                .doOnError(throwable -> mTextView.setText(throwable.getMessage()))
                .subscribe();

    }
}
