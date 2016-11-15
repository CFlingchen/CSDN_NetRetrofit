package com.lingchen.testlib;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Author    lingchen
 * Email     838878458@qq.com
 * Time      2016/11/14
 * Function  ...
 */

public class Poetry {
    private String mPemo;

    // 用Inject标记构造函数,表示用它来注入到目标对象中去
    @Inject
    @Singleton
    public Poetry() {
        mPemo = "11";
    }

    public String getPemo() {
        return mPemo;
    }
}
