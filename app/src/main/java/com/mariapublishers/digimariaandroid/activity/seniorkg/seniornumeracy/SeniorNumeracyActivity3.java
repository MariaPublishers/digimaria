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

public class SeniorNumeracyActivity3 extends BaseActivity implements View.OnClickListener {

    TextView _4, _6, _7, _13, drop_4, drop_6, drop_7, drop_13;
    ImageView bannerun3, cakeun3, birthdaycapun3, lollipopun3, giftun3;
    CardView back, next;
    int i = 0;
    SweetAlertDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_numeracy3);

        currentContext = SeniorNumeracyActivity3.this;

        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {

        _4.setOnLongClickListener(longClickListener);
        _6.setOnLongClickListener(longClickListener);
        _7.setOnLongClickListener(longClickListener);
        _13.setOnLongClickListener(longClickListener);

        drop_4.setOnDragListener(dragListenre);
        drop_6.setOnDragListener(dragListenre);
        drop_7.setOnDragListener(dragListenre);
        drop_13.setOnDragListener(dragListenre);

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
                    if (view.getId() == R.id._6 && v.getId() == R.id.drop_6) {
                        _6.setVisibility(View.INVISIBLE);
                        drop_6.setText(R.string._6);
                        i += 1;
                        if (i == 4) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id._7 && v.getId() == R.id.drop_7) {
                        _7.setVisibility(View.INVISIBLE);
                        drop_7.setText(R.string._7);
                        i += 1;
                        if (i == 4) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id._4 && v.getId() == R.id.drop_4) {
                        _4.setVisibility(View.INVISIBLE);
                        drop_4.setText(R.string._4);
                        i += 1;
                        if (i == 4) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id._13 && v.getId() == R.id.drop_13) {
                        _13.setVisibility(View.INVISIBLE);
                        drop_13.setText(R.string._13);
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

    private void initialize() {

        _4 = findViewById(R.id._4);
        _6 = findViewById(R.id._6);
        _7 = findViewById(R.id._7);
        _13 = findViewById(R.id._13);
        drop_4 = findViewById(R.id.drop_4);
        drop_6 = findViewById(R.id.drop_6);
        drop_7 = findViewById(R.id.drop_7);
        drop_13 = findViewById(R.id.drop_13);
        next = findViewById(R.id.next);
        back = findViewById(R.id.back);

        bannerun3 = findViewById(R.id.bannerun3);
        cakeun3 = findViewById(R.id.cakeun3);
        birthdaycapun3 = findViewById(R.id.birthdaycapun3);
        lollipopun3 = findViewById(R.id.lollipopun3);
        giftun3 = findViewById(R.id.giftun3);

        pDialog = new SweetAlertDialog(SeniorNumeracyActivity3.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading ...");
        pDialog.setCancelable(false);
        pDialog.show();

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/bannerun3.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(bannerun3);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/cakeun3.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(cakeun3);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/birthdaycapun3.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(birthdaycapun3);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/lollipopun3.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(lollipopun3);

        Glide.with(this)
                .load("https://digimaria.com/ERP/public/mobileasset/drawablexxxhdpi/drawablexxxhdpi/giftun3.png")
                .error(R.drawable.ic_sync_problem_black_24dp)
                .into(giftun3);

        pDialog.cancel();

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(SeniorNumeracyActivity3.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(SeniorNumeracyActivity3.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(SeniorNumeracyActivity3.this, SeniorNumeracyActivity4.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(SeniorNumeracyActivity3.this, SeniorNumeracyActivity2.class));
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
        book_name_header.setText("Sort and count (Hold and Drag)");

    }

    private void redirectPage() {
        Intent intent = new Intent(SeniorNumeracyActivity3.this, RedirectPages.class);
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
                        stopService(new Intent(SeniorNumeracyActivity3.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorNumeracyActivity3.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorNumeracyActivity3.this, MusicService.class));
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
