package com.sweijia.fitnessapp.js;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class JsWebViewClient extends WebViewClient {
    public JsWebViewClient() {
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return true;
    }
}
