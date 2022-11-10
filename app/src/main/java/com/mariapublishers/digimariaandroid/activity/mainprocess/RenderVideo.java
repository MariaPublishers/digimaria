package com.mariapublishers.digimariaandroid.activity.mainprocess;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.adapter.Video;
import com.mariapublishers.digimariaandroid.adapter.VideoAdapter;
import com.mariapublishers.digimariaandroid.model.video.VideoData;
import com.mariapublishers.digimariaandroid.model.video.Videolist;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.retrofit.APIUrl;
import com.mariapublishers.digimariaandroid.service.Config;
import com.mariapublishers.digimariaandroid.service.MusicService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RenderVideo extends YouTubeBaseActivity implements VideoAdapter.OnNoteListerner {

    private static final String TAG = "huw";
    RecyclerView video_list;
    Pref pref;
    HashMap<String, String> hashMap;
    List<Video> videoList;
    VideoAdapter videoAdapter;
    Intent get_int;
    String title, path, bookid;
    private static final int RECOVERY_REQUEST = 1;
    TextView video_title;
    YouTubePlayerView youtube_player_view;
    String volval;

    YouTubePlayer youTubePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_render_video);

        intialize();

        pref= new Pref(getApplicationContext());

        ImageView toback = findViewById(R.id.toback);
        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Animation Video");

        stopService(new Intent(this, MusicService.class));

        toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volval = pref.getVolumeval();
                if (volval.equals("1")) {
                    startService(new Intent(RenderVideo.this, MusicService.class));
                } else {
                    stopService(new Intent(RenderVideo.this, MusicService.class));
                }
                Intent intent = new Intent(RenderVideo.this, ListVideo.class);
                intent.putExtra("bookid", pref.getClassid());
                startActivity(intent);
                finish();
            }
        });

        get_int = getIntent();

        // loading_bar

        if (get_int.getStringExtra("title") != null) {
            title = get_int.getStringExtra("title");
            video_title.setText(title);
        }

        if (get_int.getStringExtra("path") != null) {
            path = get_int.getStringExtra("path");

            Log.d(TAG, "onCreate: " + path);

            youtube_player_view.initialize(Config.YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer youTubePlayer1, boolean b) {
                    if (!b) {
//                        youTubePlayer.loadVideo("XfP31eWXli4");
                        youTubePlayer = youTubePlayer1;
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
                    Toast.makeText(RenderVideo.this, "Unable to play video", Toast.LENGTH_SHORT).show();
                }
            });

        }

        if (get_int.getStringExtra("bookid") != null) {
            bookid = get_int.getStringExtra("bookid");
            hashMap = new HashMap<>();
            hashMap.put("bookid", pref.getBookId());
            Log.d(TAG, "onCreate: " + hashMap);
            userSignIn(hashMap);
        }

    }

    private void userSignIn(HashMap<String, String> hashMap) {

        Call<VideoData> call = APIUrl.getService().getVideo(pref.getToken(), hashMap);

        call.enqueue(new Callback<VideoData>() {
            @Override
            public void onResponse(Call<VideoData> call, Response<VideoData> response) {

                VideoData loginResponse = response.body();

                if (response.isSuccessful()) {
                    if (loginResponse.getSuccess() == 1) {

                        LinearLayoutManager HorizontalLayout = new LinearLayoutManager(RenderVideo.this, LinearLayoutManager.VERTICAL, false);
                        video_list.setLayoutManager(HorizontalLayout);

                        videoList = new ArrayList<>();

                        //adding some items to our list
                        for (Videolist tripBasedData : loginResponse.getVideolist()) {

                            String url = APIUrl.BASE_URL+tripBasedData.getImagecover();
                            url = url.replace("api/v1/", "");

                            String video_type = "";
                            if (tripBasedData.getVideotype() == 1) {
                                video_type = "RHYMES";
                            } else {
                                video_type = "STORY";
                            }

                            videoList.add(
                                    new Video(
                                            String.valueOf(tripBasedData.getBooksid()),
                                            video_type + " - " + tripBasedData.getBookvideoname().toUpperCase(),
                                            tripBasedData.getBookvideopath(),
                                            url
                                    )
                            );

                        }

                        //creating recyclerview adapter
                        videoAdapter = new VideoAdapter(getApplicationContext(), videoList, RenderVideo.this);

                        //setting adapter to recyclerview
                        video_list.setAdapter(videoAdapter);

                    } else {

                        videoList.add(
                                new Video(
                                        "",
                                        "Nothing Found",
                                        "",
                                        ""
                                )
                        );

                        videoAdapter = new VideoAdapter(getApplicationContext(), videoList, RenderVideo.this);
                        video_list.setAdapter(videoAdapter);
                        Toast.makeText(RenderVideo.this, "Nothing Found", Toast.LENGTH_SHORT).show();
                    }
                } else {
//                    pDialog.cancel();
                    Toast.makeText(RenderVideo.this, "Server Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<VideoData> call, Throwable t) {
//                pDialog.cancel();
                Log.d("on Failure", "" + t.getLocalizedMessage());

            }
        });
    }

    private void intialize() {
        youtube_player_view = findViewById(R.id.youtube_player_view);
        video_title = findViewById(R.id.video_title);
        video_list = findViewById(R.id.video_list);
        pref = new Pref(getApplicationContext());
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onNoteClick(String position, String title) {
        youTubePlayer.release();
        Intent start = new Intent(RenderVideo.this, RenderVideo.class);
        start.putExtra("bookid", pref.getBookId());
        start.putExtra("title", title);
        start.putExtra("path", position);
        startActivity(start);
        finish();
        Log.d(TAG, "onNoteClick: " + position + title);
    }

    @Override
    public void onBackPressed() {
        volval = pref.getVolumeval();;
        if (volval.equals("1")) {
            startService(new Intent(RenderVideo.this, MusicService.class));
        } else {
            stopService(new Intent(RenderVideo.this, MusicService.class));
        }
        startActivity(new Intent(RenderVideo.this, ListVideo.class));
        finish();
    }

}
