package com.mariapublishers.digimariaandroid.activity.juniorkg.juniorgeneralawarness;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.activity.mainprocess.SearchActivity;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class JuniorGeneralActivity6 extends BaseActivity implements View.OnClickListener {

    TextView ra1, ra2, ra3, ra4, ra5, ra6, li1, li2, li3, li4, fo1, fo2, fo3, sn1, sn2, sn3, sn4, sn5, ti1, ti2, ti3, ti4, ti5,
            n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13;
    CardView next, back;
    int i = 0, j = 0, k = 0, l = 0, m = 0, n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junior_general6);

        currentContext = JuniorGeneralActivity6.this;

        callFunc();

    }

    private void callFunc() {

        actionbar();
        musiccontrol();
        initialize();
        onclickbtn();

    }

    private void onclickbtn() {
        
        ra1.setOnClickListener(this);
        ra2.setOnClickListener(this);
        ra3.setOnClickListener(this);
        ra4.setOnClickListener(this);
        ra5.setOnClickListener(this);
        ra6.setOnClickListener(this);
        li1.setOnClickListener(this);
        li2.setOnClickListener(this);
        li3.setOnClickListener(this);
        li4.setOnClickListener(this);
        fo1.setOnClickListener(this);
        fo2.setOnClickListener(this);
        fo3.setOnClickListener(this);
        sn1.setOnClickListener(this);
        sn2.setOnClickListener(this);
        sn3.setOnClickListener(this);
        sn4.setOnClickListener(this);
        sn5.setOnClickListener(this);
        ti1.setOnClickListener(this);
        ti2.setOnClickListener(this);
        ti3.setOnClickListener(this);
        ti4 .setOnClickListener(this);
        ti5 .setOnClickListener(this);
        n1.setOnClickListener(this);
        n2.setOnClickListener(this);
        n3.setOnClickListener(this);
        n4.setOnClickListener(this);
        n5.setOnClickListener(this);
        n6.setOnClickListener(this);
        n7.setOnClickListener(this);
        n8.setOnClickListener(this);
        n9.setOnClickListener(this);
        n10.setOnClickListener(this);
        n11.setOnClickListener(this);
        n12.setOnClickListener(this);
        n13.setOnClickListener(this);
        back.setOnClickListener(this);
        next.setOnClickListener(this);

    }

    private void initialize() {
        ra1 = findViewById(R.id.ra1);
        ra2 = findViewById(R.id.ra2);
        ra3 = findViewById(R.id.ra3);
        ra4 = findViewById(R.id.ra4);
        ra5 = findViewById(R.id.ra5);
        ra6 = findViewById(R.id.ra6);
        li1 = findViewById(R.id.li1);
        li2 = findViewById(R.id.li2);
        li3 = findViewById(R.id.li3);
        li4 = findViewById(R.id.li4);
        fo1 = findViewById(R.id.fo1);
        fo2 = findViewById(R.id.fo2);
        fo3 = findViewById(R.id.fo3);
        sn1 = findViewById(R.id.sn1);
        sn2 = findViewById(R.id.sn2);
        sn3 = findViewById(R.id.sn3);
        sn4 = findViewById(R.id.sn4);
        sn5 = findViewById(R.id.sn5);
        ti1 = findViewById(R.id.ti1);
        ti2 = findViewById(R.id.ti2);
        ti3 = findViewById(R.id.ti3);
        ti4  = findViewById(R.id.ti4);
        ti5  = findViewById(R.id.ti5);
        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);
        n5 = findViewById(R.id.n5);
        n6 = findViewById(R.id.n6);
        n7 = findViewById(R.id.n7);
        n8 = findViewById(R.id.n8);
        n9 = findViewById(R.id.n9);
        n10 = findViewById(R.id.n10);
        n11 = findViewById(R.id.n11);
        n12 = findViewById(R.id.n12);
        n13 = findViewById(R.id.n13);
        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(JuniorGeneralActivity6.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(JuniorGeneralActivity6.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(JuniorGeneralActivity6.this, JuniorGeneralActivity8.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(JuniorGeneralActivity6.this, JuniorGeneralActivity5.class));
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
        book_name_header.setText("Guess and color the names of animals shown in grid");

    }

    private void redirectPage() {
        Intent intent = new Intent(JuniorGeneralActivity6.this, RedirectPages.class);
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
                        stopService(new Intent(JuniorGeneralActivity6.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(JuniorGeneralActivity6.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(JuniorGeneralActivity6.this, MusicService.class));
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

        if (v.getId() == R.id.ra1) {
            if (i == 0) {
                i += 1;
                ra1.setBackground(getResources().getDrawable(R.drawable.plain_border_fill));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.ra2) {
            if (i == 1) {
                i += 1;
                ra2.setBackground(getResources().getDrawable(R.drawable.plain_border_fill));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.ra3) {
            if (i == 2) {
                i += 1;
                ra3.setBackground(getResources().getDrawable(R.drawable.plain_border_fill));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.ra4) {
            if (i == 3) {
                i += 1;
                ra4.setBackground(getResources().getDrawable(R.drawable.plain_border_fill));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.ra5) {
            if (i == 4) {
                i += 1;
                ra5.setBackground(getResources().getDrawable(R.drawable.plain_border_fill));
                
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.ra6) {
            if (i == 5) {
                i += 1;
                ra6.setBackground(getResources().getDrawable(R.drawable.plain_border_fill));
                if (i == 6 && j == 4 && k == 3 && l == 5 && n == 5) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.li1) {
            if (j == 0) {
                j += 1;
                li1.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_4));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.li2) {
            if (j == 1) {
                j += 1;
                li2.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_4));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.li3) {
            if (j == 2) {
                j += 1;
                li3.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_4));
            } else {
                alertMessage(1, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.li4) {
            if (j == 3) {
                j += 1;
                li4.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_4));
                if (i == 6 && j == 4 && k == 3 && l == 5 && n == 5) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.fo1) {
            if (k == 0) {
                k += 1;
                fo1.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_2));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.fo2) {
            if (k == 1) {
                k += 1;
                fo2.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_2));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.fo3) {
            if (k == 2) {
                k += 1;
                fo3.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_2));
                if (i == 6 && j == 4 && k == 3 && l == 5 && n == 5) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.sn1) {
            if (l == 0) {
                l += 1;
                sn1.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_3));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.sn2) {
            if (l == 1) {
                l += 1;
                sn2.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_3));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.sn3) {
            if (l == 2) {
                l += 1;
                sn3.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_3));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.sn4) {
            if (l == 3) {
                l += 1;
                sn4.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_3));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.sn5) {
            if (l == 4) {
                l += 1;
                sn5.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_3));
                if (i == 6 && j == 4 && k == 3 && l == 5 && n == 5) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.ti1) {
            if (n == 0) {
                n += 1;
                ti1.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_1));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.ti2) {
            if (n == 1) {
                n += 1;
                ti2.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_1));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.ti3) {
            if (n == 2) {
                n += 1;
                ti3.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_1));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.ti4) {
            if (n == 3) {
                n += 1;
                ti4.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_1));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.ti5) {
            if (n == 4) {
                n += 1;
                if (i == 6 && j == 4 && k == 3 && l == 5 && n == 5) {
                    alertMessage(1, "Hurray!", "Activity Cleared.");
                }
                ti5.setBackground(getResources().getDrawable(R.drawable.plain_border_fill_1));
            } else {
                alertMessage(2, "Oops...", "Choose the right answer.");
            }
        } else if (v.getId() == R.id.n1) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.n2) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.n3) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.n4) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.n5) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.n6) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.n7) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.n8) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.n9) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.n10) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.n11) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.n13) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.n14) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.next) {
            onclickNext();
        } else if (v.getId() == R.id.back) {
            onclickBack();
        }

    }

}
