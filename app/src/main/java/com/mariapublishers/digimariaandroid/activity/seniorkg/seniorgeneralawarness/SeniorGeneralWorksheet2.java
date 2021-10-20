package com.mariapublishers.digimariaandroid.activity.seniorkg.seniorgeneralawarness;

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

public class SeniorGeneralWorksheet2 extends BaseActivity implements View.OnClickListener {

    CardView next, back, school, hospital, library, bank, fire_station, fire_vi, hospital_vi, school_vi, library_vi, bank_vi;
    LinearLayout school_drop, hospital_drop, library_drop, bank_drop, fire_station_drop;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_general_worksheet2);

        currentContext = SeniorGeneralWorksheet2.this;

        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {

        bank.setOnLongClickListener(longClickListener);
        fire_station.setOnLongClickListener(longClickListener);
        school.setOnLongClickListener(longClickListener);
        hospital.setOnLongClickListener(longClickListener);
        library.setOnLongClickListener(longClickListener);

        school_drop.setOnDragListener(dragListenre);
        hospital_drop.setOnDragListener(dragListenre);
        library_drop.setOnDragListener(dragListenre);
        bank_drop.setOnDragListener(dragListenre);
        fire_station_drop.setOnDragListener(dragListenre);

        back.setOnClickListener(this);
        next.setOnClickListener(this);

    }

    View.OnLongClickListener longClickListener = v -> {
        ClipData data = ClipData.newPlainText("", "");
        View.DragShadowBuilder shadow = new View.DragShadowBuilder(v);
        v.startDrag(data, shadow, v, 0);
        return false;
    };

    View.OnDragListener dragListenre = (v, event) -> {
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
                if (view.getId() == R.id.school && v.getId() == R.id.school_drop) {
                    school.setVisibility(View.INVISIBLE);
                    school_vi.setVisibility(View.VISIBLE);
                    i += 1;
                    if (i == 5) {
                        alertMessage(1, "Hurray!", "Activity Cleared.");
                    }
                } else if (view.getId() == R.id.hospital && v.getId() == R.id.hospital_drop) {
                    hospital.setVisibility(View.INVISIBLE);
                    hospital_vi.setVisibility(View.VISIBLE);
                    i += 1;
                    if (i == 5) {
                        alertMessage(1, "Hurray!", "Activity Cleared.");
                    }
                } else if (view.getId() == R.id.library && v.getId() == R.id.library_drop) {
                    library.setVisibility(View.INVISIBLE);
                    library_vi.setVisibility(View.VISIBLE);
                    i += 1;
                    if (i == 5) {
                        alertMessage(1, "Hurray!", "Activity Cleared.");
                    }
                } else if (view.getId() == R.id.bank && v.getId() == R.id.bank_drop) {
                    bank.setVisibility(View.INVISIBLE);
                    bank_vi.setVisibility(View.VISIBLE);
                    i += 1;
                    if (i == 5) {
                        alertMessage(1, "Hurray!", "Activity Cleared.");
                    }
                } else if (view.getId() == R.id.fire_station && v.getId() == R.id.fire_station_drop) {
                    fire_station.setVisibility(View.INVISIBLE);
                    fire_vi.setVisibility(View.VISIBLE);
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
    };

    private void initialize() {

        school = findViewById(R.id.school);
        hospital = findViewById(R.id.hospital);
        library = findViewById(R.id.library);
        bank = findViewById(R.id.bank);
        fire_station = findViewById(R.id.fire_station);
        fire_vi = findViewById(R.id.fire_vi);
        hospital_vi = findViewById(R.id.hospital_vi);
        school_vi = findViewById(R.id.school_vi);
        library_vi = findViewById(R.id.library_vi);
        bank_vi = findViewById(R.id.bank_vi);
        school_drop = findViewById(R.id.school_drop);
        hospital_drop = findViewById(R.id.hospital_drop);
        library_drop = findViewById(R.id.library_drop);
        bank_drop = findViewById(R.id.bank_drop);
        fire_station_drop = findViewById(R.id.fire_station_drop);
        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(SeniorGeneralWorksheet2.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(SeniorGeneralWorksheet2.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(SeniorGeneralWorksheet2.this, SeniorGeneralWorksheet3.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(SeniorGeneralWorksheet2.this, SeniorGeneralWorksheet1.class));
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
        book_name_header.setText("Places and their names (Hold & Drag)");

    }

    private void redirectPage() {
        Intent intent = new Intent(SeniorGeneralWorksheet2.this, RedirectPages.class);
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
                        stopService(new Intent(SeniorGeneralWorksheet2.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorGeneralWorksheet2.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorGeneralWorksheet2.this, MusicService.class));
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