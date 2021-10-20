package com.mariapublishers.digimariaandroid.activity.mainprocess;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.model.licence.LicenceData;
import com.mariapublishers.digimariaandroid.retrofit.APIUrl;

import java.util.HashMap;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LicenceKey extends AppCompatActivity {

    private static final String TAG = "LicenceKey.java";
    HashMap<String, String> hashMap;
    Intent getId;
    String bookid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getId = getIntent();
        if (getId.getStringExtra("bookid").equals("")) {
            Toast.makeText(this, "Failed to get book id", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LicenceKey.this, Dashboard.class));
        } else {
            setContentView(R.layout.activity_licence_key);

            CardView redeemkey = findViewById(R.id.redeemkey);
            final EditText key1 = findViewById(R.id.key1);
            final EditText key2 = findViewById(R.id.key2);
            final EditText key3 = findViewById(R.id.key3);
            final EditText key4 = findViewById(R.id.key4);
            redeemkey.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (key1.getText().toString().equals("") && key2.getText().toString().equals("") &&
                            key3.getText().toString().equals("") && key4.getText().toString().equals("")) {
                        new SweetAlertDialog(LicenceKey.this, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Error")
                                .setContentText("Fill the key for vaild it.")
                                .show();
                    } else {
                        hashMap = new HashMap<>();

                        String key = key1.getText().toString() + "-" + key2.getText().toString() + "-"
                                + key3.getText().toString() + "-" + key4.getText().toString();
                        bookid = getId.getStringExtra("bookid");
                        hashMap.put("redeemcode", key);
                        hashMap.put("bookid", bookid);
                        Log.d(TAG, "onClick: " + hashMap);
                        userSignIn(hashMap);
                    }
                }
            });

        }

    }

    private void userSignIn(HashMap<String, String> hashMap) {

//        Log.d(TAG, "userSignIn: " + token);

        Call<LicenceData> call = APIUrl.getService().licenceKey(hashMap);

        call.enqueue(new Callback<LicenceData>() {
            @Override
            public void onResponse(Call<LicenceData> call, Response<LicenceData> response) {

                LicenceData loginResponse = response.body();

                if (response.isSuccessful()) {
                    if (loginResponse.getSuccess() == 1) {
                        new SweetAlertDialog(LicenceKey.this, SweetAlertDialog.SUCCESS_TYPE)
                                .setTitleText("Success")
                                .setContentText(loginResponse.getMessage())
                                .setConfirmText("Take Me to Book")
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        Intent intent = new Intent(LicenceKey.this, BookLanding.class);
                                        intent.putExtra("bookid", bookid);
                                        startActivity(intent);
                                    }
                                })
                                .show();
//                    showCustomDialogSuccessOk("Success", "Login Success");
                    } else {
//                    showCustomDialogFailedOk("Sorry", "Wrong Crediantials");
                        new SweetAlertDialog(LicenceKey.this, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Error")
                                .setContentText(loginResponse.getMessage())
                                .show();
                        Toast.makeText(LicenceKey.this, "Nothing Found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LicenceKey.this, "Server Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LicenceData> call, Throwable t) {

                Log.d("on Failure", "" + t.getLocalizedMessage());

            }
        });

    }
}
