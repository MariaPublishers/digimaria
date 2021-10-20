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

public class JuniorNumeracyActivity7 extends BaseActivity implements View.OnClickListener {

    int i = 0;
    CardView next, back;
    TextView four, seven, ten, thirteen, sixteen, ninteen, twentytwo, twentyfive, twenteight, thirtyone, thirtyfour, thirtyseven, forty, fortythree,
            fortysix, fortynine;
    TextView fourdrop, sevendrop, tendrop, thirteendrop, sixteendrop, ninteendrop, twentytwodrop, twentyfivedrop, twenteightdrop, thirtyonedrop, thirtyfourdrop, thirtysevendrop, fortydrop,
            fortythreedrop, fortysixdrop, fortyninedrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junior_numeracy7);

        currentContext = JuniorNumeracyActivity7.this;

        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {

        four.setOnLongClickListener(longClickListener);
        seven.setOnLongClickListener(longClickListener);
        ten.setOnLongClickListener(longClickListener);
        thirteen.setOnLongClickListener(longClickListener);
        sixteen.setOnLongClickListener(longClickListener);
        ninteen.setOnLongClickListener(longClickListener);
        twentytwo.setOnLongClickListener(longClickListener);
        twentyfive.setOnLongClickListener(longClickListener);
        twenteight.setOnLongClickListener(longClickListener);
        thirtyone.setOnLongClickListener(longClickListener);
        thirtyfour.setOnLongClickListener(longClickListener);
        thirtyseven.setOnLongClickListener(longClickListener);
        forty.setOnLongClickListener(longClickListener);
        fortythree.setOnLongClickListener(longClickListener);
        fortysix.setOnLongClickListener(longClickListener);
        fortynine.setOnLongClickListener(longClickListener);

        fourdrop.setOnDragListener(dragListenre);
        sevendrop.setOnDragListener(dragListenre);
        tendrop.setOnDragListener(dragListenre);
        thirteendrop.setOnDragListener(dragListenre);
        sixteendrop.setOnDragListener(dragListenre);
        ninteendrop.setOnDragListener(dragListenre);
        twentytwodrop.setOnDragListener(dragListenre);
        twentyfivedrop.setOnDragListener(dragListenre);
        twenteightdrop.setOnDragListener(dragListenre);
        thirtyonedrop.setOnDragListener(dragListenre);
        thirtyfourdrop.setOnDragListener(dragListenre);
        thirtysevendrop.setOnDragListener(dragListenre);
        fortydrop.setOnDragListener(dragListenre);
        fortythreedrop.setOnDragListener(dragListenre);
        fortysixdrop.setOnDragListener(dragListenre);
        fortyninedrop.setOnDragListener(dragListenre);

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

                    if (view.getId() == R.id.four && v.getId() == R.id.fourdrop) {
                        if (i == 0) {
                            four.setVisibility(View.GONE);
                            fourdrop.setText("4");
                            i += 1;
                            if (i == 16) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id.seven && v.getId() == R.id.sevendrop) {
                        if (i == 1) {
                            seven.setVisibility(View.GONE);
                            sevendrop.setText("7");
                            i += 1;
                            if (i == 16) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id.ten && v.getId() == R.id.tendrop) {
                        if (i == 2) {
                            ten.setVisibility(View.GONE);
                            tendrop.setText("10");
                            i += 1;
                            if (i == 16) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id.thirteen && v.getId() == R.id.thirteendrop) {
                        if (i == 3) {
                            thirteen.setVisibility(View.GONE);
                            thirteendrop.setText("13");
                            i += 1;
                            if (i == 16) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id.sixteen && v.getId() == R.id.sixteendrop) {
                        if (i == 4) {
                            sixteen.setVisibility(View.GONE);
                            sixteendrop.setText("16");
                            i += 1;
                            if (i == 16) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id.ninteen && v.getId() == R.id.ninteendrop) {
                        if (i == 5) {
                            ninteen.setVisibility(View.GONE);
                            ninteendrop.setText("19");
                            i += 1;
                            if (i == 16) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id.twentytwo && v.getId() == R.id.twentytwodrop) {
                        if (i == 6) {
                            twentytwo.setVisibility(View.GONE);
                            twentytwodrop.setText("22");
                            i += 1;
                            if (i == 16) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id.twentyfive && v.getId() == R.id.twentyfivedrop) {
                        if (i == 7) {
                            twentyfive.setVisibility(View.GONE);
                            twentyfivedrop.setText("25");
                            i += 1;
                            if (i == 16) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id.twenteight && v.getId() == R.id.twenteightdrop) {
                        if (i == 8) {
                            twenteight.setVisibility(View.GONE);
                            twenteightdrop.setText("28");
                            i += 1;
                            if (i == 16) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id.thirtyone && v.getId() == R.id.thirtyonedrop) {
                        if (i == 9) {
                            thirtyone.setVisibility(View.GONE);
                            thirtyonedrop.setText("31");
                            i += 1;
                            if (i == 16) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id.thirtyfour && v.getId() == R.id.thirtyfourdrop) {
                        if (i == 10) {
                            thirtyfour.setVisibility(View.GONE);
                            thirtyfourdrop.setText("34");
                            i += 1;
                            if (i == 16) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id.thirtyseven && v.getId() == R.id.thirtysevendrop) {
                        if (i == 11) {
                            thirtyseven.setVisibility(View.GONE);
                            thirtysevendrop.setText("37");
                            i += 1;
                            if (i == 16) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id.forty && v.getId() == R.id.fortydrop) {
                        if (i == 12) {
                            forty.setVisibility(View.GONE);
                            fortydrop.setText("40");
                            i += 1;
                            if (i == 16) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id.fortythree && v.getId() == R.id.fortythreedrop) {
                        if (i == 13) {
                            fortythree.setVisibility(View.GONE);
                            fortythreedrop.setText("43");
                            i += 1;
                            if (i == 16) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id.fortysix && v.getId() == R.id.fortysixdrop) {
                        if (i == 14) {
                            fortysix.setVisibility(View.GONE);
                            fortysixdrop.setText("46");
                            i += 1;
                            if (i == 16) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else if (view.getId() == R.id.fortynine && v.getId() == R.id.fortyninedrop) {
                        if (i == 15) {
                            fortynine.setVisibility(View.GONE);
                            fortyninedrop.setText("49");
                            i += 1;
                            if (i == 16) {
                                alertMessage(1, "Hurray!", "Activity Cleared.");
                            }
                        } else {
                            alertMessage(2, "Oops...", "Go with order.");
                        }
                    } else {
                        alertMessage(2, "Oops...", "Drop on right box.");
                    }
                    break;

            }
            return true;
        }
    };

    private void initialize() {

        four = findViewById(R.id.four);
        seven = findViewById(R.id.seven);
        ten = findViewById(R.id.ten);
        thirteen = findViewById(R.id.thirteen);
        sixteen = findViewById(R.id.sixteen);
        ninteen = findViewById(R.id.ninteen);
        twentytwo = findViewById(R.id.twentytwo);
        twentyfive = findViewById(R.id.twentyfive);
        twenteight = findViewById(R.id.twenteight);
        thirtyone = findViewById(R.id.thirtyone);
        thirtyfour = findViewById(R.id.thirtyfour);
        thirtyseven = findViewById(R.id.thirtyseven);
        forty = findViewById(R.id.forty);
        fortythree = findViewById(R.id.fortythree);
        fortysix = findViewById(R.id.fortysix);
        fortynine = findViewById(R.id.fortynine);
        thirteen = findViewById(R.id.thirteen);

        fourdrop = findViewById(R.id.fourdrop);
        sevendrop = findViewById(R.id.sevendrop);
        tendrop = findViewById(R.id.tendrop);
        thirteendrop = findViewById(R.id.thirteendrop);
        sixteendrop = findViewById(R.id.sixteendrop);
        ninteendrop = findViewById(R.id.ninteendrop);
        twentytwodrop = findViewById(R.id.twentytwodrop);
        twentyfivedrop = findViewById(R.id.twentyfivedrop);
        twenteightdrop = findViewById(R.id.twenteightdrop);
        thirtyonedrop = findViewById(R.id.thirtyonedrop);
        thirtyfourdrop = findViewById(R.id.thirtyfourdrop);
        thirtysevendrop = findViewById(R.id.thirtysevendrop);
        fortydrop = findViewById(R.id.fortydrop);
        fortythreedrop = findViewById(R.id.fortythreedrop);
        fortysixdrop = findViewById(R.id.fortysixdrop);
        fortyninedrop = findViewById(R.id.fortyninedrop);

        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(JuniorNumeracyActivity7.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(JuniorNumeracyActivity7.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(JuniorNumeracyActivity7.this, JuniorNumeracyActivity8.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(JuniorNumeracyActivity7.this, JuniorNumeracyActivity6.class));
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
        book_name_header.setText("Place the missing numbers from \n1 to 50 in boxes (Hold & Drag)");

    }

    private void redirectPage() {
        Intent intent = new Intent(JuniorNumeracyActivity7.this, RedirectPages.class);
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
                        stopService(new Intent(JuniorNumeracyActivity7.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(JuniorNumeracyActivity7.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(JuniorNumeracyActivity7.this, MusicService.class));
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
