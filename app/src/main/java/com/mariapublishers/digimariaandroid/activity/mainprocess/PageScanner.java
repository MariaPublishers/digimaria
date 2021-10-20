package com.mariapublishers.digimariaandroid.activity.mainprocess;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.model.arvideo.ArData;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.retrofit.APIUrl;
import com.mariapublishers.digimariaandroid.service.MusicService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import androidx.core.app.ActivityCompat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PageScanner extends BaseActivity {

    private static final String TAG = "PageScanner";
    SurfaceView cameraView;
    TextView textView;
    CameraSource cameraSource;
    HashMap<String, String> hashMap;
    String valData = "", bookid = "";
    int i = 0;

    DisplayMetrics metrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_scanner);

        cameraView = (SurfaceView) findViewById(R.id.surface_view);
        textView = (TextView) findViewById(R.id.text_view);

        if (getIntent() != null && getIntent().getExtras() != null)
            bookid = getIntent().getStringExtra("bookid");

        currentContext = PageScanner.this;
        pref = new Pref(this);
        volval = pref.getVolumeval();

        volumenote = findViewById(R.id.volumenote);

        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        volumenote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (volval != null) {
                    if (volval.equals("1")) {
                        pref.setVolumeval("0");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeoff);
                        stopService(new Intent(PageScanner.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(PageScanner.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(PageScanner.this, MusicService.class));
                }


            }
        });

        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }

        ImageView toback = findViewById(R.id.toback);
        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Page Scanner");

        toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageScanner.this, RedirectVideo.class);
                intent.putExtra("bookid", pref.getClassid());
                startActivity(intent);
                finish();
            }
        });

        TextRecognizer textRecognizer = new TextRecognizer.Builder(getApplicationContext()).build();
        if (!textRecognizer.isOperational()) {
            Log.w("PageActivity", "Detector dependencies are not yet available");
        } else {

            hashMap = new HashMap<>();

            cameraSource = new CameraSource.Builder(getApplicationContext(), textRecognizer)
                    .setFacing(CameraSource.CAMERA_FACING_BACK)
                    .setRequestedPreviewSize(metrics.heightPixels, metrics.widthPixels)
                    .setRequestedFps(2.0f)
                    .setAutoFocusEnabled(true)
                    .build();
            cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
                @Override
                public void surfaceCreated(SurfaceHolder surfaceHolder) {

                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
                        Dexter.withActivity(PageScanner.this)
                                .withPermissions(
                                        Manifest.permission.READ_EXTERNAL_STORAGE,
                                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                        Manifest.permission.CAMERA)
                                .withListener(new MultiplePermissionsListener() {
                                    @Override
                                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                                        // check if all permissions are granted
                                        if (report.areAllPermissionsGranted()) {
                                            recreate();
                                        }

                                        // check for permanent denial of any permission
                                        if (report.isAnyPermissionPermanentlyDenied()) {
                                            // permission is denied permenantly, navigate user to app settings
                                        }
                                    }

                                    @Override
                                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                                        token.continuePermissionRequest();
                                    }
                                })
                                .onSameThread()
                                .check();
                    } else {
                        if (i == 0) {
                            try {
                                cameraSource.start(cameraView.getHolder());
                                i += 1;
                            } catch (IOException e) {
                                Log.d(TAG, "surfaceCreated: " + e.getMessage());
                            }
                        }
                    }

                }

                @Override
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

                }

                @Override
                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    cameraSource.stop();
                }
            });

            textRecognizer.setProcessor(new Detector.Processor<TextBlock>() {
                @Override
                public void release() {

                }

                @Override
                public void receiveDetections(Detector.Detections<TextBlock> detections) {

                    final SparseArray<TextBlock> items = detections.getDetectedItems();
                    if (items.size() != 0) {
                        textView.post(new Runnable() {
                            @Override
                            public void run() {
                                if (i <= 3) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    for (int j = 0; j < items.size(); ++j) {
                                        TextBlock item = items.valueAt(j);
                                        stringBuilder.append(item.getValue());
                                        stringBuilder.append(" ");
//                                        textView.setText(stringBuilder.toString());
//                                        stringBuilder.append("\n");
                                    }
                                    valData = stringBuilder.toString();
                                    i += 1;
                                } else {
                                    Log.d(TAG, "run: " + i);
                                    if (i == 4) {
                                        if (valData != null) {
//                                            if (valData.length() >= 15) {
//                                                textView.setText(valData);
                                            valData = valData.replace(",", "");
                                            valData = valData.replace(".", "");
                                            valData = valData.replace("!", "");
                                            valData = valData.replace("&", "");
                                            valData = valData.replace(";", "");
                                            valData = valData.replace(":", "");
                                            valData = valData.replace("?", "");
                                            valData = valData.replace("$", "");
                                            valData = valData.replace("#", "");
                                            valData = valData.replace("}", "");
                                            valData = valData.replace("{", "");
                                            valData = valData.replace("'", "");
                                            valData = valData.replace("/", "");
                                            valData = valData.replace("<", "");
                                            valData = valData.replace(">", "");
                                            valData = valData.replace("|", "");
                                            valData = valData.replace("[", "");
                                            valData = valData.replace("]", "");
                                            valData = valData.replace("-", "");
                                            valData = valData.replace("\n", " ");
//                                                valData = valData.replace(" ", "");
                                            valData = valData.toLowerCase();
                                            valData = valData.replace("colours t love", "colours i love");
                                            valData = valData.replace("colours tlove", "colours i love");
                                            valData = valData.replace("ILOVE", "I LOVE");
                                            valData = valData.replace("ilove", "i love");
                                            valData = valData.replace("Ilove", "i love");
                                            valData = valData.replace("t love", "i love");
                                            valData = valData.replace("T LOVE", "I LOVE");
                                            valData = valData.replace("TAM", "I AM");
                                            valData = valData.replace("T AM", "I AM");
                                            valData = valData.replace("tam", "i am");
                                            valData = valData.replace("t am", "i am");
                                            valData = valData.replace("thave", "i have");
                                            valData = valData.replace("t have", "i have");

//                                                if (valData.length() < 30 || valData.length() > 15) {
//                                                    valData = valData.substring(0, 10);
//                                                } else {
//                                                    valData = valData.substring(0, 30);
//                                                }
//                                                textView.setText(valData);
                                            pref = new Pref(PageScanner.this);
                                            Log.d("valval", "valdata" + valData);
                                            hashMap.put("videocontent", valData);
                                            hashMap.put("bookid", bookid);
                                            userSignIn(hashMap);
                                            i += 1;
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void userSignIn(HashMap<String, String> hashMap) {

        cameraSource.stop();
//        Log.d(TAG, "userSignIn: " + token);

//        Log.d(TAG, "onResponse: coming" + hashMap);

        final Pref pref = new Pref(getApplicationContext());
        Call<ArData> call = APIUrl.getService().getAR("test", hashMap);

        call.enqueue(new Callback<ArData>() {
            @Override
            public void onResponse(Call<ArData> call, Response<ArData> response) {

                ArData loginResponse = response.body();

                if (response.isSuccessful()) {
                    if (loginResponse.getSuccess() == 1) {

                        if (loginResponse.getMessage() != null &&
                                loginResponse.getMessage().equals("Wrong destination. Please scan the correct book.")) {
                            Toast.makeText(PageScanner.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                            recreate();
                        } else if (loginResponse.getArlist() != null) {
                            Log.d(TAG, "onResponse: " + loginResponse.getArlist().getBookvideopath());
                            Intent intent = new Intent(PageScanner.this, AnimateVideo.class);
                            intent.putExtra("path", loginResponse.getArlist().getBookvideopath());
                            intent.putExtra("bookid", bookid);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(PageScanner.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                            recreate();
                        }

                    } else {
                        Toast.makeText(PageScanner.this, "Ensure correct book is scanned", Toast.LENGTH_SHORT).show();
                        recreate();
                    }
                } else {
                    recreate();
                    Toast.makeText(PageScanner.this, "Server Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArData> call, Throwable t) {
                recreate();
                Log.d("on Failure", "" + t.getLocalizedMessage());

            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
