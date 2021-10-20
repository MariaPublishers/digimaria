package com.mariapublishers.digimariaandroid.activity.mainprocess;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.mariapublishers.digimariaandroid.R;

import java.net.URL;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ((TextView)findViewById(R.id.title)).setText(getIntent().getStringExtra("Title"));
        WebView webView  =findViewById(R.id.webview);

        SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading ...");
        pDialog.setCancelable(false);
        pDialog.show();


        webView.getSettings().setJavaScriptEnabled(true); // enable javascript
        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                pDialog.dismiss();
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });
        Log.d("TAG", "onCreate: "+getIntent().getStringExtra("URL"));
        String url=getIntent().getStringExtra("URL");
        if(url.contains(".pdf"))
            webView.loadUrl("https://docs.google.com/viewer?url=" +url);
        else
            webView.loadUrl(url);

    }

    public void onBackPressed(View view) {
        finish();
    }
}