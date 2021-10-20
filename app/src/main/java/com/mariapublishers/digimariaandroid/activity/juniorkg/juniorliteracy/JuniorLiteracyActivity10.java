package com.mariapublishers.digimariaandroid.activity.juniorkg.juniorliteracy;

import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class JuniorLiteracyActivity10 extends BaseActivity {

    private static final String TAG = JuniorLiteracyActivity1.class.getSimpleName();
    TextView cook, exercise, brush, play, read, climb, cook_txt, exercise_txt, brush_txt, read_txt, play_txt, climb_txt;
    LinearLayout climb_lay, cooking_lay, brush_lay, exercise_lay, play_lay, read_lay;
    CardView back;
    int fin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junior_literacy10);

        currentContext = JuniorLiteracyActivity10.this;

        cook = findViewById(R.id.cook);
        exercise = findViewById(R.id.exercise);
        brush = findViewById(R.id.brush);
        play = findViewById(R.id.play);
        read = findViewById(R.id.read);
        climb = findViewById(R.id.climb);

        cook_txt = findViewById(R.id.cook_txt);
        exercise_txt = findViewById(R.id.exercise_txt);
        brush_txt = findViewById(R.id.brush_txt);
        read_txt = findViewById(R.id.read_txt);
        play_txt = findViewById(R.id.play_txt);
        climb_txt = findViewById(R.id.climb_txt);

        climb_lay = findViewById(R.id.climb_lay);
        cooking_lay = findViewById(R.id.cooking_lay);
        brush_lay = findViewById(R.id.brush_lay);
        exercise_lay = findViewById(R.id.exercise_lay);
        play_lay = findViewById(R.id.play_lay);
        read_lay = findViewById(R.id.read_lay);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JuniorLiteracyActivity10.this, JuniorLiteracyActivity9.class);
                intent.putExtra("bookid", pref.getClassid());
                startActivity(intent);
                finish();
            }
        });

        climb_lay.setOnDragListener(dragListenre);
        cooking_lay.setOnDragListener(dragListenre);
        brush_lay.setOnDragListener(dragListenre);
        exercise_lay.setOnDragListener(dragListenre);
        play_lay.setOnDragListener(dragListenre);
        read_lay.setOnDragListener(dragListenre);

        cook.setOnLongClickListener(longClickListener);
        exercise.setOnLongClickListener(longClickListener);
        brush.setOnLongClickListener(longClickListener);
        read.setOnLongClickListener(longClickListener);
        play.setOnLongClickListener(longClickListener);
        climb.setOnLongClickListener(longClickListener);

        actionbar();
        musiccontrol();
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
                        stopService(new Intent(JuniorLiteracyActivity10.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(JuniorLiteracyActivity10.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(JuniorLiteracyActivity10.this, MusicService.class));
                }


            }
        });

        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }

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
        book_name_header.setText("Hold and drag the correct action word (Hold and Drag)");

    }

    private void redirectPage() {
        Intent intent = new Intent(JuniorLiteracyActivity10.this, RedirectPages.class);
        intent.putExtra("type", "activity");
        startActivity(intent);
        finish();
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
                    if (view.getId() == R.id.climb && v.getId() == R.id.climb_lay) {
                        climb.setVisibility(View.GONE);
                        climb_txt.setText("climb");
                        fin += 1;
                        if (fin == 6) {
                            toBack();
                        }
                    } else if (view.getId() == R.id.play && v.getId() == R.id.play_lay) {
                        play.setVisibility(View.GONE);
                        play_txt.setText("play");
                        fin += 1;
                        if (fin == 6) {
                            toBack();
                        }
                    } else if (view.getId() == R.id.read && v.getId() == R.id.read_lay) {
                        read.setVisibility(View.GONE);
                        read_txt.setText("read");
                        fin += 1;
                        if (fin == 6) {
                            toBack();
                        }
                    } else if (view.getId() == R.id.brush && v.getId() == R.id.brush_lay) {
                        brush.setVisibility(View.GONE);
                        brush_txt.setText("brush");
                        fin += 1;
                        if (fin == 6) {
                            toBack();
                        }
                    } else if (view.getId() == R.id.exercise && v.getId() == R.id.exercise_lay) {
                        exercise.setVisibility(View.GONE);
                        exercise_txt.setText("exercise");
                        fin += 1;
                        if (fin == 6) {
                            toBack();
                        }
                    } else if (view.getId() == R.id.cook && v.getId() == R.id.cooking_lay) {
                        cook.setVisibility(View.GONE);
                        cook_txt.setText("cook");
                        fin += 1;
                        if (fin == 6) {
                            toBack();
                        }
                    } else {
                        alertError();
                    }
                    break;

            }
            return true;
        }
    };

    public void alertError() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wrong);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(JuniorLiteracyActivity10.this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setConfirmText("OK")
                .setContentText("Drop on the right box.")
                .show();
    }

    public void toBack() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(JuniorLiteracyActivity10.this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Hurray!")
                .setContentText("Activity Cleared.")
                .setConfirmText("OK")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        Intent intent = new Intent(JuniorLiteracyActivity10.this, RedirectPages.class);
                        intent.putExtra("type", "activity");
                        startActivity(intent);
                        finish();
                    }
                })
                .show();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(JuniorLiteracyActivity10.this, JuniorLiteracyActivity9.class);
        intent.putExtra("bookid", pref.getClassid());
        startActivity(intent);
        finish();
    }

}
