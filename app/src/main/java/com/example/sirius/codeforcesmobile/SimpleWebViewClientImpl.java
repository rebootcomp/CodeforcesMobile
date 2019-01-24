package com.example.sirius.codeforcesmobile;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SimpleWebViewClientImpl extends WebViewClient {

    private Activity activity = null;

    public SimpleWebViewClientImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        // все ссылки, в которых содержится 'prologistic.com.ua'
        // будут открываться внутри приложения
        return false;
    }
}
