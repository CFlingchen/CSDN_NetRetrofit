package com.yimwing.cloud.EventListener;

import android.view.View;

/**
 * Author     Sdz
 * Email      946616236@qq.com
 * Time       2016/11/9 0009
 * Function   防抖点击
 */
public abstract class AntiShakeOnClickListener implements View.OnClickListener {
    private long antiShakeTime = 500;

    private long lastTime;

    public AntiShakeOnClickListener() {
    }

    public AntiShakeOnClickListener(long antiShakeTime) {
        this.antiShakeTime = antiShakeTime;
    }

    @Override
    public void onClick(View v) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastTime >= antiShakeTime) {
            onAntiShakeClick(v);
        }
        lastTime = currentTime;
    }

    protected abstract void onAntiShakeClick(View view);
}
