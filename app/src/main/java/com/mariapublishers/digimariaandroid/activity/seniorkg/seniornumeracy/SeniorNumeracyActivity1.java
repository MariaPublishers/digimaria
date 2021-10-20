package com.mariapublishers.digimariaandroid.activity.seniorkg.seniornumeracy;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.juniorkg.juniorliteracy.JuniorLiteracyActivity10;
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.activity.nursery.nurserynumeracy.NurseryNumeracyActivity2;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class SeniorNumeracyActivity1 extends BaseActivity implements View.OnClickListener {

    TextView _25, _43, _74, _67, _89, drop_25, drop_43, drop_74, drop_67, drop_89;
    ImageView train;
    CardView back, next;
    int i = 0;
    SweetAlertDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_numeracy1);

        currentContext = SeniorNumeracyActivity1.this;

        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {

        _25.setOnLongClickListener(longClickListener);
        _43.setOnLongClickListener(longClickListener);
        _74.setOnLongClickListener(longClickListener);
        _67.setOnLongClickListener(longClickListener);
        _89.setOnLongClickListener(longClickListener);

        drop_25.setOnDragListener(dragListenre);
        drop_43.setOnDragListener(dragListenre);
        drop_74.setOnDragListener(dragListenre);
        drop_67.setOnDragListener(dragListenre);
        drop_89.setOnDragListener(dragListenre);

        next.setOnClickListener(this);

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
                    if (view.getId() == R.id._25 && v.getId() == R.id.drop_25) {
                        _25.setVisibility(View.INVISIBLE);
                        drop_25.setText(R.string._25);
                        i += 1;
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id._43 && v.getId() == R.id.drop_43) {
                        _43.setVisibility(View.INVISIBLE);
                        drop_43.setText(R.string._43);
                        i += 1;
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id._74 && v.getId() == R.id.drop_74) {
                        _74.setVisibility(View.INVISIBLE);
                        drop_74.setText(R.string._74);
                        i += 1;
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id._67 && v.getId() == R.id.drop_67) {
                        _67.setVisibility(View.INVISIBLE);
                        drop_67.setText(R.string._67);
                        i += 1;
                        if (i == 5) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id._89 && v.getId() == R.id.drop_89) {
                        _89.setVisibility(View.INVISIBLE);
                        drop_89.setText(R.string._89);
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

        _25 = findViewById(R.id._25);
        _43 = findViewById(R.id._43);
        _74 = findViewById(R.id._74);
        _67 = findViewById(R.id._67);
        _89 = findViewById(R.id._89);
        drop_25 = findViewById(R.id.drop_25);
        drop_43 = findViewById(R.id.drop_43);
        drop_74 = findViewById(R.id.drop_74);
        drop_67 = findViewById(R.id.drop_67);
        drop_89 = findViewById(R.id.drop_89);
        next = findViewById(R.id.next);

        train = findViewById(R.id.train);

        pDialog = new SweetAlertDialog(SeniorNumeracyActivity1.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading ...");
        pDialog.setCancelable(false);
        pDialog.show();

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/trainun1.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(train);

        pDialog.cancel();

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(SeniorNumeracyActivity1.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(SeniorNumeracyActivity1.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(SeniorNumeracyActivity1.this, SeniorNumeracyActivity2.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        redirectPage();
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
        book_name_header.setText("Find the correct number sequences (Hold and Drag)");

    }

    private void redirectPage() {
        Intent intent = new Intent(SeniorNumeracyActivity1.this, RedirectPages.class);
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
                        stopService(new Intent(SeniorNumeracyActivity1.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorNumeracyActivity1.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorNumeracyActivity1.this, MusicService.class));
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
        }
    }
}
