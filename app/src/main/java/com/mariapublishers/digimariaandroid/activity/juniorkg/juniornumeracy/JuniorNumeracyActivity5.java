package com.mariapublishers.digimariaandroid.activity.juniorkg.juniornumeracy;

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
import com.mariapublishers.digimariaandroid.activity.juniorkg.juniorliteracy.JuniorLiteracyActivity10;
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class JuniorNumeracyActivity5 extends BaseActivity implements View.OnClickListener {

    int i = 0;
    CardView next, back;
    TextView cir1, cir2, cir3, cir1drop, cir2drop, cir3drop, tri1, tri2, tri3, tri4, tri1drop, tri2drop, tri3drop, tri4drop, squ1, squ2, squ3,
            squ1drop, squ2drop, squ3drop, rec1, rec2, rec3, rec4, rec1drop, rec2drop, rec3drop, rec4drop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junior_numeracy5);

        currentContext = JuniorNumeracyActivity5.this;

        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {

        cir1.setOnLongClickListener(longClickListener);
        cir2.setOnLongClickListener(longClickListener);
        cir3.setOnLongClickListener(longClickListener);
        tri1.setOnLongClickListener(longClickListener);
        tri2.setOnLongClickListener(longClickListener);
        tri3.setOnLongClickListener(longClickListener);
        tri4.setOnLongClickListener(longClickListener);
        squ1.setOnLongClickListener(longClickListener);
        squ2.setOnLongClickListener(longClickListener);
        squ3.setOnLongClickListener(longClickListener);
        rec1.setOnLongClickListener(longClickListener);
        rec2.setOnLongClickListener(longClickListener);
        rec3.setOnLongClickListener(longClickListener);
        rec4.setOnLongClickListener(longClickListener);

        cir1drop.setOnDragListener(dragListenre);
        cir2drop.setOnDragListener(dragListenre);
        cir3drop.setOnDragListener(dragListenre);
        tri1drop.setOnDragListener(dragListenre);
        tri2drop.setOnDragListener(dragListenre);
        tri3drop.setOnDragListener(dragListenre);
        tri4drop.setOnDragListener(dragListenre);
        squ1drop.setOnDragListener(dragListenre);
        squ2drop.setOnDragListener(dragListenre);
        squ3drop.setOnDragListener(dragListenre);
        rec1drop.setOnDragListener(dragListenre);
        rec2drop.setOnDragListener(dragListenre);
        rec3drop.setOnDragListener(dragListenre);
        rec4drop.setOnDragListener(dragListenre);

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
                    if (view.getId() == R.id.cir1 && v.getId() == R.id.cir1drop) {
                        cir1.setVisibility(View.GONE);
                        cir1drop.setText(R.string.cap_i);
                        i += 1;
                        if (i == 14) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.cir2 && v.getId() == R.id.cir2drop) {
                        cir2.setVisibility(View.GONE);
                        cir2drop.setText(R.string.c_cap);
                        i += 1;
                        if (i == 14) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.cir3 && v.getId() == R.id.cir3drop) {
                        cir3.setVisibility(View.GONE);
                        cir3drop.setText(R.string.e_cap);
                        i += 1;
                        if (i == 14) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.tri1 && v.getId() == R.id.tri1drop) {
                        tri1.setVisibility(View.GONE);
                        tri1drop.setText(R.string.t_cap);
                        i += 1;
                        if (i == 14) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.tri2 && v.getId() == R.id.tri2drop) {
                        tri2.setVisibility(View.GONE);
                        tri2drop.setText(R.string.cap_i);
                        i += 1;
                        if (i == 14) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.tri3 && v.getId() == R.id.tri3drop) {
                        tri3.setVisibility(View.GONE);
                        tri3drop.setText(R.string.n_cap);
                        i += 1;
                        if (i == 14) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.tri4 && v.getId() == R.id.tri4drop) {
                        tri4.setVisibility(View.GONE);
                        tri4drop.setText(R.string.l_cap);
                        i += 1;
                        if (i == 14) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.squ1 && v.getId() == R.id.squ1drop) {
                        squ1.setVisibility(View.GONE);
                        squ1drop.setText(R.string.s_cap);
                        i += 1;
                        if (i == 14) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.squ2 && v.getId() == R.id.squ2drop) {
                        squ2.setVisibility(View.GONE);
                        squ2drop.setText(R.string.u_cap);
                        i += 1;
                        if (i == 14) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.squ3 && v.getId() == R.id.squ3drop) {
                        squ3.setVisibility(View.GONE);
                        squ3drop.setText(R.string.r_cap);
                        i += 1;
                        if (i == 14) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.rec1 && v.getId() == R.id.rec1drop) {
                        rec1.setVisibility(View.GONE);
                        rec1drop.setText(R.string.e_cap);
                        i += 1;
                        if (i == 14) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.rec2 && v.getId() == R.id.rec2drop) {
                        rec2.setVisibility(View.GONE);
                        rec2drop.setText(R.string.t_cap);
                        i += 1;
                        if (i == 14) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.rec3 && v.getId() == R.id.rec3drop) {
                        rec3.setVisibility(View.GONE);
                        rec3drop.setText(R.string.n_cap);
                        i += 1;
                        if (i == 14) {
                            alertMessage(1, "Hurray!", "Activity Cleared.");
                        }
                    } else if (view.getId() == R.id.rec4 && v.getId() == R.id.rec4drop) {
                        rec4.setVisibility(View.GONE);
                        rec4drop.setText(R.string.l_cap);
                        i += 1;
                        if (i == 14) {
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

        cir1 = findViewById(R.id.cir1);
        cir2 = findViewById(R.id.cir2);
        cir3 = findViewById(R.id.cir3);
        cir1drop = findViewById(R.id.cir1drop);
        cir2drop = findViewById(R.id.cir2drop);
        cir3drop = findViewById(R.id.cir3drop);
        tri1 = findViewById(R.id.tri1);
        tri2 = findViewById(R.id.tri2);
        tri3 = findViewById(R.id.tri3);
        tri4 = findViewById(R.id.tri4);
        tri1drop = findViewById(R.id.tri1drop);
        tri2drop = findViewById(R.id.tri2drop);
        tri3drop = findViewById(R.id.tri3drop);
        tri4drop = findViewById(R.id.tri4drop);
        squ1 = findViewById(R.id.squ1);
        squ2 = findViewById(R.id.squ2);
        squ3 = findViewById(R.id.squ3);
        squ1drop = findViewById(R.id.squ1drop);
        squ2drop = findViewById(R.id.squ2drop);
        squ3drop = findViewById(R.id.squ3drop);
        rec1 = findViewById(R.id.rec1);
        rec2 = findViewById(R.id.rec2);
        rec3 = findViewById(R.id.rec3);
        rec4 = findViewById(R.id.rec4);
        rec1drop = findViewById(R.id.rec1drop);
        rec2drop = findViewById(R.id.rec2drop);
        rec3drop = findViewById(R.id.rec3drop);
        rec4drop = findViewById(R.id.rec4drop);
        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(JuniorNumeracyActivity5.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(JuniorNumeracyActivity5.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer."
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(JuniorNumeracyActivity5.this, JuniorNumeracyActivity6.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(JuniorNumeracyActivity5.this, JuniorNumeracyActivity4.class));
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
        book_name_header.setText("Name the shapes (Hold & Drag)");

    }

    private void redirectPage() {
        Intent intent = new Intent(JuniorNumeracyActivity5.this, RedirectPages.class);
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
                        stopService(new Intent(JuniorNumeracyActivity5.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(JuniorNumeracyActivity5.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(JuniorNumeracyActivity5.this, MusicService.class));
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
