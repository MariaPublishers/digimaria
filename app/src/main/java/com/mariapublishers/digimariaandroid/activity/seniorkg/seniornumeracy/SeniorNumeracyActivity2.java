package com.mariapublishers.digimariaandroid.activity.seniorkg.seniornumeracy;

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

public class SeniorNumeracyActivity2 extends BaseActivity implements View.OnClickListener {

    TextView s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16,
            n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, n17, n18, n19, n20;


    CardView next, back;
    int i = 0, j = 0, k = 0, l = 0, m = 0, n = 0, o = 0, p = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_numeracy2);

        currentContext = SeniorNumeracyActivity2.this;

        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {

        s1.setOnClickListener(this);
        s2.setOnClickListener(this);
        s3.setOnClickListener(this);
        s4.setOnClickListener(this);
        s5.setOnClickListener(this);
        s6.setOnClickListener(this);
        s7.setOnClickListener(this);
        s8.setOnClickListener(this);
        s9.setOnClickListener(this);
        s10.setOnClickListener(this);
        s11.setOnClickListener(this);
        s12.setOnClickListener(this);
        s13.setOnClickListener(this);
        s14.setOnClickListener(this);
        s15.setOnClickListener(this);
        s16.setOnClickListener(this);
        n1.setOnClickListener(this);
        n2.setOnClickListener(this);
        n3.setOnClickListener(this);
        n4.setOnClickListener(this);
        n5.setOnClickListener(this);
        n6.setOnClickListener(this);
        n7.setOnClickListener(this);
        n8.setOnClickListener(this);
        n9.setOnClickListener(this);
        n10.setOnClickListener(this);
        n11.setOnClickListener(this);
        n12.setOnClickListener(this);
        n13.setOnClickListener(this);
        n14.setOnClickListener(this);
        n15.setOnClickListener(this);
        n16.setOnClickListener(this);
        n17.setOnClickListener(this);
        n18.setOnClickListener(this);
        n19.setOnClickListener(this);
        n20.setOnClickListener(this);
        back.setOnClickListener(this);
        next.setOnClickListener(this);

    }

    private void initialize() {

        s1 = findViewById(R.id.s1);
        s2 = findViewById(R.id.s2);
        s3 = findViewById(R.id.s3);
        s4 = findViewById(R.id.s4);
        s5 = findViewById(R.id.s5);
        s6 = findViewById(R.id.s6);
        s7 = findViewById(R.id.s7);
        s8 = findViewById(R.id.s8);
        s9 = findViewById(R.id.s9);
        s10 = findViewById(R.id.s10);
        s11 = findViewById(R.id.s11);
        s12 = findViewById(R.id.s12);
        s13 = findViewById(R.id.s13);
        s14 = findViewById(R.id.s14);
        s15 = findViewById(R.id.s15);
        s16 = findViewById(R.id.s16);
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
        n13 = findViewById(R.id.n13);
        n14 = findViewById(R.id.n14);
        n15 = findViewById(R.id.n15);
        n16 = findViewById(R.id.n16);
        n17 = findViewById(R.id.n17);
        n18 = findViewById(R.id.n18);
        n19 = findViewById(R.id.n19);
        n20 = findViewById(R.id.n20);

        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(SeniorNumeracyActivity2.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(SeniorNumeracyActivity2.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(SeniorNumeracyActivity2.this, SeniorNumeracyActivity3.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(SeniorNumeracyActivity2.this, SeniorNumeracyActivity1.class));
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
        book_name_header.setText("Tap the given below numbers on the grid");

    }

    private void redirectPage() {
        Intent intent = new Intent(SeniorNumeracyActivity2.this, RedirectPages.class);
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
                        stopService(new Intent(SeniorNumeracyActivity2.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorNumeracyActivity2.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorNumeracyActivity2.this, MusicService.class));
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
        } else if (v.getId() == R.id.s1) {
            if (i == 0) {
                i += 1;
                s1.setBackground(getResources().getDrawable(R.drawable.plain_border_fill));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.s2) {
            if (i == 1) {
                i += 1;
                s2.setBackground(getResources().getDrawable(R.drawable.plain_border_fill));
                if (i == 2 && j == 2 && k == 2 && l == 2 && m == 2 && n == 2 && o == 2 && p == 2) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.s3) {
            if (j == 0) {
                j += 1;
                s3.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_1));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.s4) {
            if (j == 1) {
                j += 1;
                s4.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_1));
                if (i == 2 && j == 2 && k == 2 && l == 2 && m == 2 && n == 2 && o == 2 && p == 2) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.s5) {
            if (k == 0) {
                k += 1;
                s5.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_2));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.s6) {
            if (k == 1) {
                k += 1;
                s6.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_2));
                if (i == 2 && j == 2 && k == 2 && l == 2 && m == 2 && n == 2 && o == 2 && p == 2) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.s7) {
            if (l == 0) {
                l += 1;
                s7.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_3));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.s8) {
            if (l == 1) {
                l += 1;
                s8.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_3));
                if (i == 2 && j == 2 && k == 2 && l == 2 && m == 2 && n == 2 && o == 2 && p == 2) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.s9) {
            if (m == 0) {
                m += 1;
                s9.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_4));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.s10) {
            if (m == 1) {
                m += 1;
                s10.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_4));
                if (i == 2 && j == 2 && k == 2 && l == 2 && m == 2 && n == 2 && o == 2 && p == 2) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.s11) {
            if (n == 0) {
                n += 1;
                s11.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_5));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.s12) {
            if (n == 1) {
                n += 1;
                s12.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_5));
                if (i == 2 && j == 2 && k == 2 && l == 2 && m == 2 && n == 2 && o == 2 && p == 2) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.s13) {
            if (o == 0) {
                o += 1;
                s13.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_6));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.s14) {
            if (o == 1) {
                o += 1;
                s14.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_6));
                if (i == 2 && j == 2 && k == 2 && l == 2 && m == 2 && n == 2 && o == 2 && p == 2) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.s15) {
            if (p == 0) {
                p += 1;
                s15.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_7));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.s16) {
            if (p == 1) {
                p += 1;
                s16.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_7));
                if (i == 2 && j == 2 && k == 2 && l == 2 && m == 2 && n == 2 && o == 2 && p == 2) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else {
            alertMessage(2, "Oops...", "Choose the right answer.");
        }

    }
}
