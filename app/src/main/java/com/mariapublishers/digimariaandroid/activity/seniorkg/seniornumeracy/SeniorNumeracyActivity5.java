package com.mariapublishers.digimariaandroid.activity.seniorkg.seniornumeracy;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.juniorkg.juniorliteracy.JuniorLiteracyActivity10;
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.activity.nursery.nurserynumeracy.NurseryNumeracyActivity2;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class SeniorNumeracyActivity5 extends BaseActivity implements View.OnClickListener {

    LinearLayout cr1, cr2, cr3, cr4, cr5, wr1, wr2, wr3, wr4, wr5, wr6, wr7, wr8, wr9, wr10;
    CardView back, next;
    int i = 0, one = 0, two = 0, three = 0, four = 0, five = 0;
    ImageView positionun5, beerun5, turtleun5, horseun5, lionun5, elephantun5;
    SweetAlertDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_numeracy5);

        currentContext = SeniorNumeracyActivity5.this;

        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {

        cr1.setOnClickListener(this);
        cr2.setOnClickListener(this);
        cr3.setOnClickListener(this);
        cr4.setOnClickListener(this);
        cr5.setOnClickListener(this);
        wr1.setOnClickListener(this);
        wr2.setOnClickListener(this);
        wr3.setOnClickListener(this);
        wr4.setOnClickListener(this);
        wr5.setOnClickListener(this);
        wr6.setOnClickListener(this);
        wr7.setOnClickListener(this);
        wr8.setOnClickListener(this);
        wr9.setOnClickListener(this);
        wr10.setOnClickListener(this);
        next.setOnClickListener(this);
        back.setOnClickListener(this);

    }

    private void initialize() {

        cr1 = findViewById(R.id.cr1);
        cr2 = findViewById(R.id.cr2);
        cr3 = findViewById(R.id.cr3);
        cr4 = findViewById(R.id.cr4);
        cr5 = findViewById(R.id.cr5);
        wr1 = findViewById(R.id.wr1);
        wr2 = findViewById(R.id.wr2);
        wr3 = findViewById(R.id.wr3);
        wr4 = findViewById(R.id.wr4);
        wr5 = findViewById(R.id.wr5);
        wr6 = findViewById(R.id.wr6);
        wr7 = findViewById(R.id.wr7);
        wr8 = findViewById(R.id.wr8);
        wr9 = findViewById(R.id.wr9);
        wr10 = findViewById(R.id.wr10);
        next = findViewById(R.id.next);
        back = findViewById(R.id.back);

        positionun5 = findViewById(R.id.positionun5);
        beerun5 = findViewById(R.id.beerun5);
        turtleun5 = findViewById(R.id.turtleun5);
        horseun5 = findViewById(R.id.horseun5);
        lionun5 = findViewById(R.id.lionun5);
        elephantun5 = findViewById(R.id.elephantun5);

        pDialog = new SweetAlertDialog(SeniorNumeracyActivity5.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading ...");
        pDialog.setCancelable(false);
        pDialog.show();

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/positionun5.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(positionun5);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/beerun5.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(beerun5);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/turtleun5.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(turtleun5);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/horseun5.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(horseun5);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/lionun5.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(lionun5);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/elephantun5.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(elephantun5);

        pDialog.cancel();


    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(SeniorNumeracyActivity5.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(SeniorNumeracyActivity5.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(SeniorNumeracyActivity5.this, SeniorNumeracyActivity6.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(SeniorNumeracyActivity5.this, SeniorNumeracyActivity4.class));
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
        book_name_header.setText("Choose the correct position");

    }

    private void redirectPage() {
        Intent intent = new Intent(SeniorNumeracyActivity5.this, RedirectPages.class);
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
                        stopService(new Intent(SeniorNumeracyActivity5.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorNumeracyActivity5.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorNumeracyActivity5.this, MusicService.class));
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
        } else if (v.getId() == R.id.cr1) {
            if (one == 0) {
                i += 1;
                one += 1;
                cr1.setBackgroundResource(R.drawable.blue_outer_line_color);
                if (i == 5) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.cr2) {
            if (two == 0) {
                i += 1;
                two += 1;
                cr2.setBackgroundResource(R.drawable.blue_outer_line_color);
                if (i == 5) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.cr3) {
            if (three == 0) {
                i += 1;
                three += 1;
                cr3.setBackgroundResource(R.drawable.blue_outer_line_color);
                if (i == 5) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.cr4) {
            if (four == 0) {
                i += 1;
                four += 1;
                cr4.setBackgroundResource(R.drawable.blue_outer_line_color);
                if (i == 5) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.cr5) {
            if (five == 0) {
                i += 1;
                five += 1;
                cr5.setBackgroundResource(R.drawable.blue_outer_line_color);
                if (i == 5) {
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
