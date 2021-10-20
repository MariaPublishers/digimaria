package com.mariapublishers.digimariaandroid.activity.seniorslide;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.mainprocess.BookLanding;
import com.mariapublishers.digimariaandroid.activity.seniorflashcard.SeniorFlasCard1;
import com.mariapublishers.digimariaandroid.activity.seniorflashcard.SeniorFlashCard14;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import static android.media.MediaPlayer.create;

public class SeniorSlideActivity extends BaseActivity {
    LinearLayout aa_layout, bb_layout, cc_layout, dd_layout, ee_layout,
            ff_layout, gg_layout, hh_layout, ii_layout, jj_layout,
            kk_layout, ll_layout, mm_layout, nn_layout, oo_layout,
            pp_layout, qq_layout, rr_layout, ss_layout, tt_layout,
            uu_layout, vv_layout, ww_layout, xx_layout, yy_layout, zz_layout;
    ImageView vimage, bimage, cimage, dimage, eimage, fimage, gimage, himage, iimage, jimage, kimage, limage, mimage, nimage, oimage, pimage, qimage, rimage, simage, timage, wimage, ximage, yimage, zimage, aimage, uimage;
    ProgressBar progress;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seniorslide);
        currentContext = SeniorSlideActivity.this;
        TextView off = findViewById(R.id.off);
        volval = pref.getVolumeval();
        progress=findViewById(R.id.progress_dialog);
        volumenote = findViewById(R.id.volumenote);
        volumenote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (volval != null) {
                    if (volval.equals("1")) {
                        pref.setVolumeval("0");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeoff);
                        stopService(new Intent(SeniorSlideActivity.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorSlideActivity.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorSlideActivity.this, MusicService.class));
                }

            }
        });
        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Slideshow - Alphabet");

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

        kk_layout = findViewById(R.id.kk_layout);
        ll_layout = findViewById(R.id.ll_layout);
        mm_layout = findViewById(R.id.mm_layout);
        nn_layout = findViewById(R.id.nn_layout);
        oo_layout = findViewById(R.id.oo_layout);

        pp_layout = findViewById(R.id.pp_layout);
        qq_layout = findViewById(R.id.qq_layout);
        rr_layout = findViewById(R.id.rr_layout);
        ss_layout = findViewById(R.id.ss_layout);
        tt_layout = findViewById(R.id.tt_layout);

        uu_layout = findViewById(R.id.uu_layout);
        vv_layout = findViewById(R.id.vv_layout);
        ww_layout = findViewById(R.id.ww_layout);
        xx_layout = findViewById(R.id.xx_layout);
        yy_layout = findViewById(R.id.yy_layout);

        zz_layout = findViewById(R.id.zz_layout);


        aimage = findViewById(R.id.aimage);
        bimage = findViewById(R.id.bimage);
        cimage = findViewById(R.id.cimage);
        dimage = findViewById(R.id.dimage);
        eimage = findViewById(R.id.eimage);

        fimage = findViewById(R.id.fimage);
        gimage = findViewById(R.id.gimage);
        himage = findViewById(R.id.himage);
        iimage = findViewById(R.id.iimage);
        jimage = findViewById(R.id.jimage);

        kimage = findViewById(R.id.kimage);
        limage = findViewById(R.id.limage);
        mimage = findViewById(R.id.mimage);
        nimage = findViewById(R.id.nimage);
        oimage = findViewById(R.id.oimage);

        pimage = findViewById(R.id.pimage);
        qimage = findViewById(R.id.qimage);
        rimage = findViewById(R.id.rimage);
        simage = findViewById(R.id.simage);
        timage = findViewById(R.id.timage);

        uimage = findViewById(R.id.uimage);
        vimage = findViewById(R.id.vimage);
        wimage = findViewById(R.id.wimage);
        ximage = findViewById(R.id.ximage);
        yimage = findViewById(R.id.yimage);
        zimage = findViewById(R.id.zimage);

        lLoadImage();

        aa_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Aa", "APPLE", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_apple.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/as.m4a");
            }
        });
        bb_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Bb", "BALL", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_ball.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/bs.m4a");
            }
        });
        cc_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Cc", "CAMEL", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_vcamel.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/cs.m4a");
            }
        });
        dd_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Dd", "deer", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_deer.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/ds.m4a");
            }
        });
        ee_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Ee", "ear", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_ear.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/es.m4a");
            }
        });
