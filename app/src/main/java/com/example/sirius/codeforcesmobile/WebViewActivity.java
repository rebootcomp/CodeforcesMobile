package com.example.sirius.codeforcesmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        WebView webView = findViewById(R.id.webView);
        Intent intent = getIntent();
        String url = "http://"+intent.getStringExtra("URL") + "?mobile=true";
        //Toast.makeText(getApplicationContext(),url, Toast.LENGTH_SHORT).show();
        webView.loadUrl(url);
        WebSettings webSettings = webView.getSettings();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        SimpleWebViewClientImpl webViewClient = new SimpleWebViewClientImpl(this);
        webView.setWebViewClient(webViewClient);
    }
}
