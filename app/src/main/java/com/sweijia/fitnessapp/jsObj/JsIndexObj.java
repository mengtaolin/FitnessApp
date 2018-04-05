package com.sweijia.fitnessapp.jsObj;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/**
 * Created by Administrator on 2018/4/4.
 */

public class JsIndexObj {

    private WebView webView;
    public JsIndexObj(WebView webView) {
        this.webView = webView;
    }

    @JavascriptInterface
    public void gotoWebView(final String url){
//        webView.post(new Runnable() {
//            @Override
//            public void run() {
//                webView.loadUrl(url);
//            }
//        });
        doJsFun();
    }

    public void doJsFun(){
        webView.post(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl("javascript:addItem()");
            }
        });
    }
}
