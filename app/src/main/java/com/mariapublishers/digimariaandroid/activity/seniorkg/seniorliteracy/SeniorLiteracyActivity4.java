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

public class SeniorLiteracyActivity4 extends BaseActivity implements View.OnClickListener {

    TextView _1, _2, _3, _4, _5, _6, _7, _8, drop_1, drop_2, drop_3, drop_4, drop_5, drop_6, drop_7, drop_8;
    CardView back, next;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_literacy4);

        currentContext = SeniorLiteracyActivity4.this;

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

        drop_1.setOnDragListener(dragListenre);
        drop_2.setOnDragListener(dragListenre);
        drop_3.setOnDragListener(dragListenre);
        drop_4.setOnDragListener(dragListenre);
        drop_5.setOnDragListener(dragListenre);
        drop_6.setOnDragListener(dragListenre);
        drop_7.setOnDragListener(dragListenre);
        drop_8.setOnDragListener(dragListenre);

        next.setOnClickListener(this);
        back.setOnClickListener(this);

    }

    View.OnLongClickListener longClickListener = v -> {
        ClipData data = ClipData.newPlainText("", "");
        View.DragShadowBuilder shadow = new View.DragShadowBuilder(v);
        v.startDrag(data, shadow, v, 0);
        return false;
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
                    if (view.getId() == R.id._1 && v.getId() == R.id.drop_1) {
                        _1.setVisibility(View.INVISIBLE);
                        drop_1.setText(R.string.far);
                        i += 1;
                        if (i == 8) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id._2 && v.getId() == R.id.drop_2) {
                        _2.setVisibility(View.INVISIBLE);
                        drop_2.setText(R.string.near);
                        i += 1;
                        if (i == 8) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id._3 && v.getId() == R.id.drop_3) {
                        _3.setVisibility(View.INVISIBLE);
                        drop_3.setText(R.string.behind);
                        i += 1;
                        if (i == 8) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id._4 && v.getId() == R.id.drop_4) {
                        _4.setVisibility(View.INVISIBLE);
                        drop_4.setText(R.string.beside);
                        i += 1;
                        if (i == 8) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id._5 && v.getId() == R.id.drop_5) {
                        _5.setVisibility(View.INVISIBLE);
                        drop_5.setText(R.string.over);
                        i += 1;
                        if (i == 8) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id._6 && v.getId() == R.id.drop_6) {
                        _6.setVisibility(View.INVISIBLE);
                        drop_6.setText(R.string.under);
                        i += 1;
                        if (i == 8) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id._7 && v.getId() == R.id.drop_7) {
                        _7.setVisibility(View.INVISIBLE);
                        drop_7.setText(R.string.in);
                        i += 1;
                        if (i == 8) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id._8 && v.getId() == R.id.drop_8) {
                        _8.setVisibility(View.INVISIBLE);
                        drop_8.setText(R.string.on);
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

        _1 = findViewById(R.id._1);
        _2 = findViewById(R.id._2);
        _3 = findViewById(R.id._3);
        _4 = findViewById(R.id._4);
        _5 = findViewById(R.id._5);
        _6 = findViewById(R.id._6);
        _7 = findViewById(R.id._7);
        _8 = findViewById(R.id._8);

        drop_1 = findViewById(R.id.drop_1);
        drop_2 = findViewById(R.id.drop_2);
        drop_3 = findViewById(R.id.drop_3);
        drop_4 = findViewById(R.id.drop_4);
        drop_5 = findViewById(R.id.drop_5);
        drop_6 = findViewById(R.id.drop_6);
        drop_7 = findViewById(R.id.drop_7);
        drop_8 = findViewById(R.id.drop_8);

        next = findViewById(R.id.next);
        back = findViewById(R.id.back);

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(SeniorLiteracyActivity4.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(SeniorLiteracyActivity4.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(SeniorLiteracyActivity4.this, SeniorLiteracyActivity5.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(SeniorLiteracyActivity4.this, SeniorLiteracyActivity3.class));
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
        book_name_header.setText("Choose the correct positional words (Hold and Drag)");

    }

    private void redirectPage() {
        Intent intent = new Intent(SeniorLiteracyActivity4.this, RedirectPages.class);
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
                        stopService(new Intent(SeniorLiteracyActivity4.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorLiteracyActivity4.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorLiteracyActivity4.this, MusicService.class));
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
