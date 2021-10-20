package com.mariapublishers.digimariaandroid.activity.seniorkg.seniornumeracy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
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

public class SeniorNumeracyWorksheet1 extends BaseActivity implements View.OnClickListener {

    int i = 0, j = 0, k = 0;
    CardView next, back;
    float m1 = 0, m2 = 0, m3 = 0, m4 = 0, e1 = 0, e2 = 0, e3 = 0, e4 = 0, r1 = 0, r2 = 0, r3 = 0, r4 = 0, p1 = 0, p2 = 0, p3 = 0, p4 = 0,
            d1 = 0, d2 = 0, d3 = 0, d4 = 0, f1 = 0, f2 = 0, f3 = 0, f4 = 0;
    DrawView drawView;
    RelativeLayout rl1;
    RadioButton one, onel1, onel2, two, twol1, twol2, three, threel1, threel2;
    int q1 = 0, q2 = 0, q3 = 0, a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0, a6 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_numeracy_worksheet1);

        currentContext = SeniorNumeracyWorksheet1.this;

        callfunc();

    }

    private void callfunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {

        one.setOnClickListener(this);
        onel1.setOnClickListener(this);
        onel2.setOnClickListener(this);
        two.setOnClickListener(this);
        twol1.setOnClickListener(this);
        twol2.setOnClickListener(this);
        three.setOnClickListener(this);
        threel1.setOnClickListener(this);
        threel2.setOnClickListener(this);
        next.setOnClickListener(this);
        back.setOnClickListener(this);

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
        book_name_header.setText("Skip counting: 2s, 5s, 10s");

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
                        stopService(new Intent(SeniorNumeracyWorksheet1.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorNumeracyWorksheet1.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorNumeracyWorksheet1.this, MusicService.class));
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

        one = findViewById(R.id.one);
        onel1 = findViewById(R.id.onel1);
        onel2 = findViewById(R.id.onel2);
        two = findViewById(R.id.two);
        twol1 = findViewById(R.id.twol1);
        twol2 = findViewById(R.id.twol2);
        three = findViewById(R.id.three);
        threel1 = findViewById(R.id.threel1);
        threel2 = findViewById(R.id.threel2);
        next = findViewById(R.id.next);
        back = findViewById(R.id.back);
        rl1 = findViewById(R.id.rl1);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back){
            onclickBack();
        } else if (v.getId() == R.id.next){
            onclickNext();
        } else if (v.getId() == R.id.one) {
            if (i == 0) {
                if (q1 == 0) {
                    q1 += 1;
                    i = 1;
                } else if (q1 == 1) {
                    q1 += 1;
                    i = 1;
                }
                one.setChecked(true);
            } else {
                if (q1 == 0) {
                    one.setChecked(false);
                } else {
                    one.setChecked(true);
                }
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.onel1) {
            if (i == 1) {
                if (a1 == 0) {
                    a1 += 1;
                    i = 0;
                    onel1.setChecked(true);
                    drawView = new DrawView(this,one,onel1);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);

                    j += 1;
                    k += 1;
                    if (j == 6) {
                        alertMessage(1, "Hurray!", "Activity Cleared.");
                    }
                }
            } else if (i == 0){
                if (a1 == 0) {
                    onel1.setChecked(false);
                } else {
                    onel1.setChecked(true);
                }
                alertMessage(2, "Oops...","Select the question first.");
            } else {
                if (a1 == 0) {
                    onel1.setChecked(false);
                } else {
                    onel1.setChecked(true);
                }
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.onel2) {
            if (i == 1) {
                if (a2 == 0) {
                    a2 += 1;
                    i = 0;
                    onel2.setChecked(true);
                    drawView = new DrawView(this,one,onel2);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    j += 1;
                    k += 1;
                    if (j == 6) {
                        alertMessage(1, "Hurray!", "Activity Cleared.");
                    }
                }
            } else if (i == 0){
                if (a2 == 0) {
                    onel2.setChecked(false);
                } else {
                    onel2.setChecked(true);
                }
                alertMessage(2, "Oops...","Select the question first.");
            } else {
                if (a2 == 0) {
                    onel2.setChecked(false);
                } else {
                    onel2.setChecked(true);
                }
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.two) {
            if (i == 0) {
                if (q2 == 0) {
                    q2 += 1;
                    i = 2;
                } else if (q2 == 1) {
                    q2 += 1;
                    i = 2;
                }
                two.setChecked(true);
            } else {
                if (q2 == 0) {
                    two.setChecked(false);
                } else {
                    two.setChecked(true);
                }
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.twol1) {
            if (i == 2) {
                if (a3 == 0) {
                    a3 += 1;
                    i = 0;
                    twol1.setChecked(true);
                    drawView = new DrawView(this,two,twol1);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    j += 1;
                    k += 1;
                    if (j == 6) {
                        alertMessage(1, "Hurray!", "Activity Cleared.");
                    }
                }
            } else if (i == 0){
                if (a3 == 0) {
                    twol1.setChecked(false);
                } else {
                    twol1.setChecked(true);
                }
                alertMessage(2, "Oops...","Select the question first.");
            } else {
                if (a3 == 0) {
                    twol1.setChecked(false);
                } else {
                    twol1.setChecked(true);
                }
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.twol2) {
            if (i == 2) {
                if (a4 == 0) {
                    a4 += 1;
                    i = 0;
                    twol2.setChecked(true);
                    drawView = new DrawView(this,two,twol2);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    j += 1;
                    k += 1;
                    if (j == 6) {
                        alertMessage(1, "Hurray!", "Activity Cleared.");
                    }
                }
            } else if (i == 0){
                if (a4 == 0) {
                    twol2.setChecked(false);
                } else {
                    twol2.setChecked(true);
                }
                alertMessage(2, "Oops...","Select the question first.");
            } else {
                if (a4 == 0) {
                    twol2.setChecked(false);
                } else {
                    twol2.setChecked(true);
                }
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.three) {
            if (i == 0) {
                if (q3 == 0) {
                    q3 += 1;
                    i = 3;
                } else if (q3 == 1) {
                    q3 += 1;
                    i = 3;
                }
                three.setChecked(true);
            } else {
                if (q3 == 0) {
                    three.setChecked(false);
                } else {
                    three.setChecked(true);
                }
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.threel1) {
            if (i == 3) {
                if (a5 == 0) {
                    a5 += 1;
                    i = 0;
                    threel1.setChecked(true);
                    drawView = new DrawView(this,three,threel1);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    j += 1;
                    k += 1;
                    if (j == 6) {
                        alertMessage(1, "Hurray!", "Activity Cleared.");
                    }
                }
            } else if (i == 0){
                if (a5 == 0) {
                    threel1.setChecked(false);
                } else {
                    threel1.setChecked(true);
                }
                alertMessage(2, "Oops...","Select the question first.");
            } else {
                if (a5 == 0) {
                    threel1.setChecked(false);
                } else {
                    threel1.setChecked(true);
                }
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.threel2) {
            if (i == 3) {
                if (a6 == 0) {
                    a6 += 1;i = 0;
                    threel2.setChecked(true);
                    drawView = new DrawView(this,three,threel2);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    j += 1;
                    k += 1;
                    if (j == 6) {
                        alertMessage(1, "Hurray!", "Activity Cleared.");
                    }
                }
            } else if (i == 0){
                if (a6 == 0) {
                    threel2.setChecked(false);
                } else {
                    threel2.setChecked(true);
                }
                alertMessage(2, "Oops...","Select the question first.");
            } else {
                if (a6 == 0) {
                    threel2.setChecked(false);
                } else {
                    threel2.setChecked(true);
                }
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else {
            alertMessage(2, "Oops...", "Choose the right answer.");
        }
    }

    public void onclickNext() {
        startActivity(new Intent(SeniorNumeracyWorksheet1.this, SeniorNumeracyWorksheet2.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(SeniorNumeracyWorksheet1.this, SeniorNumeracyActivity8.class));
        finish();
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

            new SweetAlertDialog(SeniorNumeracyWorksheet1.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText(title) // "Hurray!"
                    .setContentText(message) // "Activity Cleared."
                    .setConfirmText("OK")
                    .setConfirmClickListener(sDialog -> onclickNext())
                    .show();
        } else {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wrong);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(SeniorNumeracyWorksheet1.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer."
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
                m1 = startView.getX() + 34;
                m2 = startView.getY() + 34;
                m3 = endView.getX() + 34;
                m4 = endView.getY() + 34;
                canvas.drawLine(m1, m2, m3, m4, paint);
            }

            if (k == 2) {
                e1 = startView.getX() + 34;
                e2 = startView.getY() + 34;
                e3 = endView.getX() + 34;
                e4 = endView.getY() + 34;
                canvas.drawLine(m1, m2, m3, m4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
            }

            if (k == 3) {
                r1 = startView.getX() + 34;
                r2 = startView.getY() + 34;
                r3 = endView.getX() + 34;
                r4 = endView.getY() + 34;
                canvas.drawLine(m1, m2, m3, m4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
                canvas.drawLine(r1, r2, r3, r4, paint);
            }

            if (k == 4) {
                p1 = startView.getX() + 34;
                p2 = startView.getY() + 34;
                p3 = endView.getX() + 34;
                p4 = endView.getY() + 34;
                canvas.drawLine(m1, m2, m3, m4, paint);
                canvas.drawLine(p1, p2, p3, p4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
                canvas.drawLine(r1, r2, r3, r4, paint);
            }

            if (k == 5) {
                d1 = startView.getX() + 34;
                d2 = startView.getY() + 34;
                d3 = endView.getX() + 34;
                d4 = endView.getY() + 34;
                canvas.drawLine(m1, m2, m3, m4, paint);
                canvas.drawLine(d1, d2, d3, d4, paint);
                canvas.drawLine(p1, p2, p3, p4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
                canvas.drawLine(r1, r2, r3, r4, paint);
            }

            if (k == 6) {
                f1 = startView.getX() + 34;
                f2 = startView.getY() + 34;
                f3 = endView.getX() + 34;
                f4 = endView.getY() + 34;
                canvas.drawLine(m1, m2, m3, m4, paint);
                canvas.drawLine(d1, d2, d3, d4, paint);
                canvas.drawLine(p1, p2, p3, p4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
                canvas.drawLine(r1, r2, r3, r4, paint);
                canvas.drawLine(f1, f2, f3, f4, paint);
            }
        }
    }

    private void redirectPage() {
        Intent intent = new Intent(SeniorNumeracyWorksheet1.this, RedirectPages.class);
        intent.putExtra("type", "activity");
        startActivity(intent);
        finish();
    }
}


