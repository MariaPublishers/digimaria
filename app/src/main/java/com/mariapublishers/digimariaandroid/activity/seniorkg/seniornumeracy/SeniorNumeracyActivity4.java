package com.mariapublishers.digimariaandroid.activity.seniorkg.seniornumeracy;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.activity.nursery.nurserynumeracy.NurseryNumeracyActivity2;
import com.mariapublishers.digimariaandroid.activity.nursery.nurserynumeracy.NurseryNumeracyActivity4;
import com.mariapublishers.digimariaandroid.activity.seniorflashcard.SeniorFlashCard14;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class SeniorNumeracyActivity4 extends BaseActivity implements View.OnClickListener {

    CardView back, next;
    int i = 0, one = 0, two = 0, three = 0, four = 0, five = 0;
    ImageView one_cross, two_cross, three_cross, four_cross, five_cross,
            assertoneun4, asserttwoun4, assertthreeun4, assertfourun4, assertfiveun4, assertsixun4;
    RelativeLayout wrong1, wrong2, wrong3, wrong4, wrong5;
    SweetAlertDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_numeracy4);

        currentContext = SeniorNumeracyActivity4.this;

        callFunc();

    }private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {

        one_cross.setOnClickListener(this);
        two_cross.setOnClickListener(this);
        three_cross.setOnClickListener(this);
        four_cross.setOnClickListener(this);
        five_cross.setOnClickListener(this);

        wrong1.setOnClickListener(this);
        wrong2.setOnClickListener(this);
        wrong3.setOnClickListener(this);
        wrong4.setOnClickListener(this);
        wrong5.setOnClickListener(this);

        back.setOnClickListener(this);
        next.setOnClickListener(this);

    }

    private void initialize() {

        one_cross = findViewById(R.id.one_cross);
        two_cross = findViewById(R.id.two_cross);
        three_cross = findViewById(R.id.three_cross);
        four_cross = findViewById(R.id.four_cross);
        five_cross = findViewById(R.id.five_cross);

        wrong1 = findViewById(R.id.wrong1);
        wrong2 = findViewById(R.id.wrong2);
        wrong3 = findViewById(R.id.wrong3);
        wrong4 = findViewById(R.id.wrong4);
        wrong5 = findViewById(R.id.wrong5);

        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

        assertoneun4 = findViewById(R.id.assertoneun4);
        asserttwoun4 = findViewById(R.id.asserttwoun4);
        assertthreeun4 = findViewById(R.id.assertthreeun4);
        assertfourun4 = findViewById(R.id.assertfourun4);
        assertfiveun4 = findViewById(R.id.assertfiveun4);
        assertsixun4 = findViewById(R.id.assertsixun4);

        pDialog = new SweetAlertDialog(SeniorNumeracyActivity4.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading ...");
        pDialog.setCancelable(false);
        pDialog.show();

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/assertoneun4.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(assertoneun4);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/asserttwoun4.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(asserttwoun4);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/assertthreeun4.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(assertthreeun4);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/assertfourun4.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(assertfourun4);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/assertfiveun4.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(assertfiveun4);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/assertsixun4.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(assertsixun4);

        pDialog.cancel();

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(SeniorNumeracyActivity4.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(SeniorNumeracyActivity4.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer."
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(SeniorNumeracyActivity4.this, SeniorNumeracyActivity5.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(SeniorNumeracyActivity4.this, SeniorNumeracyActivity3.class));
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
        book_name_header.setText("Cross out the odd one in each group");

    }

    private void redirectPage() {
        Intent intent = new Intent(SeniorNumeracyActivity4.this, RedirectPages.class);
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
                        stopService(new Intent(SeniorNumeracyActivity4.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorNumeracyActivity4.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorNumeracyActivity4.this, MusicService.class));
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
        } else if (v.getId() == R.id.one_cross) {
            if (one == 0) {
                i += 1;
                one += 1;
                one_cross.setImageResource(R.drawable.close);
                if (i == 5) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.two_cross) {
            if (two == 0) {
                i += 1;
                two += 1;
                two_cross.setImageResource(R.drawable.close);
                if (i == 5) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.three_cross) {
            if (three == 0) {
                i += 1;
                three += 1;
                three_cross.setImageResource(R.drawable.close);
                if (i == 5) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.four_cross) {
            if (four == 0) {
                i += 1;
                four += 1;
                four_cross.setImageResource(R.drawable.close);
                if (i == 5) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.five_cross) {
            if (five == 0) {
                i += 1;
                five += 1;
                five_cross.setImageResource(R.drawable.close);
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
