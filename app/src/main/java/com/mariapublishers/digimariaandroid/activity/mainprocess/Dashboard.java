package com.mariapublishers.digimariaandroid.activity.mainprocess;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.adapter.Book;
import com.mariapublishers.digimariaandroid.adapter.BookAdapter;
import com.mariapublishers.digimariaandroid.adapter.PublicationListAdapter;
import com.mariapublishers.digimariaandroid.http.DownloadCallback;
import com.mariapublishers.digimariaandroid.http.GetBookIDTask;
import com.mariapublishers.digimariaandroid.http.GetBooksTask;
import com.mariapublishers.digimariaandroid.http.GetPublicationTask;
import com.mariapublishers.digimariaandroid.model.book.BookData;
import com.mariapublishers.digimariaandroid.model.book.Bookdatum;
import com.mariapublishers.digimariaandroid.model.usedbooks.UsedBookData;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.retrofit.APIUrl;
import com.mariapublishers.digimariaandroid.service.MusicService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dashboard extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, BookAdapter.OnNoteListerner {

    private static final String TAG = "hrhw";
    DrawerLayout drawer;
    NavigationView navigationView;
    CardView kg_series, science, gk, cs, english, social, valueedu, regionallang;
    //    private Pref pref;
    ActionBarDrawerToggle toggle;
    int position_type, position_id, position_ids;
    HashMap<String, String> hashMap;

    List<Book> BookList;
    EditText searchkeyword;
    //the recyclerview
    RecyclerView recyclerView;

    private Pref pref;

    public SweetAlertDialog pDialog;

    String volval;
    ImageView volumenote;
    SharedPreferences preferences;
    JSONArray student;
    public static ArrayList<SearchBooksBean> searchBookList;
    SharedPreferences sPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        preferences = getSharedPreferences("DigiMaria", MODE_PRIVATE);
        pDialog = new SweetAlertDialog(Dashboard.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading ...");
        pDialog.setCancelable(false);
        pDialog.show();

        hashMap = new HashMap<>();

        searchkeyword = findViewById(R.id.searchkeyword);
        searchkeyword.setFocusable(false);
        searchkeyword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, SearchActivity.class));
            }
        });

        currentContext = Dashboard.this;
        pref = new Pref(this);
        sPref= this.getSharedPreferences("SharedPrefManager", 0);
        volval = pref.getVolumeval();

        volumenote = findViewById(R.id.volumenote);

        volumenote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onCreate: " + volval);

                if (volval != null) {
                    if (volval.equals("1")) {
                        pref.setVolumeval("0");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeoff);
                        stopService(new Intent(Dashboard.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(Dashboard.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    if (pref.getMusicval() != null) {
                        if (pref.getMusicval().equals("0")) {
                            pref.setVolumeval("0");
                            volval = pref.getVolumeval();
                            volumenote.setImageResource(R.drawable.volumeoff);
                            stopService(new Intent(Dashboard.this, MusicService.class));
                            pref.setMusicval("1");
                        } else {
                            pref.setVolumeval("0");
                            volval = pref.getVolumeval();
                            volumenote.setImageResource(R.drawable.volumeoff);
                            stopService(new Intent(Dashboard.this, MusicService.class));
                            pref.setMusicval("1");
                        }
                    } else {
                        Log.d(TAG, "onCreate: null");
                    }
                }

            }
        });



        if (sPref.getString("SPLASH_SCREEN_LOADING", "0").equals("0")) {
            pref.setSplashScreen("1");
            if (volval.equals("1"))
                getApplicationContext().startService(new Intent(this, MusicService.class));
        }



        if (volval != null) {
            if (volval.equals("1")) {
                volumenote.setImageResource(R.drawable.volumeup);
            } else {
                volumenote.setImageResource(R.drawable.volumeoff);
            }
        } else {
            volumenote.setImageResource(R.drawable.volumeup);
        }

        ImageView menu_btn = findViewById(R.id.menu_btn);
        drawer = findViewById(R.id.drawer_layout_home);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        kg_series = findViewById(R.id.kg_series);
        science = findViewById(R.id.science);
        gk = findViewById(R.id.gk);
        cs = findViewById(R.id.cs);
        english = findViewById(R.id.english);
        social = findViewById(R.id.social);
        valueedu = findViewById(R.id.valedu);
        regionallang = findViewById(R.id.regional);


        setListener(kg_series, "KG Series", kg_series.getCardBackgroundColor().getDefaultColor(), R.drawable.ic_kg_series);
        setListener(english, "English", english.getCardBackgroundColor().getDefaultColor(), R.drawable.english);
        setListener(science, "Science", science.getCardBackgroundColor().getDefaultColor(), R.drawable.science);
        setListener(cs, "Computer Science", cs.getCardBackgroundColor().getDefaultColor(), R.drawable.computer);
        setListener(gk, "General Knowledge", gk.getCardBackgroundColor().getDefaultColor(), R.drawable.generalknow);
        setListener(valueedu, "Value Education", valueedu.getCardBackgroundColor().getDefaultColor(), R.drawable.value);
        setListener(regionallang, "Regional Language", regionallang.getCardBackgroundColor().getDefaultColor(), R.drawable.ic_regional_language);
        setListener(social, "Others", social.getCardBackgroundColor().getDefaultColor(), R.drawable.others);

        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        userSignIn();
        updateStudentInfo();
        updateOurBooks();



    }

    @Override
    protected void onResume() {
        super.onResume();
            if (sPref.getString("VOLUMEVAL", "1").equals("1")) {
                volumenote.setImageResource(R.drawable.volumeup);
            } else {
                volumenote.setImageResource(R.drawable.volumeoff);
            }
    }

    private void updateOurBooks() {
        try {
            RecyclerView recyclerView = findViewById(R.id.publication_rv);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
            recyclerView.setLayoutManager(gridLayoutManager);

            System.out.println("unique id --- "+preferences.getString("UniqueID", "0"));

            new GetPublicationTask(new DownloadCallback() {
                @Override
                public void onDownloadInterrupted(String cause) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
//                            pDialog.dismiss();
                            alertError("Try Again!!!", cause);
                        }
                    });

                }

                @Override
                public void onDownloadCompleted(String json) {
//                    pDialog.dismiss();
                    try {
                        JSONObject jsonResponse = new JSONObject(json);
                        Log.d("Publication detail", jsonResponse.toString());
                        if (jsonResponse.getString("code").equals("100")) {
                            JSONArray publicationarray = jsonResponse.getJSONArray("details");
                            if (publicationarray != null) {
                                ArrayList<JSONObject> publicationList = new ArrayList<>();
                                for (int i = 0; i < publicationarray.length(); i++) {
                                    publicationList.add(publicationarray.getJSONObject(i));
                                }
                                PublicationListAdapter adapter = new PublicationListAdapter(getApplicationContext(), publicationList, "dashboard");
                                recyclerView.setAdapter(adapter);
                            }

                            if (getIntent().getStringExtra("BookList")==null) {
                                if (searchBookList ==null) {
                                    searchBookList = new ArrayList();
                                    getBookList();
                                }else
                                    pDialog.dismiss();
                            }else {
                                searchBookList = new ArrayList();
                                getBookList();
                            }
                        } else
                            alertError("Error!!!", jsonResponse.getString("error"));

                    } catch (Exception e) {
                        e.printStackTrace();
                        alertError("Try Again!!!", "Something went wrong...");

                    }

                }
            }).execute(preferences.getString("StudentId", "0"), "0", preferences.getString("UniqueID", "0"));

            //creating gridview adapter


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getBookList() {
        try {
//            pDialog = new SweetAlertDialog(Dashboard.this, SweetAlertDialog.PROGRESS_TYPE);
//            pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
//            pDialog.setTitleText("Loading ...");
//            pDialog.setCancelable(false);
//            pDialog.show();
            new GetBookIDTask(new DownloadCallback() {
                @Override
                public void onDownloadInterrupted(String cause) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            alertError("Try Again!!!", cause);
                        }
                    });

                }

                @Override
                public void onDownloadCompleted(String json) {
//                    pDialog.dismiss();
//                    Log.d("String", json);
                    try {
                        JSONObject jsonResponse = new JSONObject(json);
                        Log.d("sample detail", jsonResponse.toString());
                        pDialog.dismiss();
                        if (jsonResponse.getString("code").equals("100")) {
                            student = jsonResponse.getJSONArray("details");
                            StringBuilder subjectbuilder = new StringBuilder();

                            if (student != null && student.length()> 0) {
                                for (int i = 0; i < student.length(); i++) {
                                    JSONObject jsonObj = student.getJSONObject(i);
                                    String sub = jsonObj.getString("subjectname");
                                    subjectbuilder.append(sub).append(",").append(jsonObj.getString("subjectid")).append("##");
                                }
                                String[] subId = subjectbuilder.toString().split("##");
                                HashMap<String, JSONArray> hashMap = new HashMap<>();
                                for (int k = 0; k < subId.length; k++) {
                                    int finalI = k;
                                    new GetBooksTask(new DownloadCallback() {
                                        @Override
                                        public void onDownloadInterrupted(String cause) {
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {

                                                    alertError("Try Again!!!", cause);
                                                }
                                            });

                                        }

                                        @Override
                                        public void onDownloadCompleted(String json) {
                                            try {

                                                JSONObject jsonResponse = new JSONObject(json);
                                                Log.d("Book detail", jsonResponse.toString());
                                                if (jsonResponse.getString("code").equals("100")) {
                                                    JSONArray student = jsonResponse.getJSONArray("details");
                                                    hashMap.put(subId[finalI].split(",")[0], student);
                                                    if (finalI == subId.length - 1) {
//                                                        mergeMultiJsonArray(hashMap);

                                                        for (String key : hashMap.keySet()) {
                                                            JSONArray array = hashMap.get(key);
                                                            for (int i = 0; i < array.length(); i++) {
                                                                SearchBooksBean bean=new SearchBooksBean();
                                                                bean.setSubject(key);
                                                                bean.setIcon(getIcons(key));
                                                                bean.setColor(getColors(key));
                                                                bean.setBookTitle(array.optJSONObject(i).getString("booktitle"));
                                                                bean.setBookId(array.optJSONObject(i).getString("bookassignid"));
                                                                bean.setJsonObject(array.optJSONObject(i));
                                                                searchBookList.add(bean);
                                                            }
                                                        }
                                                        pDialog.dismiss();
                                                    }

                                                } else
                                                    alertError("Error!!!", jsonResponse.getString("error"));

                                            } catch (Exception e) {
                                                e.printStackTrace();
                                                alertError("Try Again!!!", "Something went wrong...");

                                            }

                                        }
                                    }).execute(preferences.getString("StudentId", "0"), subId[k].split(",")[1], preferences.getString("UniqueID", "0"));
                                }
                            }
                        } else
                            alertError("Error!!!", jsonResponse.getString("error"));

                    } catch (Exception e) {
                        e.printStackTrace();
                        alertError("Try Again!!!", "Something went wrong...");

                    }

                }
            }).execute(preferences.getString("StudentId", "0"), preferences.getString("SchoolId", "0"), preferences.getString("UniqueID", "0"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getIcons(String key) {
        try {
            switch (key.replaceAll(" ", "").toLowerCase())
            {
                case "kgseries":
                    return R.drawable.ic_kg_series;
                case "english":
                    return R.drawable.english;
                case "science":
                    return R.drawable.science;
                case "computerscience":
                    return R.drawable.computer;
                case "generalknowledge":
                    return R.drawable.generalknow;
                case "valueeducation":
                    return R.drawable.value;
                case "regionallanguages":
                    return R.drawable.ic_regional_language;
                default:
                    return R.drawable.others;
            }

        }catch (Exception e){e.printStackTrace();}
        return 0;
    }

    private int getColors(String key) {
        try {
            switch (key.replaceAll(" ", "").toLowerCase())
            {
                case "kgseries":
                    return kg_series.getCardBackgroundColor().getDefaultColor();
                case "english":
                    return english.getCardBackgroundColor().getDefaultColor();
                case "science":
                    return science.getCardBackgroundColor().getDefaultColor();
                case "computerscience":
                    return cs.getCardBackgroundColor().getDefaultColor();
                case "generalknowledge":
                    return gk.getCardBackgroundColor().getDefaultColor();
                case "valueeducation":
                    return valueedu.getCardBackgroundColor().getDefaultColor();
                case "regionallanguages":
                    return regionallang.getCardBackgroundColor().getDefaultColor();
                default:
                    return social.getCardBackgroundColor().getDefaultColor();
            }

        }catch (Exception e){e.printStackTrace();}
        return 0;
    }

    //    ArrayList<Integer> assetList=new ArrayList<>();


    public void mergeMultiJsonArray(HashMap<String, JSONArray> arrays) {
//        ArrayList<String> subNameList=new ArrayList();
        JSONArray outArray = new JSONArray();
//        assetList.clear();
        for (String key : arrays.keySet()) {
            JSONArray array = arrays.get(key);
            for (int i = 0; i < array.length(); i++) {
                outArray.put(array.optJSONObject(i));
//                subNameList.add(key);
                Log.i("--------", key + "--------" + array.optJSONObject(i));
            }
//            getAsset(array);
        }

        pDialog.show();

//        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                pDialog.dismiss();
//
//                ((TextView)findViewById(R.id.count)).setText(subNameList.size()+" Book(s)");
//                recyclerView.setAdapter(new ContentActivity.BooksAdapter(outArray,subNameList,assetList));
//            }
//        }, 5000);


    }

    public void setListener(View view, String title, int color, int resource) {
        view.setOnTouchListener(new View.OnTouchListener() {
            private float startX;
            private float startY;

            private boolean isAClick(float startX, float endX, float startY, float endY) {
                float differenceX = Math.abs(startX - endX);
                float differenceY = Math.abs(startY - endY);
                int CLICK_ACTION_THRESHOLD = 200;
                return !(differenceX > CLICK_ACTION_THRESHOLD/* =5 */ || differenceY > CLICK_ACTION_THRESHOLD);
            }

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getX();
                        startY = event.getY();
                        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(view,
                                "scaleX", 0.95f);
                        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(view,
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
                                view, "scaleX", 1f);
                        ObjectAnimator scaleDownY2 = ObjectAnimator.ofFloat(
                                view, "scaleY", 1f);
                        scaleDownX2.setDuration(200);
                        scaleDownY2.setDuration(200);

                        AnimatorSet scaleDown2 = new AnimatorSet();
                        scaleDown2.play(scaleDownX2).with(scaleDownY2);

                        scaleDown2.start();
                        float endX = event.getX();
                        float endY = event.getY();
                        if (isAClick(startX, endX, startY, endY)) {


                            if (!preferences.getString("ClassName", "Class Name").toLowerCase().contains("kg") && title.equals("KG Series"))
                                Toast.makeText(Dashboard.this, getString(R.string.kg_student), Toast.LENGTH_SHORT).show();
                            else
                                checkBookAvailable(title, color, resource);

                            //   userLogin(hashMap);


                        }
                        break;
                }
                return true;
            }
        });

    }

    private void checkBookAvailable(String title, int color, int resource) {
        if (student != null) {
            gotoBook(title, color, resource);
            return;
        }

        pDialog = new SweetAlertDialog(Dashboard.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading ...");
        pDialog.setCancelable(false);
        pDialog.show();
        new GetBookIDTask(new DownloadCallback() {
            @Override
            public void onDownloadInterrupted(String cause) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        alertError("Try Again!!!", cause);
                    }
                });

            }

            @Override
            public void onDownloadCompleted(String json) {
                pDialog.dismiss();
                Log.d("String", json);
                try {
                    JSONObject jsonResponse = new JSONObject(json);
                    Log.d("detail", jsonResponse.toString());
                    if (jsonResponse.getString("code").equals("100")) {
                        student = jsonResponse.getJSONArray("details");
//                        updateOthers();
                        gotoBook(title, color, resource);
                    } else
                        alertError("Error!!!", jsonResponse.getString("error"));

                } catch (Exception e) {
                    e.printStackTrace();
                    alertError("Try Again!!!", "Something went wrong...");

                }

            }
        }).execute(preferences.getString("StudentId", "0"), preferences.getString("SchoolId", "0"), preferences.getString("UniqueID", "0"));

    }

    private void updateOthers() {
        try {
            ArrayList<String> available = new ArrayList<>();
            available.add("kgseries");
            available.add("english");
            available.add("science");
            available.add("computerscience");
            available.add("generalknowledge");
            available.add("valueeducation");
            available.add("regionallanguages");
            ArrayList<String> extrasubjects = new ArrayList<>();
            if (student != null)
                Log.i("----------", "---------Json :: " + student);
            for (int i = 0; i < student.length(); i++) {

                JSONObject jsonObj = student.getJSONObject(i);
                String sub = jsonObj.getString("subjectname").replaceAll(" ", "").toLowerCase();
                Log.i("----------", "---------subjectname :: " + sub);
                if (!available.contains(sub)) {
                    extrasubjects.add(sub + "##" + jsonObj.getString("subjectid"));
                }
            }

//            RecyclerView recyclerView=findViewById(R.id.othersrecycler);
//                recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
//                recyclerView.setAdapter(new OthersAdapter(extrasubjects));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void gotoBook(String title, int color, int resource) {
        try {
            boolean avaiable = false;
            ArrayList<String> available = new ArrayList<>();
            available.add("kgseries");
            available.add("english");
            available.add("science");
            available.add("computerscience");
            available.add("generalknowledge");
            available.add("valueeducation");
            available.add("regionallanguages");
            StringBuilder subjectbuilder = new StringBuilder();

            if (student != null && title.equals("Others")) {
                for (int i = 0; i < student.length(); i++) {

                    JSONObject jsonObj = student.getJSONObject(i);
                    String sub = jsonObj.getString("subjectname").replaceAll(" ", "").toLowerCase();
                    if (!available.contains(sub)) {
                        subjectbuilder.append(sub).append(",").append(jsonObj.getString("subjectid")).append("##");
                    }
                }
            }

            for (int i = 0; i < student.length(); i++) {

                JSONObject jsonObj = student.getJSONObject(i);
                Log.d("text", jsonObj.getString("subjectname") + " " + title);

                if (jsonObj.getString("subjectname").replaceAll(" ", "").toLowerCase().equals(title.replaceAll(" ", "").toLowerCase())
                        || subjectbuilder.toString().replaceAll(" ", "").toLowerCase().contains(jsonObj.getString("subjectname").replaceAll(" ", "").toLowerCase())) {
                    avaiable = true;
                    startActivity(new Intent(Dashboard.this, ContentActivity.class)
                            .putExtra("color", color)
                            .putExtra("drawable", resource)
                            .putExtra("SubjectName", title)
                            .putExtra("SubjectId", !title.equals("Others") ? jsonObj.getString("subjectid") : subjectbuilder.toString()));
                    break;
                }
            }
            if (!avaiable) {
                Intent intent = new Intent(Dashboard.this, EmptyStatus.class);
                intent.putExtra("status", "coming");
                startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
            alertError("Try Again!!!", "Something went wrong...");
        }
    }

    public void alertError(String title, String message) {
        try {
            pDialog.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("Errro", message);

        SweetAlertDialog sweetAlertDialog= new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(title)
                .setContentText(message);
        if (message.contains("Alreay device connected for this account")||message.contains("Already device connected for this account")) {
            sweetAlertDialog.setConfirmText("Log Out").
            setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sDialog) {
                    try {
                        preferences.edit().putBoolean("LoggedIn", false)
                                .remove("StudentId")
                                .remove("StudentName")
                                .remove("RollNo")
                                .remove("LoginName")
                                .remove("SchoolLogo")
                                .remove("SchoolName")
                                .remove("SchoolId")
                                .remove("SchoolCode")
                                .remove("AcademicYear")
                                .apply();

                        pref.setSplashScreen("0");
                        stopService(new Intent(Dashboard.this, MusicService.class));
                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        sweetAlertDialog.show();

    }


    private void updateStudentInfo() {
        ((TextView) findViewById(R.id.studentname)).setText(preferences.getString("StudentName", "Student Name"));
        ((TextView) findViewById(R.id.class_name)).setText(preferences.getString("ClassName", "Class Name"));
        ((TextView) findViewById(R.id.mobile_no)).setText(preferences.getString("StudentMobileNo", "Mobile No"));

        ((TextView) findViewById(R.id.viewAll_tv)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, PublicationActivity.class);
                startActivity(intent);
            }
        });
    }

/*    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
//        Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();
        stopService(new Intent(this, MusicService.class));
    }*/

//    @Override
//    protected void onRestart() {
//        super.onRestart();
////        Toast.makeText(this, "volval" + volval, Toast.LENGTH_SHORT).show();
//
//
//        if (volval != null) {
//            if (volval.equals("1")) {
//                volumenote.setImageResource(R.drawable.volumeup);
//            } else {
//                volumenote.setImageResource(R.drawable.volumeoff);
//            }
//        } else {
//            volumenote.setImageResource(R.drawable.volumeup);
//        }
//
//        if (volval != null) {
//            if (pref.getMusicval() != null) {
//                if (pref.getMusicval().equals("0")) {
//                    if (volval.equals("1")) {
//                        Log.d(TAG, "onCreate: ok running");
//                        startService(new Intent(this, MusicService.class));
//                    } else {
//                        Log.d(TAG, "onCreate: stop running");
//                        stopService(new Intent(this, MusicService.class));
//                    }
//                    pref.setMusicval("1");
//                } else {
//                    if (volval.equals("1")) {
//                        Log.d(TAG, "onCreate: ok running");
//                        startService(new Intent(this, MusicService.class));
//                    } else {
//                        Log.d(TAG, "onCreate: stop running");
//                        stopService(new Intent(this, MusicService.class));
//                    }
//                    Log.d(TAG, "onCreate: on other");
//                }
//            } else {
//                Log.d(TAG, "onCreate: null");
//            }
//        } else {
//            startService(new Intent(this, MusicService.class));
//            Log.d(TAG, "onCreate: this on major error");
//        }
//    }

    private void userSignIn() {

//        Log.d(TAG, "userSignIn: " + token);

        final Pref pref = new Pref(getApplicationContext());
        Call<BookData> call = APIUrl.getService().getbookData();

        call.enqueue(new Callback<BookData>() {
            @Override
            public void onResponse(Call<BookData> call, Response<BookData> response) {

                BookData loginResponse = response.body();

                if (response.isSuccessful()) {
                    if (loginResponse.getSuccess() == 1) {

                        recyclerView = findViewById(R.id.recyclerview);
                        LinearLayoutManager HorizontalLayout = new LinearLayoutManager(Dashboard.this, LinearLayoutManager.HORIZONTAL, false);
                        recyclerView.setLayoutManager(HorizontalLayout);

                        //initializing the productlist
                        //initializing the Booklist
                        BookList = new ArrayList<>();

//                       Abu pref.setClassID(loginResponse.getBookdata().get(0).getBookclass(), loginResponse.getBookdata().get(1).getBookclass(), loginResponse.getBookdata().get(2).getBookclass());

                        //adding some items to our list
                        for (Bookdatum tripBasedData : loginResponse.getBookdata()) {
//                            Log.d(TAG, "onResponse: " + "http://10.0.2.2:8000/"+tripBasedData.getBookcover());

                            String url = APIUrl.BASE_URL + tripBasedData.getBookcover();
                            url = url.replace("api/v1/", "");


                            BookList.add(
                                    new Book(
                                            String.valueOf(tripBasedData.getBookclass()),
                                            tripBasedData.getBooktitle(),
//                                            tripBasedData.getSubjectname() + " | " + tripBasedData.getLanguagename(),
                                            "",
                                            url,
                                            tripBasedData
                                    )
                            );

                        }

                        //creating recyclerview adapter
                        BookAdapter adapter = new BookAdapter(getApplicationContext(), BookList, Dashboard.this);

                        //setting adapter to recyclerview
                        recyclerView.setAdapter(adapter);
//                        pDialog.cancel();

//                    showCustomDialogSuccessOk("Success", "Login Success");
                    } else {
//                    showCustomDialogFailedOk("Sorry", "Wrong Crediantials");
                        Bookdatum bookdatum = new Bookdatum();
                        BookList.add(
                                new Book(
                                        "0",
                                        "Books Not Available",
                                        "",
                                        "https://cdn.pixabay.com/photo/2015/03/03/17/32/book-657637_960_720.jpg",
                                        bookdatum
                                )
                        );

                        BookAdapter adapter = new BookAdapter(getApplicationContext(), BookList, Dashboard.this);
                        recyclerView.setAdapter(adapter);
                        Toast.makeText(Dashboard.this, "Nothing Found", Toast.LENGTH_SHORT).show();
//                        pDialog.cancel();
                    }
                } else {
                    pDialog.cancel();
                    Toast.makeText(Dashboard.this, "Server Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BookData> call, Throwable t) {
                pDialog.cancel();
                Log.d("on Failure", "" + t.getLocalizedMessage());

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_home) {
            recreate();
        } else if (item.getItemId() == R.id.logout) {
            pref.setSplashScreen("0");
            stopService(new Intent(Dashboard.this, MusicService.class));
            startActivity(new Intent(Dashboard.this, Login.class));
            finish();
        }

        item.setChecked(false);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_dashboard_drawer, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public static void setIdVal(String position_id) {
        Log.d(TAG, "setIdVal: " + position_id);
    }

    @Override
    public void onNoteClick(String position) {

/*       Abu final String getPos = position;

        hashMap.put("usedbook", position);

        pref.setBookId(position);*/

        int selPos = BookList.get(Integer.parseInt(position)).getBookdatum().getBookid();
        final String getPos = String.valueOf(selPos);
        hashMap.put("usedbook", getPos);
        System.out.println("postion"+ getPos);
        pref.setBookId(getPos);

        Log.d(TAG, "onNoteClick: " + getPos);

        Call<UsedBookData> call = APIUrl.getService().usedbookData(hashMap);

        call.enqueue(new Callback<UsedBookData>() {
            @Override
            public void onResponse(Call<UsedBookData> call, Response<UsedBookData> response) {

                UsedBookData loginResponse = response.body();

                if (response.isSuccessful()) {
                    if (loginResponse.getSuccess() == 1) {
                        if (loginResponse.getMessage().equals("1")) {
                            Intent intent = new Intent(Dashboard.this, BookLanding.class);
                            pref.setClassid(getPos);
                            intent.putExtra("bookid", getPos);
                            startActivity(intent);
                        } else {
//                            Intent intent = new Intent(Dashboard.this, BookLanding.class);
//                            pref.setClassid(getPos);
//                            intent.putExtra("bookid", getPos);
//                            startActivity(intent);
                            Toast.makeText(Dashboard.this, "Unable to load books", Toast.LENGTH_SHORT).show();
                        }
//                    showCustomDialogSuccessOk("Success", "Login Success");
                    } else {
//                    showCustomDialogFailedOk("Sorry", "Wrong Crediantials");
                        Intent intent = new Intent(Dashboard.this, BookLanding.class);
                        pref.setClassid(getPos);
                        intent.putExtra("bookid", getPos);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(Dashboard.this, "Server Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UsedBookData> call, Throwable t) {

                Log.d("on Failure", "" + t.getLocalizedMessage());

            }
        });
    }

    public void home(View view) {
        drawer.closeDrawer(GravityCompat.START);
    }

    public void profile(View view) {
        try {
            drawer.closeDrawer(GravityCompat.START);
            drawer.post(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(intent);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void logout(View view) {
        drawer.closeDrawer(GravityCompat.START);
        preferences.edit().putBoolean("LoggedIn", false)
                .remove("StudentId")
                .remove("StudentName")
                .remove("RollNo")
                .remove("LoginName")
                .remove("SchoolLogo")
                .remove("SchoolName")
                .remove("SchoolId")
                .remove("SchoolCode")
                .remove("AcademicYear")
                .apply();

        pref.setSplashScreen("0");
        stopService(new Intent(Dashboard.this, MusicService.class));
        drawer.post(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }

    private class OthersAdapter extends RecyclerView.Adapter<OthersAdapter.Holder> {
        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new Holder(getLayoutInflater().inflate(R.layout.item_otherbooks, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            holder.title.setText(subjects.get(position).split("##")[0]);
        }

        @Override
        public int getItemCount() {
            return subjects.size();
        }

        class Holder extends RecyclerView.ViewHolder {
            TextView title;

            public Holder(@NonNull View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.extrasub);
            }
        }

        ArrayList<String> subjects;

        public OthersAdapter(ArrayList<String> extrasubjects) {
            subjects = extrasubjects;
        }
    }
}
