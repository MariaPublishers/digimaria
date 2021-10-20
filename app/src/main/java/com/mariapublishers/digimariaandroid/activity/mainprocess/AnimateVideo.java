package com.mariapublishers.digimariaandroid.activity.mainprocess;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.Config;
import com.mariapublishers.digimariaandroid.service.MusicService;

public class AnimateVideo extends YouTubeBaseActivity {

    private static final String TAG = "AnimateVideo.java";
    YouTubePlayerView youtube_player_view1;
    String path;
    Pref pref;
    String volval, bookid = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate_video);

        pref= new Pref(getApplicationContext());

        if (getIntent() != null && getIntent().getExtras() != null)
            bookid = getIntent().getStringExtra("bookid");

        ImageView toback = findViewById(R.id.toback);
        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Rhymes and Stories");

        stopService(new Intent(this, MusicService.class));

        toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volval = pref.getVolumeval();;
                if (volval.equals("1")) {
                    startService(new Intent(AnimateVideo.this, MusicService.class));
                } else {
                    stopService(new Intent(AnimateVideo.this, MusicService.class));
                }
                Intent intent = new Intent(AnimateVideo.this, RedirectVideo.class);
                intent.putExtra("bookid", pref.getClassid());
                startActivity(intent);
                finish();
            }
        });

        youtube_player_view1 = findViewById(R.id.youtube_player_view1);

        Intent getUrl = getIntent();

        if (getUrl.getStringExtra("path") != null) {

            path = getUrl.getStringExtra("path");

            Log.d(TAG, "onCreate: " + path);

            youtube_player_view1.initialize(Config.YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer youTubePlayer, boolean b) {
                    if (!b) {
                        youTubePlayer.loadVideo(path, 0);
                        youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                        youTubePlayer.setPlaylistEventListener(new YouTubePlayer.PlaylistEventListener() {
                            @Override
                            public void onPrevious() {

                            }

                            @Override
                            public void onNext() {

                            }

                            @Override
                            public void onPlaylistEnded() {
                                youTubePlayer.seekToMillis(1000);
                                youTubePlayer.pause();
                            }
                        });
                    }
                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                    Toast.makeText(AnimateVideo.this, "Unable to play video", Toast.LENGTH_SHORT).show();
                }
            });

        } else {
            Log.d(TAG, "onCreate: no video");
        }

    }

    @Override
    public void onBackPressed() {
        volval = pref.getVolumeval();
        if (volval.equals("1")) {
            startService(new Intent(AnimateVideo.this, MusicService.class));
        } else {
            stopService(new Intent(AnimateVideo.this, MusicService.class));
        }
        Intent intent = new Intent(AnimateVideo.this, PageScanner.class);
        intent.putExtra("bookid", bookid);
        startActivity(intent);
        finish();
    }
}
