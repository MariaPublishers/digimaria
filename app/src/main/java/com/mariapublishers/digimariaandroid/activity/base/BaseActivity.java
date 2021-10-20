package com.mariapublishers.digimariaandroid.activity.base;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.application.DigiMariaApplication;
import com.mariapublishers.digimariaandroid.prefference.Pref;

public class BaseActivity extends AppCompatActivity {

    protected Context currentContext;
    protected Pref pref;
    protected String volval;
    protected ImageView volumenote;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref = new Pref(this);
        volval = pref.getVolumeval();
    }

    @Override
    protected void onStop() {
        super.onStop();
//        if (DigiMariaApplication.isMusicServiceRunning)
//            stopService(new Intent(currentContext, MusicService.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (volumenote != null)
            if (volval != null) {
                if (volval.equals("0")) {
                    if (DigiMariaApplication.isMusicServiceRunning) {
                        volumenote.setImageResource(R.drawable.volumeoff);
//                    stopService(new Intent(currentContext, MusicService.class));
                    }
                } else if (volval.equals("1")) {
                    if (!DigiMariaApplication.isMusicServiceRunning) {
                        volumenote.setImageResource(R.drawable.volumeup);
//                    startService(new Intent(currentContext, MusicService.class));
                    }
                }
            } else {
                pref.setVolumeval("1");
                volval = pref.getVolumeval();
                if (!DigiMariaApplication.isMusicServiceRunning) {
                    volumenote.setImageResource(R.drawable.volumeup);
//                startService(new Intent(currentContext, MusicService.class));
                }
            }
    }

}
