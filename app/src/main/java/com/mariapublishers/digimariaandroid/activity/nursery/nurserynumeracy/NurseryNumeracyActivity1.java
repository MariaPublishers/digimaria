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
import com.mariapublishers.digimariaandroid.activity.nursery.nurseryliteracy.HelpFrog;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class NurseryNumeracyActivity1 extends BaseActivity {

    ImageView monkey, rabittail, rabit, dogtail, elephant2, pigtail, pig, elephanttail, dog, monkeytail;
    int i = 0, j = 0, k = 0;
    CardView match_num;
    float m1 = 0, m2 = 0, m3 = 0, m4 = 0, e1 = 0, e2 = 0, e3 = 0, e4 = 0, r1 = 0, r2 = 0, r3 = 0, r4 = 0, p1 = 0, p2 = 0, p3 = 0, p4 = 0, d1 = 0, d2 = 0, d3 = 0, d4 = 0;
    DrawView drawView;
    RadioButton mr1, mt1, rr1, rt1, er1, et1, dr1, dt1, pr1, pt1;
    RelativeLayout rl1;
    SweetAlertDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nursery_numeracy1);

        currentContext = NurseryNumeracyActivity1.this;

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
                        stopService(new Intent(NurseryNumeracyActivity1.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(NurseryNumeracyActivity1.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(NurseryNumeracyActivity1.this, MusicService.class));
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
                Intent intent = new Intent(NurseryNumeracyActivity1.this, RedirectPages.class);
                intent.putExtra("type", "activity");
                startActivity(intent);
                finish();
            }
        });

        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Match the animals with their tails");

//        ImageView profile_id = findViewById(R.id.profile_id);
//        profile_id.setVisibility(View.INVISIBLE);

        match_num = findViewById(R.id.match_num);
        match_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NurseryNumeracyActivity1.this, NurseryNumeracyActivity2.class));
                finish();
            }
        });

        monkey = findViewById(R.id.monkey);
        rabittail = findViewById(R.id.rabittail);
        rabit = findViewById(R.id.rabit);
        dogtail = findViewById(R.id.dogtail);
        elephant2 = findViewById(R.id.elephant3);
        pigtail = findViewById(R.id.pigtail);
        pig = findViewById(R.id.pig);
        elephanttail = findViewById(R.id.elephanttail);
        dog = findViewById(R.id.dog);
        monkeytail = findViewById(R.id.monkeytail);

        pDialog = new SweetAlertDialog(NurseryNumeracyActivity1.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading ...");
        pDialog.setCancelable(false);
        pDialog.show();

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/monkey.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(monkey);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/rabittail.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(rabittail);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/rabit.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(rabit);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/dogtail.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(dogtail);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/elephant2.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(elephant2);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/pigtail.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(pigtail);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/pig.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(pig);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/elephanttail.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(elephanttail);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/dog.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(dog);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/monkeytail.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(monkeytail);

        pDialog.cancel();

        mr1 = findViewById(R.id.mr1);
        mt1 = findViewById(R.id.mt1);
        rr1 = findViewById(R.id.rr1);
        rt1 = findViewById(R.id.rt1);
        er1 = findViewById(R.id.er1);
        et1 = findViewById(R.id.et1);
        dr1 = findViewById(R.id.dr1);
        dt1 = findViewById(R.id.dt1);
        pr1 = findViewById(R.id.pr1);
        pt1 = findViewById(R.id.pt1);

        rl1 = findViewById(R.id.rl1);

        mr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i = 1;
                    mr1.setChecked(true);
                } else {
                    mr1.setChecked(false);
                    alertError("Choose the right answer");
                }
            }
        });

        rr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i = 2;
                    rr1.setChecked(true);
                } else {
                    rr1.setChecked(false);
                    alertError("Choose the right answer");
                }
            }
        });

        er1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i = 3;
                    er1.setChecked(true);
                } else {
                    er1.setChecked(false);
                    alertError("Choose the right answer");
                }
            }
        });

        pr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i = 4;
                    pr1.setChecked(true);
                } else {
                    pr1.setChecked(false);
                    alertError("Choose the right answer");
                }
            }
        });

        dr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i = 5;
                    dr1.setChecked(true);
                } else {
                    dr1.setChecked(false);
                    alertError("Choose the right answer");
                }
            }
        });

        rt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 2) {
                    i = 0;
                    j += 1;
                    k += 1;
                    rt1.setChecked(true);
                    drawView = new DrawView(NurseryNumeracyActivity1.this,rr1,rt1);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);

                    if (j == 5) {
                        rt1.setChecked(true);
                        toBack();
                    }
                } else if (i == 0) {
                    rt1.setChecked(false);
                    alertError("Choose the question first");
                } else {
                    rt1.setChecked(false);
                    alertError("Choose the right answer");
                }
            }
        });

        dt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 5) {
                    i = 0;
                    j += 1;
                    k += 1;
                    dt1.setChecked(true);
                    drawView = new DrawView(NurseryNumeracyActivity1.this,dr1,dt1);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);

                    if (j == 5) {
                        dt1.setChecked(true);
                        toBack();
                    }
                } else if (i == 0) {
                    dt1.setChecked(false);
                    alertError("Choose the question first");
                } else {
                    dt1.setChecked(false);
                    alertError("Choose the right answer");
                }
            }
        });

        pt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 4) {
                    i = 0;
                    j += 1;
                    pt1.setChecked(true);
                    drawView = new DrawView(NurseryNumeracyActivity1.this,pr1,pt1);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    k += 1;
                    if (j == 5) {
                        pt1.setChecked(true);
                        toBack();
                    }
                } else if (i == 0) {
                    pt1.setChecked(false);
                    alertError("Choose the question first");
                } else {
                    pt1.setChecked(false);
                    alertError("Choose the right answer");
                }
            }
        });

        et1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 3) {
                    i = 0;
                    j += 1;
                    k += 1;
                    et1.setChecked(true);
                    drawView = new DrawView(NurseryNumeracyActivity1.this,er1,et1);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);

                    if (j == 5) {
                        et1.setChecked(true);
                        toBack();
                    }
                } else if (i == 0) {
                    et1.setChecked(false);
                    alertError("Choose the question first");
                } else {
                    et1.setChecked(false);
                    alertError("Choose the right answer");
                }
            }
        });

        mt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 1) {
                    i = 0;
                    j += 1;
                    k += 1;
                    mt1.setChecked(true);
                    drawView = new DrawView(NurseryNumeracyActivity1.this,mr1,mt1);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);

                    if (j == 5) {
                        mt1.setChecked(true);
                        toBack();
                    }
                } else if (i == 0) {
                    mt1.setChecked(false);
                    alertError("Choose the question first");
                } else {
                    mt1.setChecked(false);
                    alertError("Choose the right answer");
                }
            }
        });

    }

    public void alertError(String message) {

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wrong);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(NurseryNumeracyActivity1.this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setConfirmText("OK")
                .setContentText(message)
                .show();
    }

    public void toBack() {

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(NurseryNumeracyActivity1.this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Hurray!")
                .setContentText("Activity Cleared.")
                .setConfirmText("OK")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        startActivity(new Intent(NurseryNumeracyActivity1.this, NurseryNumeracyActivity2.class));
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
