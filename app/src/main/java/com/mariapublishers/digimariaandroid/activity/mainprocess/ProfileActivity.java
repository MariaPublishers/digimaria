package com.mariapublishers.digimariaandroid.activity.mainprocess;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mariapublishers.digimariaandroid.R;

public class ProfileActivity extends AppCompatActivity {
    SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        preferences = getSharedPreferences("DigiMaria", MODE_PRIVATE);

        init();

    }

    private void init() {
        try {
            TextView parentName_tv = findViewById(R.id.parent_name);
            TextView email_id_tv = findViewById(R.id.email_id);
            TextView city_tv = findViewById(R.id.city);
            TextView school_tv = findViewById(R.id.school);


            parentName_tv.setText(preferences.getString("ParentName", "Parent Name"));
            email_id_tv.setText(preferences.getString("Email_Id", "Email"));
            city_tv.setText(preferences.getString("City", "City"));
            school_tv.setText(preferences.getString("SchoolName", "School Name"));

            ((TextView) findViewById(R.id.studentname)).setText(preferences.getString("StudentName", "Student Name"));
            ((TextView) findViewById(R.id.class_name)).setText(preferences.getString("ClassName", "Class Name"));
            ((TextView) findViewById(R.id.mobile_no)).setText(preferences.getString("StudentMobileNo", "Mobile No"));


            findViewById(R.id.toback).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
