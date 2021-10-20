package com.mariapublishers.digimariaandroid.activity.nursery.nurserygeneralawarness;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.juniorkg.juniorliteracy.JuniorLiteracyActivity10;
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class NurseryGeneralActivity4 extends BaseActivity {

    CardView heathy_food, help_spider;
    TextView la1, la2, la3, la4, ca1, ca2, ca3, fa1, fa2, fa3, fa4, ha1, ha2, ha3, ha4, ha5, ha6, ha7, ha8, ho1, ho2, ho3, ho4, ho5, ta1, ta2, ta3, ta4, ta5;
    TextView n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, n17, n18, n19, n20, n21, n22;
    int lion = 0, cat = 0, housefly = 0, frog = 0, horse = 0, tiger = 0, lion1 = 0, cat1 = 0, housefly1 = 0, frog1 = 0, horse1 = 0, tiger1 = 0, common = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nursery_general4);

        currentContext = NurseryGeneralActivity4.this;

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
                        stopService(new Intent(NurseryGeneralActivity4.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(NurseryGeneralActivity4.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(NurseryGeneralActivity4.this, MusicService.class));
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
                Intent intent = new Intent(NurseryGeneralActivity4.this, RedirectPages.class);
                intent.putExtra("type", "activity");
                startActivity(intent);
                finish();
            }
        });

        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Who am I? Colour my name");

