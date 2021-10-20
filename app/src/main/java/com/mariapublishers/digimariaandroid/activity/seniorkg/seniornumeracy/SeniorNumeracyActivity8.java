package com.mariapublishers.digimariaandroid.activity.seniorkg.seniornumeracy;

import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.DragEvent;
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

public class SeniorNumeracyActivity8 extends BaseActivity implements View.OnClickListener {

    int i = 0;
    CardView next, back;
    TextView _1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20, _21, _22, _23, _24, _25,
            _26, _27, _28, _29, _30, _31, _32, _33, _34, _35, _36, _37, _38, _39, _40, _41, _42, _43, _44, _45, _46;
    TextView _1_d, _2_d, _3_d, _4_d, _5_d, _6_d, _7_d, _8_d, _9_d, _10_d, _11_d, _12_d, _13_d, _14_d, _15_d, _16_d, _17_d, _18_d,
            _19_d, _20_d, _21_d, _22_d, _23_d, _24_d, _25_d, _26_d, _27_d, _28_d, _29_d, _30_d, _31_d, _32_d, _33_d,
            _34_d, _35_d, _36_d, _37_d, _38_d, _39_d, _40_d, _41_d, _42_d, _43_d, _44_d, _45_d, _46_d;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_numeracy8);

        currentContext = SeniorNumeracyActivity8.this;

        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {

        _1.setOnLongClickListener(longClickListener);
        _2.setOnLongClickListener(longClickListener);
        _3.setOnLongClickListener(longClickListener);
        _4.setOnLongClickListener(longClickListener);
        _5.setOnLongClickListener(longClickListener);
        _6.setOnLongClickListener(longClickListener);
        _7.setOnLongClickListener(longClickListener);
        _8.setOnLongClickListener(longClickListener);
        _9.setOnLongClickListener(longClickListener);
        _10.setOnLongClickListener(longClickListener);
        _11.setOnLongClickListener(longClickListener);
        _12.setOnLongClickListener(longClickListener);
        _13.setOnLongClickListener(longClickListener);
        _14.setOnLongClickListener(longClickListener);
        _15.setOnLongClickListener(longClickListener);
        _16.setOnLongClickListener(longClickListener);
        _17.setOnLongClickListener(longClickListener);
        _18.setOnLongClickListener(longClickListener);
        _19.setOnLongClickListener(longClickListener);
        _20.setOnLongClickListener(longClickListener);
        _21.setOnLongClickListener(longClickListener);
        _22.setOnLongClickListener(longClickListener);
        _23.setOnLongClickListener(longClickListener);
        _24.setOnLongClickListener(longClickListener);
        _25.setOnLongClickListener(longClickListener);
        _26.setOnLongClickListener(longClickListener);
        _27.setOnLongClickListener(longClickListener);
        _28.setOnLongClickListener(longClickListener);
        _29.setOnLongClickListener(longClickListener);
        _30.setOnLongClickListener(longClickListener);
        _31.setOnLongClickListener(longClickListener);
        _32.setOnLongClickListener(longClickListener);
        _33.setOnLongClickListener(longClickListener);
        _34.setOnLongClickListener(longClickListener);
        _35.setOnLongClickListener(longClickListener);
        _36.setOnLongClickListener(longClickListener);
        _37.setOnLongClickListener(longClickListener);
        _38.setOnLongClickListener(longClickListener);
        _39.setOnLongClickListener(longClickListener);
        _40.setOnLongClickListener(longClickListener);
        _41.setOnLongClickListener(longClickListener);
        _42.setOnLongClickListener(longClickListener);
        _43.setOnLongClickListener(longClickListener);
        _44.setOnLongClickListener(longClickListener);
        _45.setOnLongClickListener(longClickListener);
        _46.setOnLongClickListener(longClickListener);

        _1_d.setOnDragListener(dragListenre);
        _2_d.setOnDragListener(dragListenre);
        _3_d.setOnDragListener(dragListenre);
        _4_d.setOnDragListener(dragListenre);
        _5_d.setOnDragListener(dragListenre);
        _6_d.setOnDragListener(dragListenre);
        _7_d.setOnDragListener(dragListenre);
        _8_d.setOnDragListener(dragListenre);
        _9_d.setOnDragListener(dragListenre);
        _10_d.setOnDragListener(dragListenre);
        _11_d.setOnDragListener(dragListenre);
        _12_d.setOnDragListener(dragListenre);
        _13_d.setOnDragListener(dragListenre);
        _14_d.setOnDragListener(dragListenre);
        _15_d.setOnDragListener(dragListenre);
        _16_d.setOnDragListener(dragListenre);
        _17_d.setOnDragListener(dragListenre);
        _18_d.setOnDragListener(dragListenre);
        _19_d.setOnDragListener(dragListenre);
        _20_d.setOnDragListener(dragListenre);
        _21_d.setOnDragListener(dragListenre);
        _22_d.setOnDragListener(dragListenre);
        _23_d.setOnDragListener(dragListenre);
        _24_d.setOnDragListener(dragListenre);
        _25_d.setOnDragListener(dragListenre);
        _26_d.setOnDragListener(dragListenre);
        _27_d.setOnDragListener(dragListenre);
        _28_d.setOnDragListener(dragListenre);
        _29_d.setOnDragListener(dragListenre);
        _30_d.setOnDragListener(dragListenre);
        _31_d.setOnDragListener(dragListenre);
        _32_d.setOnDragListener(dragListenre);
        _33_d.setOnDragListener(dragListenre);
        _34_d.setOnDragListener(dragListenre);
        _35_d.setOnDragListener(dragListenre);
        _36_d.setOnDragListener(dragListenre);
        _37_d.setOnDragListener(dragListenre);
        _38_d.setOnDragListener(dragListenre);
        _39_d.setOnDragListener(dragListenre);
        _40_d.setOnDragListener(dragListenre);
        _41_d.setOnDragListener(dragListenre);
        _42_d.setOnDragListener(dragListenre);
        _43_d.setOnDragListener(dragListenre);
        _44_d.setOnDragListener(dragListenre);
        _45_d.setOnDragListener(dragListenre);
        _46_d.setOnDragListener(dragListenre);

        back.setOnClickListener(this);
        next.setOnClickListener(this);

    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadow = new View.DragShadowBuilder(v);
            v.startDrag(data, shadow, v, 0);
            return false;
        }
    };

    View.OnDragListener dragListenre = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();

            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_STARTED:
