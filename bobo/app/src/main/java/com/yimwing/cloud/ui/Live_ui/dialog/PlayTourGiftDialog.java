package com.yimwing.cloud.ui.Live_ui.dialog;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.yimwing.cloud.R;

/**
 * Author    lingchen
 * Email     838878458@qq.com
 * Time      2016/11/10
 * Function  打赏动画
 */

public class PlayTourGiftDialog extends OperateSelector {

    public PlayTourGiftDialog(Activity activity) {
        super(activity, new Configuration());
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.dialog_playtour_gift;
    }

    @Override
    protected void preOnShow(CustomDialog dialog) {
        dialog.setCanceledOnTouchOutside(false);
        activity.getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        WebView webView = dialog.findView(R.id.wv_playtour_gift);
        webView.loadUrl("http://10.0.0.11:36/web-mobile/");
        WebSettings settings = webView.getSettings();
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        // 应用可以有缓存
        settings.setAppCacheEnabled(true);

        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
        webView.setBackgroundColor(0);
    }

    @Override
    protected void postOnShow(final CustomDialog dialog) {

    }

}
