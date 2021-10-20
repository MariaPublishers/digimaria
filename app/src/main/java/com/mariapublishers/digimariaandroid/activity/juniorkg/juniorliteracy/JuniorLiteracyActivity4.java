package com.mariapublishers.digimariaandroid.activity.juniorkg.juniorliteracy;

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
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.juniorkg.juniorgeneralawarness.JuniorGeneralActivity2;
import com.mariapublishers.digimariaandroid.activity.juniorkg.juniorgeneralawarness.JuniorGeneralActivity4;
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class JuniorLiteracyActivity4 extends BaseActivity implements OnClickListener {

    RadioButton ibtn, tub, insect, leaf, igloo, hut, ironbox, icecream, frog, ink;
    ImageView icecreamcopy;
    CardView next, back;
    DrawView drawView;
    RelativeLayout rl1;
    float m1 = 0, m2 = 0, m3 = 0, m4 = 0, e1 = 0, e2 = 0, e3 = 0, e4 = 0, r1 = 0, r2 = 0, r3 = 0, r4 = 0, p1 = 0, p2 = 0, p3 = 0, p4 = 0, d1 = 0, d2 = 0, d3 = 0, d4 = 0;
    int k = 0, i = 0;
    SweetAlertDialog pDialog;
    private boolean isAnswerSelectedTwice = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junior_literacy4);

        currentContext = JuniorLiteracyActivity4.this;

        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {

        ibtn.setOnClickListener(this);
        tub.setOnClickListener(this);
        insect.setOnClickListener(this);
        leaf.setOnClickListener(this);
        igloo.setOnClickListener(this);
        hut.setOnClickListener(this);
        ironbox.setOnClickListener(this);
        icecream.setOnClickListener(this);
        frog.setOnClickListener(this);
        ink.setOnClickListener(this);
        next.setOnClickListener(this);
        back.setOnClickListener(this);

    }

    private void actionbar() {

        ImageView toback = findViewById(R.id.toback);

        toback.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectPage();
            }
        });

        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Which of the following start with the “I” sound? Connect them to the letter “I”");

    }

    private void redirectPage() {
        Intent intent = new Intent(JuniorLiteracyActivity4.this, RedirectPages.class);
        intent.putExtra("type", "activity");
        startActivity(intent);
        finish();
    }

    private void musiccontrol() {

        volval = pref.getVolumeval();

        volumenote = findViewById(R.id.volumenote);

        volumenote.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (volval != null) {
                    if (volval.equals("1")) {
                        pref.setVolumeval("0");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeoff);
                        stopService(new Intent(JuniorLiteracyActivity4.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(JuniorLiteracyActivity4.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(JuniorLiteracyActivity4.this, MusicService.class));
                }


            }
        });

        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }
        
    }

    private void initialize() {

        ibtn = findViewById(R.id.ibtn);
        tub = findViewById(R.id.tub);
        insect = findViewById(R.id.insect);
        leaf = findViewById(R.id.leaf);
        igloo = findViewById(R.id.igloo);
        hut = findViewById(R.id.hut);
        ironbox = findViewById(R.id.ironbox);
        icecream = findViewById(R.id.icecream);
        frog = findViewById(R.id.frog);
        ink = findViewById(R.id.ink);
        next = findViewById(R.id.next);
        back = findViewById(R.id.back);
        rl1 = findViewById(R.id.rl1);

        icecreamcopy = findViewById(R.id.icecreamcopy);

        pDialog = new SweetAlertDialog(JuniorLiteracyActivity4.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading ...");
        pDialog.setCancelable(false);
        pDialog.show();

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/icecreamcopy.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(icecreamcopy);

        pDialog.cancel();

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(JuniorLiteracyActivity4.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText(title) // "Hurray!"
                    .setContentText(message) // "Activity Cleared."
                    .setConfirmText("OK")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            onclickNext();
                        }
                    })
                    .show();
        } else {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wrong);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(JuniorLiteracyActivity4.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

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

    public void onclickNext() {
        startActivity(new Intent(JuniorLiteracyActivity4.this, JuniorLiteracyActivity5.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(JuniorLiteracyActivity4.this, JuniorLiteracyActivity3.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        onclickBack();
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.back) {
            onclickBack();
        } else if (v.getId() == R.id.next) {
            onclickNext();
        } else if (v.getId() == R.id.ibtn) {
            isAnswerSelectedTwice = false;
            if (i <= 5) {

                if (i == 1) {
                    drawView = new DrawView(this,igloo,ibtn);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    k += 1;

                    if (k == 5) {
                        alertMessage(1, "Hurray!", "Activity Cleared.");
                    }
                } else if (i == 2) {
                    drawView = new DrawView(this,ironbox,ibtn);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    k += 1;

                    if (k == 5) {
                        alertMessage(1, "Hurray!", "Activity Cleared.");
                    }
                } else if (i == 3) {
                    drawView = new DrawView(this,icecream,ibtn);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    k += 1;

                    if (k == 5) {
                        alertMessage(1, "Hurray!", "Activity Cleared.");
                    }
                } else if (i == 4) {
                    drawView = new DrawView(this,insect,ibtn);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    k += 1;

                    if (k == 5) {
                        alertMessage(1, "Hurray!", "Activity Cleared.");
                    }
                } else if (i == 5) {
                    drawView = new DrawView(this,ink,ibtn);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    k += 1;

                    if (k == 5) {
                        alertMessage(1, "Hurray!", "Activity Cleared.");
                    }
                } else if (i == 0) {
                    alertMessage(2, "Oops...", "Choose the right object first");
                    ibtn.setChecked(false);
                }

            } else {
                if (i == 6) {
                    tub.setChecked(false);
                } else if (i == 7) {
                    leaf.setChecked(false);
                } else if (i == 8) {
                    hut.setChecked(false);
                } else if (i == 9) {
                    frog.setChecked(false);
                }
                ibtn.setChecked(false);
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.tub) {
            linkBeforeSelectingNextAnswer(tub, 6);
        } else if (v.getId() == R.id.leaf) {
            linkBeforeSelectingNextAnswer(leaf, 7);
        } else if (v.getId() == R.id.igloo) {
            linkBeforeSelectingNextAnswer(igloo, 1);
        } else if (v.getId() == R.id.hut) {
            linkBeforeSelectingNextAnswer(hut, 8);
        } else if (v.getId() == R.id.ironbox) {
            linkBeforeSelectingNextAnswer(ironbox, 2);
        } else if (v.getId() == R.id.icecream) {
            linkBeforeSelectingNextAnswer(icecream, 3);
        } else if (v.getId() == R.id.insect) {
            linkBeforeSelectingNextAnswer(insect, 4);
        } else if (v.getId() == R.id.frog) {
            linkBeforeSelectingNextAnswer(frog, 9);
        } else if (v.getId() == R.id.ink) {
            linkBeforeSelectingNextAnswer(ink, 5);
        }

    }

    private void linkBeforeSelectingNextAnswer(RadioButton radioButton, int i) {
        if (!isAnswerSelectedTwice) {
            this.i = i;
            isAnswerSelectedTwice = true;
        } else {
            radioButton.setChecked(false);
            alertMessage(2, "Oops...", "Link to I, before selecting next answer");
        }
    }
}
