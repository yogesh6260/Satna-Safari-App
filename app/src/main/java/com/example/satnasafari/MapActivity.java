package com.example.satnasafari;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MapActivity extends AppCompatActivity {
    private WebView mywebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_acitvity);
        mywebview = (WebView) findViewById(R.id.webv);
        WebSettings webset = mywebview.getSettings();
        webset.setJavaScriptEnabled(true);
        mywebview.loadUrl("https://satna.nic.in/en/map-of-district/");
        mywebview.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if(mywebview.canGoBack())
        {
            mywebview.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}