package com.mariapublishers.digimariaandroid.activity.juniorkg.juniorgeneralawarness;

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
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.activity.mainprocess.SearchActivity;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class JuniorGeneralActivity9 extends BaseActivity implements View.OnClickListener {

    ImageView correct1, correct2, correct3, correct4, correct5, correct6, correct7, correct8,
            wrong1, wrong2, wrong3, wrong4, wrong5, wrong6, wrong7, wrong8;
    CardView next, back;
    int i = 0, cr1 = 0, cr2 = 0, cr3 = 0, cr4 = 0, cr5 = 0, cr6 = 0, cr7 = 0, cr8 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junior_general9);

        currentContext = JuniorGeneralActivity9.this;

        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {

        correct1.setOnClickListener(this);
        correct2.setOnClickListener(this);
        correct3.setOnClickListener(this);
        correct4.setOnClickListener(this);
        correct5.setOnClickListener(this);
        correct6.setOnClickListener(this);
        correct7.setOnClickListener(this);
        correct8.setOnClickListener(this);
        wrong1.setOnClickListener(this);
        wrong2.setOnClickListener(this);
        wrong3.setOnClickListener(this);
        wrong4.setOnClickListener(this);
        wrong5.setOnClickListener(this);
        wrong6.setOnClickListener(this);
        wrong7.setOnClickListener(this);
        wrong8.setOnClickListener(this);
        back.setOnClickListener(this);
        next.setOnClickListener(this);

    }

    private void initialize() {

        correct1 = findViewById(R.id.correct1);
        correct2 = findViewById(R.id.correct2);
        correct3 = findViewById(R.id.correct3);
        correct4 = findViewById(R.id.correct4);
        correct5 = findViewById(R.id.correct5);
        correct6 = findViewById(R.id.correct6);
        correct7 = findViewById(R.id.correct7);
        correct8 = findViewById(R.id.correct8);
        wrong1 = findViewById(R.id.wrong1);
        wrong2 = findViewById(R.id.wrong2);
        wrong3 = findViewById(R.id.wrong3);
        wrong4 = findViewById(R.id.wrong4);
        wrong5 = findViewById(R.id.wrong5);
        wrong6 = findViewById(R.id.wrong6);
        wrong7 = findViewById(R.id.wrong7);
        wrong8 = findViewById(R.id.wrong8);
        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(JuniorGeneralActivity9.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(JuniorGeneralActivity9.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer."
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(JuniorGeneralActivity9.this, JuniorGeneralActivity10.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(JuniorGeneralActivity9.this, JuniorGeneralActivity8.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        onclickBack();
    }

    private void actionbar() {

        ImageView toback = findViewById(R.id.toback);

        toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectPage();
            }
        });

        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Tick the correct number of wheels that the following vehicles have");

    }

    private void redirectPage() {
        Intent intent = new Intent(JuniorGeneralActivity9.this, RedirectPages.class);
        intent.putExtra("type", "activity");
        startActivity(intent);
        finish();
    }

    private void musiccontrol() {

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
                        stopService(new Intent(JuniorGeneralActivity9.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(JuniorGeneralActivity9.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(JuniorGeneralActivity9.this, MusicService.class));
                }


            }
        });

        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.next) {
            onclickNext();
        } else if (v.getId() == R.id.back) {
            onclickBack();
        } else if (v.getId() == R.id.correct1) {
            if (cr1 == 0) {
                cr1 += 1;
                i += 1;
                correct1.setImageResource(R.drawable.right_mark_icon);
                if (i == 8) {
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
                if (i == 8) {
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
                if (i == 8) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.correct4) {
            if (cr4 == 0) {
                cr4 += 1;
                i += 1;
                correct4.setImageResource(R.drawable.right_mark_icon);
                if (i == 8) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.correct5) {
            if (cr5 == 0) {
                cr5 += 1;
                i += 1;
                correct5.setImageResource(R.drawable.right_mark_icon);
                if (i == 8) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.correct6) {
            if (cr6 == 0) {
                cr6 += 1;
                i += 1;
                correct6.setImageResource(R.drawable.right_mark_icon);
                if (i == 8) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.correct7) {
            if (cr7 == 0) {
                cr7 += 1;
                i += 1;
                correct7.setImageResource(R.drawable.right_mark_icon);
                if (i == 8) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.correct8) {
            if (cr8 == 0) {
                cr8 += 1;
                i += 1;
                correct8.setImageResource(R.drawable.right_mark_icon);
                if (i == 8) {
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
        } else if (v.getId() == R.id.wrong4) {
            wrong4.setImageResource(R.drawable.wrong_mark_icon);
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.wrong5) {
            wrong5.setImageResource(R.drawable.wrong_mark_icon);
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.wrong6) {
            wrong6.setImageResource(R.drawable.wrong_mark_icon);
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.wrong7) {
            wrong7.setImageResource(R.drawable.wrong_mark_icon);
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.wrong8) {
            wrong8.setImageResource(R.drawable.wrong_mark_icon);
            alertMessage(2, "Oops...", "Choose the right answer.");
        }

    }

}
