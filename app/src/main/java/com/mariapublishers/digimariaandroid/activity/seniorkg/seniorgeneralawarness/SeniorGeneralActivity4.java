package com.mariapublishers.digimariaandroid.activity.seniorkg.seniorgeneralawarness;

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
import android.widget.RadioButton;
import android.widget.RelativeLayout;
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

public class SeniorGeneralActivity4 extends BaseActivity implements View.OnClickListener {

    RadioButton one, two, three, one1, one2, two1, two2, three1, three2;
    CardView next, back;
    DrawView drawView;
    RelativeLayout rl1;
    float a1 = 0, a2 = 0, a3 = 0, a4 = 0,
            b1 = 0, b2 = 0, b3 = 0, b4 = 0,
            c1 = 0, c2 = 0, c3 = 0, c4 = 0,
            d1 = 0, d2 = 0, d3 = 0, d4 = 0,
            e1 = 0, e2 = 0, e3 = 0, e4 = 0,
            f1 = 0, f2 = 0, f3 = 0, f4 = 0,
            g1 = 0, g2 = 0, g3 = 0, g4 = 0,
            h1 = 0, h2 = 0, h3 = 0, h4 = 0,
            i1 = 0, i2 = 0, i3 = 0, i4 = 0,
            j1 = 0, j2 = 0, j3 = 0, j4 = 0,
            k1 = 0, k2 = 0, k3 = 0, k4 = 0,
            l1 = 0, l2 = 0, l3 = 0, l4 = 0;
    int k = 0, i = 0, cr1 = 0, cr2 = 0, cr3 = 0, cr4 = 0, cr5 = 0, cr6 = 0, qr1 = 0, qr2 = 0, qr3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_general4);

        currentContext = SeniorGeneralActivity4.this;

        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {

        one.setOnClickListener(this);
        one1.setOnClickListener(this);
        one2.setOnClickListener(this);
        two.setOnClickListener(this);
        two1.setOnClickListener(this);
        two2.setOnClickListener(this);
        three.setOnClickListener(this);
        three1.setOnClickListener(this);
        three2.setOnClickListener(this);
        next.setOnClickListener(this);
        back.setOnClickListener(this);

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
        book_name_header.setText("Connect the seasons things to appropriate");

    }

    private void redirectPage() {
        Intent intent = new Intent(SeniorGeneralActivity4.this, RedirectPages.class);
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
                        stopService(new Intent(SeniorGeneralActivity4.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorGeneralActivity4.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorGeneralActivity4.this, MusicService.class));
                }


            }
        });

        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }

    }

    private void initialize() {

        one = findViewById(R.id.one);
        one1 = findViewById(R.id.one1);
        one2 = findViewById(R.id.one2);
        two = findViewById(R.id.two);
        two1 = findViewById(R.id.two1);
        two2 = findViewById(R.id.two2);
        three = findViewById(R.id.three);
        three1 = findViewById(R.id.three1);
        three2 = findViewById(R.id.three2);
        next = findViewById(R.id.next);
        back = findViewById(R.id.back);
        rl1 = findViewById(R.id.rl1);

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(SeniorGeneralActivity4.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(SeniorGeneralActivity4.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.back) {
            onclickBack();
        } else if (v.getId() == R.id.next) {
            onclickNext();
        } else if (v.getId() == R.id.one) {
            /*if (i == 0) {
                i = 1;
                qr1 = 1;
            } else {
                i = 1;
                qr1 = 1;
                if (qr1 == 1) {
                    one.setChecked(true);
                } else {
                    one.setChecked(false);
                }
                alertMessage(2, "Oops...", "Choose the right answer.");
            }*/
            i = 1;
            qr1 = 1;
            if (qr1 >= 1) {
                one.setChecked(true);
            } else {
                one.setChecked(false);
            }
        } else if (v.getId() == R.id.two) {
//            if (i == 0) {
//                i = 2;
//                qr2 = 1;
//            } else {
//                if (qr2 == 1) {
//                    two.setChecked(true);
//                } else {
//                    two.setChecked(false);
//                }
//                alertMessage(2, "Oops...", "Choose the right answer.");
//            }

            i = 2;
            qr2 = 1;
            if (qr2 >= 1) {
                two.setChecked(true);
            } else {
                two.setChecked(false);
            }
        } else if (v.getId() == R.id.three) {
            /*if (i == 0) {
                i = 3;
                qr3 = 1;
            } else {
                i = 3;
                qr3 = 1;
                if (qr3 >= 1) {
                    three.setChecked(true);
                } else {
                    three.setChecked(false);
                }
                alertMessage(2, "Oops...", "Choose the right answer.");
            }*/
            i = 3;
            qr3 = 1;
            if (qr3 >= 1) {
                three.setChecked(true);
            } else {
                three.setChecked(false);
            }
        } else if (v.getId() == R.id.one1) {
            if (i == 1) {
                if (cr1 == 0) {
                    i = 0;
                    cr1 += 1;
                    k += 1;
                    drawView = new DrawView(this,one,one1);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    if (k == 6) {
                        alertMessage(1, "Hurray!", "Activity Cleared.");
                    }
                } else {
                    i = 0;
                    if (cr1 == 1) {
                        one1.setChecked(true);
                    } else {
                        one1.setChecked(false);
                    }
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
            } else if (i == 0) {
                if (cr1 == 1) {
                    one1.setChecked(true);
                } else {
                    one1.setChecked(false);
                }
                alertMessage(2, "Oops...", "Select the question first.");
            } else {
                if (cr1 == 1) {
                    one1.setChecked(true);
                } else {
                    one1.setChecked(false);
                }
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.one2) {
            if (i == 1) {
                if (cr2 == 0) {
                    i = 0;
                    cr2 += 1;
                    k += 1;
                    drawView = new DrawView(this,one,one2);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    if (k == 6) {
                        alertMessage(1, "Hurray!", "Activity Cleared.");
                    }
                } else {
                    i = 0;
                    if (cr2 == 1) {
                        one2.setChecked(true);
                    } else {
                        one2.setChecked(false);
                    }
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
            } else if (i == 0) {
                if (cr2 == 0) {
                    one2.setChecked(false);
                } else  {
                    one2.setChecked(true);
                }
                alertMessage(2, "Oops...", "Select the question first.");
            } else {
                if (cr2 == 0) {
                    one2.setChecked(false);
                } else  {
                    one2.setChecked(true);
                }
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.two1) {
            if (i == 2) {
                if (cr3 == 0) {
                    i = 0;
                    cr3 += 1;
                    k += 1;
                    drawView = new DrawView(this,two,two1);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    if (k == 6) {
                        alertMessage(1, "Hurray!", "Activity Cleared.");
                    }
                } else {
                    if (cr3 == 1) {
                        two1.setChecked(true);
                    } else {
                        two1.setChecked(false);
                    }
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
            } else if (i == 0) {
                if (cr3 == 0) {
                    two1.setChecked(false);
                } else {
                    two1.setChecked(true);
                }
                alertMessage(2, "Oops...", "Select the question first.");
            } else {
                if (cr3 == 0) {
                    two1.setChecked(false);
                } else {
                    two1.setChecked(true);
                }
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        }
        else if (v.getId() == R.id.two2) {
            if (i == 2) {
                if (cr4 == 0) {
                    i = 0;
                    cr4 += 1;
                    k += 1;
                    drawView = new DrawView(this,two,two2);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    if (k == 6) {
                        alertMessage(1, "Hurray!", "Activity Cleared.");
                    }
                } else {
                    if (cr4 == 1) {
                        two2.setChecked(true);
                    } else {
                        two2.setChecked(false);
                    }
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
            } else if (i == 0) {
                if (cr4 == 1) {
                    two2.setChecked(true);
                } else {
                    two2.setChecked(false);
                }
                alertMessage(2, "Oops...", "Select the question first.");
            } else {
                if (cr4 == 1) {
                    two2.setChecked(true);
                } else {
                    two2.setChecked(false);
                }
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.three1) {
            if (i == 3) {
                if (cr5 == 0) {
                    i = 0;
                    cr5 += 1;
                    k += 1;
                    drawView = new DrawView(this,three,three1);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    if (k == 6) {
                        alertMessage(1, "Hurray!", "Activity Cleared.");
                    }
                } else {
                    i = 0;
                    if (cr5 == 1) {
                        three1.setChecked(true);
                    } else {
                        three1.setChecked(false);
                    }
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
            } else if (i == 0) {
                if (cr5 == 1) {
                    three1.setChecked(true);
                } else {
                    three1.setChecked(false);
                }
                alertMessage(2, "Oops...", "Select the question first.");
            } else {
                if (cr5 == 1) {
                    three1.setChecked(true);
                } else {
                    three1.setChecked(false);
                }
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.three2) {
            if (i == 3) {
                if (cr6 == 0) {
                    i = 0;
                    cr6 += 1;
                    k += 1;
                    drawView = new DrawView(this,three,three2);
                    drawView.setBackgroundColor(Color.WHITE);
                    rl1.addView(drawView);
                    if (k == 6) {
                        alertMessage(1, "Hurray!", "Activity Cleared.");
                    }
                } else {
                    i = 0;
                    if (cr6 == 1) {
                        three1.setChecked(true);
                    } else {
                        three1.setChecked(false);
                    }
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
            } else if (i == 0) {
                if (cr6 == 1) {
                    three2.setChecked(true);
                } else {
                    three2.setChecked(false);
                }
                alertMessage(2, "Oops...", "Select the question first.");
            } else {
                if (cr6 == 1) {
                    three2.setChecked(true);
                } else {
                    three2.setChecked(false);
                }
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        }

    }

    public class DrawView extends View {
        Paint paint = new Paint();
        View startView;
        View endView;

        public DrawView(Context context, View startView, View endView) {
            super(context);
            paint.setColor(getResources().getColor(R.color.colorAccent));
            paint.setStrokeWidth(10f);
            paint.setAntiAlias(true);
            this.startView = startView;
            this.endView = endView;
        }

        @SuppressLint("NewApi")
        public void onDraw(Canvas canvas) {
            if (k == 1) {
                a1 = startView.getX() + 40;
                a2 = startView.getY() + 50;
                a3 = endView.getX() + 40;
                a4 = endView.getY() + 50;
                canvas.drawLine(a1, a2, a3, a4, paint);
            }

            if (k == 2) {
                b1 = startView.getX() + 40;
                b2 = startView.getY() + 50;
                b3 = endView.getX() + 40;
                b4 = endView.getY() + 50;
                canvas.drawLine(a1, a2, a3, a4, paint);
                canvas.drawLine(b1, b2, b3, b4, paint);
            }

            if (k == 3) {
                c1 = startView.getX() + 40;
                c2 = startView.getY() + 50;
                c3 = endView.getX() + 40;
                c4 = endView.getY() + 50;
                canvas.drawLine(a1, a2, a3, a4, paint);
                canvas.drawLine(b1, b2, b3, b4, paint);
                canvas.drawLine(c1, c2, c3, c4, paint);
            }

            if (k == 4) {
                d1 = startView.getX() + 40;
                d2 = startView.getY() + 50;
                d3 = endView.getX() + 40;
                d4 = endView.getY() + 50;
                canvas.drawLine(a1, a2, a3, a4, paint);
                canvas.drawLine(b1, b2, b3, b4, paint);
                canvas.drawLine(c1, c2, c3, c4, paint);
                canvas.drawLine(d1, d2, d3, d4, paint);
            }

            if (k == 5) {
                e1 = startView.getX() + 40;
                e2 = startView.getY() + 50;
                e3 = endView.getX() + 40;
                e4 = endView.getY() + 50;
                canvas.drawLine(a1, a2, a3, a4, paint);
                canvas.drawLine(b1, b2, b3, b4, paint);
                canvas.drawLine(c1, c2, c3, c4, paint);
                canvas.drawLine(d1, d2, d3, d4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
            }

            if (k == 6) {
                f1 = startView.getX() + 40;
                f2 = startView.getY() + 50;
                f3 = endView.getX() + 40;
                f4 = endView.getY() + 50;
                canvas.drawLine(a1, a2, a3, a4, paint);
                canvas.drawLine(b1, b2, b3, b4, paint);
                canvas.drawLine(c1, c2, c3, c4, paint);
                canvas.drawLine(d1, d2, d3, d4, paint);
                canvas.drawLine(e1, e2, e3, e4, paint);
                canvas.drawLine(f1, f2, f3, f4, paint);
            }

        }

    }

    public void onclickNext() {
        startActivity(new Intent(SeniorGeneralActivity4.this, SeniorGeneralActivity5.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(SeniorGeneralActivity4.this, SeniorGeneralActivity3.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        onclickBack();
    }

}
