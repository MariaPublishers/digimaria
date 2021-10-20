package com.mariapublishers.digimariaandroid.activity.seniorkg.seniorliteracy;

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
import com.mariapublishers.digimariaandroid.activity.mainprocess.BookLanding;
import com.mariapublishers.digimariaandroid.activity.mainprocess.RedirectPages;
import com.mariapublishers.digimariaandroid.activity.seniorflashcard.SeniorFlashCard14;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class SeniorLiteracyActivity1 extends BaseActivity implements View.OnClickListener {
    CardView AA, BB, CC, DD, EE, FF, II, JJ, KK, LL, MM, NN, OO, PP, QQ,
            RR, SS, TT, UU, VV, WW, XX, YY, ZZ,GG,HH;
    CardView next;
     int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_literacy1);
        currentContext = SeniorLiteracyActivity1.this;

        callFunc();
    }

    private void callFunc() {
        initialize();
        actionbar();
        musiccontrol();
        onclickbtn();

    }

    private void initialize() {

        AA = findViewById(R.id.AA);
        BB = findViewById(R.id.BB);
        CC = findViewById(R.id.CC);
        DD = findViewById(R.id.DD);
        EE = findViewById(R.id.EE);
        FF = findViewById(R.id.FF);
        GG = findViewById(R.id.GG);
        HH = findViewById(R.id.HH);
        ZZ = findViewById(R.id.ZZ);
        II = findViewById(R.id.II);
        JJ = findViewById(R.id.JJ);
        KK = findViewById(R.id.KK);
        LL = findViewById(R.id.LL);
        MM = findViewById(R.id.MM);
        NN = findViewById(R.id.NN);
        OO = findViewById(R.id.OO);
        PP = findViewById(R.id.PP);
        QQ = findViewById(R.id.QQ);
        ZZ = findViewById(R.id.ZZ);
        RR = findViewById(R.id.RR);
        SS = findViewById(R.id.SS);
        TT = findViewById(R.id.TT);
        UU = findViewById(R.id.UU);
        VV = findViewById(R.id.VV);
        WW = findViewById(R.id.WW);
        XX = findViewById(R.id.XX);
        YY = findViewById(R.id.YY);
//        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

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
        book_name_header.setText("Select the consonants");

    }

    private void redirectPage() {
        Intent intent = new Intent(SeniorLiteracyActivity1.this, RedirectPages.class);
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
                        stopService(new Intent(SeniorLiteracyActivity1.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorLiteracyActivity1.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorLiteracyActivity1.this, MusicService.class));
                }


            }
        });

        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }

    }

    private void onclickbtn() {

        AA.setOnClickListener(this);
        BB.setOnClickListener(this);
        CC.setOnClickListener(this);
        DD.setOnClickListener(this);
        EE.setOnClickListener(this);
        FF.setOnClickListener(this);
        GG.setOnClickListener(this);
        HH.setOnClickListener(this);
        ZZ.setOnClickListener(this);
        II.setOnClickListener(this);
        JJ.setOnClickListener(this);
        KK.setOnClickListener(this);
        LL.setOnClickListener(this);
        MM.setOnClickListener(this);
        NN.setOnClickListener(this);
        OO.setOnClickListener(this);
        PP.setOnClickListener(this);
        QQ.setOnClickListener(this);
        RR.setOnClickListener(this);
        SS.setOnClickListener(this);
        TT.setOnClickListener(this);
        UU.setOnClickListener(this);
        VV.setOnClickListener(this);
        WW.setOnClickListener(this);
        XX.setOnClickListener(this);
        YY.setOnClickListener(this);
//        back.setOnClickListener(this);
        next.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
//        if (v.getId() == R.id.RR) {
//            if (cr1 == 0) {
//                cr1 += 1;
//                i += 1;
//                RR.setBackgroundColor(getResources().getColor(R.color.successgreen));
//                if (i == 8) {
//                    alertMessage(1, "Hurray!", "Activity Cleared.");
//                }
//            } else {
//                alertMessage(2, "Oops...", "Choose the right answer.");
//            }
//        } else if (v.getId() == R.id.SS) {
//            if (cr2 == 0) {
//                cr2 += 1;
//                i += 1;
//                SS.setBackgroundColor(getResources().getColor(R.color.successgreen));
//                if (i == 8) {
//                    alertMessage(1, "Hurray!", "Activity Cleared.");
//                }
//            } else {
//                alertMessage(2, "Oops...", "Choose the right answer.");
//            }
//        } else if (v.getId() == R.id.TT) {
//            if (cr3 == 0) {
//                cr3 += 1;
//                i += 1;
//                TT.setBackgroundColor(getResources().getColor(R.color.successgreen));
//                if (i == 8) {
//                    alertMessage(1, "Hurray!", "Activity Cleared.");
//                }
//            } else {
//                alertMessage(2, "Oops...", "Choose the right answer.");
//            }
//        } else if (v.getId() == R.id.UU) {
//            if (cr4 == 0) {
//                cr4 += 1;
//                i += 1;
//                UU.setBackgroundColor(getResources().getColor(R.color.successgreen));
//                if (i == 8) {
//                    alertMessage(1, "Hurray!", "Activity Cleared.");
//                }
//            } else {
//                alertMessage(2, "Oops...", "Choose the right answer.");
//            }
//        } else if (v.getId() == R.id.VV) {
//            if (cr5 == 0) {
//                cr5 += 1;
//                i += 1;
//                VV.setBackgroundColor(getResources().getColor(R.color.successgreen));
//                if (i == 8) {
//                    alertMessage(1, "Hurray!", "Activity Cleared.");
//                }
//            } else {
//                alertMessage(2, "Oops...", "Choose the right answer.");
//            }
//        } else if (v.getId() == R.id.WW) {
//            if (cr6 == 0) {
//                cr6 += 1;
//                i += 1;
//                WW.setBackgroundColor(getResources().getColor(R.color.successgreen));
//                if (i == 8) {
//                    alertMessage(1, "Hurray!", "Activity Cleared.");
//                }
//            } else {
//                alertMessage(2, "Oops...", "Choose the right answer.");
//            }
//        } else if (v.getId() == R.id.XX) {
//            if (cr7 == 0) {
//                cr7 += 1;
//                i += 1;
//                XX.setBackgroundColor(getResources().getColor(R.color.successgreen));
//                if (i == 8) {
//                    alertMessage(1, "Hurray!", "Activity Cleared.");
//                }
//            } else {
//                alertMessage(2, "Oops...", "Choose the right answer.");
//            }
//        } else if (v.getId() == R.id.YY) {
//            if (cr8 == 0) {
//                cr8 += 1;
//                i += 1;
//                YY.setBackgroundColor(getResources().getColor(R.color.successgreen));
//                if (i == 8) {
//                    alertMessage(1, "Hurray!", "Activity Cleared.");
//                }
//            } else {
//                alertMessage(2, "Oops...", "Choose the right answer.");
//            }
        //   } else

        if (v.getId() == R.id.AA) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.EE) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.II) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.OO) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.UU) {
            alertMessage(2, "Oops...", "Choose the right answer.");
        } else if (v.getId() == R.id.BB) {
            BB.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
        } else if (v.getId() == R.id.CC) {
            CC.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
        } else if (v.getId() == R.id.DD) {
            DD.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
        } else if (v.getId() == R.id.FF) {
            FF.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
        } else if (v.getId() == R.id.GG) {
            GG.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
        }else if (v.getId() == R.id.HH) {
            HH.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
        }else if (v.getId() == R.id.ZZ) {
            ZZ.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
        } else if (v.getId() == R.id.JJ) {
            JJ.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
        } else if (v.getId() == R.id.KK) {
            KK.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
         } else if (v.getId() == R.id.LL) {
            LL.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
        } else if (v.getId() == R.id.MM) {
            MM.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
        } else if (v.getId() == R.id.NN) {
            NN.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
        } else if (v.getId() == R.id.PP) {
            PP.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
        } else if (v.getId() == R.id.QQ) {
            QQ.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
        } else if (v.getId() == R.id.RR) {
            RR.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
        } else if (v.getId() == R.id.SS) {
            SS.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
        } else if (v.getId() == R.id.TT) {
            TT.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
        } else if (v.getId() == R.id.VV) {
            VV.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
        } else if (v.getId() == R.id.WW) {
            WW.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
        } else if (v.getId() == R.id.XX) {
            XX.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
        } else if (v.getId() == R.id.YY) {
            YY.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
        } else if (v.getId() == R.id.ZZ) {
            ZZ.setCardBackgroundColor(getResources().getColor(R.color.successgreen));
            i += 1;
            if (i == 21) {
                alertMessage(1, "Hurray!", "Activity Cleared.");
            }
        } else if (v.getId() == R.id.next) {
            onclickNext();
        } else if (v.getId() == R.id.back) {
            onclickBack();
        }
    }

    public void alertMessage(int type, String title, String message) {

        if (type == 1) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();

            new SweetAlertDialog(SeniorLiteracyActivity1.this, SweetAlertDialog.SUCCESS_TYPE)
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

            new SweetAlertDialog(SeniorLiteracyActivity1.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title) //"Oops..."
                    .setConfirmText("OK")
                    .setContentText(message) //"Choose the right answer"
                    .show();
        }

    }

    public void onclickNext() {
        startActivity(new Intent(SeniorLiteracyActivity1.this, SeniorLiteracyActivity2.class));
        finish();
    }

    public void onclickBack() {
        startActivity(new Intent(SeniorLiteracyActivity1.this, BookLanding.class));
        finish();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