//        ImageView profile_id = findViewById(R.id.profile_id);
//        profile_id.setVisibility(View.INVISIBLE);

        heathy_food = findViewById(R.id.heathy_food);
        heathy_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NurseryGeneralActivity4.this, NurseryGeneralActivity2.class));
                finish();
            }
        });

        help_spider = findViewById(R.id.help_spider);
        help_spider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NurseryGeneralActivity4.this, NurseryGeneralActivity5.class));
                finish();
            }
        });

        la1 = findViewById(R.id.la1);
        la2 = findViewById(R.id.la2);
        la3 = findViewById(R.id.la3);
        la4 = findViewById(R.id.la4);
        ca1 = findViewById(R.id.ca1);
        ca2 = findViewById(R.id.ca2);
        ca3 = findViewById(R.id.ca3);
        fa1 = findViewById(R.id.fa1);
        fa2 = findViewById(R.id.fa2);
        fa3 = findViewById(R.id.fa3);
        fa4 = findViewById(R.id.fa4);
        ha1 = findViewById(R.id.ha1);
        ha2 = findViewById(R.id.ha2);
        ha3 = findViewById(R.id.ha3);
        ha4 = findViewById(R.id.ha4);
        ha5 = findViewById(R.id.ha5);
        ha6 = findViewById(R.id.ha6);
        ha7 = findViewById(R.id.ha7);
        ha8 = findViewById(R.id.ha8);
        ho1 = findViewById(R.id.ho1);
        ho2 = findViewById(R.id.ho2);
        ho3 = findViewById(R.id.ho3);
        ho4 = findViewById(R.id.ho4);
        ho5 = findViewById(R.id.ho5);
        ta1 = findViewById(R.id.ta1);
        ta2 = findViewById(R.id.ta2);
        ta3 = findViewById(R.id.ta3);
        ta4 = findViewById(R.id.ta4);
        ta5 = findViewById(R.id.ta5);

        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);
        n5 = findViewById(R.id.n5);
        n6 = findViewById(R.id.n6);
        n7 = findViewById(R.id.n7);
        n8 = findViewById(R.id.n8);
        n9 = findViewById(R.id.n9);
        n10 = findViewById(R.id.n10);
        n11 = findViewById(R.id.n11);
        n12 = findViewById(R.id.n12);
        n13 = findViewById(R.id.n13);
        n14 = findViewById(R.id.n14);
        n15 = findViewById(R.id.n15);
        n16 = findViewById(R.id.n16);
        n17 = findViewById(R.id.n17);
        n18 = findViewById(R.id.n18);
        n19 = findViewById(R.id.n19);
        n20 = findViewById(R.id.n20);
        n21 = findViewById(R.id.n21);
        n22 = findViewById(R.id.n22);

        la1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lion == 0) {
                    la1.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    lion = 1;
                    lion1 += 1;
                    common += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        la2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lion == 1) {
                    la2.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    lion = 2;
                    lion1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        la3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lion == 2) {
                    la3.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    lion = 3;
                    lion1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        la4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lion == 3) {
                    la4.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    lion = 4;
                    lion1 += 1;
                    if (lion1 == 4) {
                        common += 1;
                        if (common == 7) {
                            toBack();
                        }
                    }
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        ca1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cat == 0) {
                    ca1.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    cat = 1;
                    cat1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        ca2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cat == 1) {
                    ca2.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    cat = 2;
                    cat1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        ca3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cat == 2) {
                    ca3.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    cat = 3;
                    cat1 += 1;
                    if (cat1 == 3) {
                        common += 1;
                        if (common == 7) {
                            toBack();
                        }
                    }
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        fa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (frog == 0) {
                    fa1.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    frog = 1;
                    frog1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        fa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (frog == 1) {
                    fa2.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    frog = 2;
                    frog1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        fa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (frog == 2) {
                    fa3.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    frog = 3;
                    frog1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        fa4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (frog == 3) {
                    fa4.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    frog = 4;
                    frog1 += 1;
                    if (frog1 == 4) {
                        common += 1;
                        if (common == 7) {
                            toBack();
                        }
                    }
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        ha1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (housefly == 0) {
                    ha1.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    housefly = 1;
                    housefly1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        ha2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (housefly == 1) {
                    ha2.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    housefly = 2;
                    housefly1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        ha3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (housefly == 2) {
                    ha3.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    housefly = 3;
                    housefly1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        ha4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (housefly == 3) {
                    ha4.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    housefly = 4;
                    housefly1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        ha5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (housefly == 4) {
                    ha5.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    housefly = 5;
                    housefly1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        ha6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (housefly == 5) {
                    ha6.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    housefly = 6;
                    housefly1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        ha7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (housefly == 6) {
                    ha7.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    housefly = 7;
                    housefly1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        ha8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (housefly == 7) {
                    ha8.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    housefly = 8;
                    housefly1 += 1;
                    if (housefly1 == 8) {
                        common += 1;
                        if (common == 7) {
                            toBack();
                        }
                    }
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        ho1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (horse == 0) {
                    ho1.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    horse = 1;
                    horse1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        ho2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (horse == 1) {
                    ho2.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    horse = 2;
                    horse1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        ho3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (horse == 2) {
                    ho3.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    horse = 3;
                    horse1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        ho4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (horse == 3) {
                    ho4.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    horse = 4;
                    horse1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        ho5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (horse == 4) {
                    ho5.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    horse = 5;
                    horse1 += 1;
                    if (horse1 == 5) {
                        common += 1;
                        if (common == 7) {
                            toBack();
                        }
                    }
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        ta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tiger == 0) {
                    ta1.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    tiger = 1;
                    tiger1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        ta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tiger == 1) {
                    ta2.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    tiger = 2;
                    tiger1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        ta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tiger == 2) {
                    ta3.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    tiger = 3;
                    tiger1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        ta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tiger == 3) {
                    ta4.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    tiger = 4;
                    tiger1 += 1;
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        ta5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tiger == 4) {
                    ta5.setBackground(getResources().getDrawable(R.drawable.word_outer_selected));
                    tiger = 5;
                    tiger1 += 1;
                    if (tiger1 == 5) {
                        common += 1;
                        if (common == 7) {
                            toBack();
                        }
                    }
                } else {
                    alertError("Choose the correct answer");
                }
            }
        });

        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });

        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });

        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });

        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });

        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });

        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });

        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });

        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });

        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });

        n10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });

        n11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });

        n12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });

        n13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });

        n14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });

        n15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });

        n16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });

        n17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });

        n18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });

        n19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });

        n20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });

        n21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });

        n22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertError("Choose the correct answer");
            }
        });
    }

    public void alertError(String message) {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wrong);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(NurseryGeneralActivity4.this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setContentText(message)
                .setConfirmText("OK")
                .show();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(NurseryGeneralActivity4.this, NurseryGeneralActivity3.class);
        intent.putExtra("bookid", pref.getClassid());
        startActivity(intent);
        finish();
    }

    public void toBack() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(NurseryGeneralActivity4.this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Hurray!")
                .setContentText("Activity Cleared.")
                .setConfirmText("OK")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        startActivity(new Intent(NurseryGeneralActivity4.this, NurseryGeneralActivity5.class));
                        finish();
                    }
                })
                .show();
    }
}
