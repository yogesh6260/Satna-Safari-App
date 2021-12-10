package com.example.satnasafari;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class restaurant extends AppCompatActivity {
    private WebView mywebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        mywebview = (WebView) findViewById(R.id.webv);
        WebSettings webset = mywebview.getSettings();
        webset.setJavaScriptEnabled(true);
        mywebview.loadUrl("https://www.google.com/search?rlz=1C1CHBF_enIN863IN863&tbs=lf:1,lf_ui:9&sxsrf=AOaemvL-jTL2_sGeJN37cdp0uMSca-KuPA:1634118530838&q=all+restaurants+and+cafe+in+satna&rflfq=1&num=10&sa=X&ved=2ahUKEwjChLT0jcfzAhUJOSsKHSGZB0MQjGp6BAgNEF4&biw=1536&bih=722&dpr=1.25&ibp=gwp;0,6#rlfi=hd:;si:;mv:[[24.623546002449608,80.93165281477593],[24.53518976715524,80.74007871809624],null,[24.57937567517618,80.83586576643609],13]");
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