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

public class NurseryNumeracyActivity4 extends BaseActivity {

    int i = 0, j = 0, k = 0, l = 0;
    ImageView apple7_2, apple7_1, apple2_3, apple7_3, apple2_2, apple2_1, basket2, basket7, tree;
    CardView help_butter, help_cat;

    SweetAlertDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nursery_numeracy4);

        currentContext = NurseryNumeracyActivity4.this;

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
                        stopService(new Intent(NurseryNumeracyActivity4.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(NurseryNumeracyActivity4.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(NurseryNumeracyActivity4.this, MusicService.class));
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
                Intent intent = new Intent(NurseryNumeracyActivity4.this, RedirectPages.class);
                intent.putExtra("type", "activity");
                startActivity(intent);
                finish();
            }
        });

        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Place the apples in the correct basket (Hold and drag)");

//        ImageView profile_id = findViewById(R.id.profile_id);
//        profile_id.setVisibility(View.INVISIBLE);

        help_butter = findViewById(R.id.help_butter);
        help_butter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NurseryNumeracyActivity4.this, NurseryNumeracyActivity3.class));
                finish();
            }
        });

        help_cat = findViewById(R.id.help_cat);
        help_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NurseryNumeracyActivity4.this, NurseryNumeracyActivity5.class));
                finish();
            }
        });

        apple7_2 = findViewById(R.id.apple7_2);
        apple7_1 = findViewById(R.id.apple7_1);
        apple2_3 = findViewById(R.id.apple2_3);
        apple7_3 = findViewById(R.id.apple7_3);
        apple2_2 = findViewById(R.id.apple2_2);
        apple2_1 = findViewById(R.id.apple2_1);
        basket2 = findViewById(R.id.basket2);
        basket7 = findViewById(R.id.basket7);
        tree = findViewById(R.id.tree);

        apple2_1.setOnLongClickListener(longClickListener);
        apple2_2.setOnLongClickListener(longClickListener);
        apple2_3.setOnLongClickListener(longClickListener);
        apple7_1.setOnLongClickListener(longClickListener);
        apple7_2.setOnLongClickListener(longClickListener);
        apple7_3.setOnLongClickListener(longClickListener);

        basket2.setOnDragListener(dragListenre);
        basket7.setOnDragListener(dragListenres);

        pDialog = new SweetAlertDialog(NurseryNumeracyActivity4.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading ...");
        pDialog.setCancelable(false);
        pDialog.show();

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/apple2.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(apple2_1);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/apple2.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(apple2_2);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/apple2.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(apple2_3);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/apple7.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(apple7_1);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/apple7.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(apple7_2);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/apple7.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(apple7_3);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/empty2.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(basket2);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/empty7.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(basket7);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/tree.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(tree);

        pDialog.cancel();

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
                    if (view.getId() == R.id.apple2_1 && v.getId() == R.id.basket2) {
                        j = 0;
                        l += 1;
                        if (l == 1) {
                            basket2.setImageResource(R.drawable.apple21);
                            apple2_1.setVisibility(View.GONE);
                        } else if (l == 2) {
                            basket2.setImageResource(R.drawable.apple22);
                            apple2_1.setVisibility(View.GONE);
                        } else if (l == 3) {
                            basket2.setImageResource(R.drawable.apple23);
                            apple2_1.setVisibility(View.GONE);
                            if (l == 3 && k == 3) {
                                toBack();
                            }
                        }
                    } else if (view.getId() == R.id.apple2_2 && v.getId() == R.id.basket2) {
                        j = 0;
                        l += 1;
                        if (l == 1) {
                            basket2.setImageResource(R.drawable.apple21);
                            apple2_2.setVisibility(View.GONE);
                        } else if (l == 2) {
                            basket2.setImageResource(R.drawable.apple22);
                            apple2_2.setVisibility(View.GONE);
                        } else if (l == 3) {
                            basket2.setImageResource(R.drawable.apple23);
                            apple2_2.setVisibility(View.GONE);
                            if (l == 3 && k == 3) {
                                toBack();
                            }
                        }
                    } else if (view.getId() == R.id.apple2_3 && v.getId() == R.id.basket2) {
                        j = 0;
                        l += 1;
                        if (l == 1) {
                            basket2.setImageResource(R.drawable.apple21);
                            apple2_3.setVisibility(View.GONE);
                        } else if (l == 2) {
                            basket2.setImageResource(R.drawable.apple22);
                            apple2_3.setVisibility(View.GONE);
                        } else if (l == 3) {
                            basket2.setImageResource(R.drawable.apple23);
                            apple2_3.setVisibility(View.GONE);
                            if (l == 3 && k == 3) {
                                toBack();
                            }
                        }
                    } else {
                        alertError("Choose the correct basket.");
                    }
                    break;

            }
            return true;
        }
    };

    View.OnDragListener dragListenres = new View.OnDragListener() {
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
                    if (view.getId() == R.id.apple7_1 && v.getId() == R.id.basket7) {
                        j = 0;
                        k += 1;
                        if (k == 1) {
                            basket7.setImageResource(R.drawable.apple71);
                            apple7_1.setVisibility(View.GONE);
                        } else if (k == 2) {
                            basket7.setImageResource(R.drawable.apple72);
                            apple7_1.setVisibility(View.GONE);
                        } else if (k == 3) {
                            basket7.setImageResource(R.drawable.apple73);
                            apple7_1.setVisibility(View.GONE);
                            if (l == 3 && k == 3) {
                                toBack();
                            }
                        }
                    } else if (view.getId() == R.id.apple7_2 && v.getId() == R.id.basket7) {
                        j = 0;
                        k += 1;
                        if (k == 1) {
                            basket7.setImageResource(R.drawable.apple71);
                            apple7_2.setVisibility(View.GONE);
                        } else if (k == 2) {
                            basket7.setImageResource(R.drawable.apple72);
                            apple7_2.setVisibility(View.GONE);
                        } else if (k == 3) {
                            basket7.setImageResource(R.drawable.apple73);
                            apple7_2.setVisibility(View.GONE);
                            if (l == 3 && k == 3) {
                                toBack();
                            }
                        }
                    } else if (view.getId() == R.id.apple7_3 && v.getId() == R.id.basket7) {
                        j = 0;
                        k += 1;
                        if (k == 1) {
                            basket7.setImageResource(R.drawable.apple71);
                            apple7_3.setVisibility(View.GONE);
                        } else if (k == 2) {
                            basket7.setImageResource(R.drawable.apple72);
                            apple7_3.setVisibility(View.GONE);
                        } else if (k == 3) {
                            basket7.setImageResource(R.drawable.apple73);
                            apple7_3.setVisibility(View.GONE);
                            if (l == 3 && k == 3) {
                                toBack();
                            }
                        }
                    } else {
                        alertError("Choose the correct basket.");
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

        new SweetAlertDialog(NurseryNumeracyActivity4.this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setConfirmText("OK")
                .setContentText(message)
                .show();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(NurseryNumeracyActivity4.this, NurseryNumeracyActivity3.class);
        intent.putExtra("bookid", pref.getClassid());
        startActivity(intent);
        finish();
    }

    public void toBack() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(NurseryNumeracyActivity4.this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Hurray!")
                .setContentText("Activity Cleared.")
                .setConfirmText("OK")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        startActivity(new Intent(NurseryNumeracyActivity4.this, NurseryNumeracyActivity5.class));
                        finish();
                    }
                })
                .show();
    }

}
