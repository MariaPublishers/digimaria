package com.mariapublishers.digimariaandroid.activity.nursery.nurseryliteracy;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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

public class HelpFrog extends BaseActivity {

    RelativeLayout a, b, c, d, e, f, g, n1, n2, n3, n4;
    int inc = 0;
    ImageView txt_a, txt_b, txt_c, txt_d, txt_e, txt_f, txt_g, none1, none2, none3, none4, frog_up, pond;
    CardView help_bee_2, small_caps;

    SweetAlertDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_frog);

        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Colour the leaves with letters and help the frog reach the pond");

//        ImageView profile_id = findViewById(R.id.profile_id);
//        profile_id.setVisibility(View.INVISIBLE);

        currentContext = HelpFrog.this;

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
                        stopService(new Intent(HelpFrog.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(HelpFrog.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(HelpFrog.this, MusicService.class));
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
                Intent intent = new Intent(HelpFrog.this, RedirectPages.class);
                intent.putExtra("type", "activity");
                startActivity(intent);
                finish();
            }
        });

        help_bee_2 = findViewById(R.id.help_bee_2);
        help_bee_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelpFrog.this, HelpBee.class));
            }
        });

        small_caps = findViewById(R.id.small_caps);
        small_caps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelpFrog.this, SmallCaps.class));
            }
        });

        a = findViewById(R.id.a_frg);
        b = findViewById(R.id.b_frg);
        c = findViewById(R.id.c_frg);
        d = findViewById(R.id.d_frg);
        e = findViewById(R.id.e_frg);
        f = findViewById(R.id.f_frg);
        g = findViewById(R.id.g_frg);

        txt_a = findViewById(R.id.txt_a);
        txt_b = findViewById(R.id.txt_b);
        txt_c = findViewById(R.id.txt_c);
        txt_d = findViewById(R.id.txt_d);
        txt_e = findViewById(R.id.txt_e);
        txt_f = findViewById(R.id.txt_f);
        txt_g = findViewById(R.id.txt_g);

        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);

        none1 = findViewById(R.id.none1);
        none2 = findViewById(R.id.none2);
        none3 = findViewById(R.id.none3);
        none4 = findViewById(R.id.none4);

        frog_up = findViewById(R.id.frog_up);
        pond = findViewById(R.id.pond);

        pDialog = new SweetAlertDialog(HelpFrog.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading ...");
        pDialog.setCancelable(false);
        pDialog.show();

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/leafnl3.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(none1);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/leafnl3.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(none2);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/leafnl3.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(none3);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/leafnl3.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(none4);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/leafnl3.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(txt_a);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/leafnl3.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(txt_b);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/leafnl3.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(txt_c);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/leafnl3.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(txt_d);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/leafnl3.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(txt_e);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/leafnl3.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(txt_f);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/leafnl3.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(txt_g);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable24/drawablev24/frog.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(frog_up);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable24/drawablev24/pond.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(pond);

        pDialog.cancel();

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inc == 0) {
                    inc = 1;
                    txt_a.setImageResource(R.drawable.leaf2);
                } else {
                    alertError("Choose A");
                }
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inc == 1) {
                    inc = 2;
                    txt_b.setImageResource(R.drawable.leaf2);
                } else {
                    inc = 0;
                    alertError("Choose A and choose B");
                }
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inc == 2) {
                    inc = 3;
                    txt_c.setImageResource(R.drawable.leaf2);
                } else {
                    alertError("Choose B and choose C");
                }
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inc == 3) {
                    inc = 4;
                    txt_d.setImageResource(R.drawable.leaf2);
                } else {
                    alertError("Choose C and choose D");
                }
            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inc == 4) {
                    inc = 5;
                    txt_e.setImageResource(R.drawable.leaf2);
                } else {
                    alertError("Choose D and choose E");
                }
            }
        });

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inc == 5) {
                    inc = 6;
                    txt_f.setImageResource(R.drawable.leaf2);
                } else {
                    alertError("Choose E and choose F");
                }
            }
        });

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inc == 6) {
                    inc = 7;
                    txt_g.setImageResource(R.drawable.leaf2);
                    if (inc == 7) {
                        toBack();
                    }
                } else {
                    alertError("Choose F and choose G");
                }
            }
        });

        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Wrong Leaf");
            }
        });

        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Wrong Leaf");
            }
        });

        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Wrong Leaf");
            }
        });

        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Wrong Leaf");
            }
        });

    }

    public void alertError(String msg) {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wrong);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(HelpFrog.this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setConfirmText("OK")
                .setContentText(msg)
                .show();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(HelpFrog.this, SmallCaps.class);
        intent.putExtra("bookid", pref.getClassid());
        startActivity(intent);
        finish();
    }

    public void toBack() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(HelpFrog.this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Hurray!")
                .setContentText("Activity Cleared.")
                .setConfirmText("OK")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        startActivity(new Intent(HelpFrog.this, SmallCaps.class));
                    }
                })
                .show();
    }

}
