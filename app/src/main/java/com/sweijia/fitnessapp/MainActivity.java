package com.sweijia.fitnessapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.sweijia.fitnessapp.js.JsWebChromeClient;
import com.sweijia.fitnessapp.js.JsWebViewClient;
import com.sweijia.fitnessapp.jsObj.JsIndexObj;
import com.sweijia.fitnessapp.utils.WebViewUtil;

import java.util.HashMap;
import java.util.Map;
public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private Map<Integer, String> urlMap;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int value = item.getItemId();
            if(urlMap.containsKey(value)){
                String url = urlMap.get(value);
                url = "file:///android_asset/html5/" + url;
                webView.loadUrl(url);
                return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initDatas();
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        this.initWebView();
        this.initHtml();
    }

    private void initDatas() {
        urlMap = new HashMap<Integer, String>();
        urlMap.put(R.id.navigation_home, "index.html");
        urlMap.put(R.id.navigation_dashboard, "src/dashboard.html");
        urlMap.put(R.id.navigation_notifications, "src/notifications.html");
    }

    private void initWebView(){
        webView = (WebView)findViewById(R.id.wb);
        webView.setWebViewClient(new JsWebViewClient());
        webView.setWebChromeClient(new JsWebChromeClient(this));
        webView.setVerticalScrollbarOverlay(true);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        webView.addJavascriptInterface(new JsIndexObj(webView), "android");
    }

    private void initHtml(){
        webView.loadUrl("file:///android_asset/html5/index.html");
    }
}
