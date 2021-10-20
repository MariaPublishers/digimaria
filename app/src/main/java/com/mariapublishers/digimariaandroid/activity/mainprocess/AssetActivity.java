package com.mariapublishers.digimariaandroid.activity.mainprocess;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.http.DownloadCallback;
import com.mariapublishers.digimariaandroid.http.GetAssetsTask;
import com.mariapublishers.digimariaandroid.http.GetBooksTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.util.ArrayList;
import java.util.Objects;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class AssetActivity extends AppCompatActivity {
        RecyclerView recyclerView;
        SweetAlertDialog pDialog;
        SharedPreferences preferences;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_content);
            preferences=getSharedPreferences("DigiMaria",MODE_PRIVATE);
            recyclerView=findViewById(R.id.mainRecyclerView);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            SharedPreferences preferences=getSharedPreferences("DigiMaria",MODE_PRIVATE);

            ((TextView)findViewById(R.id.title)).setText("Assets");
            ((CardView)findViewById(R.id.card)).setCardBackgroundColor(getIntent().getIntExtra("color",0));
            ((ImageView)findViewById(R.id.image)).setImageResource(getIntent().getIntExtra("drawable",0));
            TextView sub=  ((TextView)findViewById(R.id.subject));sub.setText(getIntent().getStringExtra("SubjectName"));

            {

                pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
                pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialog.setTitleText("Loading ...");
                pDialog.setCancelable(false);
                pDialog.show();


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
                        pDialog.dismiss();
                        Log.d("String",json);
                        try {
                            JSONObject jsonResponse = new JSONObject(json);
                            Log.d("detail", jsonResponse.toString());
                            if (jsonResponse.getString("code").equals("100")) {
                                JSONObject student=jsonResponse.getJSONArray("details").getJSONObject(0);

                                if (student != null)
                                {
                                    sub.setText(student.getString("assetspicname"));
                                    JSONArray array=student.getJSONArray("assetdetails");
                                    ((TextView)findViewById(R.id.count)).setText(array.length()+" Asset(s)");
                                    recyclerView.setAdapter(new BooksAdapter(array));
                                }
                            } else
                                alertError("Error!!!", jsonResponse.getString("error"));

                        } catch (Exception e) {
                            e.printStackTrace();
                            alertError("Try Again!!!", "Something went wrong...");

                        }

                    }
                }).execute(preferences.getString("StudentId","0"),getIntent().getStringExtra("AssetId"),preferences.getString("UniqueID","0"));


                //   userLogin(hashMap);



            }
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
            BooksAdapter(JSONArray arr)
            {
                array= arr;
            }
            @NonNull
            @Override
            public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new Holder(getLayoutInflater().inflate(R.layout.item_asset,parent,false));
            }

            @Override
            public void onBindViewHolder(@NonNull Holder holder, int position) {
                try {
                    JSONObject object=array.getJSONObject(position);
                    holder.title.setText(object.getString("name"));
                    String url=object.getString("bookimgpath");
                    holder.next.setImageResource(url.contains("zip")?R.drawable.icon_download:R.drawable.icon_link);
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            try {
                                if(url.contains("zip"))
                                {
                                    curtit=holder.title.getText().toString();cururl=url;
                                    if(isStorageAccessNOTGranted()) {
                                        if (preferences.getBoolean("GoToSettings", false))
                                            showGoToSettingsDialog();
                                        else
                                            askPermissions();
                                    }
                                    else
                                        downloadFile();
                                }
                                else
                                    startActivity(new Intent(AssetActivity.this,WebViewActivity.class)
                                    .putExtra("URL",url)
                                    .putExtra("Title",holder.title.getText().toString()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (Exception e) {
                   // e.printStackTrace();
                }

            }

            @Override
            public int getItemCount() {
                return array.length();
            }

            class Holder extends RecyclerView.ViewHolder
            {
                TextView title;
                ImageView next;
                public Holder(@NonNull View itemView) {
                    super(itemView);
                    title=itemView.findViewById(R.id.title);
                    next=itemView.findViewById(R.id.icon);
                }
            }
        }

        String cururl,curtit;
    public void downloadFile() {
        if(!cururl.toLowerCase().startsWith("http")) {
            Toast.makeText(this, "Can't download", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this,"Downloading...",Toast.LENGTH_SHORT).show();

        DownloadManager.Request request1 = new DownloadManager.Request(Uri.parse(cururl));
        request1.setDescription("Downloading Zip File...");   //appears the same in Notification bar while downloading
        request1.setTitle(curtit);
        request1.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,  curtit+System.currentTimeMillis()+".zip");
        DownloadManager manager1 = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        Objects.requireNonNull(manager1).enqueue(request1);
    }

    private void showGoToSettingsDialog() {
        View contentview=getLayoutInflater().inflate(R.layout.layout_simple_bottomalert,null);
        final BottomSheetDialog dialog=new BottomSheetDialog(this);
        dialog.setContentView(contentview);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        contentview.findViewById(R.id.positivebutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                try {
                    Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    intent.setData(Uri.parse("package:" + getPackageName()));
                    startActivity(intent);

                } catch ( ActivityNotFoundException e ) {
                    //Open the generic Apps page:
                    Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS);
                    startActivity(intent);

                }
            }
        });

        contentview.findViewById(R.id.negativebutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();

            }
        });
        dialog.show();
    }


    private void askPermissions() {
        ArrayList<String> permissions=new ArrayList<>();
            permissions.add(android.Manifest.permission.READ_EXTERNAL_STORAGE);
            permissions.add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        ActivityCompat.requestPermissions(this,permissions.toArray(new String[0]), 1);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {
        try {
            if (requestCode==1) {
                if (!isStorageAccessNOTGranted())
                    downloadFile();
                else {
                    Toast.makeText(getApplicationContext(), "Permissions not granted", Toast.LENGTH_SHORT).show();
                    if(isStorageAccessNOTGranted())
                    {
                        boolean yes=!shouldShowRequestPermissionRationale(android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
                        preferences.edit().putBoolean("GoToSettings",yes).apply();

                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    boolean isStorageAccessNOTGranted() {

        return ContextCompat.checkSelfPermission(getApplicationContext(),
                android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(getApplicationContext(),
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED;

    }

}