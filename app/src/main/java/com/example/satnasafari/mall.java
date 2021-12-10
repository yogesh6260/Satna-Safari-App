package com.example.satnasafari;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class mall extends AppCompatActivity {
    private WebView mywebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall);
        mywebview = (WebView) findViewById(R.id.webv);
        WebSettings webset = mywebview.getSettings();
        webset.setJavaScriptEnabled(true);
        mywebview.loadUrl("https://www.google.com/search?rlz=1C1CHBF_enIN863IN863&tbs=lf:1,lf_ui:10&sxsrf=AOaemvKoqdeO2YZkMlL1H4_n68kwNDRoFQ:1634118740352&q=all+malls+in+satna&rflfq=1&num=10&sa=X&ved=2ahUKEwjk46fYjsfzAhXu7XMBHVYaB3sQjGp6BAgJEGI&biw=1536&bih=722&dpr=1.25&ibp=gwp;0,6#rlfi=hd:;si:;mv:[[24.607256,80.8700192],[24.5589349,80.8080836]];tbs:lrf:!1m4!1u3!2m2!3m1!1e1!1m4!1u2!2m2!2m1!1e1!1m4!1u16!2m2!16m1!1e1!1m4!1u16!2m2!16m1!1e2!2m1!1e2!2m1!1e16!2m1!1e3!3sIAE,lf:1,lf_ui:10");
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