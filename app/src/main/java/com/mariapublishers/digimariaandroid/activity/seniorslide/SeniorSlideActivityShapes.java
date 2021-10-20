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
import com.mariapublishers.digimariaandroid.activity.mainprocess.SearchActivity;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import static android.media.MediaPlayer.create;

public class SeniorSlideActivityShapes extends BaseActivity {
    LinearLayout aa_layout, bb_layout, cc_layout, dd_layout;
    ImageView circleimage, rectimaage, squareimage, triimage;
    String safetyfloat = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/safetyfloat.png";
    String slide_rectangle = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_rectangle.jpg";
    String slide_square = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_square.png";
    String slide_triangle = "https://digimaria.com/ERP/public/mobileasset/drawable/drawable/slide_triangle.jpg";

    private void lLoadImage() {

        Glide.with(this)
                .load(safetyfloat)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(circleimage);
        Glide.with(this)
                .load(slide_rectangle)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(rectimaage);
        Glide.with(this)
                .load(slide_square)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(squareimage);
        Glide.with(this)
                .load(slide_triangle)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(triimage);


    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seniorslide_shapes);

        currentContext = SeniorSlideActivityShapes.this;

        TextView off = findViewById(R.id.off);
        volval = pref.getVolumeval();
        volumenote = findViewById(R.id.volumenote);
        circleimage = findViewById(R.id.circleimage);
        rectimaage = findViewById(R.id.rectimaage);
        squareimage = findViewById(R.id.squareimage);
        triimage = findViewById(R.id.triimage);
        ImageView toback = findViewById(R.id.toback);

        toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pref pref = new Pref(getApplicationContext());
                Intent intent = new Intent(SeniorSlideActivityShapes.this, SlideShowMain.class);
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
                        stopService(new Intent(SeniorSlideActivityShapes.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorSlideActivityShapes.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorSlideActivityShapes.this, MusicService.class));
                }

            }
        });
        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Slideshow - Shapes");

        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }
        aa_layout = findViewById(R.id.aa_layout);
        bb_layout = findViewById(R.id.bb_layout);
        cc_layout = findViewById(R.id.cc_layout);
        dd_layout = findViewById(R.id.dd_layout);

        aa_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Circle", safetyfloat, "https://digimaria.com/ERP/public/mobileasset/raw/raw/circle.m4a");
            }
        });
        bb_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Rectangle", slide_rectangle, "https://digimaria.com/ERP/public/mobileasset/raw/raw/rectangle.m4a");
            }
        });
        cc_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Square", slide_square, "https://digimaria.com/ERP/public/mobileasset/raw/raw/square.m4a");
            }
        });
        dd_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDialog11(R.style.DialogAnimation, "Triangle", slide_triangle, "https://digimaria.com/ERP/public/mobileasset/raw/raw/triangle.m4a");
            }
        });
        lLoadImage();
    }

    private void buildDialog11(int animationSource, String subtextsubtext, String drawable, String daudio) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.slide_content_shapes, null);
        final TextView subtext = alertLayout.findViewById(R.id.subtext);
        final ImageView imageView = alertLayout.findViewById(R.id.image_book);
        final Button closee = alertLayout.findViewById(R.id.closee);

        subtext.setText("" + subtextsubtext);
        Glide.with(this)
                .load(drawable)
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(imageView);
        //    imageView.setImageDrawable(drawable);
        //final MediaPlayer mp = create(SeniorSlideActivityShapes.this, daudio);
     //   mp.start();

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
