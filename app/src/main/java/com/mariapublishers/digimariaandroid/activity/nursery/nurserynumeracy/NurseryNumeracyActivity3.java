package com.mariapublishers.digimariaandroid.activity.nursery.nurserynumeracy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
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

public class NurseryNumeracyActivity3 extends BaseActivity {

    ImageView butter2, butter2l, butter5, butter5l, butter8, butter8l, butter10, butter10l, butter13, butter13l;
    CardView help_bee, help_frog;
    int i = 0, j = 0, k = 0;
    CardView match_num;
    float m1 = 0, m2 = 0, m3 = 0, m4 = 0, e1 = 0, e2 = 0, e3 = 0, e4 = 0, r1 = 0, r2 = 0, r3 = 0, r4 = 0, p1 = 0, p2 = 0, p3 = 0, p4 = 0, d1 = 0, d2 = 0, d3 = 0, d4 = 0;
    DrawView drawView;
    RadioButton b2, bl2, b5, bl5, b8, bl8, b10, bl10, b13, bl13;
    RelativeLayout rl1;
    SweetAlertDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nursery_numeracy3);

        currentContext = NurseryNumeracyActivity3.this;

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
                        stopService(new Intent(NurseryNumeracyActivity3.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(NurseryNumeracyActivity3.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(NurseryNumeracyActivity3.this, MusicService.class));
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
                Intent intent = new Intent(NurseryNumeracyActivity3.this, RedirectPages.class);
                intent.putExtra("type", "activity");
                startActivity(intent);
                finish();
            }
        });

        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Connect the butterflies with the same numbers");

