package com.example.satnasafari;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class hospital extends AppCompatActivity {
    private WebView mywebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);
        mywebview = (WebView) findViewById(R.id.webv);
        WebSettings webset = mywebview.getSettings();
        webset.setJavaScriptEnabled(true);
        mywebview.loadUrl("https://www.google.com/search?rlz=1C1CHBF_enIN863IN863&tbs=lf:1,lf_ui:2&tbm=lcl&sxsrf=AOaemvJJ2mxUQqySL1e6ouwHjoA3GfVpmA:1634118892458&q=all+hospitals+in+satna&rflfq=1&num=10&sa=X&ved=2ahUKEwj64uugj8fzAhUAIbcAHYqNBmsQjGp6BAgOEGs&biw=1536&bih=722&dpr=1.25#rlfi=hd:;si:;mv:[[24.633975099999997,80.8599497],[24.5637767,80.7948147]];tbs:lrf:!1m4!1u3!2m2!3m1!1e1!1m4!1u2!2m2!2m1!1e1!1m4!1u16!2m2!16m1!1e1!1m4!1u16!2m2!16m1!1e2!2m1!1e2!2m1!1e16!2m1!1e3!3sIAE,lf:1,lf_ui:2");
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