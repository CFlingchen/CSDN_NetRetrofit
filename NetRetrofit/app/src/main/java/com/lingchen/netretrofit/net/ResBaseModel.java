package com.lingchen.netretrofit.net;

/**
 * Author    lingchen
 * Email     838878458@qq.com
 * Time      2016/11/4
 * Function  数据响应模型
 */

public class ResBaseModel<T> {
    private static final int CODE_SUCCESS = 1;

    /**
     * data : {}
     * code : 1
     * msg : 操作成功
     */

    private int code;
    private String msg;
    protected T data;

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public boolean isSuccess() {
        return CODE_SUCCESS == code;
    }
}
