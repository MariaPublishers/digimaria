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
import com.mariapublishers.digimariaandroid.activity.mainprocess.BookLanding;
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class FindChick extends BaseActivity {

    ImageView h1, h2, h3, h4, h5, h6, p1, p2, p3, d1, d2, d3, hen_img;
    int i = 0, i1 = 0, i2 = 0, i3 = 0, i4 = 0, i5 = 0, i6 = 0;
    CardView help_bee;

    public SweetAlertDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_chick);

        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Help the hen to find her chick with the letter ‘h’");

//        ImageView profile_id = findViewById(R.id.profile_id);
//        profile_id.setVisibility(View.INVISIBLE);

        help_bee = findViewById(R.id.help_bee);
        help_bee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindChick.this, HelpBee.class));
            }
        });

        currentContext = FindChick.this;

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
                        stopService(new Intent(FindChick.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(FindChick.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(FindChick.this, MusicService.class));
                }


            }
        });

        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }

        ImageView toback = findViewById(R.id.toback);

        toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindChick.this, RedirectPages.class);
                intent.putExtra("type", "activity");
                startActivity(intent);
                finish();
            }
        });

        h1 = findViewById(R.id.h1);
        h2 = findViewById(R.id.h2);
        h3 = findViewById(R.id.h3);
        h4 = findViewById(R.id.h4);
        h5 = findViewById(R.id.h5);
        h6 = findViewById(R.id.h6);
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        p3 = findViewById(R.id.p3);
        d1 = findViewById(R.id.d1);
        d2 = findViewById(R.id.d2);
        d3 = findViewById(R.id.d3);
        hen_img = findViewById(R.id.hen_img);

        pDialog = new SweetAlertDialog(FindChick.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading ...");
        pDialog.setCancelable(false);
        pDialog.show();

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable24/drawablev24/chick.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(h1);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable24/drawablev24/chick.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(h2);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable24/drawablev24/chick.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(h3);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable24/drawablev24/chick.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(h4);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable24/drawablev24/chick.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(h5);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable24/drawablev24/chick.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(h6);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable24/drawablev24/chick.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(p1);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable24/drawablev24/chick.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(p2);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable24/drawablev24/chick.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(p3);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable24/drawablev24/chick.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(d1);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable24/drawablev24/chick.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(d2);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable24/drawablev24/chick.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(d3);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable24/drawablev24/hen.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(hen_img);

        pDialog.cancel();

        h1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i < 6) {
                    i1 += 1;
                    if (i1 == 1) {
                        i += 1;
                        i1 += 1;
                        h1.setImageResource(R.drawable.chick_2);
                        if (i == 6) {
                            toBack();
                        }
                    }
                } else {
                    toBack();
                }
            }
        });

        h2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i < 6) {
                    i2 += 1;
                    if (i2 == 1) {
                        i += 1;
                        i2 += 1;
                        h2.setImageResource(R.drawable.chick_2);
                        if (i == 6) {
                            toBack();
                        }
                    }
                } else {
                    toBack();
                }
            }
        });

        h3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i < 6) {
                    i3 += 1;
                    if (i3 == 1) {
                        i += 1;
                        i3 += 1;
                        h3.setImageResource(R.drawable.chick_2);
                        if (i == 6) {
                            toBack();
                        }
                    }
                } else {
                    toBack();
                }
            }
        });

        h4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i < 6) {
                    i4 += 1;
                    if (i4 == 1) {
                        i += 1;
                        i4 += 1;
                        h4.setImageResource(R.drawable.chick_2);
                        if (i == 6) {
                            toBack();
                        }
                    }
                } else {
                    toBack();
                }
            }
        });

        h5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i < 6) {
                    i5 += 1;
                    if (i5 == 1) {
                        i += 1;
                        i5 += 1;
                        h5.setImageResource(R.drawable.chick_2);
                        if (i == 6) {
                            toBack();
                        }
                    }
                } else {
                    toBack();
                }
            }
        });

        h6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i < 6) {
                    i6 += 1;
                    if (i6 == 1) {
                        i += 1;
                        i6 += 1;
                        h6.setImageResource(R.drawable.chick_2);
                        if (i == 6) {
                            toBack();
                        }
                    }
                } else {
                    toBack();
                }
            }
        });

        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError();
            }
        });

        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError();
            }
        });

        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError();
            }
        });

        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError();
            }
        });

        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError();
            }
        });

        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError();
            }
        });

    }

    public void alertError() {
        final MediaPlayer mpf = MediaPlayer.create(this, R.raw.wrong);
        mpf.setLooping(false);
        mpf.start();

        new SweetAlertDialog(FindChick.this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setConfirmText("OK")
                .setContentText("Wrong, try again")
                .show();
    }

    public void toBack() {
        final MediaPlayer mps = MediaPlayer.create(this, R.raw.correct);
        mps.setLooping(false);
        mps.start();

        new SweetAlertDialog(FindChick.this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Hurray!")
                .setContentText("Activity Cleared.")
                .setConfirmText("OK")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        startActivity(new Intent(FindChick.this, HelpBee.class));
                    }
                })
                .show();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(FindChick.this, BookLanding.class);
        intent.putExtra("bookid", pref.getClassid());
        startActivity(intent);
        finish();
    }
}
