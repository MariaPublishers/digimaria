package com.mariapublishers.digimariaandroid.activity.nursery.nurseryliteracy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.juniorkg.juniorliteracy.JuniorLiteracyActivity10;
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class SmallCaps extends BaseActivity {

    CardView d_c, p_s, h_c, d_s, b_c, t_s, p_c, b_s, t_c, h_s;
    int i = 0, j = 0;
    CardView help_frog_2, animals_first;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small_caps);

        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Match the following capital letters with their small letters");

//        ImageView profile_id = findViewById(R.id.profile_id);
//        profile_id.setVisibility(View.INVISIBLE);

        currentContext = SmallCaps.this;

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
                        stopService(new Intent(SmallCaps.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SmallCaps.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SmallCaps.this, MusicService.class));
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
                Intent intent = new Intent(SmallCaps.this, RedirectPages.class);
                intent.putExtra("type", "activity");
                startActivity(intent);
                finish();
            }
        });

        help_frog_2 = findViewById(R.id.help_frog_2);
        help_frog_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SmallCaps.this, HelpFrog.class));
            }
        });

        animals_first = findViewById(R.id.animals_first);
        animals_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SmallCaps.this, BookActivities.class));
            }
        });

        d_c = findViewById(R.id.d_c);
        p_s = findViewById(R.id.p_s);
        h_c = findViewById(R.id.h_c);
        d_s = findViewById(R.id.d_s);
        b_c = findViewById(R.id.b_c);
        t_s = findViewById(R.id.t_s);
        p_c = findViewById(R.id.p_c);
        b_s = findViewById(R.id.b_s);
        t_c = findViewById(R.id.t_c);
        h_s = findViewById(R.id.h_s);

        d_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i = 1;
                    d_c.setCardBackgroundColor(getResources().getColor(R.color.matchone));
                } else {
                    alertError("Choose the right answer.");
                }
            }
        });

        h_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i = 2;
                    h_c.setCardBackgroundColor(getResources().getColor(R.color.matchtwo));
                } else {
                    alertError("Choose the right answer.");
                }
            }
        });

        b_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i = 3;
                    b_c.setCardBackgroundColor(getResources().getColor(R.color.matchthree));
                } else {
                    alertError("Choose the right answer.");
                }
            }
        });

        p_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i = 4;
                    p_c.setCardBackgroundColor(getResources().getColor(R.color.matchfour));
                } else {
                    alertError("Choose the right answer.");
                }
            }
        });

        t_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i = 5;
                    t_c.setCardBackgroundColor(getResources().getColor(R.color.matchfive));
                } else {
                    alertError("Choose the right answer.");
                }
            }
        });

        p_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 4) {
                    i = 0;
                    p_s.setCardBackgroundColor(getResources().getColor(R.color.matchfour));
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

        d_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 1) {
                    i = 0;
                    d_s.setCardBackgroundColor(getResources().getColor(R.color.matchone));
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

        t_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 5) {
                    i = 0;
                    t_s.setCardBackgroundColor(getResources().getColor(R.color.matchfive));
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

        b_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 3) {
                    i = 0;
                    b_s.setCardBackgroundColor(getResources().getColor(R.color.matchthree));
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

        h_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 2) {
                    i = 0;
                    h_s.setCardBackgroundColor(getResources().getColor(R.color.matchtwo));
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

        new SweetAlertDialog(SmallCaps.this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setConfirmText("OK")
                .setContentText(message)
                .show();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SmallCaps.this, BookActivities.class);
        intent.putExtra("bookid", pref.getClassid());
        startActivity(intent);
        finish();
    }

    public void toBack() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(SmallCaps.this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Hurray!")
                .setContentText("Activity Cleared.")
                .setConfirmText("OK")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        startActivity(new Intent(SmallCaps.this, BookActivities.class));
                    }
                })
                .show();
    }
}
