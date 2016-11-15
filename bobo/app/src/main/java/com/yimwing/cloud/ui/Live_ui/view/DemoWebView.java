package com.yimwing.cloud.ui.Live_ui.view;


import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Author    lingchen
 * Email     838878458@qq.com
 * Time      2016/11/11
 * Function  显示gift动画
 */

public class DemoWebView extends WebView {
    public DemoWebView(Context context) {
        this(context, null);
    }

    public DemoWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    private void init() {
        WebSettings settings = getSettings();
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        // 应用可以有缓存
        settings.setAppCacheEnabled(true);
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
        setBackgroundColor(0);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {//永远不拦截
        return false;
    }

}
