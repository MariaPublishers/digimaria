package com.mariapublishers.digimariaandroid.activity.mainprocess;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.prefference.Pref;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_SCREEN_TIME_OUT = 2500;
    private static final String TAG = "MainActivity";
    private Pref pref;
    String volval;
    // Fill in the missing letters.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        pref = new Pref(getApplicationContext());

        pref.setMusicval("0");
        pref.setSplashScreen("0");

        Log.d(TAG, "onCreate: " + pref.getMusicval() + " " + pref.getVolumeval());

//        pref.clearPrefs();

        if (isNetworkConnected()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (pref.getLoginStatus() == 1) {
                        Intent intent = new Intent(MainActivity.this, Dashboard.class);
                        intent.putExtra("BookList", "get Book list data");
                        startActivity(intent);
                    } else {
                        startActivity(new Intent(MainActivity.this, Login.class));
                    }
                    //invoke the SecondActivity.
                    finish();
                    //the current activity will get finished.
                }
            }, SPLASH_SCREEN_TIME_OUT);
        } else {
            Intent intent = new Intent(MainActivity.this, EmptyStatus.class);
            intent.putExtra("status", "nonet");
            startActivity(intent);
        }

    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

}
