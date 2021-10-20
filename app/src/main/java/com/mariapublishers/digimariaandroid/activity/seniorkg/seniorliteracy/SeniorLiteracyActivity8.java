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

public class SeniorLiteracyActivity8 extends BaseActivity implements View.OnClickListener {

    TextView he_textview, your_textview, we_textview, she_textview;
    LinearLayout he_layout, your_layout, we_layout, she_layout;
    int i = 0;
    CardView she_card, he_card, your_card, our_card, we_card, you_card, she2_card, he2_card;
    CardView next, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_literacy8);
        currentContext = SeniorLiteracyActivity8.this;
        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void initialize() {

        she_card = findViewById(R.id.she_card);
        he_card = findViewById(R.id.he_card);
        your_card = findViewById(R.id.your_card);
        our_card = findViewById(R.id.our_card);
        we_card = findViewById(R.id.we_card);
        you_card = findViewById(R.id.you_card);
        she2_card = findViewById(R.id.she2_card);
        he2_card = findViewById(R.id.he2_card);

        he_textview = findViewById(R.id.he_textview);
        your_textview = findViewById(R.id.your_textview);
        we_textview = findViewById(R.id.we_textview);
        she_textview = findViewById(R.id.she_textview);

        he_layout = findViewById(R.id.he_layout);
        your_layout = findViewById(R.id.your_layout);
        we_layout = findViewById(R.id.we_layout);
        she_layout = findViewById(R.id.she_layout);


        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

    }


    private void onclickbtn() {

        she_card.setOnLongClickListener(longClickListener);
        he_card.setOnLongClickListener(longClickListener);
        your_card.setOnLongClickListener(longClickListener);
        our_card.setOnLongClickListener(longClickListener);
        we_card.setOnLongClickListener(longClickListener);
        you_card.setOnLongClickListener(longClickListener);
        she2_card.setOnLongClickListener(longClickListener);
        he2_card.setOnLongClickListener(longClickListener);

        he_layout.setOnDragListener(dragListenre);
        your_layout.setOnDragListener(dragListenre);
        we_layout.setOnDragListener(dragListenre);
        she_layout.setOnDragListener(dragListenre);


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
                    if (view.getId() == R.id.he_card && v.getId() == R.id.he_layout) {
                        //  he_card.setVisibility(View.INVISIBLE);
                        // she.setVisibility(View.VISIBLE);
                        he_card.setVisibility(View.GONE);
                        she_card.setVisibility(View.GONE);
                        he_textview.setText("He");
                        i += 1;
                        if (i == 4) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.your_card && v.getId() == R.id.your_layout) {
                        //   this2_card.setVisibility(View.INVISIBLE);
                        your_card.setVisibility(View.GONE);
                        our_card.setVisibility(View.GONE);
                        your_textview.setText("your");
                        i += 1;
                        if (i == 4) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.we_card && v.getId() == R.id.we_layout) {
                        // that_card.setVisibility(View.INVISIBLE);
                        we_card.setVisibility(View.GONE);
                        you_card.setVisibility(View.GONE);
                        we_textview.setText("We");
                        i += 1;
                        if (i == 4) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.she2_card && v.getId() == R.id.she_layout) {
                        //   these_card.setVisibility(View.INVISIBLE);
                        he2_card.setVisibility(View.GONE);
                        she2_card.setVisibility(View.GONE);
                        she_textview.setText("She");
                        i += 1;
                        if (i == 4) {
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


    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(SeniorLiteracyActivity8.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(SeniorLiteracyActivity8.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(SeniorLiteracyActivity8.this, SeniorLiteracyActivity9.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(SeniorLiteracyActivity8.this, SeniorLiteracyActivity7.class));
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
        book_name_header.setText("Complete the sentences (Hold and Drag)");

    }

    private void redirectPage() {
        Intent intent = new Intent(SeniorLiteracyActivity8.this, RedirectPages.class);
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
                        stopService(new Intent(SeniorLiteracyActivity8.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorLiteracyActivity8.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorLiteracyActivity8.this, MusicService.class));
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
