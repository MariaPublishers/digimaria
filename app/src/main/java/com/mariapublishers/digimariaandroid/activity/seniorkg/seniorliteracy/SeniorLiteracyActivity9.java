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
import com.mariapublishers.digimariaandroid.activity.juniorkg.juniorliteracy.JuniorLiteracyActivity10;
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class SeniorLiteracyActivity9 extends BaseActivity implements View.OnClickListener {

    TextView excuseme_textview, thankyou_textview;
    CardView next, back, thankyou_card, sorry_card, excuse_card, please_card;
    LinearLayout thankyou_layout, excuseme_layout;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_literacy9);
        currentContext = SeniorLiteracyActivity9.this;
        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }


    private void onclickbtn() {

        thankyou_card.setOnLongClickListener(longClickListener);
        sorry_card.setOnLongClickListener(longClickListener);
        excuse_card.setOnLongClickListener(longClickListener);
        please_card.setOnLongClickListener(longClickListener);
        thankyou_layout.setOnDragListener(dragListenre);
        excuseme_layout.setOnDragListener(dragListenre);
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
                    if (view.getId() == R.id.thankyou_card && v.getId() == R.id.thankyou_layout) {
                        thankyou_card.setVisibility(View.INVISIBLE);

                        thankyou_textview.setText("Thank You");
                        i += 1;
                        if (i == 2) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.excuse_card && v.getId() == R.id.excuseme_layout) {
                        excuse_card.setVisibility(View.INVISIBLE);
                        excuseme_textview.setText("Excuse Me");
                        i += 1;
                        if (i == 2) {
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

        thankyou_card = findViewById(R.id.thankyou_card);
        sorry_card = findViewById(R.id.sorry_card);
        excuse_card = findViewById(R.id.excuse_card);
        please_card = findViewById(R.id.please_card);

        thankyou_textview = findViewById(R.id.thankyou_textview);
        excuseme_textview = findViewById(R.id.excuseme_textview);

        thankyou_layout = findViewById(R.id.thankyou_layout);
        excuseme_layout = findViewById(R.id.excuseme_layout);


        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(SeniorLiteracyActivity9.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(SeniorLiteracyActivity9.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(SeniorLiteracyActivity9.this, SeniorLiteracyWorksheet4.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(SeniorLiteracyActivity9.this, SeniorLiteracyActivity8.class));
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
        book_name_header.setText("Choose the correct magic words (Hold and Drag)");

    }

    private void redirectPage() {
        Intent intent = new Intent(SeniorLiteracyActivity9.this, RedirectPages.class);
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
                        stopService(new Intent(SeniorLiteracyActivity9.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorLiteracyActivity9.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorLiteracyActivity9.this, MusicService.class));
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
