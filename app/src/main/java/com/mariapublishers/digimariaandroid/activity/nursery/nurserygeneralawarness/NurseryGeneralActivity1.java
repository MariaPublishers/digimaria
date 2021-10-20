package com.mariapublishers.digimariaandroid.activity.nursery.nurserygeneralawarness;

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
import com.mariapublishers.digimariaandroid.activity.mainprocess.BookLanding;
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.activity.nursery.nurserynumeracy.NurseryNumeracyActivity2;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class NurseryGeneralActivity1 extends BaseActivity {

    CardView heathy_food;
    LinearLayout n1, n2, n3, n4, n5, n6, s1, s2, s3, s4, s5, s6;
    ImageView ni1, ni2, ni3, ni4, ni5, ni6, si1, si2, si3, si4, si5, si6;
    ImageView babycrawling, eggs, choco, nuts, samosa, chips, pizza, fish, fruits, milk, icecream, cake, vegtables, superboy;
    int i = 0;

    SweetAlertDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nursery_general1);

        currentContext = NurseryGeneralActivity1.this;

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
                        stopService(new Intent(NurseryGeneralActivity1.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(NurseryGeneralActivity1.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(NurseryGeneralActivity1.this, MusicService.class));
                }


            }
        });

        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }

        ImageView toback = findViewById(R.id.toback);

        toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NurseryGeneralActivity1.this, RedirectPages.class);
                intent.putExtra("type", "activity");
                startActivity(intent);
                finish();
            }
        });

        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Tick the healthy foods and help the baby grow stronger");

//        ImageView profile_id = findViewById(R.id.profile_id);
//        profile_id.setVisibility(View.INVISIBLE);

        heathy_food = findViewById(R.id.heathy_food);
        heathy_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NurseryGeneralActivity1.this, NurseryGeneralActivity2.class));
                finish();
            }
        });

        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);
        n5 = findViewById(R.id.n5);
        n6 = findViewById(R.id.n6);
        s1 = findViewById(R.id.s1);
        s2 = findViewById(R.id.s2);
        s3 = findViewById(R.id.s3);
        s4 = findViewById(R.id.s4);
        s5 = findViewById(R.id.s5);
        s6 = findViewById(R.id.s6);

        ni1 = findViewById(R.id.ni1);
        ni2 = findViewById(R.id.ni2);
        ni3 = findViewById(R.id.ni3);
        ni4 = findViewById(R.id.ni4);
        ni5 = findViewById(R.id.ni5);
        ni6 = findViewById(R.id.ni6);
        si1 = findViewById(R.id.si1);
        si2 = findViewById(R.id.si2);
        si3 = findViewById(R.id.si3);
        si4 = findViewById(R.id.si4);
        si5 = findViewById(R.id.si5);
        si6 = findViewById(R.id.si6);

        babycrawling = findViewById(R.id.babycrawling);
        eggs = findViewById(R.id.eggs);
        choco = findViewById(R.id.choco);
        nuts = findViewById(R.id.nuts);
        samosa = findViewById(R.id.samosa);
        chips = findViewById(R.id.chips);
        pizza = findViewById(R.id.pizza);
        fish = findViewById(R.id.fish);
        fruits = findViewById(R.id.fruits);
        milk = findViewById(R.id.milk);
        icecream = findViewById(R.id.icecream);
        cake = findViewById(R.id.cake);
        vegtables = findViewById(R.id.vegtables);
        superboy = findViewById(R.id.superboy);

        pDialog = new SweetAlertDialog(NurseryGeneralActivity1.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading ...");
        pDialog.setCancelable(false);
        pDialog.show();

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/babycrawling.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(babycrawling);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/eggs.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(eggs);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/cholate.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(choco);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/nutscopy.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(nuts);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/samosacopy.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(samosa);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/chipscopy.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(chips);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/pizzacopy.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(pizza);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/fishinplate.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(fish);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/fruitscopy.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(fruits);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/milk.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(milk);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/icecreamcopy.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(icecream);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/cakecopy.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(cake);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/vegetablescopy.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(vegtables);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/superman.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(superboy);

        pDialog.cancel();

        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                si1.setImageResource(R.drawable.right_mark_icon);
                i += 1;
                if (i == 6) {
                    toBack();
                }
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                si2.setImageResource(R.drawable.right_mark_icon);
                i += 1;
                if (i == 6) {
                    toBack();
                }
            }
        });

        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                si3.setImageResource(R.drawable.right_mark_icon);
                i += 1;
                if (i == 6) {
                    toBack();
                }
            }
        });

        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                si4.setImageResource(R.drawable.right_mark_icon);
                i += 1;
                if (i == 6) {
                    toBack();
                }
            }
        });

        s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                si5.setImageResource(R.drawable.right_mark_icon);
                i += 1;
                if (i == 6) {
                    toBack();
                }
            }
        });

        s6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                si6.setImageResource(R.drawable.right_mark_icon);
                i += 1;
                if (i == 6) {
                    toBack();
                }
            }
        });

        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ni1.setImageResource(R.drawable.wrong_mark_icon);
                alertError();
            }
        });

        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ni2.setImageResource(R.drawable.wrong_mark_icon);
                alertError();
            }
        });

        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ni3.setImageResource(R.drawable.wrong_mark_icon);
                alertError();
            }
        });

        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ni4.setImageResource(R.drawable.wrong_mark_icon);
                alertError();
            }
        });

        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ni5.setImageResource(R.drawable.wrong_mark_icon);
                alertError();
            }
        });

        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ni6.setImageResource(R.drawable.wrong_mark_icon);
                alertError();
            }
        });

    }

    public void alertError() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wrong);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(NurseryGeneralActivity1.this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setConfirmText("OK")
                .setContentText("Choose the right answer")
                .show();
    }

    public void toBack() {

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(NurseryGeneralActivity1.this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Hurray!")
                .setContentText("Activity Cleared.")
                .setConfirmText("OK")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        startActivity(new Intent(NurseryGeneralActivity1.this, NurseryGeneralActivity2.class));
                        finish();
                    }
                })
                .show();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(NurseryGeneralActivity1.this, BookLanding.class);
        intent.putExtra("bookid", pref.getClassid());
        startActivity(intent);
        finish();
    }

}
