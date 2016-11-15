package com.lingchen.testlib;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.tv_result)
    TextView resultTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    //开始请求
    @OnClick(R.id.start)
    public void start(View view) {
       /* //交给父类管理生命周期
        addDisposable(mComApi.checkVersion()
                .doOnNext(versionModelResBaseModel -> {
                    if (versionModelResBaseModel.isSuccess()) {
                        resultTv.setText(versionModelResBaseModel.getData().getUpdateContent());
                    } else {
                        resultTv.setText("请求失败");
                    }
                })
                .doOnError(throwable -> resultTv.setText(throwable.getMessage()))
                .subscribe());*/
    }
}
