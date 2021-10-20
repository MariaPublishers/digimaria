package com.mariapublishers.digimariaandroid.activity.mainprocess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.http.DownloadCallback;
import com.mariapublishers.digimariaandroid.http.LoginTask;

import org.json.JSONObject;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class RegisterActivity extends AppCompatActivity {

    EditText mobile_login, phonenum_login;

    public  final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public  boolean validate(String emailStr) {
        try {
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
            return matcher.find();
        } catch (Exception e) {
            return false;
        }
    }
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        SharedPreferences preferences=getSharedPreferences("DigiMaria",MODE_PRIVATE);
        if(preferences.getBoolean("LoggedIn",false))
        {
            startActivity(new Intent(this,Dashboard.class));
            finish();
        }
        else {
            mobile_login = findViewById(R.id.emailid_login);
            phonenum_login = findViewById(R.id.mobile_login);

            mobile_login.addTextChangedListener(new TextWatcher() {

                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if(validate(editable.toString()))
                        ((View)mobile_login.getParent()).setBackgroundResource(R.drawable.line_correct);
                    else
                        ((View)mobile_login.getParent()).setBackgroundResource(R.drawable.line_wrong);

                }
            });



            phonenum_login.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if(editable.toString().length()==10)
                        ((View) phonenum_login.getParent()).setBackgroundResource(R.drawable.line_correct);
                    else
                        ((View) phonenum_login.getParent()).setBackgroundResource(R.drawable.line_wrong);

                }
            });


            CardView login_btn = findViewById(R.id.login_btn);
            login_btn.setOnTouchListener(new View.OnTouchListener() {
                private int CLICK_ACTION_THRESHOLD = 200;
                private float startX;
                private float startY;

                private boolean isAClick(float startX, float endX, float startY, float endY) {
                    float differenceX = Math.abs(startX - endX);
                    float differenceY = Math.abs(startY - endY);
                    return !(differenceX > CLICK_ACTION_THRESHOLD/* =5 */ || differenceY > CLICK_ACTION_THRESHOLD);
                }

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            startX = event.getX();
                            startY = event.getY();
                            ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(login_btn,
                                    "scaleX", 0.95f);
                            ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(login_btn,
                                    "scaleY", 0.95f);
                            scaleDownX.setDuration(200);
                            scaleDownY.setDuration(200);

                            AnimatorSet scaleDown = new AnimatorSet();
                            scaleDown.play(scaleDownX).with(scaleDownY);

                            scaleDown.start();
                            break;

                        case MotionEvent.ACTION_UP:
                            Log.d("String", "clidked111");
                            ObjectAnimator scaleDownX2 = ObjectAnimator.ofFloat(
                                    login_btn, "scaleX", 1f);
                            ObjectAnimator scaleDownY2 = ObjectAnimator.ofFloat(
                                    login_btn, "scaleY", 1f);
                            scaleDownX2.setDuration(200);
                            scaleDownY2.setDuration(200);

                            AnimatorSet scaleDown2 = new AnimatorSet();
                            scaleDown2.play(scaleDownX2).with(scaleDownY2);

                            scaleDown2.start();
                            float endX = event.getX();
                            float endY = event.getY();
                            if (isAClick(startX, endX, startY, endY)) {

                                if (mobile_login.getText().toString().equals("")) {
                                    alertError("Email ID is mandatory");
                                } else if (phonenum_login.getText().toString().isEmpty()) {
                                    alertError("Mobile Number is mandatory");
                                }
                                else if (!validate(mobile_login.getText().toString())) {
                                    alertError("Email ID is not valid");
                                }
                                else if(phonenum_login.getText().toString().length()!=10)
                                {
                                    alertError("Mobile Number should be 10 digits");

                                }
                                else {

                                    startActivity(new Intent(RegisterActivity.this,UserDetailRegister.class)
                                    .putExtra("Email",mobile_login.getText().toString())
                                    .putExtra("Phone",phonenum_login.getText().toString()));


                                }
                            }
                            break;
                    }
                    return true;
                }
            });
        }
    }

    public void alertError(String title,String message) {
        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(title)
                .setContentText(message)
                .show();

    }

    public void alertError(String message) {
        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Missing!!!")
                .setContentText(message)
                .show();

    }

    public void finish(View view) {
        finish();
    }


}