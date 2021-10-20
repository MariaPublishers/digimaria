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

public class JuniorLiteracyActivity6 extends BaseActivity implements OnClickListener {

    TextView  s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24, s25,
    n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11;
    CardView next, back;
    int i = 0, j = 0, k = 0, l = 0, m = 0, n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junior_literacy6);

        currentContext = JuniorLiteracyActivity6.this;

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
        s17.setOnClickListener(this);
        s18.setOnClickListener(this);
        s19.setOnClickListener(this);
        s20.setOnClickListener(this);
        s21.setOnClickListener(this);
        s22 .setOnClickListener(this);
        s23 .setOnClickListener(this);
        s24 .setOnClickListener(this);
        s25 .setOnClickListener(this);
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
        back.setOnClickListener(this);
        next.setOnClickListener(this);

    }

    private void initialize() {

        s1 = findViewById(R.id.s1_val);
        s2 = findViewById(R.id.s2_val);
        s3 = findViewById(R.id.s3_val);
        s4 = findViewById(R.id.s4_val);
        s5 = findViewById(R.id.s5_val);
        s6 = findViewById(R.id.s6_val);
        s7 = findViewById(R.id.s7_val);
        s8 = findViewById(R.id.s8_val);
        s9 = findViewById(R.id.s9_val);
        s10 = findViewById(R.id.s10_val);
        s11 = findViewById(R.id.s11_val);
        s12 = findViewById(R.id.s12_val);
        s13 = findViewById(R.id.s13_val);
        s14 = findViewById(R.id.s14_val);
        s15 = findViewById(R.id.s15_val);
        s16 = findViewById(R.id.s16_val);
        s17 = findViewById(R.id.s17_val);
        s18 = findViewById(R.id.s18_val);
        s19 = findViewById(R.id.s19_val);
        s20 = findViewById(R.id.s20_val);
        s21 = findViewById(R.id.s21_val);
        s22  = findViewById(R.id.s22_val);
        s23  = findViewById(R.id.s23_val);
        s24  = findViewById(R.id.s24_val);
        s25  = findViewById(R.id.s25_val);
        n1 = findViewById(R.id.n1_val);
        n2 = findViewById(R.id.n2_val);
        n3 = findViewById(R.id.n3_val);
        n4 = findViewById(R.id.n4_val);
        n5 = findViewById(R.id.n5_val);
        n6 = findViewById(R.id.n6_val);
        n7 = findViewById(R.id.n7_val);
        n8 = findViewById(R.id.n8_val);
        n9 = findViewById(R.id.n9_val);
        n10 = findViewById(R.id.n10_val);
        n11 = findViewById(R.id.n11_val);
        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(JuniorLiteracyActivity6.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(JuniorLiteracyActivity6.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(JuniorLiteracyActivity6.this, JuniorLiteracyActivity7.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(JuniorLiteracyActivity6.this, JuniorLiteracyActivity5.class));
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
        book_name_header.setText("Find and colour the following words in the grid below");

    }

    private void redirectPage() {
        Intent intent = new Intent(JuniorLiteracyActivity6.this, RedirectPages.class);
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
                        stopService(new Intent(JuniorLiteracyActivity6.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(JuniorLiteracyActivity6.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(JuniorLiteracyActivity6.this, MusicService.class));
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

        if (v.getId() == R.id.s1_val) {
            if (i == 0) {
                i += 1;
                s1.setBackground(getResources().getDrawable(R.drawable.plain_border_fill));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s2_val) {
            if (i == 1) {
                i += 1;
                s2.setBackground(getResources().getDrawable(R.drawable.plain_border_fill));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s3_val) {
            if (i == 2) {
                i += 1;
                s3.setBackground(getResources().getDrawable(R.drawable.plain_border_fill));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s4_val) {
            if (i == 3) {
                i += 1;
                s4.setBackground(getResources().getDrawable(R.drawable.plain_border_fill));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s5_val) {
            if (i == 4) {
                i += 1;
                s5.setBackground(getResources().getDrawable(R.drawable.plain_border_fill));
                if (i == 5 && j == 4 && k == 4 && l == 5 && n == 3 && m == 4) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s6_val) {
            if (j == 0) {
                j += 1;
                s6.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_4));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s7_val) {
            if (j == 1) {
                j += 1;
                s7.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_4));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s8_val) {
            if (j == 2) {
                j += 1;
                s8.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_4));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s9_val) {
            if (j == 3) {
                j += 1;
                s9.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_4));
                if (i == 5 && j == 4 && k == 4 && l == 5 && n == 3 && m == 4) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(1, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s10_val) {
            if (k == 0) {
                k += 1;
                s10.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_1));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s11_val) {
            if (k == 1) {
                k += 1;
                s11.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_1));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s12_val) {
            if (k == 2) {
                k += 1;
                s12.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_1));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s13_val) {
            if (k == 3) {
                k += 1;
                s13.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_1));
                if (i == 5 && j == 4 && k == 4 && l == 5 && n == 3 && m == 4) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s14_val) {
            if (l == 0) {
                l += 1;
                s14.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_2));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s15_val) {
            if (l == 1) {
                l += 1;
                s15.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_2));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s16_val) {
            if (l == 2) {
                l += 1;
                s16.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_2));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s17_val) {
            if (l == 3) {
                l += 1;
                s17.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_2));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s18_val) {
            if (l == 4) {
                l += 1;
                s18.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_2));
                if (i == 5 && j == 4 && k == 4 && l == 5 && n == 3 && m == 4) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s19_val) {
            if (n == 0) {
                n += 1;
                s19.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_3));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s20_val) {
            if (n == 1) {
                n += 1;
                s20.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_3));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s21_val) {
            if (n == 2) {
                n += 1;
                s21.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_3));
                if (i == 5 && j == 4 && k == 4 && l == 4 && m == 4) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s22_val) {
            if (m == 0) {
                m += 1;
                s22.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_5));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s23_val) {
            if (m == 1) {
                m += 1;
                s23.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_5));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s24_val) {
            if (m == 2) {
                m += 1;
                s24.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_5));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.s25_val) {
            if (m == 3) {
                m += 1;
                s25.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_5));
                if (i == 5 && j == 4 && k == 4 && l == 5 && n == 3 && m == 4) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer");
            }
        } else if (v.getId() == R.id.n1_val) {
            alertMessage(2, "Oops...", "Choose the right answer");
        } else if (v.getId() == R.id.n2_val) {
            alertMessage(2, "Oops...", "Choose the right answer");
        } else if (v.getId() == R.id.n3_val) {
            alertMessage(2, "Oops...", "Choose the right answer");
        } else if (v.getId() == R.id.n4_val) {
            alertMessage(2, "Oops...", "Choose the right answer");
        } else if (v.getId() == R.id.n5_val) {
            alertMessage(2, "Oops...", "Choose the right answer");
        } else if (v.getId() == R.id.n6_val) {
            alertMessage(2, "Oops...", "Choose the right answer");
        } else if (v.getId() == R.id.n7_val) {
            alertMessage(2, "Oops...", "Choose the right answer");
        } else if (v.getId() == R.id.n8_val) {
            alertMessage(2, "Oops...", "Choose the right answer");
        } else if (v.getId() == R.id.n9_val) {
            alertMessage(2, "Oops...", "Choose the right answer");
        } else if (v.getId() == R.id.n10_val) {
            alertMessage(2, "Oops...", "Choose the right answer");
        } else if (v.getId() == R.id.n11_val) {
            alertMessage(2, "Oops...", "Choose the right answer");
        } else if (v.getId() == R.id.next) {
            onclickNext();
        } else if (v.getId() == R.id.back) {
            onclickBack();
        }

    }

}
