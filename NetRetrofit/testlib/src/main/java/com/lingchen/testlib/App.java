package com.lingchen.testlib;

import android.app.Application;

import com.lingchen.testlib.dagger.DaggerMainComponent;
import com.lingchen.testlib.dagger.MainComponent;

/**
 * Author    lingchen
 * Email     838878458@qq.com
 * Time      2016/11/15
 * Function  Application
 */

public class App extends Application {
    public static MainComponent mainComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
    }

    // 使用Dagger2生成的类 生成组件进行构造，并注入
    private void initComponent() {
        mainComponent = DaggerMainComponent.builder()
                .build();
    }

    public static MainComponent component() {
        return mainComponent;
    }

}
