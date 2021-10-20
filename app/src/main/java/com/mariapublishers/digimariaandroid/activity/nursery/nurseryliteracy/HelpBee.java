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

public class HelpBee extends BaseActivity {

    TextView a, b, c, d, e, f, g, h, i, j;
    int inc = 0 ;
    CardView help_bee, help_frog;
    int alpha = 0;

    SweetAlertDialog pDialog;
    ImageView honey_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_bee);

        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Colour the cells with letters and help the bee store the nectar");

        currentContext = HelpBee.this;

        volval = pref.getVolumeval();

        volumenote = findViewById(R.id.volumenote);

        pDialog = new SweetAlertDialog(HelpBee.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));

        volumenote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (volval != null) {
                    if (volval.equals("1")) {
                        pref.setVolumeval("0");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeoff);
                        stopService(new Intent(HelpBee.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(HelpBee.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(HelpBee.this, MusicService.class));
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
                Intent intent = new Intent(HelpBee.this, RedirectPages.class);
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
                startActivity(new Intent(HelpBee.this, FindChick.class));
                finish();
            }
        });

        help_frog = findViewById(R.id.help_frog);
        help_frog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelpBee.this, HelpFrog.class));
                finish();
            }
        });

        honey_img = findViewById(R.id.honey_img);

        pDialog.setTitleText("Loading ...");
        pDialog.setCancelable(false);
        pDialog.show();

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/bee.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(honey_img);

        pDialog.cancel();

        a = findViewById(R.id.a_id);
        b = findViewById(R.id.b_id);
        c = findViewById(R.id.c_id);
        d = findViewById(R.id.d_id);
        e = findViewById(R.id.e_id);
        f = findViewById(R.id.f_id);
        g = findViewById(R.id.g_id);
        h = findViewById(R.id.h_id);
        i = findViewById(R.id.i_id);
        j = findViewById(R.id.j_id);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alpha == 0) {
                    if (inc < 10) {
                        inc += 1;
                        alpha = 1;
                        a.setBackground(getResources().getDrawable(R.drawable.hexagon_selected));
                        if (inc == 10) {
                            toBack();
                        }
                    } else {
                        toBack();
                    }
                } else {
                    alertError();
                }
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alpha == 1) {
                    if (inc < 10) {
                        inc += 1;
                        alpha = 2;
                        b.setBackground(getResources().getDrawable(R.drawable.hexagon_selected));
                        if (inc == 10) {
                            toBack();
                        }
                    } else {
                        toBack();
                    }
                } else {
                    alertError();
                }
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alpha == 2) {
                    if (inc < 10) {
                        inc += 1;
                        alpha = 3;
                        c.setBackground(getResources().getDrawable(R.drawable.hexagon_selected));
                        if (inc == 10) {
                            toBack();
                        }
                    } else {
                        toBack();
                    }
                } else {
                    alertError();
                }
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alpha == 3) {
                    if (inc < 10) {
                        inc += 1;
                        alpha = 4;
                        d.setBackground(getResources().getDrawable(R.drawable.hexagon_selected));
                        if (inc == 10) {
                            toBack();
                        }
                    } else {
                        toBack();
                    }
                } else {
                    alertError();
                }
            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alpha == 4) {
                    if (inc < 10) {
                        inc += 1;
                        alpha = 5;
                        e.setBackground(getResources().getDrawable(R.drawable.hexagon_selected));
                        if (inc == 10) {
                            toBack();
                        }
                    } else {
                        toBack();
                    }
                } else {
                    alertError();
                }
            }
        });

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alpha == 5) {
                    if (inc < 10) {
                        inc += 1;
                        alpha = 6;
                        f.setBackground(getResources().getDrawable(R.drawable.hexagon_selected));
                        if (inc == 10) {
                            toBack();
                        }
                    } else {
                        toBack();
                    }
                } else {
                    alertError();
                }
            }
        });

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alpha == 6) {
                    if (inc < 10) {
                        inc += 1;
                        alpha = 7;
                        g.setBackground(getResources().getDrawable(R.drawable.hexagon_selected));
                        if (inc == 10) {
                            toBack();
                        }
                    } else {
                        toBack();
                    }
                } else {
                    alertError();
                }
            }
        });

        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alpha == 7) {
                    if (inc < 10) {
                        inc += 1;
                        alpha = 8;
                        h.setBackground(getResources().getDrawable(R.drawable.hexagon_selected));
                        if (inc == 10) {
                            toBack();
                        }
                    } else {
                        toBack();
                    }
                } else {
                    alertError();
                }
            }
        });

        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alpha == 8) {
                    if (inc < 10) {
                        inc += 1;
                        alpha = 9;
                        i.setBackground(getResources().getDrawable(R.drawable.hexagon_selected));
                        if (inc == 10) {
                            toBack();
                        }
                    } else {
                        toBack();
                    }
                } else {
                    alertError();
                }
            }
        });

        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alpha == 9) {
                    if (inc < 10) {
                        inc += 1;
                        alpha = 10;
                        j.setBackground(getResources().getDrawable(R.drawable.hexagon_selected));
                        if (inc == 10) {
                            toBack();
                        }
                    } else {
                        toBack();
                    }
                } else {
                    alertError();
                }
            }
        });

    }

    public void alertError() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wrong);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(HelpBee.this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setConfirmText("OK")
                .setContentText("Go with the alphabet order")
                .show();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(HelpBee.this, FindChick.class);
        intent.putExtra("bookid", pref.getClassid());
        startActivity(intent);
        finish();
    }

    public void toBack() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(HelpBee.this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Hurray!")
                .setContentText("Activity Cleared.")
                .setConfirmText("OK")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        startActivity(new Intent(HelpBee.this, HelpFrog.class));
                        finish();
                    }
                })
                .show();
    }

}
