package com.mariapublishers.digimariaandroid.activity.mainprocess;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.http.DownloadCallback;
import com.mariapublishers.digimariaandroid.http.GetCityListTask;
import com.mariapublishers.digimariaandroid.http.GetClassListTask;
import com.mariapublishers.digimariaandroid.http.GetSchoolsTask;
import com.mariapublishers.digimariaandroid.http.RegisterTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class UserDetailRegister extends AppCompatActivity {


    SweetAlertDialog pDialog;

    String id = "", selectedschoolid = "", selectedclassid = "";
    JSONArray cityJSON, schoolJSON, classJSON;
    TextView city, school, tvClass;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail_register);

        SharedPreferences preferences = getSharedPreferences("DigiMaria", MODE_PRIVATE);
        pDialog = new SweetAlertDialog(UserDetailRegister.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading ...");
        pDialog.setCancelable(false);

        if (preferences.getBoolean("LoggedIn", false)) {
            startActivity(new Intent(this, Dashboard.class));
            finish();
        } else {
            EditText parent = findViewById(R.id.parent_reg);
            EditText student = findViewById(R.id.student_reg);
//            EditText classn = findViewById(R.id.class_reg);
            EditText rollno = findViewById(R.id.rollnum_reg);
            city = findViewById(R.id.city_reg);
            school = findViewById(R.id.school_reg);
            tvClass = findViewById(R.id.tv_class_reg);

            setTextWatcher(parent);
            setTextWatcher(student);
//            setTextWatcher(classn);
            setTextWatcher(rollno);

            city.setOnClickListener(view -> {
                if (cityJSON == null) {
                    pDialog.show();
                    new GetCityListTask(new DownloadCallback() {
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
                                    cityJSON = jsonResponse.getJSONArray("details");
                                    showList(0);
                                } else
                                    alertError("Error!!!", jsonResponse.getString("error"));

                            } catch (Exception e) {
                                e.printStackTrace();
                                alertError("Try Again!!!", "Something went wrong while logging in...");

                            }

                        }
                    }).execute();


                } else
                    showList(0);

            });

            school.setOnClickListener(view -> {
                if (id.isEmpty())
                    Toast.makeText(UserDetailRegister.this, "Choose City First", Toast.LENGTH_SHORT).show();
                else {
                    if (schoolJSON == null) {
                        pDialog.show();
                        new GetSchoolsTask(new DownloadCallback() {
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
                                        schoolJSON = jsonResponse.getJSONArray("details");
                                        showList(1);
                                    } else
                                        alertError("Error!!!", jsonResponse.getString("error"));

                                } catch (Exception e) {
                                    e.printStackTrace();
                                    alertError("Try Again!!!", "Something went wrong while logging in...");

                                }

                            }
                        }).execute(id);


                    } else
                        showList(1);
                }
            });

            tvClass.setOnClickListener(view -> {
                if (classJSON == null) {
                    pDialog.show();
                    new GetClassListTask(new DownloadCallback() {
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
                                    classJSON = jsonResponse.getJSONArray("details");
                                    showList(2);
                                } else
                                    alertError("Error!!!", jsonResponse.getString("error"));

                            } catch (Exception e) {
                                e.printStackTrace();
                                alertError("Try Again!!!", "Something went wrong while logging in...");

                            }

                        }
                    }).execute();


                } else
                    showList(2);

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
                                String parentname = parent.getText().toString();
                                String studentname = student.getText().toString();
//                                String classname = classn.getText().toString();
                                String rollnum = rollno.getText().toString();
                                if (parentname.isEmpty())
                                    alertError("Parent name is mandatory");
                                else if (studentname.isEmpty())
                                    alertError("Student name is mandatory");
