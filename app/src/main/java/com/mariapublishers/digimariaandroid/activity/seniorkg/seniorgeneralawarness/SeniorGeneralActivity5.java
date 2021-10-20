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

public class SeniorGeneralActivity5 extends BaseActivity implements View.OnClickListener {

    LinearLayout pig, pig_d, piglet, piglet_d, goat, goat_d, kid, kid_d, cow, cow_d, calf, calf_d,
            hen, hen_d, chick, chick_d, dog, dog_d, puppy, puppy_d;
    TextView pigi, pigg, pigleti, pigletg, pigletl, piglete, piglett, goato, goata, goatt, kidi, kidd, cowo, coww,
            calfa, calfl, calff, hene, henn, chickh, chicki, chickc, chickk, dogo, dogg, puppyu, puppyp, puppypp, puppyy;
    int one = 0, two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0, nine = 0, ten = 0, i = 0;
    CardView next, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_general5);

        currentContext = SeniorGeneralActivity5.this;

        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {

        pig.setOnLongClickListener(longClickListener);
        piglet.setOnLongClickListener(longClickListener);
        goat.setOnLongClickListener(longClickListener);
        kid.setOnLongClickListener(longClickListener);
        cow.setOnLongClickListener(longClickListener);
        calf.setOnLongClickListener(longClickListener);
        hen.setOnLongClickListener(longClickListener);
        chick.setOnLongClickListener(longClickListener);
        dog.setOnLongClickListener(longClickListener);
        puppy.setOnLongClickListener(longClickListener);

        dog_d.setOnDragListener(dragListenre);
        puppy_d.setOnDragListener(dragListenre);
        chick_d.setOnDragListener(dragListenre);
        hen_d.setOnDragListener(dragListenre);
        calf_d.setOnDragListener(dragListenre);
        cow_d.setOnDragListener(dragListenre);
        kid_d.setOnDragListener(dragListenre);
        goat_d.setOnDragListener(dragListenre);
        piglet_d.setOnDragListener(dragListenre);
        pig_d.setOnDragListener(dragListenre);

        next.setOnClickListener(this);
        back.setOnClickListener(this);

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
                if (view.getId() == R.id.pig && v.getId() == R.id.pig_d) {
                    if (one == 0) {
                        pigi.setText(R.string.i);
                        pigg.setText(R.string.g);
                        one += 1;
                        i += 1;
                        pig.setVisibility(View.GONE);
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.piglet && v.getId() == R.id.piglet_d) {
                    if (two == 0) {
                        pigleti.setText(R.string.i);
                        pigletg.setText(R.string.g);
                        pigletl.setText(R.string.l);
                        piglete.setText(R.string.e);
                        piglett.setText(R.string.t);
                        two += 1;
                        i += 1;
                        piglet.setVisibility(View.GONE);
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.goat && v.getId() == R.id.goat_d) {
                    if (three == 0) {
                        goato.setText(R.string.o);
                        goata.setText(R.string.a);
                        goatt.setText(R.string.t);
                        three += 1;
                        i += 1;
                        goat.setVisibility(View.GONE);
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.kid && v.getId() == R.id.kid_d) {
                    if (four == 0) {
                        kidi.setText(R.string.i);
                        kidd.setText(R.string.d);
                        four += 1;
                        i += 1;
                        kid.setVisibility(View.GONE);
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.cow && v.getId() == R.id.cow_d) {
                    if (five == 0) {
                        cowo.setText(R.string.o);
                        coww.setText(R.string.w);
                        five += 1;
                        i += 1;
                        cow.setVisibility(View.GONE);
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.calf && v.getId() == R.id.calf_d) {
                    if (six == 0) {
                        calfa.setText(R.string.a);
                        calfl.setText(R.string.l);
                        calff.setText(R.string.f);
                        six += 1;
                        i += 1;
                        calf.setVisibility(View.GONE);
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.hen && v.getId() == R.id.hen_d) {
                    if (seven == 0) {
                        hene.setText(R.string.e);
                        henn.setText(R.string.n);
                        seven += 1;
                        i += 1;
                        hen.setVisibility(View.GONE);
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.chick && v.getId() == R.id.chick_d) {
                    if (eight == 0) {
                        chickh.setText(R.string.h);
                        chicki.setText(R.string.i);
                        chickc.setText(R.string.c);
                        chickk.setText(R.string.k);
                        eight += 1;
                        i += 1;
                        chick.setVisibility(View.GONE);
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.dog && v.getId() == R.id.dog_d) {
                    if (nine == 0) {
                        dogo.setText(R.string.o);
                        dogg.setText(R.string.g);
                        nine += 1;
                        i += 1;
                        dog.setVisibility(View.GONE);
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else if (view.getId() == R.id.puppy && v.getId() == R.id.puppy_d) {
                    if (ten == 0) {
                        puppyu.setText(R.string.u);
                        puppyp.setText(R.string.p);
                        puppypp.setText(R.string.p);
                        puppyy.setText(R.string.y);
                        ten += 1;
                        i += 1;
                        puppy.setVisibility(View.GONE);
                        if (i == 10) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Choose the right answer.");
                    }
                } else {
                    alertMessage(2, "Oops...", "Choose the right answer.");
                }
                break;

        }
        return true;
    };

    private void actionbar() {

        ImageView toback = findViewById(R.id.toback);

        toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectPage();
            }
        });

        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Animals and their young one's (Hold & Drag)");

    }

    private void redirectPage() {
        Intent intent = new Intent(SeniorGeneralActivity5.this, RedirectPages.class);
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
                        stopService(new Intent(SeniorGeneralActivity5.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorGeneralActivity5.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorGeneralActivity5.this, MusicService.class));
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

        pig = findViewById(R.id.pig);
        pig_d = findViewById(R.id.pig_d);
        piglet = findViewById(R.id.piglet);
        piglet_d = findViewById(R.id.piglet_d);
        goat = findViewById(R.id.goat);
        goat_d = findViewById(R.id.goat_d);
        kid = findViewById(R.id.kid);
        kid_d = findViewById(R.id.kid_d);
        cow = findViewById(R.id.cow);
        cow_d = findViewById(R.id.cow_d);
        calf = findViewById(R.id.calf);
        calf_d = findViewById(R.id.calf_d);
        hen = findViewById(R.id.hen);
        hen_d = findViewById(R.id.hen_d);
        chick = findViewById(R.id.chick);
        chick_d = findViewById(R.id.chick_d);
        dog = findViewById(R.id.dog);
        dog_d = findViewById(R.id.dog_d);
        puppy = findViewById(R.id.puppy);
        puppy_d = findViewById(R.id.puppy_d);

        pigi = findViewById(R.id.pigi);
        pigg = findViewById(R.id.pigg);
        pigleti = findViewById(R.id.pigleti);
        pigletg = findViewById(R.id.pigletg);
        pigletl = findViewById(R.id.pigletl);
        piglete = findViewById(R.id.piglete);
        piglett = findViewById(R.id.piglett);
        goato = findViewById(R.id.goato);
        goata = findViewById(R.id.goata);
        goatt = findViewById(R.id.goatt);
        kidi = findViewById(R.id.kidi);
        kidd = findViewById(R.id.kidd);
        cowo = findViewById(R.id.cowo);
        coww = findViewById(R.id.coww);
        calfa = findViewById(R.id.calfa);
        calfl = findViewById(R.id.calfl);
        calff = findViewById(R.id.calff);
        hene = findViewById(R.id.hene);
        henn = findViewById(R.id.henn);
        chickh = findViewById(R.id.chickh);
        chicki = findViewById(R.id.chicki);
        chickc = findViewById(R.id.chickc);
        chickk = findViewById(R.id.chickk);
        dogo = findViewById(R.id.dogo);
        dogg = findViewById(R.id.dogg);
        puppyu = findViewById(R.id.puppyu);
        puppyp = findViewById(R.id.puppyp);
        puppypp = findViewById(R.id.puppypp);
        puppyy = findViewById(R.id.puppyy);

        next = findViewById(R.id.next);
        back = findViewById(R.id.back);

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(SeniorGeneralActivity5.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(SeniorGeneralActivity5.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(SeniorGeneralActivity5.this, SeniorGeneralActivity6.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(SeniorGeneralActivity5.this, SeniorGeneralActivity4.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        onclickBack();
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
