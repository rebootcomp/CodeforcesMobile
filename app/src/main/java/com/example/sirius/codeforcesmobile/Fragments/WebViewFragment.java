package com.example.sirius.codeforcesmobile.Fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.sirius.codeforcesmobile.R;
import com.example.sirius.codeforcesmobile.RecycleViewAdapter.contestRecyclerViewAdapter;
import com.example.sirius.codeforcesmobile.RecycleViewAdapter.notificationRecyclerViewAdapter;
import com.example.sirius.codeforcesmobile.SimpleWebViewClientImpl;

import java.util.ArrayList;

public class WebViewFragment extends Fragment {


    notificationRecyclerViewAdapter adapter;
    FragmentTransaction transaction;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View myFragmentView = inflater.inflate(R.layout.web_view_fragment, null);
        WebView webView = myFragmentView.findViewById(R.id.webView);
        webView.loadUrl("https://codeforces.com");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        SimpleWebViewClientImpl webViewClient = new SimpleWebViewClientImpl(getActivity());
        webView.setWebViewClient(webViewClient);
        return myFragmentView;
    }

/*
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }*/
}