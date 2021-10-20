package com.mariapublishers.digimariaandroid.activity.juniorkg.juniornumeracy;

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
import com.mariapublishers.digimariaandroid.activity.juniorkg.juniorliteracy.JuniorLiteracyActivity10;
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class JuniorNumeracyActivity4 extends BaseActivity implements View.OnClickListener {

    LinearLayout blue, yellow, green, red, bluedrop, yellowdrop, greendrop, reddrop;
    TextView blueans, yellowans, greenans, redans;
    CardView next, back;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junior_numeracy4);

        currentContext = JuniorNumeracyActivity4.this;

        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {

        blue.setOnLongClickListener(longClickListener);
        yellow.setOnLongClickListener(longClickListener);
        green.setOnLongClickListener(longClickListener);
        red.setOnLongClickListener(longClickListener);

        bluedrop.setOnDragListener(dragListenre);
        yellowdrop.setOnDragListener(dragListenre);
        greendrop.setOnDragListener(dragListenre);
        reddrop.setOnDragListener(dragListenre);

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
                    if (view.getId() == R.id.yellow && v.getId() == R.id.yellowdrop) {
                        yellow.setVisibility(View.GONE);
                        yellowans.setText("Ans: Yellow");
                        i += 1;
                        if (i == 4) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.blue && v.getId() == R.id.bluedrop) {
                        blue.setVisibility(View.GONE);
                        blueans.setText("Ans: Blue");
                        i += 1;
                        if (i == 4) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.green && v.getId() == R.id.greendrop) {
                        green.setVisibility(View.GONE);
                        greenans.setText("Ans: Green");
                        i += 1;
                        if (i == 4) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.red && v.getId() == R.id.reddrop) {
                        red.setVisibility(View.GONE);
                        redans.setText("Ans: Red");
                        i += 1;
                        if (i == 4) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer");
                    }
                    break;

            }
            return true;
        }
    };

    private void initialize() {

        blue = findViewById(R.id.blue);
        yellow = findViewById(R.id.yellow);
        green = findViewById(R.id.green);
        red = findViewById(R.id.red);
        bluedrop = findViewById(R.id.bluedrop);
        yellowdrop = findViewById(R.id.yellowdrop);
        greendrop = findViewById(R.id.greendrop);
        reddrop = findViewById(R.id.reddrop);
        blueans = findViewById(R.id.blueans);
        yellowans = findViewById(R.id.yellowans);
        greenans = findViewById(R.id.greenans);
        redans = findViewById(R.id.redans);
        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(JuniorNumeracyActivity4.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(JuniorNumeracyActivity4.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(JuniorNumeracyActivity4.this, JuniorNumeracyActivity5.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(JuniorNumeracyActivity4.this, JuniorNumeracyActivity3.class));
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
        book_name_header.setText("Look at the stack of colourful cubes carefully and answer the questions that follow");

    }

    private void redirectPage() {
        Intent intent = new Intent(JuniorNumeracyActivity4.this, RedirectPages.class);
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
                        stopService(new Intent(JuniorNumeracyActivity4.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(JuniorNumeracyActivity4.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(JuniorNumeracyActivity4.this, MusicService.class));
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
