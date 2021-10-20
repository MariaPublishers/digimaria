package com.mariapublishers.digimariaandroid.activity.seniorkg.seniorliteracy;

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
import com.mariapublishers.digimariaandroid.activity.seniorflashcard.SeniorFlashCard14;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class SeniorLiteracyActivity2 extends BaseActivity implements View.OnClickListener {

    int i = 0;
    TextView correct1, correct2, correct3, correct4, correct5, correct6, correct7, correct8, correct9, a_t, e_t, i_t, o_t, u_t;
    int cr1 = 0, cr2 = 0, cr3 = 0, cr4 = 0, cr5 = 0, cr6 = 0, cr7 = 0, cr8 = 0, cr9 = 0;
    CardView next, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_literacy2);

        currentContext = SeniorLiteracyActivity2.this;

        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {

        a_t.setOnLongClickListener(longClickListener);
        e_t.setOnLongClickListener(longClickListener);
        i_t.setOnLongClickListener(longClickListener);
        o_t.setOnLongClickListener(longClickListener);
        u_t.setOnLongClickListener(longClickListener);

        correct1.setOnDragListener(dragListenre);
        correct2.setOnDragListener(dragListenre);
        correct3.setOnDragListener(dragListenre);
        correct4.setOnDragListener(dragListenre);
        correct5.setOnDragListener(dragListenre);
        correct6.setOnDragListener(dragListenre);
        correct7.setOnDragListener(dragListenre);
        correct8.setOnDragListener(dragListenre);
        correct9.setOnDragListener(dragListenre);

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
                    if (view.getId() == R.id.a && v.getId() == R.id.correct1) {
                        cr1 += 1;
                        correct1.setText("a");
                        if (cr1 == 2) {
                            i += 1;
                            a_t.setVisibility(View.GONE);
                        }
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.a && v.getId() == R.id.correct9) {
                        cr1 += 1;
                        correct9.setText("a");
                        if (cr1 == 2) {
                            i += 1;
                            a_t.setVisibility(View.GONE);
                        }
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.i && v.getId() == R.id.correct2) {
                        cr2 += 1;
                        correct2.setText("i");
                        if (cr2 == 2) {
                            i += 1;
                            i_t.setVisibility(View.GONE);
                        }
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.i && v.getId() == R.id.correct6) {
                        cr2 += 1;
                        correct6.setText("i");
                        if (cr2 == 2) {
                            i += 1;
                            i_t.setVisibility(View.GONE);
                        }
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.u && v.getId() == R.id.correct3) {
                        cr3 += 1;
                        correct3.setText("u");
                        if (cr3 == 2) {
                            i += 1;
                            u_t.setVisibility(View.GONE);
                        }
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.u && v.getId() == R.id.correct8) {
                        cr3 += 1;
                        correct8.setText("u");
                        if (cr3 == 2) {
                            i += 1;
                            u_t.setVisibility(View.GONE);
                        }
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.e && v.getId() == R.id.correct4) {
                        cr4 += 1;
                        correct4.setText("e");
                        if (cr4 == 2) {
                            i += 1;
                            e_t.setVisibility(View.GONE);
                        }
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.e && v.getId() == R.id.correct7) {
                        cr4 += 1;
                        correct7.setText("e");
                        if (cr4 == 2) {
                            i += 1;
                            e_t.setVisibility(View.GONE);
                        }
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.o && v.getId() == R.id.correct5) {
                        cr5 += 1;
                        correct5.setText("o");
                        if (cr5 == 1) {
                            i += 1;
                            o_t.setVisibility(View.GONE);
                        }
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
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

        correct1 = findViewById(R.id.correct1);
        correct2 = findViewById(R.id.correct2);
        correct3 = findViewById(R.id.correct3);
        correct4 = findViewById(R.id.correct4);
        correct5 = findViewById(R.id.correct5);
        correct6 = findViewById(R.id.correct6);
        correct7 = findViewById(R.id.correct7);
        correct8 = findViewById(R.id.correct8);
        correct9 = findViewById(R.id.correct9);
        a_t = findViewById(R.id.a);
        e_t = findViewById(R.id.e);
        i_t = findViewById(R.id.i);
        o_t = findViewById(R.id.o);
        u_t = findViewById(R.id.u);
        next = findViewById(R.id.next);
        back = findViewById(R.id.back);

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(SeniorLiteracyActivity2.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(SeniorLiteracyActivity2.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(SeniorLiteracyActivity2.this, SeniorLiteracyActivity3.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(SeniorLiteracyActivity2.this, SeniorLiteracyActivity1.class));
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
        book_name_header.setText("Choose the correct vowels (Hold and Drag)");

    }

    private void redirectPage() {
        Intent intent = new Intent(SeniorLiteracyActivity2.this, RedirectPages.class);
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
                        stopService(new Intent(SeniorLiteracyActivity2.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorLiteracyActivity2.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorLiteracyActivity2.this, MusicService.class));
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