//                                else if (classname.isEmpty())
//                                    alertError("Class is mandatory");
//                                else if (rollnum.isEmpty())
//                                    alertError("Roll Number is mandatory");
                                else if (id.isEmpty())
                                    alertError("City is mandatory");
                                else if (selectedschoolid.isEmpty())
                                    alertError("School is mandatory");
                                else if (selectedclassid.isEmpty())
                                    alertError("Class is mandatory");
                                else if (rollnum.isEmpty())
                                    alertError("Roll Number is mandatory");
                                else {
                                    pDialog.show();
                                    System.out.println("Reg inputs name " + studentname + " roll " + rollnum + " phone " +
                                            getIntent().getStringExtra("Phone") + " email " + getIntent().getStringExtra("Email") + " parent " + parentname + " schoolid " + selectedschoolid + " class "+ "classname" + " " + selectedclassid);
                                    new RegisterTask(new DownloadCallback() {
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
                                                    SweetAlertDialog dialog = new SweetAlertDialog(UserDetailRegister.this, SweetAlertDialog.SUCCESS_TYPE);
                                                    dialog.setTitle("Completed");
                                                    dialog.setContentText("Successfully Registered. Please check your mail and proceed to login");
                                                    dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                                                        @Override
                                                        public void onCancel(DialogInterface dialogInterface) {
                                                            Intent intent = new Intent(getApplicationContext(), Login.class);
                                                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                            startActivity(intent);
                                                        }
                                                    });
                                                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                                        @Override
                                                        public void onDismiss(DialogInterface dialogInterface) {
                                                            Intent intent = new Intent(getApplicationContext(), Login.class);
                                                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                            startActivity(intent);
                                                        }
                                                    });
                                                    dialog.show();
                                                } else {
                                                    SweetAlertDialog dialog = new SweetAlertDialog(UserDetailRegister.this, SweetAlertDialog.ERROR_TYPE);
                                                    dialog.setTitle("Failed");
                                                    dialog.setContentText("Registered Failed. Please try again with valid inputs.");
                                                    dialog.show();
                                                }
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }).execute(studentname, rollnum,
                                            getIntent().getStringExtra("Phone"), getIntent().getStringExtra("Email"), parentname, selectedschoolid, selectedclassid); // classname
                                }
                            }
                            break;
                    }
                    return true;
                }
            });
        }
    }

    private void showList(int i) {
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        final LayoutInflater inflater = getLayoutInflater();
        final View view = inflater.inflate(R.layout.alert_list_layout, null);
        build.setView(view);
        AlertDialog parentDialog = build.create();
        parentDialog.setCancelable(true);
        ((TextView) view.findViewById(R.id.title)).setText(i == 0 ? "Cities" : i == 1 ? "Schools" : "Class");
        parentDialog.setCanceledOnTouchOutside(true);
        parentDialog.getWindow().getAttributes().windowAnimations = R.style.MyDialogAnimation;
        parentDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ListView listView = view.findViewById(R.id.listview);
        ItemListAdapter adapter = new ItemListAdapter(i == 0 ? cityJSON : i == 1 ? schoolJSON : classJSON, i);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int j, long l) {
                parentDialog.dismiss();
                if (i == 0) {
                    try {
                        id = (cityJSON.getJSONObject(j).getString("id"));
                        city.setText(cityJSON.getJSONObject(j).getString("name"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    school.setText("");
                    selectedschoolid = "";
                    schoolJSON = null;
                } else if (i == 1) {
                    try {
                        selectedschoolid = (schoolJSON.getJSONObject(j).getString("schoolid"));
                        school.setText(schoolJSON.getJSONObject(j).getString("schoolname"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        selectedclassid = (classJSON.getJSONObject(j).getString("classid"));
                        tvClass.setText(classJSON.getJSONObject(j).getString("classname"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        parentDialog.show();

    }

    private void setTextWatcher(EditText mobile_login) {

        mobile_login.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!(editable.toString().isEmpty()))
                    ((View) mobile_login.getParent()).setBackgroundResource(R.drawable.line_correct);
                else
                    ((View) mobile_login.getParent()).setBackgroundResource(R.drawable.line_wrong);

            }
        });
    }

    public void alertError(String title, String message) {
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

    private class ItemListAdapter extends BaseAdapter {
        JSONArray list;
        int type;

        ItemListAdapter(JSONArray arr, int type) {
            list = arr;
            this.type = type;
        }

        @Override
        public int getCount() {
            return list.length();
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }


        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null)
                view = getLayoutInflater().inflate(R.layout.item_textview, viewGroup, false);
            try {
                ((TextView) view).setText(list.getJSONObject(i).getString(type == 0 ? "name" : type == 1 ? "schoolname" : "classname"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return view;
        }
    }
}