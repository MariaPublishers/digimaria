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

public class SeniorSlideActivityVowels extends BaseActivity {
    LinearLayout aa_layout, ee_layout, ii_layout, oo_layout, uu_layout;
    ImageView a1, a2, a3;
    ImageView e1, e2, e3;
    ImageView i1, i2, i3;
    ImageView o1, o2, o3;
    ImageView u1, u2, u3;


    String slide_can = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_can.png";
    String slide_van = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_van.png";
    String slide_man = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_man.png";
    String slide_net = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_net.png";
    String slide_pet = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_pet.png";
    String vvvvvet = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/vvvvvet.png";
    String slide_tin = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_tin.png";
    String slide_bin = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_bin.png";
    String slide_win = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_win.png";
    String slide_cot = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_cot.png";
    String slide_pot = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_pot.png";
    String v_dot = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/v_dot.png";
    String slide_bun = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_bun.png";
    String slide_sun = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_sun.png";
    String slide_gun = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_gun.png";


    private void lLoadImage() {

        Glide.with(this)
                .load(slide_can)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(a1);
        Glide.with(this)
                .load(slide_van)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(a2);
        Glide.with(this)
                .load(slide_man)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(a3);

        Glide.with(this)
                .load(slide_net)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(e1);
        Glide.with(this)
                .load(slide_pet)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(e2);
        Glide.with(this)
                .load(vvvvvet)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(e3);

        Glide.with(this)
                .load(slide_tin)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(i1);
        Glide.with(this)
                .load(slide_bin)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(i2);
        Glide.with(this)
                .load(slide_win)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(i3);

        Glide.with(this)
                .load(slide_cot)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(o1);
        Glide.with(this)
                .load(slide_pot)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(o2);
        Glide.with(this)
                .load(v_dot)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(o3);

        Glide.with(this)
                .load(slide_bun)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(u1);
        Glide.with(this)
                .load(slide_sun)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(u2);
        Glide.with(this)
                .load(slide_gun)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(u3);



    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seniorslide_vowels);
        currentContext = SeniorSlideActivityVowels.this;
        TextView off = findViewById(R.id.off);
        volval = pref.getVolumeval();
        volumenote = findViewById(R.id.volumenote);
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);

        i1 = findViewById(R.id.i1);
        i2 = findViewById(R.id.i2);
        i3 = findViewById(R.id.i3);

        o1 = findViewById(R.id.o1);
        o2 = findViewById(R.id.o2);
        o3 = findViewById(R.id.o3);

        u1 = findViewById(R.id.u1);
        u2 = findViewById(R.id.u2);
        u3 = findViewById(R.id.u3);

        ImageView toback = findViewById(R.id.toback);

        toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pref pref = new Pref(getApplicationContext());
                Intent intent = new Intent(SeniorSlideActivityVowels.this, SlideShowMain.class);
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
                        stopService(new Intent(SeniorSlideActivityVowels.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorSlideActivityVowels.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorSlideActivityVowels.this, MusicService.class));
                }

            }
        });
        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Slideshow - Vowels");

        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }
        aa_layout = findViewById(R.id.aa_layout);
        ee_layout = findViewById(R.id.ee_layout);
        ii_layout = findViewById(R.id.ii_layout);
        oo_layout = findViewById(R.id.oo_layout);
        uu_layout = findViewById(R.id.uu_layout);

        aa_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Aa", "CAN", "VAN", "MAN",
                        slide_can, slide_van, slide_man, "https://digimaria.com/ERP/public/mobileasset/raw/raw/va.m4a");
            }
        });

        ee_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Ee", "NET", "PET", "VET", slide_net, slide_pet, vvvvvet, "https://digimaria.com/ERP/public/mobileasset/raw/raw/ve.m4a");
            }
        });
///////////////////////////////////////////5

        ii_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Ii", "TIN", "BIN", "WIN",
                        slide_tin, slide_bin, slide_win, "https://digimaria.com/ERP/public/mobileasset/raw/raw/vi.m4a");
            }
        });


        oo_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Oo", "COT", "POT", "DOT",
                        slide_cot, slide_pot,
                        v_dot, "https://digimaria.com/ERP/public/mobileasset/raw/raw/vo.m4a");
            }
        });

        //////////////////////////////////////////////////////////


        uu_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Uu", "BUN", "SUN", "GUN",
                        slide_bun, slide_sun,
                        slide_gun, "https://digimaria.com/ERP/public/mobileasset/raw/raw/vu.m4a");
            }
        });
        lLoadImage();

    }

    private void buildDialog11(int animationSource, String texttext, String ttext1, String ttext2,
                               String ttext3, String drawable, String drawable2, String drawable3, String bgm) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.slide_content_main_vowels, null);
        final TextView text = alertLayout.findViewById(R.id.text);
        final TextView text1 = alertLayout.findViewById(R.id.text1);
        final TextView text2 = alertLayout.findViewById(R.id.text2);
        final TextView text3 = alertLayout.findViewById(R.id.text3);
        final ImageView imageView1 = alertLayout.findViewById(R.id.imageView1);
        final ImageView imageView2 = alertLayout.findViewById(R.id.imageView2);
        final ImageView imageView3 = alertLayout.findViewById(R.id.imageView3);
        final Button closee = alertLayout.findViewById(R.id.closee);

        text.setText("" + texttext);
        text1.setText("" + ttext1);
        text2.setText("" + ttext2);
        text3.setText("" + ttext3);

        Glide.with(this)
                .load(drawable)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(imageView1);
        Glide.with(this)
                .load(drawable2)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(imageView2);
        Glide.with(this)
                .load(drawable3)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(imageView3);
//        imageView1.setImageDrawable(drawable);
//        imageView2.setImageDrawable(drawable2);
//        imageView3.setImageDrawable(drawable3);
      //  final MediaPlayer mp = MediaPlayer.create(this, bgm);
     //   mp.start();

        final MediaPlayer mp = new MediaPlayer();
        try {
            mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mp.setDataSource(bgm);
            // mPlayer.setDataSource(audioUrl);
            mp.prepare();
            mp.start();
        } catch (Exception e) {
            // handle exception
        }

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setView(alertLayout);
        alert.setCancelable(false);
        AlertDialog dialog = alert.create();
        dialog.getWindow().getAttributes().windowAnimations = animationSource;
        dialog.show();
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
    }
}

