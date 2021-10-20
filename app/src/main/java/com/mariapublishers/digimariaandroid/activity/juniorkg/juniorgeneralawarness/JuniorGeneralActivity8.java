package com.mariapublishers.digimariaandroid.activity.juniorkg.juniorgeneralawarness;

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
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.activity.mainprocess.SearchActivity;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class JuniorGeneralActivity8 extends BaseActivity implements View.OnClickListener {

    int i = 0;
    ImageView wrong1, wrong2, wrong3, wrong4, correct1, correct2, correct3, correct4, correct5, blueouter, redouter;
    int wr1 = 0, wr2 = 0, wr3 = 0, wr4 = 0, cr1 = 0, cr2 = 0, cr3 = 0, cr4 = 0, cr5 = 0;
    CardView next, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junior_general8);

        currentContext = JuniorGeneralActivity8.this;

        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {

        blueouter.setOnLongClickListener(longClickListener);
        redouter.setOnLongClickListener(longClickListener);

        wrong1.setOnDragListener(dragListenre);
        wrong2.setOnDragListener(dragListenre);
        wrong3.setOnDragListener(dragListenre);
        wrong4.setOnDragListener(dragListenre);
        correct1.setOnDragListener(dragListenre);
        correct2.setOnDragListener(dragListenre);
        correct3.setOnDragListener(dragListenre);
        correct4.setOnDragListener(dragListenre);
        correct5.setOnDragListener(dragListenre);

        next.setOnClickListener(this);
        back.setOnClickListener(this);

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
                    if (view.getId() == R.id.redouter && v.getId() == R.id.wrong1) {
                        if (wr1 == 0) {
                            wr1 += 1;
                            i += 1;
                            wrong1.setBackgroundResource(R.drawable.red_outer_jg8);
                            if (wr1 == 1 && wr2 == 1 && wr3 == 1 && wr4 == 1) {
                                redouter.setVisibility(View.GONE);
                            }
                            if (i == 9) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Choose the right answer.");
                        }
                    } else if (view.getId() == R.id.redouter && v.getId() == R.id.wrong2) {
                        if (wr2 == 0) {
                            wr2 += 1;
                            i += 1;
                            wrong2.setBackgroundResource(R.drawable.red_outer_jg8);
                            if (wr1 == 1 && wr2 == 1 && wr3 == 1 && wr4 == 1) {
                                redouter.setVisibility(View.GONE);
                            }
                            if (i == 9) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Choose the right answer.");
                        }
                    } else if (view.getId() == R.id.redouter && v.getId() == R.id.wrong3) {
                        if (wr3 == 0) {
                            wr3 += 1;
                            i += 1;
                            wrong3.setBackgroundResource(R.drawable.red_outer_jg8);
                            if (wr1 == 1 && wr2 == 1 && wr3 == 1 && wr4 == 1) {
                                redouter.setVisibility(View.GONE);
                            }
                            if (i == 9) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Choose the right answer.");
                        }
                    } else if (view.getId() == R.id.redouter && v.getId() == R.id.wrong4) {
                        if (wr4 == 0) {
                            wr4 += 1;
                            i += 1;
                            wrong4.setBackgroundResource(R.drawable.red_outer_jg8);
                            if (wr1 == 1 && wr2 == 1 && wr3 == 1 && wr4 == 1) {
                                redouter.setVisibility(View.GONE);
                            }
                            if (i == 9) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Choose the right answer.");
                        }
                    } else if (view.getId() == R.id.blueouter && v.getId() == R.id.correct1) {
                        if (cr1 == 0) {
                            cr1 += 1;
                            i += 1;
                            correct1.setBackgroundResource(R.drawable.blue_outer_jg8);
                            if (cr1 == 1 && cr2 == 1 && cr3 == 1 && cr4 == 1 && cr5 == 1) {
                                blueouter.setVisibility(View.GONE);
                            }
                            if (i == 9) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Choose the right answer.");
                        }
                    } else if (view.getId() == R.id.blueouter && v.getId() == R.id.correct2) {
                        if (cr2 == 0) {
                            cr2 += 1;
                            i += 1;
                            correct2.setBackgroundResource(R.drawable.blue_outer_jg8);
                            if (cr1 == 1 && cr2 == 1 && cr3 == 1 && cr4 == 1 && cr5 == 1) {
                                blueouter.setVisibility(View.GONE);
                            }
                            if (i == 9) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Choose the right answer.");
                        }
                    } else if (view.getId() == R.id.blueouter && v.getId() == R.id.correct3) {
                        if (cr3 == 0) {
                            cr3 += 1;
                            i += 1;
                            correct3.setBackgroundResource(R.drawable.blue_outer_jg8);
                            if (cr1 == 1 && cr2 == 1 && cr3 == 1 && cr4 == 1 && cr5 == 1) {
                                blueouter.setVisibility(View.GONE);
                            }
                            if (i == 9) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Choose the right answer.");
                        }
                    } else if (view.getId() == R.id.blueouter && v.getId() == R.id.correct4) {
                        if (cr4 == 0) {
                            cr4 += 1;
                            i += 1;
                            correct4.setBackgroundResource(R.drawable.blue_outer_jg8);
                            if (cr1 == 1 && cr2 == 1 && cr3 == 1 && cr4 == 1 && cr5 == 1) {
                                blueouter.setVisibility(View.GONE);
                            }
                            if (i == 9) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Choose the right answer.");
                        }
                    } else if (view.getId() == R.id.blueouter && v.getId() == R.id.correct5) {
                        if (cr5 == 0) {
                            cr5 += 1;
                            i += 1;
                            correct5.setBackgroundResource(R.drawable.blue_outer_jg8);
                            if (cr1 == 1 && cr2 == 1 && cr3 == 1 && cr4 == 1 && cr5 == 1) {
                                blueouter.setVisibility(View.GONE);
                            }
                            if (i == 9) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Choose the right answer.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                    break;

            }
            return true;
        }
    };

    private void initialize() {

        wrong1 = findViewById(R.id.wrong1);
        wrong2 = findViewById(R.id.wrong2);
        wrong3 = findViewById(R.id.wrong3);
        wrong4 = findViewById(R.id.wrong4);
        correct1 = findViewById(R.id.correct1);
        correct2 = findViewById(R.id.correct2);
        correct3 = findViewById(R.id.correct3);
        correct4 = findViewById(R.id.correct4);
        correct5 = findViewById(R.id.correct5);
        blueouter = findViewById(R.id.blueouter);
        redouter = findViewById(R.id.redouter);
        next = findViewById(R.id.next);
        back = findViewById(R.id.back);

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(JuniorGeneralActivity8.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(JuniorGeneralActivity8.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer."
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(JuniorGeneralActivity8.this, JuniorGeneralActivity9.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(JuniorGeneralActivity8.this, JuniorGeneralActivity6.class));
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
        book_name_header.setText("Colour the circle blue if it tastes sweet or red if it tastes sour \n (Hold & Drag)");

    }

    private void redirectPage() {
        Intent intent = new Intent(JuniorGeneralActivity8.this, RedirectPages.class);
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
                        stopService(new Intent(JuniorGeneralActivity8.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(JuniorGeneralActivity8.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(JuniorGeneralActivity8.this, MusicService.class));
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
