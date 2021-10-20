package com.mariapublishers.digimariaandroid.activity.mainprocess;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.seniorflashcard.SeniorFlasCard1;
import com.mariapublishers.digimariaandroid.activity.seniorkg.seniorliteracy.SeniorLiteracyActivity1;
import com.mariapublishers.digimariaandroid.activity.seniorslide.SeniorSlideActivity;
import com.mariapublishers.digimariaandroid.activity.seniorslide.SlideShowMain;
import com.mariapublishers.digimariaandroid.model.landingbook.GetBook;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.retrofit.APIUrl;
import com.mariapublishers.digimariaandroid.service.MusicService;

import java.util.HashMap;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookLanding extends BaseActivity {

    private static final String TAG = "BookLanding.java";
    HashMap<String, String> hashMap;
    Intent getId;
    String bookLink, videoLink;
    CardView flipbook, animated_video, activities, funwithcolor, flashcards, slideshow;
    ImageView landing_cover;
    SweetAlertDialog pDialog;
    TextView landing_name;
    String book_name;
    String bookid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        currentContext = BookLanding.this;

        getId = getIntent();
        if (getId.getStringExtra("bookid").equals("")) {
            Toast.makeText(this, "Failed to get book id", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(BookLanding.this, Dashboard.class));
        } else {
            setContentView(R.layout.activity_book_landing);

            Log.d(TAG, "onCreate: " + getId.getStringExtra("bookid"));
            pDialog = new SweetAlertDialog(BookLanding.this, SweetAlertDialog.PROGRESS_TYPE);
            pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            pDialog.setTitleText("Loading ...");
            pDialog.setCancelable(false);
            pDialog.show();
            hashMap = new HashMap<>();

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
                            stopService(new Intent(BookLanding.this, MusicService.class));
                        } else if (volval.equals("0")) {
                            pref.setVolumeval("1");
                            volval = pref.getVolumeval();
                            volumenote.setImageResource(R.drawable.volumeup);
                            startService(new Intent(BookLanding.this, MusicService.class));
                        }
                    } else {
                        pref.setVolumeval("1");
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(BookLanding.this, MusicService.class));
                    }


                }
            });

            if (volval.equals("1")) {
                volumenote.setImageResource(R.drawable.volumeup);
            } else {
                volumenote.setImageResource(R.drawable.volumeoff);
            }

            bookid = getId.getStringExtra("bookid");

            landing_name = findViewById(R.id.landing_name);

            if (bookid.equals("")) {
                hashMap.put("bookid", pref.getBookId());
                userSignIn(hashMap);
            } else {
                pref.setBookId(bookid);
                hashMap.put("bookid", bookid);
                Log.d(TAG, "onCreate: " + pref.getBookId());
                userSignIn(hashMap);
            }

            flipbook = findViewById(R.id.flipbook);
            animated_video = findViewById(R.id.animated_video);
            activities = findViewById(R.id.activities);
            funwithcolor = findViewById(R.id.funwithcolor);
            landing_cover = findViewById(R.id.landing_cover);
            flashcards = findViewById(R.id.flashcards);
            slideshow = findViewById(R.id.slideshow);

            if (getId.getStringExtra("bookid").equals("1")) {
                flashcards.setVisibility(View.GONE);
                slideshow.setVisibility(View.GONE);
            }

            flashcards.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(BookLanding.this, SeniorFlasCard1.class));
                }
            });
            slideshow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(BookLanding.this, SlideShowMain.class));
                }
            });

            funwithcolor.setVisibility(View.GONE);
            ImageView toback = findViewById(R.id.toback);

