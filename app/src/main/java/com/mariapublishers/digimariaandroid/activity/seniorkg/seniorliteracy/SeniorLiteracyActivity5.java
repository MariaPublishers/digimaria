package com.mariapublishers.digimariaandroid.activity.seniorkg.seniorliteracy;

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
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.activity.seniorflashcard.SeniorFlashCard14;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class SeniorLiteracyActivity5 extends BaseActivity {
    TextView n2, n3, n4, n5, n6, n8, n9, n10;
    TextView n11, n12, n14, n15, n16, n17, n18, n19, n20;
    TextView n21, n22, n24, n25, n26, n28, n29, n30;
    TextView n31, n32;
    TextView ol1, ol2, ol3;
    TextView bn1, bn2, bn3, bn4, bn5;
    TextView an1, an2, an3, an4, an5;
    TextView sn1, sn2, sn3, sn4;
    TextView fa1, fa2, fa3, fa4;
    TextView f1, f2, f3;
    int a1 = 0, b1 = 0, c1 = 0, d1 = 0, e1 = 0, g1 = 0;
    CardView next, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_literacy5);
        ol1 = findViewById(R.id.ol1);
        ol2 = findViewById(R.id.ol2);
        ol3 = findViewById(R.id.ol3);

        f1 = findViewById(R.id.f1);
        f2 = findViewById(R.id.f2);
        f3 = findViewById(R.id.f3);

        bn1 = findViewById(R.id.bn1);
        bn2 = findViewById(R.id.bn2);
        bn3 = findViewById(R.id.bn3);
        bn4 = findViewById(R.id.bn4);
        bn5 = findViewById(R.id.bn5);

        an1 = findViewById(R.id.an1);
        an2 = findViewById(R.id.an2);
        an3 = findViewById(R.id.an3);
        an4 = findViewById(R.id.an4);
        an5 = findViewById(R.id.an5);

        sn1 = findViewById(R.id.sn1);
        sn2 = findViewById(R.id.sn2);
        sn3 = findViewById(R.id.sn3);
        sn4 = findViewById(R.id.sn4);

        fa1 = findViewById(R.id.fa1);
        fa2 = findViewById(R.id.fa2);
        fa3 = findViewById(R.id.fa3);
        fa4 = findViewById(R.id.fa4);

        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);
        n5 = findViewById(R.id.n5);
        n6 = findViewById(R.id.n6);
        n8 = findViewById(R.id.n8);
        n9 = findViewById(R.id.n9);
        n10 = findViewById(R.id.n10);
        n11 = findViewById(R.id.n11);
        n12 = findViewById(R.id.n12);
        n14 = findViewById(R.id.n14);
        n15 = findViewById(R.id.n15);
        n16 = findViewById(R.id.n16);
        n17 = findViewById(R.id.n17);
        n18 = findViewById(R.id.n18);
        n19 = findViewById(R.id.n19);
        n20 = findViewById(R.id.n20);
        n21 = findViewById(R.id.n21);
        n22 = findViewById(R.id.n22);
        n24 = findViewById(R.id.n24);
        n25 = findViewById(R.id.n25);
        n26 = findViewById(R.id.n26);
        n28 = findViewById(R.id.n28);
        n29 = findViewById(R.id.n29);
        n30 = findViewById(R.id.n30);
        n31 = findViewById(R.id.n31);
        n32 = findViewById(R.id.n32);

        ////////////////////////////////////////////////////////////////////////////////
        ol1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a1 == 0) {
                    a1 += 1;
                    ol1.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_1));
                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
            }
        });
        ol2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a1 == 1) {
                    a1 += 1;
                    ol2.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_1));
                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
            }
        });
        ol3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a1 == 2) {
                    a1 += 1;
                    ol3.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_1));
                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }

            }
        });

        ////////////////////////////////////////////////////////////////////////////////

        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b1 == 0) {
                    b1 += 1;
                    f1.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_4));
                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }


            }
        });
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b1 == 1) {
                    b1 += 1;
                    f2.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_4));
                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }

            }
        });
        f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b1 == 2) {
                    b1 += 1;
                    f3.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_4));
                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }

            }
        });

        ////////////////////////////////////////////////////////////////////////////////e
        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1 == 0) {
                    e1 += 1;
                    bn1.setBackground(getResources().getDrawable(R.drawable.plain_border_fill));
                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
            }
        });
        bn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1 == 1) {
                    e1 += 1;
                    bn2.setBackground(getResources().getDrawable(R.drawable.plain_border_fill));
                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
            }
        });
        bn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1 == 2) {
                    e1 += 1;
                    bn3.setBackground(getResources().getDrawable(R.drawable.plain_border_fill));
                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
            }
        });
        bn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1 == 3) {
                    e1 += 1;
                    bn4.setBackground(getResources().getDrawable(R.drawable.plain_border_fill));
                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
            }
        });
        bn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1 == 4) {
                    e1 += 1;
                    bn5.setBackground(getResources().getDrawable(R.drawable.plain_border_fill));
                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
            }
        });


        ////////////////////////////////////////////////////////////////////////////////

        an1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (g1 == 0) {
                    g1 += 1;
                    an1.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_2));

                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }

            }
        });
        an2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (g1 == 1) {
                    g1 += 1;
                    an2.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_2));

                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
            }
        });
        an3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (g1 == 2) {
                    g1 += 1;
                    an3.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_2));

                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
            }
        });
        an4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (g1 == 3) {
                    g1 += 1;
                    an4.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_2));

                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
            }
        });
        an5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (g1 == 4) {
                    g1 += 1;
                    an5.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_2));

                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
            }
        });


        ////////////////////////////////////////////////////////////////////////////////


        sn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c1 == 0) {
                    c1 += 1;
                    sn1.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_3));
                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }


            }
        });
        sn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c1 == 1) {
                    c1 += 1;
                    sn2.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_3));
                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
            }
        });
        sn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c1 == 2) {
                    c1 += 1;
                    sn3.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_3));
                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
            }
        });
        sn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c1 == 3) {
                    c1 += 1;
                    sn4.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_3));
                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
            }
        });

        ////////////////////////////////////////////////////////////////////////////////
        fa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (d1 == 0) {
                    d1 += 1;
                    fa1.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_5));
                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }


            }
        });
        fa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (d1 == 1) {
                    d1 += 1;
                    fa2.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_5));
                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }

            }
        });
        fa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (d1 == 2) {
                    d1 += 1;
                    fa3.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_5));
                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }

            }
        });
        fa4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (d1 == 3) {
                    d1 += 1;
                    fa4.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_5));
                    if (a1 == 3 && b1 == 3 && c1 == 4 && d1 == 4 & e1 == 5 && g1 == 5) {
                        alertMessage(1, "Hurray!", "Activity cleared.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }

            }
        });


        ////////////////////////////////////////////////////////////////////////////////
        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });


        n11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });

        n21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });
        n32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        });


        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SeniorLiteracyActivity5.this, SeniorLiteracyActivity6.class));
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SeniorLiteracyActivity5.this, SeniorLiteracyActivity4.class));
                finish();
            }
        });
        currentContext = SeniorLiteracyActivity5.this;

        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();


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
        book_name_header.setText("Colour the opposites for the given words");

    }

    private void redirectPage() {
        Intent intent = new Intent(SeniorLiteracyActivity5.this, RedirectPages.class);
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
                        stopService(new Intent(SeniorLiteracyActivity5.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorLiteracyActivity5.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorLiteracyActivity5.this, MusicService.class));
                }


            }
        });

        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(SeniorLiteracyActivity5.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(SeniorLiteracyActivity5.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer."
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(SeniorLiteracyActivity5.this, SeniorLiteracyActivity6.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(SeniorLiteracyActivity5.this, SeniorLiteracyActivity4.class));
        finish();
    }
}
