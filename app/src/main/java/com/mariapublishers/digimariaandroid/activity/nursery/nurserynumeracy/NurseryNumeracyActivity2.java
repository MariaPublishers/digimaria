package com.mariapublishers.digimariaandroid.activity.nursery.nurserynumeracy;

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
import com.mariapublishers.digimariaandroid.activity.nursery.nurserygeneralawarness.NurseryGeneralActivity2;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class NurseryNumeracyActivity2 extends BaseActivity {

    int inc = 0 ;
    CardView help_bee, help_frog, n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, s1, s2, s3, s4;
    ImageView honey_img;
    int alpha = 0;

    SweetAlertDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nursery_numeracy2);

        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Colour the number shown by Dora");

        currentContext = NurseryNumeracyActivity2.this;

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
                        stopService(new Intent(NurseryNumeracyActivity2.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(NurseryNumeracyActivity2.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(NurseryNumeracyActivity2.this, MusicService.class));
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
                Intent intent = new Intent(NurseryNumeracyActivity2.this, RedirectPages.class);
                intent.putExtra("type", "activity");
                startActivity(intent);
                finish();
            }
        });

//        ImageView profile_id = findViewById(R.id.profile_id);
//        profile_id.setVisibility(View.INVISIBLE);

        help_bee = findViewById(R.id.help_bee);
        help_bee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NurseryNumeracyActivity2.this, NurseryNumeracyActivity1.class));
                finish();
            }
        });

        help_frog = findViewById(R.id.help_frog);
        help_frog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NurseryNumeracyActivity2.this, NurseryNumeracyActivity3.class));
                finish();
            }
        });

//        honey_img = findViewById(R.id.honey_img);
//
//        honey_img.setImageResource(R.drawable.beehelp);

        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);
        n5 = findViewById(R.id.n5);
        n6 = findViewById(R.id.n6);
        n7 = findViewById(R.id.n7);
        n8 = findViewById(R.id.n8);
        n9 = findViewById(R.id.n9);
        n10 = findViewById(R.id.n10);
        n11 = findViewById(R.id.n11);
        n12 = findViewById(R.id.n12);
        s1 = findViewById(R.id.s1);
        s2 = findViewById(R.id.s2);
        s3 = findViewById(R.id.s3);
        s4 = findViewById(R.id.s4);

        honey_img = findViewById(R.id.honey_img);

        pDialog = new SweetAlertDialog(NurseryNumeracyActivity2.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading ...");
        pDialog.setCancelable(false);
        pDialog.show();

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/doll_board.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(honey_img);

        pDialog.cancel();

        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (inc < 4) {
                        inc += 1;
                        alpha = 1;
                        s1.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
                        if (inc == 4) {
                            toBack();
                        }
                    } else {
                        toBack();
                    }
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inc < 4) {
                    inc += 1;
                    alpha = 1;
                    s2.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
                    if (inc == 4) {
                        toBack();
                    }
                } else {
                    toBack();
                }
            }
        });

        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inc < 4) {
                    inc += 1;
                    alpha = 1;
                    s3.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
                    if (inc == 4) {
                        toBack();
                    }
                } else {
                    toBack();
                }
            }
        });

        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inc < 4) {
                    inc += 1;
                    alpha = 1;
                    s4.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
                    if (inc == 4) {
                        toBack();
                    }
                } else {
                    toBack();
                }
            }
        });

        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError();
            }
        });

        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError();
            }
        });

        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError();
            }
        });

        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError();
            }
        });

        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError();
            }
        });

        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError();
            }
        });

        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError();
            }
        });

        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError();
            }
        });

        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError();
            }
        });

        n10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError();
            }
        });

        n11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError();
            }
        });

        n12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError();
            }
        });
    }

    public void alertError() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wrong);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(NurseryNumeracyActivity2.this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setConfirmText("OK")
                .setContentText("Choose the correct answer")
                .show();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(NurseryNumeracyActivity2.this, NurseryNumeracyActivity1.class);
        intent.putExtra("bookid", pref.getClassid());
        startActivity(intent);
        finish();
    }

    public void toBack() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(NurseryNumeracyActivity2.this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Hurray!")
                .setContentText("Activity Cleared.")
                .setConfirmText("OK")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        startActivity(new Intent(NurseryNumeracyActivity2.this, NurseryNumeracyActivity3.class));
                        finish();
                    }
                })
                .show();
    }

}
