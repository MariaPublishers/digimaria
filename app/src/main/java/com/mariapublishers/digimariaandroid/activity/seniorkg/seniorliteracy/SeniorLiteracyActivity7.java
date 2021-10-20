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

public class SeniorLiteracyActivity7 extends BaseActivity implements View.OnClickListener {

    TextView that_textview, this_textview, those_textview, this2_textview, these_textview;
    CardView next, back, this_card, this2_card, that_card, these_card, those_card;
    LinearLayout this_layout, that_layout, these_layout, those_layout, this2_layout;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_literacy7);
        currentContext = SeniorLiteracyActivity7.this;
        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }


    private void onclickbtn() {

        this2_card.setOnLongClickListener(longClickListener);
        this_card.setOnLongClickListener(longClickListener);
        that_card.setOnLongClickListener(longClickListener);
        these_card.setOnLongClickListener(longClickListener);
        those_card.setOnLongClickListener(longClickListener);

        this_layout.setOnDragListener(dragListenre);
        that_layout.setOnDragListener(dragListenre);
        these_layout.setOnDragListener(dragListenre);
        those_layout.setOnDragListener(dragListenre);
        this2_layout.setOnDragListener(dragListenre);


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
                    if (view.getId() == R.id.this_card && v.getId() == R.id.this_layout) {
                        this_card.setVisibility(View.INVISIBLE);
                        this2_card.setVisibility(View.VISIBLE);
                        this_textview.setText("This");
                        i += 1;
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.this2_card && v.getId() == R.id.this2_layout) {
                        this2_card.setVisibility(View.INVISIBLE);
                        this2_textview.setText("This");
                        i += 1;
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.that_card && v.getId() == R.id.that_layout) {
                        that_card.setVisibility(View.INVISIBLE);
                        that_textview.setText("That");
                        i += 1;
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.these_card && v.getId() == R.id.these_layout) {
                        these_card.setVisibility(View.INVISIBLE);
                        these_textview.setText("these");
                        i += 1;
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.those_card && v.getId() == R.id.those_layout) {
                        those_card.setVisibility(View.INVISIBLE);
                        those_textview.setText("those");
                        i += 1;
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

        this_card = findViewById(R.id.this_card);
        this2_card = findViewById(R.id.this2_card);
        those_card = findViewById(R.id.those_card);
        that_card = findViewById(R.id.that_card);
        these_card = findViewById(R.id.these_card);

        this_textview = findViewById(R.id.this_textview);
        this2_textview = findViewById(R.id.this2_textview);
        that_textview = findViewById(R.id.that_textview);
        those_textview = findViewById(R.id.those_textview);
        these_textview = findViewById(R.id.these_textview);


        this_layout = findViewById(R.id.this_layout);
        this2_layout = findViewById(R.id.this2_layout);
        those_layout = findViewById(R.id.those_layout);
        that_layout = findViewById(R.id.that_layout);
        these_layout = findViewById(R.id.these_layout);

        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(SeniorLiteracyActivity7.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(SeniorLiteracyActivity7.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(SeniorLiteracyActivity7.this, SeniorLiteracyActivity8.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(SeniorLiteracyActivity7.this, SeniorLiteracyActivity6.class));
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
        book_name_header.setText("Choose the correct pronoun");

    }

    private void redirectPage() {
        Intent intent = new Intent(SeniorLiteracyActivity7.this, RedirectPages.class);
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
                        stopService(new Intent(SeniorLiteracyActivity7.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorLiteracyActivity7.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorLiteracyActivity7.this, MusicService.class));
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