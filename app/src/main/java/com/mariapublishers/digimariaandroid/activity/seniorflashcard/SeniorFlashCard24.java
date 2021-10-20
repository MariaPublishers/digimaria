package com.mariapublishers.digimariaandroid.activity.seniorflashcard;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.mainprocess.BookLanding;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

import static android.media.MediaPlayer.create;

public class SeniorFlashCard24 extends BaseActivity {

    private static final String TAG = "FilpBook.java";

    Intent getUrl;

    TextView bookname_flip, off;
    private AnimatorSet mSetRightOut;
    private AnimatorSet mSetLeftIn;
    private boolean mIsBackVisible = false;
    private View mCardFrontLayout;
    private View mCardBackLayout;
MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.senior_flash1);

        Toast.makeText(this, "Tap on the Card", Toast.LENGTH_LONG).show();

        currentContext = SeniorFlashCard24.this;

        off = findViewById(R.id.off);
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
                        stopService(new Intent(SeniorFlashCard24.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorFlashCard24.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorFlashCard24.this, MusicService.class));
                }

            }
        });
        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }

        loadAnimations();
        //  changeCameraDistance();
        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText(R.string.flash_cards);
        bookname_flip = findViewById(R.id.bookname_flip);
        getUrl = getIntent();


        ImageView toback = findViewById(R.id.toback);

        toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pref pref = new Pref(getApplicationContext());
                Intent intent = new Intent(SeniorFlashCard24.this, BookLanding.class);
                intent.putExtra("bookid", pref.getBookId());
                startActivity(intent);
            }
        });
        mCardBackLayout = findViewById(R.id.card_back);
        mCardFrontLayout = findViewById(R.id.card_front);
        CardView alpaflash = findViewById(R.id.alpaflash);
        CardView imageflash = findViewById(R.id.imageflash);
        CardView back = findViewById(R.id.back);
        CardView next = findViewById(R.id.next);
        TextView text = findViewById(R.id.text);
        TextView text2 = findViewById(R.id.text2);
        TextView subtext = findViewById(R.id.subtext);
        ImageView image_book = findViewById(R.id.image_book);
        text.setText("Xx");
        text2.setText("Xx");
        subtext.setText("Xylophone");
        subtext.setAllCaps(true);
        //image_book.setImageDrawable(getResources().getDrawable(R.drawable.flash_xylophone));
        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/flash_xylophone.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(image_book);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 if (mp != null) {
                    mp.stop();
                }SeniorFlashCard24.this.finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if (mp != null) {
                    mp.stop();
                }
                startActivity(new Intent(SeniorFlashCard24.this, SeniorFlashCard25.class));
            }
        });
        mp = new MediaPlayer();
        alpaflash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSetRightOut.setTarget(mCardFrontLayout);
                mSetLeftIn.setTarget(mCardBackLayout);
                mSetRightOut.start();
                mSetLeftIn.start();
                mIsBackVisible = true;
                alpaflash.setVisibility(View.GONE);
                imageflash.setVisibility(View.VISIBLE);
                try {
                    mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mp.setDataSource("https://digimaria.com/ERP/public/mobileasset/raw/raw/x.m4a");
                    // mPlayer.setDataSource(audioUrl);
                    mp.prepare();
                    mp.start();
                } catch (Exception e) {
                    // handle exception
                }

            }
        });
        imageflash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alpaflash.setVisibility(View.VISIBLE);
                imageflash.setVisibility(View.GONE);
                mSetRightOut.setTarget(mCardBackLayout);
                mSetLeftIn.setTarget(mCardFrontLayout);
                mSetRightOut.start();
                mSetLeftIn.start();
                mIsBackVisible = false;
            }
        });

    }

    private void changeCameraDistance() {
        int distance = 8000;
        float scale = getResources().getDisplayMetrics().density * distance;
        mCardFrontLayout.setCameraDistance(scale);
        mCardBackLayout.setCameraDistance(scale);
    }

    public void flipCard(View view) {
        if (!mIsBackVisible) {
            mSetRightOut.setTarget(mCardFrontLayout);
            mSetLeftIn.setTarget(mCardBackLayout);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = true;
        } else {
            mSetRightOut.setTarget(mCardBackLayout);
            mSetLeftIn.setTarget(mCardFrontLayout);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = false;
        }
    }

    private void loadAnimations() {
        mSetRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.out_animation);
        mSetLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.in_animation);
    }

    public void alertError(String message) {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wrong);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(SeniorFlashCard24.this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setContentText(message)
                .show();
    }

    @Override
    public void onBackPressed() {
        Pref pref = new Pref(getApplicationContext());
        Intent intent = new Intent(SeniorFlashCard24.this, BookLanding.class);
        intent.putExtra("bookid", pref.getBookId());
        startActivity(intent);
    }

}


