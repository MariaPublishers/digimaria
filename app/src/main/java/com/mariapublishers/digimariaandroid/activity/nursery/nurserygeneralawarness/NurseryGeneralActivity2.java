package com.mariapublishers.digimariaandroid.activity.nursery.nurserygeneralawarness;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.juniorkg.juniorliteracy.JuniorLiteracyActivity10;
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.activity.nursery.nurserynumeracy.NurseryNumeracyActivity2;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class NurseryGeneralActivity2 extends BaseActivity {

    CardView classroom, house, sc1, sc2, sc3, sc4, hs1, hs2, hs3, hs4;
    int i1 = 0, i2 = 0, i3 = 0, i4 = 0, i5 = 0, i6 = 0, i7 = 0, i8 = 0;
    int k = 0;
    float m1 = 0, m2 = 0, m3 = 0, m4 = 0, e1 = 0, e2 = 0, e3 = 0, e4 = 0, r1 = 0, r2 = 0, r3 = 0, r4 = 0, p1 = 0, p2 = 0, p3 = 0, p4 = 0,
            d1 = 0, d2 = 0, d3 = 0, d4 = 0, c1 = 0, c2 = 0, c3 = 0, c4 = 0, f1 = 0, f2 = 0, f3 = 0, f4 = 0, g1 = 0, g2 = 0, g3 = 0, g4 = 0;
    DrawView drawView;
    RelativeLayout rs1;
    CardView heathy_food, help_spider;
    int classes, houses;
    int i = 0;

    ImageView school_img, house_img, blackboardcopy, chalkbeescopy, sofacopy, televisionrectanglecopy, pencilcopy, schoolbag, stovecopy, bucketcopy;

    SweetAlertDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nursery_general2);

        currentContext = NurseryGeneralActivity2.this;

        volval = pref.getVolumeval();

        volumenote = findViewById(R.id.volumenote);

        rs1 = findViewById(R.id.rs1);

        volumenote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (volval != null) {
                    if (volval.equals("1")) {
                        pref.setVolumeval("0");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeoff);
                        stopService(new Intent(NurseryGeneralActivity2.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(NurseryGeneralActivity2.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(NurseryGeneralActivity2.this, MusicService.class));
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
                Intent intent = new Intent(NurseryGeneralActivity2.this, RedirectPages.class);
                intent.putExtra("type", "activity");
                startActivity(intent);
                finish();
            }
        });

        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Match the things where they belong to");

