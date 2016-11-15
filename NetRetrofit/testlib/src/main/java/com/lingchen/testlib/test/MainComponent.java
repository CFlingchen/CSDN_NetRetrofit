package com.lingchen.testlib.test;

import com.lingchen.testlib.BaseActivity;
import com.lingchen.testlib.dagger.ApiModule;
import com.lingchen.testlib.dagger.NetModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Author    lingchen
 * Email     838878458@qq.com
 * Time      2016/11/14
 * Function  ...
 */
//用@Component表示这个接口是一个连接器，能用@Component注解的只
//能是interface或者抽象类
@Component(modules = {NetModule.class, ApiModule.class})
@Singleton
public interface MainComponent {
    /**
     * 需要用到这个连接器的对象，就是这个对象里面有需要注入的属性
     * （被标记为@Inject的属性）
     * 这里inject表示注入的意思，这个方法名可以随意更改，但建议就
     * 用inject即可。
     */
    void inject(BaseActivity activity);
}
