package com.mariapublishers.digimariaandroid.activity.juniorkg.juniorliteracy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class JuniorLiteracyActivity8 extends BaseActivity implements OnClickListener {

    CardView alpha1, alpha2, alpha3, alpha4, alpha5, alpha6, alpha7, alpha8, alpha9, alpha10, alpha11, alpha12, alpha13, alpha14, alpha15,
            vowel1, vowel2, vowel3, vowel4, vowel5, vowel6, vowel7, vowel8;
    CardView next, back;
    int i = 0, cr1 = 0, cr2 = 0, cr3 = 0, cr4 = 0, cr5 = 0, cr6 = 0, cr7 = 0, cr8 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junior_literacy8);

        currentContext = JuniorLiteracyActivity8.this;

        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {

        alpha1.setOnClickListener(this);
        alpha2.setOnClickListener(this);
        alpha3.setOnClickListener(this);
        alpha4.setOnClickListener(this);
        alpha5.setOnClickListener(this);
        alpha6.setOnClickListener(this);
        alpha7.setOnClickListener(this);
        alpha8.setOnClickListener(this);
        alpha9.setOnClickListener(this);
        alpha10.setOnClickListener(this);
        alpha11.setOnClickListener(this);
        alpha12.setOnClickListener(this);
        alpha13.setOnClickListener(this);
        alpha14.setOnClickListener(this);
        alpha15.setOnClickListener(this);
        vowel1.setOnClickListener(this);
        vowel2.setOnClickListener(this);
        vowel3.setOnClickListener(this);
        vowel4.setOnClickListener(this);
        vowel5.setOnClickListener(this);
        vowel6.setOnClickListener(this);
        vowel7.setOnClickListener(this);
        vowel8.setOnClickListener(this);
        back.setOnClickListener(this);
        next.setOnClickListener(this);

    }

    private void initialize() {

        alpha1 = findViewById(R.id.alpha1);
        alpha2 = findViewById(R.id.alpha2);
        alpha3 = findViewById(R.id.alpha3);
        alpha4 = findViewById(R.id.alpha4);
        alpha5 = findViewById(R.id.alpha5);
        alpha6 = findViewById(R.id.alpha6);
        alpha7 = findViewById(R.id.alpha7);
        alpha8 = findViewById(R.id.alpha8);
        alpha9 = findViewById(R.id.alpha9);
        alpha10 = findViewById(R.id.alpha10);
        alpha11 = findViewById(R.id.alpha11);
        alpha12 = findViewById(R.id.alpha12);
        alpha13 = findViewById(R.id.alpha13);
        alpha14 = findViewById(R.id.alpha14);
        alpha15 = findViewById(R.id.alpha15);
        vowel1 = findViewById(R.id.vowel1);
        vowel2 = findViewById(R.id.vowel2);
        vowel3 = findViewById(R.id.vowel3);
        vowel4 = findViewById(R.id.vowel4);
        vowel5 = findViewById(R.id.vowel5);
        vowel6 = findViewById(R.id.vowel6);
        vowel7 = findViewById(R.id.vowel7);
        vowel8 = findViewById(R.id.vowel8);
        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(JuniorLiteracyActivity8.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(JuniorLiteracyActivity8.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(JuniorLiteracyActivity8.this, JuniorLiteracyActivity9.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(JuniorLiteracyActivity8.this, JuniorLiteracyActivity7.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        onclickBack();
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
        book_name_header.setText("Select the vowels");

    }

    private void redirectPage() {
        Intent intent = new Intent(JuniorLiteracyActivity8.this, RedirectPages.class);
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
                        stopService(new Intent(JuniorLiteracyActivity8.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(JuniorLiteracyActivity8.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(JuniorLiteracyActivity8.this, MusicService.class));
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
        if (v.getId() == R.id.vowel1) {
            if (cr1 == 0) {
                cr1 += 1;
                i += 1;
                vowel1.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
                if (i == 8) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.vowel2) {
            if (cr2 == 0) {
                cr2 += 1;
                i += 1;
                vowel2.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
                if (i == 8) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.vowel3) {
            if (cr3 == 0) {
                cr3 += 1;
                i += 1;
                vowel3.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
                if (i == 8) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.vowel4) {
            if (cr4 == 0) {
                cr4 += 1;
                i += 1;
                vowel4.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
                if (i == 8) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.vowel5) {
            if (cr5 == 0) {
                cr5 += 1;
                i += 1;
                vowel5.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
                if (i == 8) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.vowel6) {
            if (cr6 == 0) {
                cr6 += 1;
                i += 1;
                vowel6.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
                if (i == 8) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.vowel7) {
            if (cr7 == 0) {
                cr7 += 1;
                i += 1;
                vowel7.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
                if (i == 8) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.vowel8) {
            if (cr8 == 0) {
                cr8 += 1;
                i += 1;
                vowel8.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
                if (i == 8) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.alpha1) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.alpha2) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.alpha3) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.alpha4) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.alpha5) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.alpha6) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.alpha7) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.alpha8) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.alpha9) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.alpha10) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.alpha11) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.alpha12) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.alpha13) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.alpha14) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.alpha15) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.next) {
            onclickNext();
        } else if (v.getId() == R.id.back) {
            onclickBack();
        }
    }
}
