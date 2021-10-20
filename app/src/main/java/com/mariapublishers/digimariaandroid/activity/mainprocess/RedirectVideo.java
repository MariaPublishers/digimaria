package com.mariapublishers.digimariaandroid.activity.mainprocess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.service.MusicService;

import androidx.cardview.widget.CardView;

public class RedirectVideo extends BaseActivity {

    CardView ar_scanner, go_to_video;
    String bookid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirect_video);

        currentContext = RedirectVideo.this;

        if (getIntent() != null && getIntent().getExtras() != null)
            bookid = getIntent().getStringExtra("bookid");

        volval = pref.getVolumeval();

        volumenote = findViewById(R.id.volumenote);

        volumenote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (volval != null) {
                    if (volval.equals("1")) {
                        pref.setVolumeval("0");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeoff);
                        stopService(new Intent(RedirectVideo.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(RedirectVideo.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(RedirectVideo.this, MusicService.class));
                }


            }
        });

        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }

        ImageView toback = findViewById(R.id.toback);
        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Animation Video");

        toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RedirectVideo.this, BookLanding.class);
                intent.putExtra("bookid", pref.getClassid());
                startActivity(intent);
                finish();
            }
        });

        ar_scanner = findViewById(R.id.ar_scanner);
        go_to_video = findViewById(R.id.go_to_video);

        ar_scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RedirectVideo.this, PageScanner.class);
                intent.putExtra("bookid", bookid);
                startActivity(intent);
            }
        });

        go_to_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RedirectVideo.this, ListVideo.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(RedirectVideo.this, BookLanding.class);
        intent.putExtra("bookid", pref.getClassid());
        startActivity(intent);
        finish();
    }
}
