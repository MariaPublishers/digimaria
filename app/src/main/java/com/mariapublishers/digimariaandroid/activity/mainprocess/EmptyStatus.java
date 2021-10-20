package com.mariapublishers.digimariaandroid.activity.mainprocess;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.mariapublishers.digimariaandroid.R;

public class EmptyStatus extends AppCompatActivity {

    private static final String TAG = EmptyStatus.class.getSimpleName();
    LinearLayout coming_soon, something_went_wrong, no_network;
    Intent get_int;
    CardView home_some, home_no, home_come;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_status);

        no_network = findViewById(R.id.no_network);
        something_went_wrong = findViewById(R.id.something_went_wrong);
        coming_soon = findViewById(R.id.coming_soon);

        home_some = findViewById(R.id.home_some);
        home_no = findViewById(R.id.home_no);
        home_come = findViewById(R.id.home_come);

        home_come.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmptyStatus.super.onBackPressed();
            }
        });

        home_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmptyStatus.this, MainActivity.class));
                finish();
            }
        });

        home_come.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmptyStatus.super.onBackPressed();
            }
        });

        get_int = getIntent();

        if (get_int.getStringExtra("status").equals("coming")) {
            Log.d(TAG, "onCreate: one");
            coming_soon.setVisibility(View.VISIBLE);
        } else if (get_int.getStringExtra("status").equals("nonet")) {
            Log.d(TAG, "onCreate: two");
            no_network.setVisibility(View.VISIBLE);
        } else if (get_int.getStringExtra("status").equals("something")) {
            Log.d(TAG, "onCreate: three");
            something_went_wrong.setVisibility(View.VISIBLE);
        }

    }
}
