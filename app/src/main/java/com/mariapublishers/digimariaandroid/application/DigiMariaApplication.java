package com.mariapublishers.digimariaandroid.application;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

public class DigiMariaApplication extends Application implements LifecycleObserver {

    protected Pref pref;
    protected String volval;

    public static boolean isMusicServiceRunning = false;
    SharedPreferences sharedPreferences;
    @Override
    public void onCreate() {
        super.onCreate();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
        pref = new Pref(this);
        sharedPreferences = this.getSharedPreferences("SharedPrefManager", 0);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onAppBackgrounded() {
        Log.e("onAppBackgrounded", "Entered");
        if (isMusicServiceRunning)
            stopService(new Intent(getApplicationContext(), MusicService.class));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onAppForegrounded() {
        Log.e("onAppForegrounded", "Entered ");
//        Log.e("onAppForegrounded", "Entered " +sharedPreferences.getString("SPLASH_SCREEN_LOADING", "0") +"---"+pref.getVolumeval().equals("1"));
        volval = sharedPreferences.getString("SPLASH_SCREEN_LOADING", "0");
        if (volval != null) {
            if (volval.equals("0")) {
                if (isMusicServiceRunning) {
                    stopService(new Intent(getApplicationContext(), MusicService.class));
                }
            } else if (volval.equals("1")) {
                if (!isMusicServiceRunning && pref.getVolumeval().equals("1")) {
                    startService(new Intent(getApplicationContext(), MusicService.class));
                }
            }
        } else {
            pref.setVolumeval("1");
            volval = pref.getVolumeval();
            if (!isMusicServiceRunning) {
                startService(new Intent(getApplicationContext(), MusicService.class));
            }
        }
    }

}
