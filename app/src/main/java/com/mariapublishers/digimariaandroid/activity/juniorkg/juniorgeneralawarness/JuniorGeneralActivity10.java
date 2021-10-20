package com.mariapublishers.digimariaandroid.activity.juniorkg.juniorgeneralawarness;

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
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.activity.mainprocess.SearchActivity;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class JuniorGeneralActivity10 extends BaseActivity implements View.OnClickListener {

    int i = 0, j = 0, k = 0;
    CardView back;
    float m1 = 0, m2 = 0, m3 = 0, m4 = 0, e1 = 0, e2 = 0, e3 = 0, e4 = 0, r1 = 0, r2 = 0, r3 = 0, r4 = 0, p1 = 0, p2 = 0, p3 = 0, p4 = 0,
            d1 = 0, d2 = 0, d3 = 0, d4 = 0;
    DrawView drawView;
    RelativeLayout rl1;
    RadioButton one, onel, two, twol, three, threel, four, fourl, five, fivel;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junior_general10);

        currentContext = JuniorGeneralActivity10.this;

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
        onel.setOnClickListener(this);
        two.setOnClickListener(this);
        twol.setOnClickListener(this);
        three.setOnClickListener(this);
        threel.setOnClickListener(this);
        four.setOnClickListener(this);
        fourl.setOnClickListener(this);
        five.setOnClickListener(this);
        back.setOnClickListener(this);
        fivel.setOnClickListener(this);

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
        book_name_header.setText("Draw a line to match the related things with the festivals");

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
                        stopService(new Intent(JuniorGeneralActivity10.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(JuniorGeneralActivity10.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(JuniorGeneralActivity10.this, MusicService.class));
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
        onel = findViewById(R.id.onel);
        two = findViewById(R.id.two);
        twol = findViewById(R.id.twol);
        three = findViewById(R.id.three);
        threel = findViewById(R.id.threel);
        four = findViewById(R.id.four);
        fourl = findViewById(R.id.fourl);
        five = findViewById(R.id.five);
        fivel = findViewById(R.id.fivel);
        back = findViewById(R.id.back);
        rl1 = findViewById(R.id.rl1);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.one) {
            if (i == 0) {
                i += 1;
                one.setChecked(true);
            } else {
                one.setChecked(false);
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.onel) {
            if (i == 4) {
                i = 0;

                onel.setChecked(true);
                drawView = new DrawView(this,four,onel);
                drawView.setBackgroundColor(Color.WHITE);
                rl1.addView(drawView);

                j += 1;
                k += 1;
                if (j == 5) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }

            } else if (i == 0){
                onel.setChecked(false);
                alertMessage(2, "Oops...","Select the question first.");
            } else {
                onel.setChecked(false);
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.two) {
            if (i == 0) {
                i = 2;
                two.setChecked(true);
            } else {
                two.setChecked(false);
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.twol) {
            if (i == 3) {
                i = 0;
                twol.setChecked(true);
                drawView = new DrawView(this,three,twol);
                drawView.setBackgroundColor(Color.WHITE);
                rl1.addView(drawView);

                j += 1;
                k += 1;
                if (j == 5) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }

            } else if (i == 0){
                twol.setChecked(false);
                alertMessage(2, "Oops...","Select the question first.");
            } else {
                twol.setChecked(false);
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.three) {
            if (i == 0) {
                i = 3;
                three.setChecked(true);
            } else {
                three.setChecked(false);
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.threel) {
            if (i == 5) {
                i = 0;
                threel.setChecked(true);
                drawView = new DrawView(this,five,threel);
                drawView.setBackgroundColor(Color.WHITE);
                rl1.addView(drawView);

                j += 1;
                k += 1;
                if (j == 5) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }

            } else if (i == 0){
                threel.setChecked(false);
                alertMessage(2, "Oops...","Select the question first.");
            } else {
                threel.setChecked(false);
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.four) {
            if (i == 0) {
                i = 4;
                four.setChecked(true);
            } else {
                four.setChecked(false);
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.fourl) {
            if (i == 1) {
                i = 0;
                fourl.setChecked(true);
                drawView = new DrawView(this,one,fourl);
                drawView.setBackgroundColor(Color.WHITE);
                rl1.addView(drawView);

                j += 1;
                k += 1;
                if (j == 5) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }

            } else if (i == 0){
                fourl.setChecked(false);
                alertMessage(2, "Oops...","Select the question first.");
            } else {
                fourl.setChecked(false);
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.five) {
            if (i == 0) {
                i = 5;
                five.setChecked(true);
            } else {
                five.setChecked(false);
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.fivel) {
            if (i == 2) {
                i = 0;
                fivel.setChecked(true);
                drawView = new DrawView(this,two,fivel);
                drawView.setBackgroundColor(Color.WHITE);
                rl1.addView(drawView);

                j += 1;
                k += 1;
                if (j == 5) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }

            } else if (i == 0){
                fivel.setChecked(false);
                alertMessage(2, "Oops...","Select the question first.");
            } else {
                fivel.setChecked(false);
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.back) {
            onclickBack();
        }
        else {
            alertMessage(2, "Oops...", "Choose the right answer.");
        }
    }

    public void onclickBack() {
        startActivity(new Intent(JuniorGeneralActivity10.this, JuniorGeneralActivity9.class));
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

            new SweetAlertDialog(JuniorGeneralActivity10.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText(title) // "Hurray!"
                    .setContentText(message) // "Activity Cleared."
                    .setConfirmText("OK")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            redirectPage();
                        }
                    })
                    .show();
        } else {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wrong);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(JuniorGeneralActivity10.this, SweetAlertDialog.ERROR_TYPE)
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
                m1 = startView.getX() + 40;
                m2 = startView.getY() + 50;
                m3 = endView.getX() + 40;
                m4 = endView.getY() + 50;
                canvas.drawLine(m1, m2, m3, m4, paint);
            }

            if (k == 2) {
                e1 = startView.getX() + 40;
                e2 = startView.getY() + 50;
                e3 = endView.getX() + 40;
                e4 = endView.getY() + 50;
                canvas.drawLine(m1, m2, m3, m4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
            }

            if (k == 3) {
                r1 = startView.getX() + 40;
                r2 = startView.getY() + 50;
                r3 = endView.getX() + 40;
                r4 = endView.getY() + 50;
                canvas.drawLine(m1, m2, m3, m4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
                canvas.drawLine(r1, r2, r3, r4, paint);
            }

            if (k == 4) {
                p1 = startView.getX() + 40;
                p2 = startView.getY() + 50;
                p3 = endView.getX() + 40;
                p4 = endView.getY() + 50;
                canvas.drawLine(m1, m2, m3, m4, paint);
                canvas.drawLine(p1, p2, p3, p4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
                canvas.drawLine(r1, r2, r3, r4, paint);
            }

            if (k == 5) {
                d1 = startView.getX() + 40;
                d2 = startView.getY() + 50;
                d3 = endView.getX() + 40;
                d4 = endView.getY() + 50;
                canvas.drawLine(m1, m2, m3, m4, paint);
                canvas.drawLine(d1, d2, d3, d4, paint);
                canvas.drawLine(p1, p2, p3, p4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
                canvas.drawLine(r1, r2, r3, r4, paint);
            }
        }
    }

    private void redirectPage() {
        Intent intent = new Intent(JuniorGeneralActivity10.this, RedirectPages.class);
        intent.putExtra("type", "activity");
        startActivity(intent);
        finish();
    }
}