///////////////////////////////////////////5
        ff_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Ff", "fan", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_fan.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fs.m4a");
            }
        });
        gg_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Gg", "gift", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_gift.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/gs.m4a");
            }
        });
        hh_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Hh", "hen", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_hen.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/h_voice.m4a");
            }
        });
        ii_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Ii", "ice", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_ice.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/is.m4a");
            }
        });
        jj_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Jj", "jeep", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_jeep.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/j_voice.m4a");
            }
        });

/////////////////////////////////////////////////////////////////////
        kk_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Kk", "kennel", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_kennel.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/k_voice.m4a");
            }
        });
        ll_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Ll", "lamp", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_lamp.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/ls.m4a");
            }
        });
        mm_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Mm", "mango", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_mango.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/ms.m4a");
            }
        });
        nn_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Nn", "net", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_net.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/ns.m4a");
            }
        });
        oo_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Oo", "onion", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_onion.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/os.m4a");
            }
        });

        //////////////////////////////////////////////////////////
        pp_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Pp", "pad", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_pad.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/ps.m4a");
            }
        });
        qq_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Qq", "quail", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_quail.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/qs.m4a");
            }
        });
        rr_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Rr", "ram", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_ram.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/rs.m4a");
            }
        });
        ss_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Ss", "ship", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_ship.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/ss.m4a");
            }
        });
        tt_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Tt", "telephone", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_telephone.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/ts.m4a");
            }
        });

        /////////////////////////////////////////////////////////
        uu_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Uu", "unicorn", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_unicorn.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/us.m4a");
            }
        });
        vv_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Vv", "vase", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_vase.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/vs.m4a");
            }
        });

        ww_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Ww", "watermelon", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_watermelon.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/ws.m4a");
            }
        });
        xx_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Xx", "xerox", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_xerox.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/xs.m4a");
            }
        });
        yy_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Yy", "yam", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_yam.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/ys.m4a");
            }
        });
        zz_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Zz", "zebra", "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_zebra.png", "https://digimaria.com/ERP/public/mobileasset/raw/raw/zs.m4a");
            }
        });
        ImageView toback = findViewById(R.id.toback);

        toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pref pref = new Pref(getApplicationContext());
                Intent intent = new Intent(SeniorSlideActivity.this, SlideShowMain.class);
                intent.putExtra("bookid", pref.getBookId());
                startActivity(intent);
            }
        });

    }

    private void lLoadImage() {


        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_apple.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(aimage);
        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_ball.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(bimage);
        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_vcamel.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(cimage);
        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_deer.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(dimage);
        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_ear.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(eimage);


        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_fan.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(fimage);
        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_gift.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(gimage);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_hen.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(himage);
        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_ice.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(iimage);
        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_jeep.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(jimage);


        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_kennel.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(kimage);
        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_lamp.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(limage);//
        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_mango.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(mimage);
        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_net.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(nimage);
        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_onion.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(oimage);


        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_pad.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(pimage);
        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_quail.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(qimage);//
        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_ram.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(rimage);
        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_ship.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(simage);
        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_telephone.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(timage);


        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_unicorn.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(uimage);
        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_vase.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(vimage);
        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_watermelon.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(wimage);
        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_xerox.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(ximage);
        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_yam.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(yimage);
        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawable/drawable/f_zebra.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(zimage);
        progress.setVisibility(View.GONE);

    }

    private void buildDialog11(int animationSource, String texttext, String subtextsubtext, String drawable_url, String daudio) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.slide_content_main, null);
        final TextView text = alertLayout.findViewById(R.id.text);
        final TextView subtext = alertLayout.findViewById(R.id.subtext);
        final ImageView imageView = alertLayout.findViewById(R.id.image_book);
        final Button closee = alertLayout.findViewById(R.id.closee);

        text.setText("" + texttext);
        subtext.setText("" + subtextsubtext);
        Glide.with(this)
                .load(drawable_url)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(imageView);

        //  imageView.setImageDrawable(drawable);
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
