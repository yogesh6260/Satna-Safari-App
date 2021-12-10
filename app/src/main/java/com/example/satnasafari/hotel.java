package com.example.satnasafari;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class hotel extends AppCompatActivity {
    private WebView mywebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        mywebview = (WebView) findViewById(R.id.webv);
        WebSettings webset = mywebview.getSettings();
        webset.setJavaScriptEnabled(true);
        mywebview.loadUrl("https://www.google.com/travel/hotels/Satna?g2lb=4624410%2C2503771%2C4545890%2C4597339%2C4617195%2C4270442%2C2503781%2C4515404%2C4317915%2C2502548%2C4605861%2C4401769%2C4306835%2C4258168%2C4419364%2C4596364%2C4371334%2C4284970%2C4270859%2C4291517&hl=en-IN&gl=in&cs=1&ssta=1&ap=aAE&q=all%20hotels%20in%20satna&rp=EKeplu-WhOSsMBDs3pO_6_vg1NkBEPCuroSUprWDsQEQmILX56uqz7sLOAFAAEgCogEVU2F0bmEsIE1hZGh5YSBQcmFkZXNo&ictx=1&sa=X&ved=0CAAQ5JsGahcKEwiwmMGJj8fzAhUAAAAAHQAAAAAQAg&utm_campaign=sharing&utm_medium=link&utm_source=htls&ts=CAESCgoCCAMKAggDEAAaOQobEhc6FVNhdG5hLCBNYWRoeWEgUHJhZGVzaBoAEhoSFAoHCOUPEAoYDxIHCOUPEAoYEBgBMgIQACoLCgcoAToDSU5SGgA");
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