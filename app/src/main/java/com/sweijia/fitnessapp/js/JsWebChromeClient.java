package com.sweijia.fitnessapp.js;

import android.content.Context;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.sweijia.fitnessapp.MainActivity;
import com.sweijia.fitnessapp.utils.WebViewUtil;

public class JsWebChromeClient extends WebChromeClient {
    private Context _context;
    public JsWebChromeClient(Context context) {
        _context = context;
    }

    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        WebViewUtil.doAlert(_context, message, result);
        return true;
    }
}
