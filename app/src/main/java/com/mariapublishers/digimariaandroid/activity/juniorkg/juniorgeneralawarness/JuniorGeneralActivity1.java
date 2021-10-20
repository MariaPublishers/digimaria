package com.mariapublishers.digimariaandroid.activity.juniorkg.juniorgeneralawarness;

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

public class JuniorGeneralActivity1 extends BaseActivity implements View.OnClickListener {

    CardView next, run, walk, eat, sing, write, cook, jump, dance, drink, walk_vi, eat_vi, run_vi, write_vi, sing_vi, cook_vi, drink_vi, jump_vi, dance_vi;
    LinearLayout walk_drop, eat_drop, run_drop, write_drop, sing_drop, cook_drop, drink_drop, jump_drop, dance_drop;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junior_general1);

        currentContext = JuniorGeneralActivity1.this;

        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {

        run.setOnLongClickListener(longClickListener);
        walk.setOnLongClickListener(longClickListener);
        eat.setOnLongClickListener(longClickListener);
        sing.setOnLongClickListener(longClickListener);
        write.setOnLongClickListener(longClickListener);
        cook.setOnLongClickListener(longClickListener);
        jump.setOnLongClickListener(longClickListener);
        dance.setOnLongClickListener(longClickListener);
        drink.setOnLongClickListener(longClickListener);

        walk_drop.setOnDragListener(dragListenre);
        eat_drop.setOnDragListener(dragListenre);
        run_drop.setOnDragListener(dragListenre);
        write_drop.setOnDragListener(dragListenre);
        sing_drop.setOnDragListener(dragListenre);
        cook_drop.setOnDragListener(dragListenre);
        drink_drop.setOnDragListener(dragListenre);
        jump_drop.setOnDragListener(dragListenre);
        dance_drop.setOnDragListener(dragListenre);

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
                    if (view.getId() == R.id.walk && v.getId() == R.id.walk_drop) {
                        walk.setVisibility(View.INVISIBLE);
                        walk_vi.setVisibility(View.VISIBLE);
                        i += 1;
                        if (i == 9) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.eat && v.getId() == R.id.eat_drop) {
                        eat.setVisibility(View.INVISIBLE);
                        eat_vi.setVisibility(View.VISIBLE);
                        i += 1;
                        if (i == 9) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.run && v.getId() == R.id.run_drop) {
                        run.setVisibility(View.INVISIBLE);
                        run_vi.setVisibility(View.VISIBLE);
                        i += 1;
                        if (i == 9) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.write && v.getId() == R.id.write_drop) {
                        write.setVisibility(View.INVISIBLE);
                        write_vi.setVisibility(View.VISIBLE);
                        i += 1;
                        if (i == 9) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.sing && v.getId() == R.id.sing_drop) {
                        sing.setVisibility(View.INVISIBLE);
                        sing_vi.setVisibility(View.VISIBLE);
                        i += 1;
                        if (i == 9) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.cook && v.getId() == R.id.cook_drop) {
                        cook.setVisibility(View.INVISIBLE);
                        cook_vi.setVisibility(View.VISIBLE);
                        i += 1;
                        if (i == 9) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.drink && v.getId() == R.id.drink_drop) {
                        drink.setVisibility(View.INVISIBLE);
                        drink_vi.setVisibility(View.VISIBLE);
                        i += 1;
                        if (i == 9) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.jump && v.getId() == R.id.jump_drop) {
                        jump.setVisibility(View.INVISIBLE);
                        jump_vi.setVisibility(View.VISIBLE);
                        i += 1;
                        if (i == 9) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.dance && v.getId() == R.id.dance_drop) {
                        dance.setVisibility(View.INVISIBLE);
                        dance_vi.setVisibility(View.VISIBLE);
                        i += 1;
                        if (i == 9) {
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

        run = findViewById(R.id.run);
        walk = findViewById(R.id.walk);
        eat = findViewById(R.id.eat);
        sing = findViewById(R.id.sing);
        write = findViewById(R.id.write);
        cook = findViewById(R.id.cook);
        jump = findViewById(R.id.jump);
        dance = findViewById(R.id.dance);
        drink = findViewById(R.id.drink);
        walk_vi = findViewById(R.id.walk_vi);
        eat_vi = findViewById(R.id.eat_vi);
        run_vi = findViewById(R.id.run_vi);
        write_vi = findViewById(R.id.write_vi);
        sing_vi = findViewById(R.id.sing_vi);
        cook_vi = findViewById(R.id.cook_vi);
        drink_vi = findViewById(R.id.drink_vi);
        jump_vi = findViewById(R.id.jump_vi);
        dance_vi = findViewById(R.id.dance_vi);
        walk_drop = findViewById(R.id.walk_drop);
        eat_drop = findViewById(R.id.eat_drop);
        run_drop = findViewById(R.id.run_drop);
        write_drop = findViewById(R.id.write_drop);
        sing_drop = findViewById(R.id.sing_drop);
        cook_drop = findViewById(R.id.cook_drop);
        drink_drop = findViewById(R.id.drink_drop);
        jump_drop = findViewById(R.id.jump_drop);
        dance_drop = findViewById(R.id.dance_drop);
        next = findViewById(R.id.next);

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(JuniorGeneralActivity1.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(JuniorGeneralActivity1.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(JuniorGeneralActivity1.this, JuniorGeneralActivity2.class));
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
        book_name_header.setText("Place the words to its respective body parts (Hold & Drag)");

    }

    private void redirectPage() {
        Intent intent = new Intent(JuniorGeneralActivity1.this, RedirectPages.class);
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
                        stopService(new Intent(JuniorGeneralActivity1.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(JuniorGeneralActivity1.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(JuniorGeneralActivity1.this, MusicService.class));
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
