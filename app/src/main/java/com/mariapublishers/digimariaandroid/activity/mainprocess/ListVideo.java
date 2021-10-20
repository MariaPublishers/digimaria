package com.mariapublishers.digimariaandroid.activity.mainprocess;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.adapter.Video;
import com.mariapublishers.digimariaandroid.adapter.VideoAdapter;
import com.mariapublishers.digimariaandroid.model.video.VideoData;
import com.mariapublishers.digimariaandroid.model.video.Videolist;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.retrofit.APIUrl;
import com.mariapublishers.digimariaandroid.service.MusicService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListVideo extends BaseActivity implements VideoAdapter.OnNoteListerner {

    private static final String TAG = ListVideo.class.getSimpleName();
    RecyclerView grid_video;
    HashMap<String, String> hashMap;
    List<Video> videoList;
    VideoAdapter videoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_video);

        intialize();

        currentContext = ListVideo.this;

        volval = pref.getVolumeval();

        volumenote = findViewById(R.id.volumenote);

        volumenote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onCreate: " + volval);

                if (volval != null) {
                    if (volval.equals("1")) {
                        pref.setVolumeval("0");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeoff);
                        stopService(new Intent(ListVideo.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(ListVideo.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(ListVideo.this, MusicService.class));
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
                Intent intent = new Intent(ListVideo.this, RedirectVideo.class);
                intent.putExtra("bookid", pref.getClassid());
                startActivity(intent);
                finish();
            }
        });

        hashMap = new HashMap<>();
        hashMap.put("bookid", pref.getBookId());
        Log.d(TAG, "onCreate: " + hashMap);
        userSignIn(hashMap);

    }

    private void userSignIn(HashMap<String, String> hashMap) {

        Call<VideoData> call = APIUrl.getService().getVideo(pref.getToken(), hashMap);

        call.enqueue(new Callback<VideoData>() {
            @Override
            public void onResponse(Call<VideoData> call, Response<VideoData> response) {

                VideoData loginResponse = response.body();

                if (response.isSuccessful()) {
                    if (loginResponse.getSuccess() == 1) {

                        LinearLayoutManager HorizontalLayout = new LinearLayoutManager(ListVideo.this, LinearLayoutManager.VERTICAL, false);
                        grid_video.setLayoutManager(HorizontalLayout);

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
                        videoAdapter = new VideoAdapter(getApplicationContext(), videoList, ListVideo.this);

                        //setting adapter to recyclerview
                        grid_video.setAdapter(videoAdapter);

                    } else {

                        videoList.add(
                                new Video(
                                        "",
                                        "Nothing Found",
                                        "",
                                        ""
                                )
                        );

                        videoAdapter = new VideoAdapter(getApplicationContext(), videoList, ListVideo.this);
                        grid_video.setAdapter(videoAdapter);
                        Toast.makeText(ListVideo.this, "Nothing Found", Toast.LENGTH_SHORT).show();
                    }
                } else {
//                    pDialog.cancel();
                    Toast.makeText(ListVideo.this, "Server Error", Toast.LENGTH_SHORT).show();
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
        grid_video = findViewById(R.id.grid_video);
        pref = new Pref(getApplicationContext());
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ListVideo.this, RedirectVideo.class);
        intent.putExtra("bookid", pref.getClassid());
        startActivity(intent);
        finish();
    }

    @Override
    public void onNoteClick(String position, String title) {
        Intent start = new Intent(ListVideo.this, RenderVideo.class);
        start.putExtra("bookid", pref.getBookId());
        start.putExtra("title", title);
        start.putExtra("path", position);
        startActivity(start);
//        Log.d(TAG, "onNoteClick: " + position + title);
    }
}
