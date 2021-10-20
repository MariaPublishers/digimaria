package com.mariapublishers.digimariaandroid.activity.mainprocess;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.JsonObject;
import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.http.DownloadCallback;
import com.mariapublishers.digimariaandroid.http.LoginTask;
import com.mariapublishers.digimariaandroid.model.login.LoginData;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.retrofit.APIUrl;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private static final String TAG = "Login.java";
    HashMap<String, String> hashMap;
    private Pref pref;
    EditText mobile_login, password_login,schoolcode_login;
    SweetAlertDialog pDialog;

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
        setContentView(R.layout.activity_login);

        SharedPreferences preferences=getSharedPreferences("DigiMaria",MODE_PRIVATE);
        if(preferences.getBoolean("LoggedIn",false))
        {
            startActivity(new Intent(this,Dashboard.class));
            finish();
        }
        else {
            mobile_login = findViewById(R.id.mobile_login);
            password_login = findViewById(R.id.password_login);
            schoolcode_login = findViewById(R.id.schoolcode_login);

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

            password_login.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if(!editable.toString().isEmpty())
                        ((View)password_login.getParent()).setBackgroundResource(R.drawable.line_correct);
                    else
                        ((View)password_login.getParent()).setBackgroundResource(R.drawable.line_wrong);

                }
            });

            schoolcode_login.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if(!editable.toString().isEmpty())
                        ((View)schoolcode_login.getParent()).setBackgroundResource(R.drawable.line_correct);
                    else
                        ((View)schoolcode_login.getParent()).setBackgroundResource(R.drawable.line_wrong);

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
                               // String token = FirebaseInstanceId.getInstance().getToken();
                              //  Log.d("String", "clidked" + token);

                                String randomid= UUID.randomUUID().toString().replaceAll("-","")
                                        .replaceAll("[^\\d.]","");

                                Log.d("String", "clidked" + randomid);
                                preferences.edit().putString("UniqueID",randomid).apply();

//           Z     Log.d(TAG, "fcm token: " + token);
                                if (mobile_login.getText().toString().equals("")) {
                                    alertError("User name is mandatory");
                                } else if (password_login.getText().toString().equals("")) {
                                    alertError("Password is mandatory");
                                } else if (schoolcode_login.getText().toString().isEmpty()) {
                                    alertError("School code is mandatory");
                                }
                                else if (!validate(mobile_login.getText().toString())) {
                                    alertError("Email ID is not valid");
                                }
                                else {

                                    try {
                                        pDialog = new SweetAlertDialog(Login.this, SweetAlertDialog.PROGRESS_TYPE);
                                        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                                        pDialog.setTitleText("Loading ...");
                                        pDialog.setCancelable(false);
                                        pDialog.show();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }


                                    new LoginTask(new DownloadCallback() {
                                        @Override
                                        public void onDownloadInterrupted(String cause) {
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    pDialog.dismiss();
                                                    alertError("Try Again!!!", cause);
                                                }
                                            });

                                        }

                                        @Override
                                        public void onDownloadCompleted(String json) {
                                            pDialog.dismiss();
                                            try {
                                                JSONObject jsonResponse = new JSONObject(json);
                                                Log.d("detail", jsonResponse.toString());
                                                if (jsonResponse.getString("code").equals("100")) {
                                                    JSONObject student=jsonResponse.getJSONObject("details").getJSONObject("students");
                                                    JSONObject school=jsonResponse.getJSONObject("details").getJSONObject("schools");
                                                    preferences.edit()
                                                            .putBoolean("LoggedIn",true)
                                                            .putString("StudentId",student.getString("student_id"))
                                                            .putString("StudentName",student.getString("student_name"))
                                                            .putString("RollNo",student.getString("roll_no"))
                                                            .putString("LoginName",student.getString("login_name"))
                                                            .putString("SchoolLogo",school.getString("school_logo"))
                                                            .putString("SchoolName",school.getString("name_display"))
                                                            .putString("SchoolId",school.getString("schoolid"))
                                                            .putString("SchoolCode",school.getString("school_code"))
                                                            .putString("AcademicYear",school.getString("academic_year"))
                                                            .putString("ClassName",student.getString("class_name"))
                                                            .putString("StudentMobileNo",student.getString("mobile_no"))
                                                            .putString("ParentName",student.getString("parent-name"))
                                                            .putString("Email_Id",student.getString("email_address"))
                                                            .putString("City",student.getString("city"))
                                                            .apply();

                                                    startActivity(new Intent(Login.this,Dashboard.class));
                                                    finish();
                                                } else
                                                    alertError("Error!!!", jsonResponse.getString("error"));

                                            } catch (Exception e) {
                                                e.printStackTrace();
                                                alertError("Try Again!!!", "Something went wrong while logging in...");

                                            }

                                        }
                                    }).execute(mobile_login.getText().toString(), password_login.getText().toString(), schoolcode_login.getText().toString(),
                                            /* token*/"adfat2344#$5SDsdfsf",randomid);


                                    //   userLogin(hashMap);


                                }
                            }
                            break;
                    }
                    return true;
                }
            });
//        login_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                startActivity(new Intent(Login.this,Dashboard.class));
////                finish();
//
//            }
//        });
        }
    }

    public void alertError(String title,String message) {
        new SweetAlertDialog(Login.this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(title)
                .setContentText(message)
                .show();

    }

    public void alertError(String message) {
        new SweetAlertDialog(Login.this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Missing!!!")
                .setContentText(message)
                .show();

    }

    private void userLogin(HashMap<String, String> hashMap) {
        Call<LoginData> call = APIUrl.getService().userLogin(hashMap);

        call.enqueue(new Callback<LoginData>() {
            @Override
            public void onResponse(Call<LoginData> call, Response<LoginData> response) {

                LoginData loginResponse = response.body();

                if (response.isSuccessful()){
                    if (loginResponse.getSuccess() == 1) {

                        pref = new Pref(getApplicationContext());

                        pref.setLogin(loginResponse.getBodyData().getToken(), loginResponse.getBodyData().getName(),
                                loginResponse.getBodyData().getEmail(), loginResponse.getBodyData().getMobile(),
                                loginResponse.getBodyData().getFcmtoken());

                        pref.setVolumeval("1");
                        startActivity(new Intent(Login.this, Dashboard.class));

                        pDialog.cancel();
//                    Toast.makeText(Login.this, "user role" + sharedPreferences.getInt(USER_ROLE, 0), Toast.LENGTH_SHORT).show();
                    } else {
                        pDialog.cancel();
                        alertError(loginResponse.getMessage());
                    }
                } else {
                    pDialog.cancel();
                    new SweetAlertDialog(Login.this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Wrong")
                            .setContentText("Invalid Details")
                            .show();
                }
//                    if (response.code() == 200) { // CEMP05, jZ2vldDy


            }

            @Override
            public void onFailure(Call<LoginData> call, Throwable t) {

            }
        });
    }

    public void gotoRegister(View view) {
        startActivity(new Intent(this,RegisterActivity.class));
    }


}
