package com.mariapublishers.digimariaandroid.activity.seniorkg.seniorliteracy;

import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class SeniorLiteracyActivity6 extends BaseActivity implements View.OnClickListener {

    TextView key_textview, jam_textview;
    CardView next, back, key_card, Jam_card, white_card;
    LinearLayout lockkey, breadjam, blackwhite, saltpepper, penpencil, bridegroom, batball, cupsaucer;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_literacy6);
        currentContext = SeniorLiteracyActivity6.this;
        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    CardView saucer_card, Pepper_card, Pencil_card, groom_card, ball_card;
    TextView white_textview, pepper_textview, pencil_textview, groom_textview, ball_textview, saucer_textview;

    private void onclickbtn() {

        key_card.setOnLongClickListener(longClickListener);
        Jam_card.setOnLongClickListener(longClickListener);
        white_card.setOnLongClickListener(longClickListener);
        saucer_card.setOnLongClickListener(longClickListener);
        Pepper_card.setOnLongClickListener(longClickListener);
        Pencil_card.setOnLongClickListener(longClickListener);
        groom_card.setOnLongClickListener(longClickListener);
        ball_card.setOnLongClickListener(longClickListener);

        lockkey.setOnDragListener(dragListenre);
        breadjam.setOnDragListener(dragListenre);
        blackwhite.setOnDragListener(dragListenre);
        saltpepper.setOnDragListener(dragListenre);
        penpencil.setOnDragListener(dragListenre);
        bridegroom.setOnDragListener(dragListenre);
        batball.setOnDragListener(dragListenre);
        cupsaucer.setOnDragListener(dragListenre);

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
                    if (view.getId() == R.id.key_card && v.getId() == R.id.lockkey) {
                        key_card.setVisibility(View.GONE);
                        key_textview.setText("Key");
                        i += 1;
                        if (i == 8) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.Jam_card && v.getId() == R.id.breadjam) {
                        Jam_card.setVisibility(View.GONE);
                        jam_textview.setText("Jam");
                        i += 1;
                        if (i == 8) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.white_card && v.getId() == R.id.blackwhite) {
                        white_card.setVisibility(View.GONE);
                        white_textview.setText("White");
                        i += 1;
                        if (i == 8) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.Pepper_card && v.getId() == R.id.saltpepper) {
                        Pepper_card.setVisibility(View.GONE);
                        pepper_textview.setText("Pepper");
                        i += 1;
                        if (i == 8) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.Pencil_card && v.getId() == R.id.penpencil) {
                        Pencil_card.setVisibility(View.GONE);
                        pencil_textview.setText("Pencil");
                        i += 1;
                        if (i == 8) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.groom_card && v.getId() == R.id.bridegroom) {
                        groom_card.setVisibility(View.GONE);
                        groom_textview.setText("Groom");
                        i += 1;
                        if (i == 8) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.ball_card && v.getId() == R.id.batball) {
                        ball_card.setVisibility(View.GONE);
                        ball_textview.setText("Ball");
                        i += 1;
                        if (i == 8) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.saucer_card && v.getId() == R.id.cupsaucer) {
                        saucer_card.setVisibility(View.GONE);
                        saucer_textview.setText("Saucer");
                        i += 1;
                        if (i == 8) {
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

        key_card = findViewById(R.id.key_card);
        Jam_card = findViewById(R.id.Jam_card);
        white_card = findViewById(R.id.white_card);
        saucer_card = findViewById(R.id.saucer_card);
        Pepper_card = findViewById(R.id.Pepper_card);
        Pencil_card = findViewById(R.id.Pencil_card);
        groom_card = findViewById(R.id.groom_card);
        ball_card = findViewById(R.id.ball_card);

        key_textview = findViewById(R.id.key_textview);
        jam_textview = findViewById(R.id.jam_textview);
        white_textview = findViewById(R.id.white_textview);
        pepper_textview = findViewById(R.id.pepper_textview);
        pencil_textview = findViewById(R.id.pencil_textview);
        groom_textview = findViewById(R.id.groom_textview);
        ball_textview = findViewById(R.id.ball_textview);
        saucer_textview = findViewById(R.id.saucer_textview);

        lockkey = findViewById(R.id.lockkey);
        breadjam = findViewById(R.id.breadjam);
        blackwhite = findViewById(R.id.blackwhite);
        saltpepper = findViewById(R.id.saltpepper);
        penpencil = findViewById(R.id.penpencil);
        bridegroom = findViewById(R.id.bridegroom);
        batball = findViewById(R.id.batball);
        cupsaucer = findViewById(R.id.cupsaucer);

        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(SeniorLiteracyActivity6.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(SeniorLiteracyActivity6.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(SeniorLiteracyActivity6.this, SeniorLiteracyActivity7.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(SeniorLiteracyActivity6.this, SeniorLiteracyActivity5.class));
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
        book_name_header.setText("Form exact pairs (Hold and Drag)");

    }

    private void redirectPage() {
        Intent intent = new Intent(SeniorLiteracyActivity6.this, RedirectPages.class);
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
                        stopService(new Intent(SeniorLiteracyActivity6.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorLiteracyActivity6.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorLiteracyActivity6.this, MusicService.class));
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
        if (v.getId() == R.id.back) {
            onclickBack();
        } else if (v.getId() == R.id.next) {
            onclickNext();
        }
    }
}