package com.mariapublishers.digimariaandroid.activity.seniorslide;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.seniorflashcard.SeniorFlashCard14;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import static android.media.MediaPlayer.create;

public class SeniorSlideActivityBodyBody extends BaseActivity {
    LinearLayout aa_layout, bb_layout, cc_layout, dd_layout, ee_layout,
            ff_layout, gg_layout, hh_layout, ii_layout, jj_layout;
    ImageView bodyimage, eyeimage, handimage, kneeimage, earimage,
            legimage, lipimage, nailimage, noseimage, tongueimage;
    String slide_body = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_body.png";
    String slide_eye = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_eye.png";
    String slide_hand = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_hand.png";
    String slide_knee = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_knee.png";
    String slide_ear = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_ear.png";
    String slide_leg = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_leg.png";
    String slide_lip = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_lip.png";
    String slide_nail = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_nail.png";
    String slide_nose = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_nose.png";
    String slide_tougue = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_tougue.png";

    private void lLoadImage() {

        Glide.with(this)
                .load(slide_leg)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(legimage);
        Glide.with(this)
                .load(slide_lip)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(lipimage);
        Glide.with(this)
                .load(slide_nail)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(nailimage);
        Glide.with(this)
                .load(slide_nose)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(noseimage);
        Glide.with(this)
                .load(slide_tougue)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(tongueimage);


        Glide.with(this)
                .load(slide_body)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(bodyimage);
        Glide.with(this)
                .load(slide_eye)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(eyeimage);
        Glide.with(this)
                .load(slide_hand)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(handimage);
        Glide.with(this)
                .load(slide_knee)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(kneeimage);
        Glide.with(this)
                .load(slide_ear)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(earimage);


    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seniorslide_body);
        currentContext = SeniorSlideActivityBodyBody.this;
        TextView off = findViewById(R.id.off);
        volval = pref.getVolumeval();
        volumenote = findViewById(R.id.volumenote);
        bodyimage = findViewById(R.id.bodyimage);
        eyeimage = findViewById(R.id.eyeimage);
        handimage = findViewById(R.id.handimage);
        kneeimage = findViewById(R.id.kneeimage);
        earimage = findViewById(R.id.earimage);
        legimage = findViewById(R.id.legimage);
        lipimage = findViewById(R.id.lipimage);
        nailimage = findViewById(R.id.nailimage);
        noseimage = findViewById(R.id.noseimage);
        tongueimage = findViewById(R.id.tongueimage);


        ImageView toback = findViewById(R.id.toback);

        toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pref pref = new Pref(getApplicationContext());
                Intent intent = new Intent(SeniorSlideActivityBodyBody.this, SlideShowMain.class);
                intent.putExtra("bookid", pref.getBookId());
                startActivity(intent);
            }
        });
        volumenote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (volval != null) {
                    if (volval.equals("1")) {
                        pref.setVolumeval("0");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeoff);
                        stopService(new Intent(SeniorSlideActivityBodyBody.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorSlideActivityBodyBody.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorSlideActivityBodyBody.this, MusicService.class));
                }

            }
        });
        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Parts of the Body");

        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }
        aa_layout = findViewById(R.id.aa_layout);
        bb_layout = findViewById(R.id.bb_layout);
        cc_layout = findViewById(R.id.cc_layout);
        dd_layout = findViewById(R.id.dd_layout);
        ee_layout = findViewById(R.id.ee_layout);

        ff_layout = findViewById(R.id.ff_layout);
        gg_layout = findViewById(R.id.gg_layout);
        hh_layout = findViewById(R.id.hh_layout);
        ii_layout = findViewById(R.id.ii_layout);
        jj_layout = findViewById(R.id.jj_layout);


        aa_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Aa", "BODY", slide_body, "https://digimaria.com/ERP/public/mobileasset/raw/raw/mybody.m4a");
            }
        });
        bb_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Bb", "EYE", slide_eye, "https://digimaria.com/ERP/public/mobileasset/raw/raw/eye.m4a");
            }
        });
        cc_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Cc", "HAND", slide_hand, "https://digimaria.com/ERP/public/mobileasset/raw/raw/hand.m4a");
            }
        });
        dd_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Dd", "Knee", slide_knee, "https://digimaria.com/ERP/public/mobileasset/raw/raw/knee.m4a");
            }
        });
        ee_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buildDialog11(R.style.DialogAnimation, "Ee", "ear", slide_ear, "https://digimaria.com/ERP/public/mobileasset/raw/raw/ear.m4a");
            }
        });
///////////////////////////////////////////5
        ff_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Ff", "LEG", slide_leg, "https://digimaria.com/ERP/public/mobileasset/raw/raw/leg.m4a");
            }
        });
        gg_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Gg", "lip", slide_lip, "https://digimaria.com/ERP/public/mobileasset/raw/raw/lip.m4a");
            }
        });
        hh_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Hh", "nail", slide_nail, "https://digimaria.com/ERP/public/mobileasset/raw/raw/nail.m4a");
            }
        });
        ii_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Ii", "NOSE", slide_nose, "https://digimaria.com/ERP/public/mobileasset/raw/raw/nose.m4a");
            }
        });
        jj_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Jj", "Tongue", slide_tougue, "https://digimaria.com/ERP/public/mobileasset/raw/raw/tongue.m4a");
            }
        });

/////////////////////////////////////////////////////////////////////
        lLoadImage();

    }

    private void buildDialog11(int animationSource, String texttext, String subtextsubtext, String drawable, String daudio) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.slide_content_main, null);
        final TextView text = alertLayout.findViewById(R.id.text);
        final TextView subtext = alertLayout.findViewById(R.id.subtext);
        final ImageView imageView = alertLayout.findViewById(R.id.image_book);
        final Button closee = alertLayout.findViewById(R.id.closee);
        text.setVisibility(View.GONE);
        // text.setText("" + texttext);
        subtext.setText("" + subtextsubtext);
        Glide.with(this)
                .load(drawable)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(imageView);

        //imageView.setImageDrawable(drawable);
        final MediaPlayer mp = new MediaPlayer();
        try {
            mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mp.setDataSource(daudio);
            // mPlayer.setDataSource(audioUrl);
            mp.prepare();
            mp.start();
        } catch (Exception e) {
            // handle exception
        }
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        // alert.setTitle("Login");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
       /* alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setPositiveButton("Done", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                //  String user = etUsername.getText().toString();
                //  String pass = etPassword.getText().toString();
                //  Toast.makeText(getBaseContext(), "Username: " + user + " Password: " + pass, Toast.LENGTH_SHORT).show();
            }
        }); */
        AlertDialog dialog = alert.create();
        closee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp != null) {
                    if (mp != null) {
                        mp.stop();
                    }
                }
                dialog.dismiss();
            }
        });

        dialog.getWindow().getAttributes().windowAnimations = animationSource;
        dialog.show();
    }
}
