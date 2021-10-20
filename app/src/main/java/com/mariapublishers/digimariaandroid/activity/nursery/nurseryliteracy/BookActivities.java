package com.mariapublishers.digimariaandroid.activity.nursery.nurseryliteracy;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.juniorkg.juniorliteracy.JuniorLiteracyActivity10;
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class BookActivities extends BaseActivity {

    private static final String TAG = "BookActivities";

    CardView bear, r_name, elephant, e_name, rabbit, z_name, yak, b_name, zebra, y_name;
    ImageView ele_img, bear_img, rab_img, ox_img, zebra_img;
    int i = 0, j = 0;
    CardView small_caps_2;

    SweetAlertDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_activities);

        ImageView toback = findViewById(R.id.toback);

        currentContext = BookActivities.this;

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
                        stopService(new Intent(BookActivities.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(BookActivities.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(BookActivities.this, MusicService.class));
                }


            }
        });

        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }

        toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookActivities.this, RedirectPages.class);
                intent.putExtra("type", "activity");
                startActivity(intent);
                finish();
            }
        });

        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Match the animals with the first letter of their names");

//        ImageView profile_id = findViewById(R.id.profile_id);
//        profile_id.setVisibility(View.INVISIBLE);

        small_caps_2 = findViewById(R.id.small_caps_2);
        small_caps_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookActivities.this, SmallCaps.class));
                finish();
            }
        });

        bear = findViewById(R.id.bear);
        r_name = findViewById(R.id.r_name);
        elephant = findViewById(R.id.elephant);
        e_name = findViewById(R.id.e_name);
        rabbit = findViewById(R.id.rabbit);
        z_name = findViewById(R.id.z_name);
        yak = findViewById(R.id.yak);
        b_name = findViewById(R.id.b_name);
        zebra = findViewById(R.id.zebra);
        y_name = findViewById(R.id.y_name);

        ele_img = findViewById(R.id.ele_img);
        bear_img = findViewById(R.id.bear_img);
        rab_img = findViewById(R.id.rab_img);
        ox_img = findViewById(R.id.ox_img);
        zebra_img = findViewById(R.id.zebra_img);
        zebra_img = findViewById(R.id.zebra_img);

        pDialog = new SweetAlertDialog(BookActivities.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading ...");
        pDialog.setCancelable(false);
        pDialog.show();

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable24/drawablev24/elephant.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(ele_img);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable24/drawablev24/bear.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(bear_img);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable24/drawablev24/rabbit.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(rab_img);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable24/drawablev24/yak.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(ox_img);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/zebra2.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(zebra_img);

        pDialog.cancel();

        bear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i = 1;
                    bear.setCardBackgroundColor(getResources().getColor(R.color.matchone));
                } else {
                    alertError("Choose the right answer");
                }
            }
        });

        elephant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i = 2;
                    elephant.setCardBackgroundColor(getResources().getColor(R.color.matchtwo));
                } else {
                    alertError("Choose the right answer");
                }
            }
        });

        rabbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i = 3;
                    rabbit.setCardBackgroundColor(getResources().getColor(R.color.matchthree));
                } else {
                    alertError("Choose the right answer");
                }
            }
        });

        yak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i = 4;
                    yak.setCardBackgroundColor(getResources().getColor(R.color.matchfour));
                } else {
                    alertError("Choose the right answer");
                }
            }
        });

        zebra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i = 5;
                    zebra.setCardBackgroundColor(getResources().getColor(R.color.matchfive));
                } else {
                    alertError("Choose the right answer");
                }
            }
        });

        r_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 3) {
                    i = 0;
                    r_name.setCardBackgroundColor(getResources().getColor(R.color.matchthree));
                    j += 1;
                    if (j == 5) {
                        toBack();
                    }
                } else if (i == 0) {
                    alertError("Choose the question first");
                } else {
                    alertError("Choose the right answer");
                }
            }
        });

        e_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 2) {
                    i = 0;
                    e_name.setCardBackgroundColor(getResources().getColor(R.color.matchtwo));
                    j += 1;
                    if (j == 5) {
                        toBack();
                    }
                } else if (i == 0) {
                    alertError("Choose the question first");
                } else {
                    alertError("Choose the right answer");
                }
            }
        });

        z_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 5) {
                    i = 0;
                    z_name.setCardBackgroundColor(getResources().getColor(R.color.matchfive));
                    j += 1;
                    if (j == 5) {
                        toBack();
                    }
                } else if (i == 0) {
                    alertError("Choose the question first");
                } else {
                    alertError("Choose the right answer");
                }
            }
        });

        b_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 1) {
                    i = 0;
                    b_name.setCardBackgroundColor(getResources().getColor(R.color.matchone));
                    j += 1;
                    if (j == 5) {
                        toBack();
                    }
                } else if (i == 0) {
                    alertError("Choose the question first");
                } else {
                    alertError("Choose the right answer");
                }
            }
        });

        y_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 4) {
                    i = 0;
                    y_name.setCardBackgroundColor(getResources().getColor(R.color.matchfour));
                    j += 1;
                    if (j == 5) {
                        toBack();
                    }
                } else if (i == 0) {
                    alertError("Choose the question first");
                } else {
                    alertError("Choose the right answer");
                }
            }
        });

    }

    public void alertError(String message) {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wrong);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(BookActivities.this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setConfirmText("OK")
                .setContentText(message)
                .show();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(BookActivities.this, SmallCaps.class);
        intent.putExtra("bookid", pref.getClassid());
        startActivity(intent);
        finish();
    }

    public void toBack() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(BookActivities.this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Hurray!")
                .setContentText("Activity Cleared.")
                .setConfirmText("OK")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        Intent intent = new Intent(BookActivities.this, RedirectPages.class);
                        intent.putExtra("type", "activity");
                        startActivity(intent);
                        finish();
                    }
                })
                .show();
    }
}
