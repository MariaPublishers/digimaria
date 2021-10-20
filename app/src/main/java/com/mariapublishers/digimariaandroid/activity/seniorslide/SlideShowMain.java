package com.mariapublishers.digimariaandroid.activity.seniorslide;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.mainprocess.BookLanding;
import com.mariapublishers.digimariaandroid.activity.seniorflashcard.SeniorFlashCard14;
import com.mariapublishers.digimariaandroid.activity.seniorflashcard.SeniorFlashCard18;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

public class SlideShowMain extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seniorslide_main);
        currentContext = SlideShowMain.this;
        TextView off = findViewById(R.id.off);
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
                        stopService(new Intent(SlideShowMain.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SlideShowMain.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SlideShowMain.this, MusicService.class));
                }

            }
        });
        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Slideshow");
        //book_name_header.setText(R.string.flash_cards);



        ImageView toback = findViewById(R.id.toback);

        toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pref pref = new Pref(getApplicationContext());
                Intent intent = new Intent(SlideShowMain.this, BookLanding.class);
                intent.putExtra("bookid", pref.getBookId());
                startActivity(intent);
            }
        });

        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }

        CardView Alphabet = findViewById(R.id.Alphabet);
        CardView Numeracy = findViewById(R.id.Numeracy);
        CardView BodyBody = findViewById(R.id.BodyBody);
        CardView Vowels = findViewById(R.id.Vowels);
        CardView Shapes = findViewById(R.id.Shapes);
        Alphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SlideShowMain.this, SeniorSlideActivity.class));
            }
        });
        Numeracy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(SlideShowMain.this, "coming soon", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SlideShowMain.this, SeniorSlideActivityNumeracy.class));
            }
        });
        BodyBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SlideShowMain.this, SeniorSlideActivityBodyBody.class));
            }
        });
        Vowels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SlideShowMain.this, SeniorSlideActivityVowels.class));
            }
        });
        Shapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SlideShowMain.this, SeniorSlideActivityShapes.class));
            }
        });

    }


}
