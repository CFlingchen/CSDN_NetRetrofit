package com.lingchen.testlib.dagger;

import com.lingchen.testlib.BaseActivity;
import com.lingchen.testlib.dagger.module.ApiModule;
import com.lingchen.testlib.dagger.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Author    lingchen
 * Email     838878458@qq.com
 * Time      2016/11/15
 * Function  主要注入器
 */
//用@Component表示这个接口是一个连接器
@Component(modules = {NetModule.class, ApiModule.class})
@Singleton
public interface MainComponent {
    /**
     * 需要用到这个连接器的对象，就是这个对象里面有需要注入的属性
     */
    void inject(BaseActivity activity);
}
