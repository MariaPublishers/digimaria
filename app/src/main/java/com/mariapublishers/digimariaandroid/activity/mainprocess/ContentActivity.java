package com.mariapublishers.digimariaandroid.activity.mainprocess;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.http.DownloadCallback;
import com.mariapublishers.digimariaandroid.http.GetAssetsTask;
import com.mariapublishers.digimariaandroid.http.GetBooksTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class ContentActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SweetAlertDialog pDialog;
    SharedPreferences  preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        recyclerView=findViewById(R.id.mainRecyclerView);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        preferences=getSharedPreferences("DigiMaria",MODE_PRIVATE);

        ((CardView)findViewById(R.id.card)).setCardBackgroundColor(getIntent().getIntExtra("color",0));
        ((ImageView)findViewById(R.id.image)).setImageResource(getIntent().getIntExtra("drawable",0));
        ((TextView)findViewById(R.id.subject)).setText(getIntent().getStringExtra("SubjectName"));

        {

            pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
            pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            pDialog.setTitleText("Loading ...");
            pDialog.setCancelable(false);
            pDialog.show();
//            ArrayList<String> subNameList=new ArrayList();
            if (getIntent().getStringExtra("SubjectName").equals("Others"))
            {
                String[] subId=getIntent().getStringExtra("SubjectId").split("##");
                HashMap<String,JSONArray> hashMap=new HashMap<>();

                for (int i=0;i<subId.length;i++)
                {
                    int finalI = i;
                    new GetBooksTask(new DownloadCallback() {
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

                            Log.d("String",json);
                            try {
                                JSONObject jsonResponse = new JSONObject(json);
                                Log.d("Book detail", jsonResponse.toString());
                                if (jsonResponse.getString("code").equals("100")) {
                                    JSONArray student=jsonResponse.getJSONArray("details");
                                    if (student != null)
                                    {
                                        hashMap.put(subId[finalI].split(",")[0],student);
                                        if (finalI==subId.length-1)
                                        {
                                            mergeMultiJsonArray(hashMap);
                                        }
                                    }else
                                        pDialog.dismiss();
                                } else
                                    alertError("Error!!!", jsonResponse.getString("error"));

                            } catch (Exception e) {
                                e.printStackTrace();
                                alertError("Try Again!!!", "Something went wrong...");

                            }

                        }
                    }).execute(preferences.getString("StudentId","0"),subId[i].split(",")[1],preferences.getString("UniqueID","0"));
                }

            }else
            {
                new GetBooksTask(new DownloadCallback() {
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
//
                        Log.d("String",json);
                        try {
                            JSONObject jsonResponse = new JSONObject(json);
                            Log.d("detail", jsonResponse.toString());
                            if (jsonResponse.getString("code").equals("100")) {
                                JSONArray student=jsonResponse.getJSONArray("details");
                                if (student != null)
                                {
                                    if ( assetList!=null)
                                        assetList.clear();

                                     getAsset(student);

                                }else
                                    pDialog.dismiss();
                            } else
                                alertError("Error!!!", jsonResponse.getString("error"));

                        } catch (Exception e) {
                            e.printStackTrace();
                            alertError("Try Again!!!", "Something went wrong...");

                        }

                    }
                }).execute(preferences.getString("StudentId","0"),getIntent().getStringExtra("SubjectId"),preferences.getString("UniqueID","0"));


            }

            //   userLogin(hashMap);



        }
    }
    public void getAsset(JSONArray student)
    {
        for (int i=0;i<student.length();i++)
        {
            try {
                JSONObject object=student.getJSONObject(i);
                int finalI = i;
                new GetAssetsTask(new DownloadCallback() {
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

                        Log.d("String",json);
                        try {
                            JSONObject jsonResponse = new JSONObject(json);
                            Log.d("detail", jsonResponse.toString());
                            if (jsonResponse.getString("code").equals("100")) {
                                JSONObject student1=jsonResponse.getJSONArray("details").getJSONObject(0);

                                if (student1 != null)
                                {
                                    JSONArray array=student1.getJSONArray("assetdetails");
                                    assetList.add(array.length());

                                    if (finalI==student.length()-1 && !getIntent().getStringExtra("SubjectName").equals("Others"))
                                    {
                                        pDialog.dismiss();
                                        ((TextView)findViewById(R.id.count)).setText(student.length()+" Book(s)");
                                        recyclerView.setAdapter(new BooksAdapter(student,new ArrayList(),assetList));
                                    }
                                }
                            } else
                                alertError("Error!!!", jsonResponse.getString("error"));

                        } catch (Exception e) {
                            e.printStackTrace();
                            alertError("Try Again!!!", "Something went wrong...");

                        }

                    }
                }).execute(preferences.getString("StudentId","0"),object.getString("bookassignid"),preferences.getString("UniqueID","0"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
    ArrayList<Integer> assetList=new ArrayList<>();
    public void mergeMultiJsonArray(HashMap<String,JSONArray> arrays) {
        ArrayList<String> subNameList=new ArrayList();
        JSONArray outArray = new JSONArray();
        assetList.clear();
        for(String key: arrays.keySet()) {
            JSONArray array = arrays.get(key);
            for (int i = 0; i < array.length(); i++)
            {
                outArray.put(array.optJSONObject(i));
                subNameList.add(key);
            }
            getAsset(array);
        }

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                pDialog.dismiss();

                ((TextView)findViewById(R.id.count)).setText(subNameList.size()+" Book(s)");
                recyclerView.setAdapter(new BooksAdapter(outArray,subNameList,assetList));
            }
        }, 5000);



    }

    public void onBackPressed(View view) {
        finish();
    }
    public void alertError(String title,String message) {
        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(title)
                .setContentText(message)
                .show();

    }

    class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.Holder>
    {
        JSONArray array;
        ArrayList<String> subNameList;
        ArrayList<Integer> assetCountList;
        BooksAdapter(JSONArray arr,ArrayList<String> subNameList, ArrayList<Integer> assetCountList)
        {
           array= arr;
           this.subNameList=subNameList;
            this.assetCountList=assetCountList;
        }
        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new Holder(getLayoutInflater().inflate(R.layout.item_content,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            try {
                JSONObject object=array.getJSONObject(position);
                holder.title.setText(object.getString("booktitle"));
                holder.pages.setText(subNameList.size()==0?assetCountList.get(position)+" Asset(s)":subNameList.get(position)+" [ "+assetCountList.get(position)+" Asset(s) ]");//object.getString("no_of_pages")

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            startActivity(new Intent(ContentActivity.this,AssetActivity.class)
                                    .putExtra("color",getIntent().getIntExtra("color",0))
                                    .putExtra("drawable",getIntent().getIntExtra("drawable",0))
                                    .putExtra("SubjectName",subNameList.size()==0?getIntent().getStringExtra("SubjectName"):subNameList.get(position))
                                    .putExtra("AssetId",object.getString("bookassignid")));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public int getItemCount() {
            return array.length();
        }

        class Holder extends RecyclerView.ViewHolder
        {
            TextView title,pages,pages1;
            ImageView next;
            public Holder(@NonNull View itemView) {
                super(itemView);
                title=itemView.findViewById(R.id.title);
                pages=itemView.findViewById(R.id.pages);
                pages1=itemView.findViewById(R.id.pages1);
            }
        }
    }


}