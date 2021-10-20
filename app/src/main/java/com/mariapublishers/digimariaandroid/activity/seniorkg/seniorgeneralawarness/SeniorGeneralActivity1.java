package com.mariapublishers.digimariaandroid.activity.seniorkg.seniorgeneralawarness;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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

public class SeniorGeneralActivity1 extends BaseActivity implements View.OnClickListener {

    CardView next;
    int i = 0, cr1 = 0, cr2 = 0, cr3 = 0, k = 0;
    RelativeLayout rl1;
    ImageView correct1, correct2, correct3, wrong1, wrong2, wrong3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_general1);

        currentContext = SeniorGeneralActivity1.this;

        callfunc();

    }

    private void callfunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {

        correct1.setOnClickListener(this);
        correct2.setOnClickListener(this);
        correct3.setOnClickListener(this);
        wrong1.setOnClickListener(this);
        wrong2.setOnClickListener(this);
        wrong3.setOnClickListener(this);
        next.setOnClickListener(this);

    }

    public void actionbar() {

        ImageView toback = findViewById(R.id.toback);

        toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectPage();
            }
        });

        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Tick the things that smell pleasant");

    }

    public void musiccontrol() {

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
                        stopService(new Intent(SeniorGeneralActivity1.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorGeneralActivity1.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorGeneralActivity1.this, MusicService.class));
                }


            }
        });

        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }

    }

    public void initialize() {

        correct1 = findViewById(R.id.correct1);
        correct2 = findViewById(R.id.correct2);
        correct3 = findViewById(R.id.correct3);
        wrong1 = findViewById(R.id.wrong1);
        wrong2 = findViewById(R.id.wrong2);
        wrong3 = findViewById(R.id.wrong3);
        next = findViewById(R.id.next);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.next) {
            onclickNext();
        } else if (v.getId() == R.id.correct1) {
            if (cr1 == 0) {
                cr1 += 1;
                i += 1;
                correct1.setImageResource(R.drawable.right_mark_icon);
                if (i == 3) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.correct2) {
            if (cr2 == 0) {
                cr2 += 1;
                i += 1;
                correct2.setImageResource(R.drawable.right_mark_icon);
                if (i == 3) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.correct3) {
            if (cr3 == 0) {
                cr3 += 1;
                i += 1;
                correct3.setImageResource(R.drawable.right_mark_icon);
                if (i == 3) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.wrong1) {
            wrong1.setImageResource(R.drawable.wrong_mark_icon);
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.wrong2) {
            wrong2.setImageResource(R.drawable.wrong_mark_icon);
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.wrong3) {
            wrong3.setImageResource(R.drawable.wrong_mark_icon);
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else {
            alertMessage(2, "Oops...", "Choose the right answer..");
        }
    }

    public void onclickNext() {
        startActivity(new Intent(SeniorGeneralActivity1.this, SeniorGeneralActivity2.class));
        finish();
    }

    public void onclickBack() {
        redirectPage();
    }

    @Override
    public void onBackPressed() {
        onclickBack();
    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(SeniorGeneralActivity1.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(SeniorGeneralActivity1.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer.."
                    .show();
        }

    }

    private void redirectPage() {
        Intent intent = new Intent(SeniorGeneralActivity1.this, RedirectPages.class);
        intent.putExtra("type", "activity");
        startActivity(intent);
        finish();
    }
}