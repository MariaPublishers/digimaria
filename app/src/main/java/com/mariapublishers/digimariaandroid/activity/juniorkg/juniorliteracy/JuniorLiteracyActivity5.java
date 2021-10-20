package com.mariapublishers.digimariaandroid.activity.juniorkg.juniorliteracy;

import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class JuniorLiteracyActivity5 extends BaseActivity {

    TextView d_drop, p_drop, n_drop, c_drop, t_drop;
    CardView next, back, dog, pig, camel, nest, tub;
    RelativeLayout rl1;
    int k = 0, i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junior_literacy5);

        currentContext = JuniorLiteracyActivity5.this;

        callFunc();
        
    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();
        ondragbtn();

    }

    private void onclickbtn() {

        dog.setOnLongClickListener(longClickListener);
        pig.setOnLongClickListener(longClickListener);
        camel.setOnLongClickListener(longClickListener);
        nest.setOnLongClickListener(longClickListener);
        tub.setOnLongClickListener(longClickListener);

    }

    private void ondragbtn() {

        d_drop.setOnDragListener(dragListenre);
        p_drop.setOnDragListener(dragListenre);
        n_drop.setOnDragListener(dragListenre);
        c_drop.setOnDragListener(dragListenre);
        t_drop.setOnDragListener(dragListenre);
        next.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.back) {
                onclickBack();
            } else if (v.getId() == R.id.next) {
                onclickNext();
            }
        }
    };

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
                    if (view.getId() == R.id.dog && v.getId() == R.id.d_drop) {
                        dog.setVisibility(View.GONE);
                        d_drop.setText("D");
                        i += 1;
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.pig && v.getId() == R.id.p_drop) {
                        pig.setVisibility(View.GONE);
                        p_drop.setText("P");
                        i += 1;
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.nest && v.getId() == R.id.n_drop) {
                        nest.setVisibility(View.GONE);
                        n_drop.setText("N");
                        i += 1;
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.camel && v.getId() == R.id.c_drop) {
                        camel.setVisibility(View.GONE);
                        c_drop.setText("C");
                        i += 1;
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.tub && v.getId() == R.id.t_drop) {
                        tub.setVisibility(View.GONE);
                        t_drop.setText("T");
                        i += 1;
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Drop the letter on the correct box.");
                    }
                    break;

            }
            return true;
        }
    };

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(JuniorLiteracyActivity5.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(JuniorLiteracyActivity5.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(JuniorLiteracyActivity5.this, JuniorLiteracyActivity6.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(JuniorLiteracyActivity5.this, JuniorLiteracyActivity4.class));
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
        book_name_header.setText("Look at the pictures and write the first letter to complete the puzzle (Hold & Drag)");

    }

    private void redirectPage() {
        Intent intent = new Intent(JuniorLiteracyActivity5.this, RedirectPages.class);
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
                        stopService(new Intent(JuniorLiteracyActivity5.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(JuniorLiteracyActivity5.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(JuniorLiteracyActivity5.this, MusicService.class));
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

        d_drop = findViewById(R.id.d_drop);
        p_drop = findViewById(R.id.p_drop);
        n_drop = findViewById(R.id.n_drop);
        c_drop = findViewById(R.id.c_drop);
        t_drop = findViewById(R.id.t_drop);
        tub = findViewById(R.id.tub);
        dog = findViewById(R.id.dog);
        pig = findViewById(R.id.pig);
        camel = findViewById(R.id.camel);
        nest = findViewById(R.id.nest);
        next = findViewById(R.id.next);
        back = findViewById(R.id.back);
        rl1 = findViewById(R.id.rl1);

    }

}