//        ImageView profile_id = findViewById(R.id.profile_id);
//        profile_id.setVisibility(View.INVISIBLE);

        help_bee = findViewById(R.id.help_bee);
        help_bee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NurseryNumeracyActivity3.this, NurseryNumeracyActivity2.class));
                finish();
            }
        });

        help_frog = findViewById(R.id.help_frog);
        help_frog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NurseryNumeracyActivity3.this, NurseryNumeracyActivity4.class));
                finish();
            }
        });

        butter2 = findViewById(R.id.butter2);
        butter2l = findViewById(R.id.butter2l);
        butter5 = findViewById(R.id.butter5);
        butter5l = findViewById(R.id.butter5l);
        butter8 = findViewById(R.id.butter8);
        butter8l = findViewById(R.id.butter8l);
        butter10 = findViewById(R.id.butter10);
        butter10l = findViewById(R.id.butter10l);
        butter13 = findViewById(R.id.butter13);
        butter13l = findViewById(R.id.butter13l);

        // b2, bl2, b5, bl5, b8, bl8, b10, bl10, b13, bl13
        b2 = findViewById(R.id.b2);
        bl2 = findViewById(R.id.bl2);
        b5 = findViewById(R.id.b5);
        bl5 = findViewById(R.id.bl5);
        b8 = findViewById(R.id.b8);
        bl8 = findViewById(R.id.bl8);
        b10 = findViewById(R.id.b10);
        bl10 = findViewById(R.id.bl10);
        b13 = findViewById(R.id.b13);
        bl13 = findViewById(R.id.bl13);

        rl1 = findViewById(R.id.rl1);

        pDialog = new SweetAlertDialog(NurseryNumeracyActivity3.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading ...");
        pDialog.setCancelable(false);
        pDialog.show();

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/butterfly_1.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(butter2);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/butterfly_1.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(butter2l);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/butterfly_3.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(butter5);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/butterfly_3.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(butter5l);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/butterfly_2.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(butter8);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/butterfly_2.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(butter8l);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/butterfly_4.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(butter10);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/butterfly_4.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(butter10l);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/butterfly_5.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(butter13);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/butterfly_5.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(butter13l);

        pDialog.cancel();

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i = 1;
                    b2.setChecked(true);
                } else {
                    b2.setChecked(false);
                    alertError("Choose the right answer");
                }
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i = 2;
                    b5.setChecked(true);
                } else {
                    b5.setChecked(false);
                    alertError("Choose the right answer");
                }
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i = 3;
                    b8.setChecked(true);
                } else {
                    b8.setChecked(false);
                    alertError("Choose the right answer");
                }
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i = 4;
                    b10.setChecked(true);
                } else {
                    b10.setChecked(false);
                    alertError("Choose the right answer");
                }
            }
        });

        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i = 5;
                    b13.setChecked(true);
                } else {
                    b13.setChecked(false);
                    alertError("Choose the right answer");
                }
            }
        });

        bl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 2) {
                    i = 0;
                    j += 1;
                    k += 1;
                    bl5.setChecked(true);
                    drawView = new DrawView(NurseryNumeracyActivity3.this,b5,bl5);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    if (j == 5) {
                        bl5.setChecked(true);
                        toBack();
                    }
                } else if (i == 0) {
                    bl5.setChecked(false);
                    alertError("Choose the question first");
                } else {
                    bl5.setChecked(false);
                    alertError("Choose the right answer");
                }
            }
        });

        bl13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 5) {
                    i = 0;
                    j += 1;
                    k += 1;
                    bl13.setChecked(true);
                    drawView = new DrawView(NurseryNumeracyActivity3.this,b13,bl13);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    if (j == 5) {
                        bl13.setChecked(true);
                        toBack();
                    }
                } else if (i == 0) {
                    bl13.setChecked(false);
                    alertError("Choose the question first");
                } else {
                    bl13.setChecked(false);
                    alertError("Choose the right answer");
                }
            }
        });

        bl10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 4) {
                    i = 0;
                    j += 1;
                    k += 1;
                    bl10.setChecked(true);
                    drawView = new DrawView(NurseryNumeracyActivity3.this,b10,bl10);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    if (j == 5) {
                        bl10.setChecked(true);
                        toBack();
                    }
                } else if (i == 0) {
                    bl10.setChecked(false);
                    alertError("Choose the question first");
                } else {
                    bl10.setChecked(false);
                    alertError("Choose the right answer");
                }
            }
        });

        bl8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 3) {
                    i = 0;
                    j += 1;
                    k += 1;
                    bl8.setChecked(true);
                    drawView = new DrawView(NurseryNumeracyActivity3.this,b8,bl8);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    if (j == 5) {
                        bl8.setChecked(true);
                        toBack();
                    }
                } else if (i == 0) {
                    bl8.setChecked(false);
                    alertError("Choose the question first");
                } else {
                    bl8.setChecked(false);
                    alertError("Choose the right answer");
                }
            }
        });

        bl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 1) {
                    i = 0;
                    j += 1;
                    k += 1;
                    bl2.setChecked(true);
                    drawView = new DrawView(NurseryNumeracyActivity3.this,b2,bl2);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    if (j == 5) {
                        bl2.setChecked(true);
                        toBack();
                    }
                } else if (i == 0) {
                    bl2.setChecked(false);
                    alertError("Choose the question first");
                } else {
                    bl2.setChecked(false);
                    alertError("Choose the right answer");
                }
            }
        });

    }

    public void alertError(String message) {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wrong);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(NurseryNumeracyActivity3.this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setConfirmText("OK")
                .setContentText(message)
                .show();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(NurseryNumeracyActivity3.this, NurseryNumeracyActivity2.class);
        intent.putExtra("bookid", pref.getClassid());
        startActivity(intent);
        finish();
    }

    public void toBack() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(NurseryNumeracyActivity3.this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Hurray!")
                .setContentText("Activity Cleared.")
                .setConfirmText("OK")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        startActivity(new Intent(NurseryNumeracyActivity3.this, NurseryNumeracyActivity4.class));
                        finish();
                    }
                })
                .show();
    }

    public class DrawView extends View {
        Paint paint = new Paint();
        View startView;
        View endView;

        public DrawView(Context context, View startView, View endView) {
            super(context);
            paint.setColor(getResources().getColor(R.color.colorAccent));
            paint.setStrokeWidth(10f);
            paint.setAntiAlias(true);
            this.startView = startView;
            this.endView = endView;
        }

        @SuppressLint("NewApi")
        public void onDraw(Canvas canvas) {
            if (k == 1) {
                m1 = startView.getX()+40;
                m2 = startView.getY()+50;
                m3 = endView.getX()+40;
                m4 = endView.getY()+50;
                canvas.drawLine(m1, m2, m3, m4, paint);
                Log.d("qwrwr", "onDraw: m " + m1);
            }

            if (k == 2) {
                e1 = startView.getX()+40;
                e2 = startView.getY()+50;
                e3 = endView.getX()+40;
                e4 = endView.getY()+50;
                canvas.drawLine(m1, m2, m3, m4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
                Log.d("qwrwr", "onDraw: e " + e1);
            }

            if (k == 3) {
                r1 = startView.getX()+40;
                r2 = startView.getY()+50;
                r3 = endView.getX()+40;
                r4 = endView.getY()+50;
                canvas.drawLine(m1, m2, m3, m4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
                canvas.drawLine(r1, r2, r3, r4, paint);
                Log.d("qwrwr", "onDraw: r " + r1);
            }

            if (k == 4) {
                p1 = startView.getX()+40;
                p2 = startView.getY()+50;
                p3 = endView.getX()+40;
                p4 = endView.getY()+50;
                canvas.drawLine(m1, m2, m3, m4, paint);
                canvas.drawLine(p1, p2, p3, p4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
                canvas.drawLine(r1, r2, r3, r4, paint);
                Log.d("qwrwr", "onDraw: p " + p1);
            }

            if (k == 5) {
                d1 = startView.getX()+40;
                d2 = startView.getY()+50;
                d3 = endView.getX()+40;
                d4 = endView.getY()+50;
                canvas.drawLine(m1, m2, m3, m4, paint);
                canvas.drawLine(d1, d2, d3, d4, paint);
                canvas.drawLine(p1, p2, p3, p4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
                canvas.drawLine(r1, r2, r3, r4, paint);
                Log.d("qwrwr", "onDraw: d " + d1);
            }

        }

    }

}