//            funwithcolor.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    Intent intent = new Intent(BookLanding.this, ParrotDrawing.class);
//                    Intent intent = new Intent(BookLanding.this, EmptyStatus.class);
//                    intent.putExtra("status", "coming");
//                    startActivity(intent);
//                }
//            });

            toback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(BookLanding.this, Dashboard.class));
                }
            });

            flipbook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent tofilpbook = new Intent(BookLanding.this, RedirectPages.class);
                    tofilpbook.putExtra("type", "flipbook");
                    startActivity(tofilpbook);
                }
            });

            animated_video.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent tovideo = new Intent(BookLanding.this, RedirectVideo.class);
                    tovideo.putExtra("bookid", bookid);
                    startActivity(tovideo);
                }
            });

            activities.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    to_literacy_fun();

                }
            });

        }

    }


    private void to_literacy_fun() {
        Intent tofilpbook = new Intent(BookLanding.this, RedirectPages.class);
        tofilpbook.putExtra("type", "activity");
        startActivity(tofilpbook);
    }

    private void userSignIn(HashMap<String, String> hashMap) {

        Call<GetBook> call = APIUrl.getService().bookData("Bearer " + pref.getToken(), hashMap);

        call.enqueue(new Callback<GetBook>() {
            @Override
            public void onResponse(Call<GetBook> call, Response<GetBook> response) {

                GetBook loginResponse = response.body();

                if (response.isSuccessful()) {
                    if (loginResponse.getSuccess() == 1) {
                        String url = "";
                        try {
                            url = APIUrl.BASE_URL;
                            url = url.replace("/api/v1", "");
                            url = url + loginResponse.getLandingbookdata().get(0).getBookcover();
                            book_name = loginResponse.getLandingbookdata().get(0).getBooktitle();
                            landing_name.setText(book_name);
                            Glide.with(getApplicationContext())
                                    .load(url)
                                    .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                                    .addListener(new RequestListener<Drawable>() {
                                        @Override
                                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                            Log.e(TAG, "onLoadFailed: " + e.getMessage());
                                            return false;
                                        }

                                        @Override
                                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                            Log.d(TAG, "onResourceReady: ");
                                            return false;
                                        }
                                    })
                                    .into(landing_cover);
//                            Log.d(TAG, "onResponse1: " + loginResponse.getLandingbookdata());
//                            Log.d(TAG, "onResponse1: " + loginResponse.getLandingbookdata().get(0).getBookid().toString());
//                            Log.d(TAG, "onResponse2: " + loginResponse.getLandingbookdata().get(1).getBookid().toString());
//                            Log.d(TAG, "onResponse3: " + loginResponse.getLandingbookdata().get(2).getBookid().toString());
                           /*Abu String bookIdOne = loginResponse.getLandingbookdata().get(0).getBookid().toString();
                            String bookIdTwo = loginResponse.getLandingbookdata().get(1).getBookid().toString();
                            String bookIdThree = loginResponse.getLandingbookdata().get(2).getBookid().toString();

                            if (bookIdOne.equals("8"))
                                bookIdOne = "3";
                            if (bookIdTwo.equals("52"))
                                bookIdTwo = "5";
                            if (bookIdThree.equals("58"))
                                bookIdThree = "7";

                            pref.setBooksID(bookIdOne, bookIdTwo, bookIdThree); */
                            String prefBookId = pref.getBookId();
                            if (prefBookId.equalsIgnoreCase("3")) {
                                String bookIdOne = "3";
                                String bookIdTwo = "5";
                                String bookIdThree = "7";
                                pref.setBooksID(bookIdOne, bookIdTwo, bookIdThree);

                            } else if (prefBookId.equalsIgnoreCase("9")) {
                                String bookIdOne = "9";
                                String bookIdTwo = "11";
                                String bookIdThree = "13";
                                pref.setBooksID(bookIdOne, bookIdTwo, bookIdThree);

                            } else if (prefBookId.equalsIgnoreCase("15")) {
                                String bookIdOne = "15";
                                String bookIdTwo = "17";
                                String bookIdThree = "19";
                                pref.setBooksID(bookIdOne, bookIdTwo, bookIdThree);

                            }

                        } catch (Exception e) {
                            Log.d(TAG, "onBindViewHolder url: " + e.getMessage());
                        }

                        pDialog.cancel();
                    } else {
                        pDialog.cancel();
                    }
                } else {
                    pDialog.cancel();
                    Toast.makeText(BookLanding.this, "Server Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetBook> call, Throwable t) {
                pDialog.cancel();
                Log.d("on Failure", "" + t.getLocalizedMessage());

            }
        });

    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(BookLanding.this, Dashboard.class));
    }
}
