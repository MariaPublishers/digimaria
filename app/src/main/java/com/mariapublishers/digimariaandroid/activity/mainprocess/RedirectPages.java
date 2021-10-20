package com.mariapublishers.digimariaandroid.activity.mainprocess;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.juniorkg.juniorgeneralawarness.JuniorGeneralActivity1;
import com.mariapublishers.digimariaandroid.activity.juniorkg.juniorliteracy.JuniorLiteracyActivity1;
import com.mariapublishers.digimariaandroid.activity.juniorkg.juniornumeracy.JuniorNumeracyActivity1;
import com.mariapublishers.digimariaandroid.activity.nursery.nurserygeneralawarness.NurseryGeneralActivity1;
import com.mariapublishers.digimariaandroid.activity.nursery.nurseryliteracy.FindChick;
import com.mariapublishers.digimariaandroid.activity.nursery.nurserynumeracy.NurseryNumeracyActivity1;
import com.mariapublishers.digimariaandroid.activity.seniorkg.seniorgeneralawarness.SeniorGeneralActivity1;
import com.mariapublishers.digimariaandroid.activity.seniorkg.seniorliteracy.SeniorLiteracyActivity1;
import com.mariapublishers.digimariaandroid.activity.seniorkg.seniornumeracy.SeniorNumeracyActivity1;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

public class RedirectPages extends BaseActivity {

    private static final String TAG = RedirectPages.class.getSimpleName();
    CardView general_awarness, literacy, numeracy;
    Intent get_intent;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirect_pages);

        currentContext = RedirectPages.this;

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
                        stopService(new Intent(RedirectPages.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(RedirectPages.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(RedirectPages.this, MusicService.class));
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
                Intent intent = new Intent(RedirectPages.this, BookLanding.class);
                intent.putExtra("bookid", pref.getClassid());
                startActivity(intent);
                finish();
            }
        });

        general_awarness = findViewById(R.id.general_awarness);
        literacy = findViewById(R.id.literacy);
        numeracy = findViewById(R.id.numeracy);

        get_intent = getIntent();
        type = get_intent.getStringExtra("type");

        if (type != null) {
            if (type.equals("activity")) {
                TextView book_name_header = findViewById(R.id.book_name_header);
                book_name_header.setText("Activity");
            } else {
                TextView book_name_header = findViewById(R.id.book_name_header);
                book_name_header.setText(R.string.flip_book);
            }
        }

        general_awarness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type != null) {
                    if (type.equals("activity")) {
                        to_literacy_fun(pref.getBookthree());
                    } else {
                        Intent intent = new Intent(RedirectPages.this, FlipBook.class);
                        Log.e("bookid", pref.getBookthree());
                        intent.putExtra("bookid", pref.getBookthree());
                        startActivity(intent);
                    }
                }
            }
        });

        literacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type != null) {
                    if (type.equals("activity")) {
                        to_literacy_fun(pref.getBookone());
                    } else {
                        Intent intent = new Intent(RedirectPages.this, FlipBook.class);
                        intent.putExtra("bookid", pref.getBookone());
                        startActivity(intent);
                    }
                }
            }
        });


        numeracy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type != null) {
                    if (type.equals("activity")) {
                        to_literacy_fun(pref.getBooktwo());
                    } else {
                        Intent intent = new Intent(RedirectPages.this, FlipBook.class);
                        intent.putExtra("bookid", pref.getBooktwo());
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private void to_literacy_fun(String bookid) {
        Intent to_next;
        switch (bookid) {
            case "3":
                to_next = new Intent(RedirectPages.this, FindChick.class);
                startActivity(to_next);
                finish();
                break;
            case "5":
                to_next = new Intent(RedirectPages.this, NurseryNumeracyActivity1.class);
                startActivity(to_next);
                finish();
                break;
            case "7":
                to_next = new Intent(RedirectPages.this, NurseryGeneralActivity1.class);
                startActivity(to_next);
                finish();
                break;
            case "9":
                to_next = new Intent(RedirectPages.this, JuniorLiteracyActivity1.class);
//                to_next = new Intent(RedirectPages.this, EmptyStatus.class);
                to_next.putExtra("status", "coming");
                startActivity(to_next);
                break;
            case "11":
                to_next = new Intent(RedirectPages.this, JuniorNumeracyActivity1.class);
//                to_next = new Intent(RedirectPages.this, EmptyStatus.class);
                to_next.putExtra("status", "coming");
                startActivity(to_next);
                break;
            case "13":
                to_next = new Intent(RedirectPages.this, JuniorGeneralActivity1.class);
//                to_next = new Intent(RedirectPages.this, EmptyStatus.class);
                to_next.putExtra("status", "coming");
                startActivity(to_next);
                break;
            case "15":
                to_next = new Intent(RedirectPages.this, SeniorLiteracyActivity1.class);
//             to_next = new Intent(RedirectPages.this, EmptyStatus.class);
//                to_next.putExtra("status", "coming");
                startActivity(to_next);
                break;
            case "17":
                to_next = new Intent(RedirectPages.this, SeniorNumeracyActivity1.class);
//                to_next = new Intent(RedirectPages.this, EmptyStatus.class);
//                to_next.putExtra("status", "coming");
                startActivity(to_next);
                break;
            case "19":
                to_next = new Intent(RedirectPages.this, SeniorGeneralActivity1.class);
//                to_next = new Intent(RedirectPages.this, EmptyStatus.class);
//                to_next.putExtra("status", "coming");
                startActivity(to_next);
                break;
        }
    }

}
