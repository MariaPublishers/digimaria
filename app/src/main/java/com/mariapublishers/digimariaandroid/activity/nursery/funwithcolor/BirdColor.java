package com.mariapublishers.digimariaandroid.activity.nursery.funwithcolor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.juniorkg.juniorliteracy.JuniorLiteracyActivity10;
import com.mariapublishers.digimariaandroid.activity.mainprocess.BookLanding;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;
import com.mariapublishers.digimariaandroid.activity.nursery.funwithcolor.BugColor;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class BirdColor extends BaseActivity implements OnClickListener {

    private ImageButton currPaint, drawbtn, baru, erase, save;
    private DrawingView drawView;
    CardView bug, micky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird_color);

        currentContext = BirdColor.this;

        drawView = findViewById(R.id.drawingView);
        drawbtn = findViewById(R.id.draw_btn);
        baru = findViewById(R.id.new_btn);
        erase = findViewById(R.id.erase_btn);
//        save = findViewById(R.id.save_btn);
        LinearLayout paintLayout = findViewById(R.id.paint_colors);
        currPaint = (ImageButton) paintLayout.getChildAt(0);
        currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
//        currPaint.setImageResource(R.drawable.paint_pressed);
        drawbtn.setOnClickListener(this);
        baru.setOnClickListener(this);
        erase.setOnClickListener(this);
//        save.setOnClickListener(this);


        volval = pref.getVolumeval();

        volumenote = findViewById(R.id.volumenote);

        ImageView toback = findViewById(R.id.toback);

        toback.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BirdColor.this, BookLanding.class);
                intent.putExtra("bookid", pref.getClassid());
                startActivity(intent);
                finish();
            }
        });

        volumenote.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (volval != null) {
                    if (volval.equals("1")) {
                        pref.setVolumeval("0");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeoff);
                        stopService(new Intent(BirdColor.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(BirdColor.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(BirdColor.this, MusicService.class));
                }


            }
        });

        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }

        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Fun with colors");

        bug = findViewById(R.id.bug);
        micky = findViewById(R.id.micky);

        bug.setOnClickListener(this);
        micky.setOnClickListener(this);
    }

    public void paintClicked(View view) {
        if (view != currPaint) {
            ImageButton imgView = (ImageButton)view;
            String color = view.getTag().toString();
            drawView.setColor(color);
            imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
            currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
            currPaint=(ImageButton)view;
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.draw_btn) {
            drawView.setupDrawing();
        }

        if (v.getId() == R.id.erase_btn) {
            drawView.setErase(true);
            drawView.setBrushSize(drawView.getBrushSize());
        }

        if (v.getId() == R.id.new_btn) {
            new SweetAlertDialog(BirdColor.this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("Won't be able to recover this file!")
                    .setConfirmText("Yes,delete it!")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            drawView.startNew();
                            sDialog.cancel();
                        }
                    })
                    .show();
        }

        if (v.getId() == R.id.bug) {
            startActivity(new Intent(BirdColor.this, BugColor.class));
        }

        if (v.getId() == R.id.micky) {
            startActivity(new Intent(BirdColor.this, MickyColor.class));
        }

//        if (v.getId() == R.id.save_btn) {
//            new SweetAlertDialog(BirdColor.this, SweetAlertDialog.WARNING_TYPE)
//                    .setTitleText("Are you sure?")
//                    .setContentText("Do you wish to save this file!")
//                    .setConfirmText("Yes,save it!")
//                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                        @Override
//                        public void onClick(SweetAlertDialog sDialog) {
//                            drawView.setDrawingCacheEnabled(true);
//                            String imgSaved = MediaStore.Images.Media.insertImage(getContentResolver(), drawView.getDrawingCache(), UUID.randomUUID().toString()+".png", "Drawing");
//                            if (imgSaved != null) {
//                                Toast savedtoast = Toast.makeText(getApplicationContext(), "Drawing saved to Gallery!", Toast.LENGTH_SHORT);
//                                savedtoast.show();
//                            } else {
//                                Toast unsaved = Toast.makeText(getApplicationContext(), "Image could not saved.", Toast.LENGTH_SHORT);
//                                unsaved.show();
//                            }
//                            drawView.destroyDrawingCache();
//                        }
//                    })
//                    .show();
//        }
    }
}