// Executed after startDrag() is called.
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    // Executed after the Drag Shadow enters the drop area

                    break;
                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id._1 && v.getId() == R.id._1_d) {
                        if (i == 0) {
                            _1.setVisibility(View.GONE);
                            _1_d.setText("47");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._2 && v.getId() == R.id._2_d) {
                        if (i == 1) {
                            _2.setVisibility(View.GONE);
                            _2_d.setText("46");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._5 && v.getId() == R.id._5_d) {
                        if (i == 2) {
                            _5.setVisibility(View.GONE);
                            _5_d.setText("43");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._6 && v.getId() == R.id._6_d) {
                        if (i == 3) {
                            _6.setVisibility(View.GONE);
                            _6_d.setText("42");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._9 && v.getId() == R.id._9_d) {
                        if (i == 4) {
                            _9.setVisibility(View.GONE);
                            _9_d.setText("39");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._10 && v.getId() == R.id._10_d) {
                        if (i == 5) {
                            _10.setVisibility(View.GONE);
                            _10_d.setText("38");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._13 && v.getId() == R.id._13_d) {
                        if (i == 6) {
                            _13.setVisibility(View.GONE);
                            _13_d.setText("35");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._14 && v.getId() == R.id._14_d) {
                        if (i == 7) {
                            _14.setVisibility(View.GONE);
                            _14_d.setText("34");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._17 && v.getId() == R.id._17_d) {
                        if (i == 8) {
                            _17.setVisibility(View.GONE);
                            _17_d.setText("31");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._18 && v.getId() == R.id._18_d) {
                        if (i == 9) {
                            _18.setVisibility(View.GONE);
                            _18_d.setText("30");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._21 && v.getId() == R.id._21_d) {
                        if (i == 10) {
                            _21.setVisibility(View.GONE);
                            _21_d.setText("27");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._22 && v.getId() == R.id._22_d) {
                        if (i == 11) {
                            _22.setVisibility(View.GONE);
                            _22_d.setText("26");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._25 && v.getId() == R.id._25_d) {
                        if (i == 12) {
                            _25.setVisibility(View.GONE);
                            _25_d.setText("23");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._26 && v.getId() == R.id._26_d) {
                        if (i == 13) {
                            _26.setVisibility(View.GONE);
                            _26_d.setText("22");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._29 && v.getId() == R.id._29_d) {
                        if (i == 14) {
                            _29.setVisibility(View.GONE);
                            _29_d.setText("19");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._30 && v.getId() == R.id._30_d) {
                        if (i == 15) {
                            _30.setVisibility(View.GONE);
                            _30_d.setText("18");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._33 && v.getId() == R.id._33_d) {
                        if (i == 16) {
                            _33.setVisibility(View.GONE);
                            _33_d.setText("15");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._34 && v.getId() == R.id._34_d) {
                        if (i == 17) {
                            _34.setVisibility(View.GONE);
                            _34_d.setText("14");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._37 && v.getId() == R.id._37_d) {
                        if (i == 18) {
                            _37.setVisibility(View.GONE);
                            _37_d.setText("11");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._38 && v.getId() == R.id._38_d) {
                        if (i == 19) {
                            _38.setVisibility(View.GONE);
                            _38_d.setText("10");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._41 && v.getId() == R.id._41_d) {
                        if (i == 20) {
                            _41.setVisibility(View.GONE);
                            _41_d.setText("7");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._42 && v.getId() == R.id._42_d) {
                        if (i == 21) {
                            _42.setVisibility(View.GONE);
                            _42_d.setText("6");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._45 && v.getId() == R.id._45_d) {
                        if (i == 22) {
                            _45.setVisibility(View.GONE);
                            _45_d.setText("3");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id._46 && v.getId() == R.id._46_d) {
                        if (i == 23) {
                            _46.setVisibility(View.GONE);
                            _46_d.setText("2");
                            i += 1;
                            if (i == 24) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Drop on the right circle.");
                    }
                    break;

            }
            return true;
        }
    };

    private void initialize() {

        _1 = findViewById(R.id._1);
        _2 = findViewById(R.id._2);
        _3 = findViewById(R.id._3);
        _4 = findViewById(R.id._4);
        _5 = findViewById(R.id._5);
        _6 = findViewById(R.id._6);
        _7 = findViewById(R.id._7);
        _8 = findViewById(R.id._8);
        _9 = findViewById(R.id._9);
        _10 = findViewById(R.id._10);
        _11 = findViewById(R.id._11);
        _12 = findViewById(R.id._12);
        _13 = findViewById(R.id._13);
        _14 = findViewById(R.id._14);
        _15 = findViewById(R.id._15);
        _16 = findViewById(R.id._16);
        _17 = findViewById(R.id._17);
        _18 = findViewById(R.id._18);
        _19 = findViewById(R.id._19);
        _20 = findViewById(R.id._20);
        _21 = findViewById(R.id._21);
        _22 = findViewById(R.id._22);
        _23 = findViewById(R.id._23);
        _24 = findViewById(R.id._24);
        _25 = findViewById(R.id._25);
        _26 = findViewById(R.id._26);
        _27 = findViewById(R.id._27);
        _28 = findViewById(R.id._28);
        _29 = findViewById(R.id._29);
        _30 = findViewById(R.id._30);
        _31 = findViewById(R.id._31);
        _32 = findViewById(R.id._32);
        _33 = findViewById(R.id._33);
        _34 = findViewById(R.id._34);
        _35 = findViewById(R.id._35);
        _36 = findViewById(R.id._36);
        _37 = findViewById(R.id._37);
        _38 = findViewById(R.id._38);
        _39 = findViewById(R.id._39);
        _40 = findViewById(R.id._40);
        _41 = findViewById(R.id._41);
        _42 = findViewById(R.id._42);
        _43 = findViewById(R.id._43);
        _44 = findViewById(R.id._44);
        _45 = findViewById(R.id._45);
        _46 = findViewById(R.id._46);

        _1_d = findViewById(R.id._1_d);
        _2_d = findViewById(R.id._2_d);
        _3_d = findViewById(R.id._3_d);
        _4_d = findViewById(R.id._4_d);
        _5_d = findViewById(R.id._5_d);
        _6_d = findViewById(R.id._6_d);
        _7_d = findViewById(R.id._7_d);
        _8_d = findViewById(R.id._8_d);
        _9_d = findViewById(R.id._9_d);
        _10_d = findViewById(R.id._10_d);
        _11_d = findViewById(R.id._11_d);
        _12_d = findViewById(R.id._12_d);
        _13_d = findViewById(R.id._13_d);
        _14_d = findViewById(R.id._14_d);
        _15_d = findViewById(R.id._15_d);
        _16_d = findViewById(R.id._16_d);
        _17_d = findViewById(R.id._17_d);
        _18_d = findViewById(R.id._18_d);
        _19_d = findViewById(R.id._19_d);
        _20_d = findViewById(R.id._20_d);
        _21_d = findViewById(R.id._21_d);
        _22_d = findViewById(R.id._22_d);
        _23_d = findViewById(R.id._23_d);
        _24_d = findViewById(R.id._24_d);
        _25_d = findViewById(R.id._25_d);
        _26_d = findViewById(R.id._26_d);
        _27_d = findViewById(R.id._27_d);
        _28_d = findViewById(R.id._28_d);
        _29_d = findViewById(R.id._29_d);
        _30_d = findViewById(R.id._30_d);
        _31_d = findViewById(R.id._31_d);
        _32_d = findViewById(R.id._32_d);
        _33_d = findViewById(R.id._33_d);
        _34_d = findViewById(R.id._34_d);
        _35_d = findViewById(R.id._35_d);
        _36_d = findViewById(R.id._36_d);
        _37_d = findViewById(R.id._37_d);
        _38_d = findViewById(R.id._38_d);
        _39_d = findViewById(R.id._39_d);
        _40_d = findViewById(R.id._40_d);
        _41_d = findViewById(R.id._41_d);
        _42_d = findViewById(R.id._42_d);
        _43_d = findViewById(R.id._43_d);
        _44_d = findViewById(R.id._44_d);
        _45_d = findViewById(R.id._45_d);
        _46_d = findViewById(R.id._46_d);

        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(SeniorNumeracyActivity8.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(SeniorNumeracyActivity8.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(SeniorNumeracyActivity8.this, SeniorNumeracyWorksheet1.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(SeniorNumeracyActivity8.this, SeniorNumeracyActivity7.class));
        finish();
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
        book_name_header.setText("Place the missing numbers in reverse order (Hold and Drag)");

    }

    private void redirectPage() {
        Intent intent = new Intent(SeniorNumeracyActivity8.this, RedirectPages.class);
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
                        stopService(new Intent(SeniorNumeracyActivity8.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorNumeracyActivity8.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorNumeracyActivity8.this, MusicService.class));
                }


            }
        });

        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.next) {
            onclickNext();
        } else if (v.getId() == R.id.back) {
            onclickBack();
        }
    }

}