//        ImageView profile_id = findViewById(R.id.profile_id);
//        profile_id.setVisibility(View.INVISIBLE);

        heathy_food = findViewById(R.id.heathy_food);
        heathy_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NurseryGeneralActivity2.this, NurseryGeneralActivity1.class));
                finish();
            }
        });

        help_spider = findViewById(R.id.help_spider);
        help_spider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NurseryGeneralActivity2.this, NurseryGeneralActivity4.class));
                finish();
            }
        });

        classroom = findViewById(R.id.classroom);
        house = findViewById(R.id.house);

        sc1 = findViewById(R.id.sc1);
        sc2 = findViewById(R.id.sc2);
        sc3 = findViewById(R.id.sc3);
        sc4 = findViewById(R.id.sc4);
        hs1 = findViewById(R.id.hs1);
        hs2 = findViewById(R.id.hs2);
        hs3 = findViewById(R.id.hs3);
        hs4 = findViewById(R.id.hs4);

        school_img = findViewById(R.id.school_img);
        house_img = findViewById(R.id.house_img);
        blackboardcopy = findViewById(R.id.blackboardcopy);
        chalkbeescopy = findViewById(R.id.chalkbeescopy);
        sofacopy = findViewById(R.id.sofacopy);
        televisionrectanglecopy = findViewById(R.id.televisionrectanglecopy);
        pencilcopy = findViewById(R.id.pencilcopy);
        schoolbag = findViewById(R.id.schoolbag);
        stovecopy = findViewById(R.id.stovecopy);
        bucketcopy = findViewById(R.id.bucketcopy);

        pDialog = new SweetAlertDialog(NurseryGeneralActivity2.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading ...");
        pDialog.setCancelable(false);
        pDialog.show();

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/classroomcopy.jpg")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(school_img);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/housecopy.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(house_img);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/blackboardcopy.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(blackboardcopy);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/chalkbeescopy.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(chalkbeescopy);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/sofacopy.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(sofacopy);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/televisionrectanglecopy.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(televisionrectanglecopy);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/pencilcopy.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(pencilcopy);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/schoolbag.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(schoolbag);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/stovecopy.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(stovecopy);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/bucketcopy.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(bucketcopy);

        pDialog.cancel();

        house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                houses = 1;
                classes = 0;
                house.setCardBackgroundColor(getResources().getColor(R.color.matchone));
            }
        });

        classroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classes = 1;
                houses = 0;
                classroom.setCardBackgroundColor(getResources().getColor(R.color.matchtwo));
            }
        });

        sc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i1 == 0) {
                    if (classes == 1) {
                        i += 1;
                        sc1.setCardBackgroundColor(getResources().getColor(R.color.matchtwo));
                        i1 = 1;
                        if (i == 8) {
                            toBack();
                        }
                    } else {
                        alertError("Choose house things");
                    }
                } else {
                    alertError("You had already choosen this option");
                }
            }
        });

        sc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i2 == 0) {
                    if (classes == 1) {
                        i += 1;
                        sc2.setCardBackgroundColor(getResources().getColor(R.color.matchtwo));
                        i2 = 1;
                        if (i == 8) {
                            toBack();
                        }
                    } else {
                        alertError("Choose house things");
                    }
                } else {
                    alertError("You had already choosen this option");
                }
            }
        });

        sc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i3 == 0) {
                    if (classes == 1) {
                        i += 1;
                        sc3.setCardBackgroundColor(getResources().getColor(R.color.matchtwo));
                        i3 = 1;
                        if (i == 8) {
                            toBack();
                        }
                    } else {
                        alertError("Choose house things");
                    }
                } else {
                    alertError("You had already choosen this option");
                }
            }
        });

        sc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i4 == 0) {
                    if (classes == 1) {
                        i += 1;
                        sc4.setCardBackgroundColor(getResources().getColor(R.color.matchtwo));
                        i4 = 1;
                        if (i == 8) {
                            toBack();
                        }
                    } else {
                        alertError("Choose house things");
                    }
                } else {
                    alertError("You had already choosen this option");
                }
            }
        });

        hs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i5 == 0) {
                    if (houses == 1) {
                        i += 1;
                        hs1.setCardBackgroundColor(getResources().getColor(R.color.matchone));
                        i5 = 1;
                        if (i == 8) {
                            toBack();
                        }
                    } else {
                        alertError("Choose school things");
                    }
                } else {
                    alertError("You had already choosen this option");
                }
            }
        });

        hs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i6 == 0) {
                    if (houses == 1) {
                        i += 1;
                        hs2.setCardBackgroundColor(getResources().getColor(R.color.matchone));
                        i6 = 1;
                        if (i == 8) {
                            toBack();
                        }
                    } else {
                        alertError("Choose school things");
                    }
                } else {
                    alertError("You had already choosen this option");
                }
            }
        });

        hs3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i7 == 0) {
                    if (houses == 1) {
                        i += 1;
                        hs3.setCardBackgroundColor(getResources().getColor(R.color.matchone));
                        i7 = 1;
                        if (i == 8) {
                            toBack();
                        }
                    } else {
                        alertError("Choose school things");
                    }
                } else {
                    alertError("You had already choosen this option");
                }
            }
        });

        hs4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i8 == 0) {
                    if (houses == 1) {
                        i += 1;
                        hs4.setCardBackgroundColor(getResources().getColor(R.color.matchone));
                        i8 = 1;
                        if (i == 8) {
                            toBack();
                        }
                    } else {
                        alertError("Choose school things");
                    }
                } else {
                    alertError("You had already choosen this option");
                }
            }
        });

    }

    public void alertError(String message) {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wrong);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(NurseryGeneralActivity2.this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setConfirmText("OK")
                .setContentText(message)
                .show();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(NurseryGeneralActivity2.this, NurseryGeneralActivity1.class);
        intent.putExtra("bookid", pref.getClassid());
        startActivity(intent);
        finish();
    }

    public void toBack() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(NurseryGeneralActivity2.this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Hurray!")
                .setContentText("Activity Cleared.")
                .setConfirmText("OK")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        startActivity(new Intent(NurseryGeneralActivity2.this, NurseryGeneralActivity4.class));
                        finish();
                    }
                })
                .show();
    }

    public class DrawView extends View {
        Paint paint = new Paint();
        View startView;
        View endView;

        public DrawView(Context context, View startView, View endView, int type) {
            super(context);

            paint.setColor(getResources().getColor(R.color.colorAccent));
//            if (type == 1) {
//                paint.setColor(getResources().getColor(R.color.successgreen));
//            } else {
//                paint.setColor(getResources().getColor(R.color.failurered));
//            }

            paint.setStrokeWidth(10f);
            paint.setAntiAlias(true);
            this.startView = startView;
            this.endView = endView;
        }

        @SuppressLint("NewApi")
        public void onDraw(Canvas canvas) {
            if (k == 1) {
                m1 = startView.getX()+40;
                m2 = startView.getY()+50;
                m3 = endView.getX()+40;
                m4 = endView.getY()+50;
                canvas.drawLine(m1, m2, m3, m4, paint);
            }

            if (k == 2) {
                e1 = startView.getX()+40;
                e2 = startView.getY()+50;
                e3 = endView.getX()+40;
                e4 = endView.getY()+50;
                canvas.drawLine(m1, m2, m3, m4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
            }

            if (k == 3) {
                r1 = startView.getX()+40;
                r2 = startView.getY()+50;
                r3 = endView.getX()+40;
                r4 = endView.getY()+50;
                canvas.drawLine(m1, m2, m3, m4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
                canvas.drawLine(r1, r2, r3, r4, paint);
            }

            if (k == 4) {
                p1 = startView.getX()+40;
                p2 = startView.getY()+50;
                p3 = endView.getX()+40;
                p4 = endView.getY()+50;
                canvas.drawLine(m1, m2, m3, m4, paint);
                canvas.drawLine(p1, p2, p3, p4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
                canvas.drawLine(r1, r2, r3, r4, paint);
            }

            if (k == 5) {
                d1 = startView.getX()+40;
                d2 = startView.getY()+50;
                d3 = endView.getX()+40;
                d4 = endView.getY()+50;
                canvas.drawLine(m1, m2, m3, m4, paint);
                canvas.drawLine(d1, d2, d3, d4, paint);
                canvas.drawLine(p1, p2, p3, p4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
                canvas.drawLine(r1, r2, r3, r4, paint);
            }

            if (k == 6) {
                c1 = startView.getX()+40;
                c2 = startView.getY()+50;
                c3 = endView.getX()+40;
                c4 = endView.getY()+50;
                canvas.drawLine(m1, m2, m3, m4, paint);
                canvas.drawLine(d1, d2, d3, d4, paint);
                canvas.drawLine(c1, c2, c3, c4, paint);
                canvas.drawLine(p1, p2, p3, p4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
                canvas.drawLine(r1, r2, r3, r4, paint);
            }

            if (k == 7) {
                f1 = startView.getX()+40;
                f2 = startView.getY()+50;
                f3 = endView.getX()+40;
                f4 = endView.getY()+50;
                canvas.drawLine(m1, m2, m3, m4, paint);
                canvas.drawLine(d1, d2, d3, d4, paint);
                canvas.drawLine(c1, c2, c3, c4, paint);
                canvas.drawLine(f1, f2, f3, f4, paint);
                canvas.drawLine(p1, p2, p3, p4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
                canvas.drawLine(r1, r2, r3, r4, paint);
            }

            if (k == 8) {
                g1 = startView.getX()+40;
                g2 = startView.getY()+50;
                g3 = endView.getX()+40;
                g4 = endView.getY()+50;
                canvas.drawLine(g1, g2, g3, g4, paint);
                canvas.drawLine(m1, m2, m3, m4, paint);
                canvas.drawLine(d1, d2, d3, d4, paint);
                canvas.drawLine(c1, c2, c3, c4, paint);
                canvas.drawLine(f1, f2, f3, f4, paint);
                canvas.drawLine(p1, p2, p3, p4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
                canvas.drawLine(r1, r2, r3, r4, paint);
            }

        }

    }

}
