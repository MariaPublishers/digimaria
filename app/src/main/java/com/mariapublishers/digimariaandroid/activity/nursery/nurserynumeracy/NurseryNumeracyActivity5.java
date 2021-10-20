package com.mariapublishers.digimariaandroid.activity.nursery.nurserynumeracy;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.juniorkg.juniorliteracy.JuniorLiteracyActivity10;
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class NurseryNumeracyActivity5 extends BaseActivity {

    TextView n1, n2, n3, n4, n5, n6, n7, n8, n9, s1, s2, s3, s4, s5, s6, s7, s8, s9;
    int i = 0;
    CardView collect_apple;
    ImageView cat, food;

    SweetAlertDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nursery_numeracy5);

        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);
        n5 = findViewById(R.id.n5);
        n6 = findViewById(R.id.n6);
        n7 = findViewById(R.id.n7);
        n8 = findViewById(R.id.n8);
        n9 = findViewById(R.id.n9);

        s1 = findViewById(R.id.s1);
        s2 = findViewById(R.id.s2);
        s3 = findViewById(R.id.s3);
        s4 = findViewById(R.id.s4);
        s5 = findViewById(R.id.s5);
        s6 = findViewById(R.id.s6);
        s7 = findViewById(R.id.s7);
        s8 = findViewById(R.id.s8);
        s9 = findViewById(R.id.s9);

        cat = findViewById(R.id.cat);
        food = findViewById(R.id.food);

        pDialog = new SweetAlertDialog(NurseryNumeracyActivity5.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading ...");
        pDialog.setCancelable(false);
        pDialog.show();

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/cat.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(cat);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/food.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(food);

        pDialog.cancel();

        currentContext = NurseryNumeracyActivity5.this;

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
                        stopService(new Intent(NurseryNumeracyActivity5.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(NurseryNumeracyActivity5.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(NurseryNumeracyActivity5.this, MusicService.class));
                }


            }
        });

        collect_apple = findViewById(R.id.collect_apple);
        collect_apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NurseryNumeracyActivity5.this, NurseryNumeracyActivity4.class));
                finish();
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
                Intent intent = new Intent(NurseryNumeracyActivity5.this, RedirectPages.class);
                intent.putExtra("type", "activity");
                startActivity(intent);
                finish();
            }
        });

        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Fill the numbers and help the cat to eat his food (Hold and drag)");

        s1.setOnDragListener(dragListenre);
        s2.setOnDragListener(dragListenre);
        s3.setOnDragListener(dragListenre);
        s4.setOnDragListener(dragListenre);
        s5.setOnDragListener(dragListenre);
        s6.setOnDragListener(dragListenre);
        s7.setOnDragListener(dragListenre);
        s8.setOnDragListener(dragListenre);
        s9.setOnDragListener(dragListenre);

        n1.setOnLongClickListener(longClickListener);
        n2.setOnLongClickListener(longClickListener);
        n3.setOnLongClickListener(longClickListener);
        n4.setOnLongClickListener(longClickListener);
        n5.setOnLongClickListener(longClickListener);
        n6.setOnLongClickListener(longClickListener);
        n7.setOnLongClickListener(longClickListener);
        n8.setOnLongClickListener(longClickListener);
        n9.setOnLongClickListener(longClickListener);

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
                    if (i == 0) {
                        if (view.getId() == R.id.n1 && v.getId() == R.id.s1) {
                            n1.setVisibility(View.GONE);
                            s1.setText("2");
                            i += 1;
                            if (i == 9) {
                                toBack();
                            }
                        } else {
                            alertError("Go with the order.");
                        }
                    } else if (i == 1) {
                        if (view.getId() == R.id.n2 && v.getId() == R.id.s2) {
                            n2.setVisibility(View.GONE);
                            s2.setText("4");
                            i += 1;
                            if (i == 9) {
                                toBack();
                            }
                        } else {
                            alertError("Go with the order.");
                        }
                    } else if (i == 2) {
                        if (view.getId() == R.id.n3 && v.getId() == R.id.s3) {
                            n3.setVisibility(View.GONE);
                            s3.setText("6");
                            i += 1;
                            if (i == 9) {
                                toBack();
                            }
                        } else {
                            alertError("Go with the order.");
                        }
                    } else if (i == 3) {
                        if (view.getId() == R.id.n4 && v.getId() == R.id.s4) {
                            n4.setVisibility(View.GONE);
                            s4.setText("7");
                            i += 1;
                            if (i == 9) {
                                toBack();
                            }
                        } else {
                            alertError("Go with the order.");
                        }
                    } else if (i == 4) {
                        if (view.getId() == R.id.n5 && v.getId() == R.id.s5) {
                            n5.setVisibility(View.GONE);
                            s5.setText("10");
                            i += 1;
                            if (i == 9) {
                                toBack();
                            }
                        } else {
                            alertError("Go with the order.");
                        }
                    } else if (i == 5) {
                        if (view.getId() == R.id.n6 && v.getId() == R.id.s6) {
                            n6.setVisibility(View.GONE);
                            s6.setText("13");
                            i += 1;
                            if (i == 9) {
                                toBack();
                            }
                        } else {
                            alertError("Go with the order.");
                        }
                    } else if (i == 6) {
                        if (view.getId() == R.id.n7 && v.getId() == R.id.s7) {
                            n7.setVisibility(View.GONE);
                            s7.setText("14");
                            i += 1;
                            if (i == 9) {
                                toBack();
                            }
                        } else {
                            alertError("Go with the order.");
                        }
                    } else if (i == 7) {
                        if (view.getId() == R.id.n8 && v.getId() == R.id.s8) {
                            n8.setVisibility(View.GONE);
                            s8.setText("17");
                            i += 1;
                            if (i == 9) {
                                toBack();
                            }
                        } else {
                            alertError("Go with the order.");
                        }
                    } else if (i == 8) {
                        if (view.getId() == R.id.n9 && v.getId() == R.id.s9) {
                            n9.setVisibility(View.GONE);
                            s9.setText("20");
                            i += 1;
                            if (i == 9) {
                                toBack();
                            }
                        } else {
                            alertError("Go with order.");
                        }
                    } else {
                        alertError("Drop the number on the correct circle.");
                    }
                    break;

            }
            return true;
        }
    };

    public void alertError(String message) {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wrong);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(NurseryNumeracyActivity5.this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setConfirmText("OK")
                .setContentText(message)
                .show();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(NurseryNumeracyActivity5.this, NurseryNumeracyActivity4.class);
        intent.putExtra("bookid", pref.getClassid());
        startActivity(intent);
        finish();
    }

    public void toBack() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(NurseryNumeracyActivity5.this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Hurray!")
                .setContentText("Activity Cleared.")
                .setConfirmText("OK")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        Intent intent = new Intent(NurseryNumeracyActivity5.this, RedirectPages.class);
                        intent.putExtra("type", "activity");
                        startActivity(intent);
                        finish();
                    }
                })
                .show();
    }

}
