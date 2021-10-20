package com.mariapublishers.digimariaandroid.activity.mainprocess;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.adapter.Book;
import com.mariapublishers.digimariaandroid.adapter.PublicationListAdapter;
import com.mariapublishers.digimariaandroid.http.DownloadCallback;
import com.mariapublishers.digimariaandroid.http.GetPublicationTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class PublicationActivity extends AppCompatActivity
{
    public SweetAlertDialog pDialog;
    SharedPreferences preferences;
    PublicationListAdapter adapter;
    LinearLayout nothing;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publication);

        init();

    }

    private void init() {
        try {

            findViewById(R.id.toback).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
            preferences = getSharedPreferences("DigiMaria", MODE_PRIVATE);
            pDialog = new SweetAlertDialog(PublicationActivity.this, SweetAlertDialog.PROGRESS_TYPE);
            pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            pDialog.setTitleText("Loading ...");
            pDialog.setCancelable(false);
            pDialog.show();

            nothing = findViewById(R.id.nothing);

            updatePubilication();

            EditText seacrhText=findViewById(R.id.search_et);
            seacrhText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    try {
                        if (adapter!=null)
                             adapter.filter(seacrhText.getText().toString().toLowerCase(),nothing);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
            findViewById(R.id.home_some).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });

        }catch (Exception e){e.printStackTrace();}
    }
    private void updatePubilication() {
        try {
            RecyclerView recyclerView = findViewById(R.id.publication_rv);
            GridLayoutManager gridLayoutManager=new GridLayoutManager(this,1);
            recyclerView.setLayoutManager(gridLayoutManager);

            new GetPublicationTask(new DownloadCallback() {
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
                        Log.d("Publication detail", jsonResponse.toString());
                        if (jsonResponse.getString("code").equals("100")) {
                            JSONArray publicationarray=jsonResponse.getJSONArray("details");
                            if (publicationarray != null)
                            {
                                ArrayList<JSONObject> publicationList=new ArrayList<>();
                                for (int i=0;i<publicationarray.length();i++)
                                {
                                    publicationList.add(publicationarray.getJSONObject(i));
//                                    Log.i("------",publicationarray.getJSONObject(i).getString("booktitle")+"--coverImage----"+publicationarray.getJSONObject(i).getString("bookcover"));
                                               }
//                                Log.i("------","--coverImage totlal----"+publicationList.size());
                                adapter = new PublicationListAdapter(getApplicationContext(),   publicationList,"publication");
                                recyclerView.setAdapter(adapter);
                            }

                        } else
                            alertError("Error!!!", jsonResponse.getString("error"));

                    } catch (Exception e) {
                        e.printStackTrace();
                        alertError("Try Again!!!", "Something went wrong...");

                    }

                }
            }).execute(preferences.getString("StudentId","0"),"1",preferences.getString("UniqueID","0"));

            //creating gridview adapter


        }catch (Exception e){e.printStackTrace();}
    }
    public void alertError(String title, String message) {
        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(title)
                .setContentText(message)
                .show();

    }
}
