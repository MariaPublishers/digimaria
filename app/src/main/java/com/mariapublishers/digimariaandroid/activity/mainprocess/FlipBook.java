package com.mariapublishers.digimariaandroid.activity.mainprocess;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.adapter.ViewPagerAdapter;
import com.mariapublishers.digimariaandroid.model.pages.Imagepath;
import com.mariapublishers.digimariaandroid.model.pages.PageData;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.retrofit.APIUrl;
import com.mariapublishers.digimariaandroid.service.MusicService;
import com.wajahatkarim3.easyflipviewpager.BookFlipPageTransformer;

import java.util.ArrayList;
import java.util.HashMap;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlipBook extends BaseActivity {

    private static final String TAG = "FilpBook.java";
    Context context;
//    PDFPagerAdapterZoom adapter;
//    RemotePDFViewPager remotePDFViewPager;
    Intent getUrl;
    CardView prev_page, next_page, first_page, last_page, content_page;
    SweetAlertDialog pDialog;
    HashMap<String, String> hashMap;
//    PDFViewPagerZoom pagecurl_view;
    ViewPager pagecurl_view;
    ViewPagerAdapter viewPagerAdapter;
    LinearLayout linear_inflate;
    EditText current_page, final_page;
    TextView bookname_flip, off;
    int get_pos = 0;
    float minx = 0;
    float miny = 0;
    int total_page = 0;
    int i = 0;
    ImageView goto_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip_book);

        linear_inflate = findViewById(R.id.linear_inflate);

        currentContext = FlipBook.this;
        pagecurl_view = findViewById(R.id.pagecurl_view);

        off = findViewById(R.id.off);

        goto_page = findViewById(R.id.goto_page);
        goto_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pagecurl_view.setCurrentItem(Integer.parseInt(current_page.getText().toString())-1, true);
                if (current_page.isCursorVisible()) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                    current_page.clearFocus();
                }
            }
        });

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = (int) (displayMetrics.heightPixels);
        int width = displayMetrics.widthPixels;

        ViewGroup.LayoutParams params =  linear_inflate.getLayoutParams();
        params.height = (int) (height/1.45);
        params.width = width;
        linear_inflate.setLayoutParams(params);

        volval = pref.getVolumeval();

        volumenote = findViewById(R.id.volumenote);

        volumenote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (volval != null) {
                    if (volval.equals("1")) {
                        pref.setVolumeval("0");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeoff);
                        stopService(new Intent(FlipBook.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(FlipBook.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(FlipBook.this, MusicService.class));
                }

            }
        });

        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }

        first_page = findViewById(R.id.first_page);
        first_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pagecurl_view.setCurrentItem(0, true);
            }
        });

        last_page = findViewById(R.id.last_page);
        last_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pagecurl_view.setCurrentItem(total_page, true);
            }
        });

        current_page = findViewById(R.id.current_page);
        current_page.setText("01");

        current_page.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    current_page.setCursorVisible(true);
                    goto_page.setVisibility(View.VISIBLE);
                    off.setVisibility(View.GONE);
                    final_page.setVisibility(View.GONE);
                } else {
                    current_page.setCursorVisible(false);
                    goto_page.setVisibility(View.GONE);
                    off.setVisibility(View.VISIBLE);
                    final_page.setVisibility(View.VISIBLE);
                }
            }
        });

        current_page.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId) {
                    case EditorInfo.IME_ACTION_GO:
                        if (current_page.getText().toString().equals("")) {
                            alertError("Enter the proper page number");
                        } else {
                            pagecurl_view.setCurrentItem(Integer.parseInt(current_page.getText().toString())-1, true);
                            if (current_page.isCursorVisible()) {
                                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                                current_page.clearFocus();
                            }
                        }
                }
                return false;
            }
        });

        prev_page = findViewById(R.id.prev_page);
        next_page = findViewById(R.id.next_page);
        final_page = findViewById(R.id.final_page);

        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText(R.string.flip_book);

        bookname_flip = findViewById(R.id.bookname_flip);
        content_page = findViewById(R.id.content_page);

        getUrl = getIntent();
        String to_book = getUrl.getStringExtra("bookid");
        if (!to_book.equals("")) {
//            bookname_flip.setText(to_book);

            if (to_book.equals("3")) {
                bookname_flip.setText("Unbox Space Nursery");
            } else if (to_book.equals("5")) {
                bookname_flip.setText("Unbox Space Nursery");
            } else if (to_book.equals("7")) {
                bookname_flip.setText("Unbox Space Nursery");
            } else if (to_book.equals("8")) {
                to_book = "3";
                bookname_flip.setText("Unbox Space Nursery");
            } else if (to_book.equals("52")) {
                to_book = "5";
                bookname_flip.setText("Unbox Space Nursery");
            } else if (to_book.equals("58")) {
                to_book = "7";
                bookname_flip.setText("Unbox Space Nursery");
            } else if (to_book.equals("9")) {
                bookname_flip.setText("Unbox Space Junior KG");
            } else if (to_book.equals("11")) {
                bookname_flip.setText("Unbox Space Junior KG");
            } else if (to_book.equals("13")) {
                bookname_flip.setText("Unbox Space Junior KG");
            } else if (to_book.equals("15")) {
                bookname_flip.setText("Unbox Space Senior KG");
            } else if (to_book.equals("17")) {
                bookname_flip.setText("Unbox Space Senior KG");
            } else if (to_book.equals("19")) {
                bookname_flip.setText("Unbox Space Senior KG");
            }

            Log.d(TAG, "onResponse: " + to_book);
            hashMap = new HashMap<>();
            hashMap.put("bookid", to_book);
            userBook(hashMap);
            i += 1;
        }

        ImageView toback = findViewById(R.id.toback);

        toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backy_to = new Intent(FlipBook.this, RedirectPages.class);
                backy_to.putExtra("type", "flipbook");
                startActivity(backy_to);
            }
        });

        content_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pagecurl_view.setCurrentItem(5, true);
            }
        });

        prev_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pagecurl_view.setCurrentItem(get_pos-1, true);
            }
        });

        next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pagecurl_view.setCurrentItem(get_pos+1, true);
            }
        });

        pagecurl_view.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Log.d(TAG, "onPageScrolled: " + position);
            }

            @Override
            public void onPageSelected(int position) {
                String pos_get = "";
                get_pos = position;
//                Log.d(TAG, "onPageScrollStateChanged: " + Integer.toString(get_pos+1).length());
                if (String.valueOf(position+1).length() == 1) {
                    pos_get = "0"+(position+1);
                    current_page.setText(pos_get);
                } else {
                    pos_get = String.valueOf(position+1);
                    current_page.setText(pos_get);
                }
                //todo: api call
//                userBook(hashMap);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        minx = pagecurl_view.getScaleX();
        miny = pagecurl_view.getScaleY();

        linear_inflate = findViewById(R.id.linear_inflate);

        pDialog = new SweetAlertDialog(FlipBook.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading ...");
        pDialog.setCancelable(false);
        pDialog.show();

//        getUrl = getIntent();

    }

    ArrayList<String> image_array = new ArrayList<>();
    private void userBook(HashMap<String, String> hashMap) {

        Call<PageData> call = APIUrl.getService().pageData("Bearer "+pref.getToken(), hashMap);

        call.enqueue(new Callback<PageData>() {
            @Override
            public void onResponse(Call<PageData> call, Response<PageData> response) {

                PageData loginResponse = response.body();

                if (response.isSuccessful()) {
                    if (loginResponse.getSuccess() == 1) {

                        for (Imagepath imagepath: loginResponse.getImagepath()) {
                            String image_list = APIUrl.BASE_URL+imagepath.getBookimgpath();
                            image_array.add(image_list.replace("api/v1/", ""));
                            viewPagerAdapter = new ViewPagerAdapter(FlipBook.this, image_array);
                            pagecurl_view.setAdapter(viewPagerAdapter);
                            total_page += 1;
                        }

                        final_page.setText(String.valueOf(total_page), TextView.BufferType.SPANNABLE);

                        BookFlipPageTransformer bookFlipPageTransformer = new BookFlipPageTransformer();

                        //// Enable / Disable scaling while flipping. If true, then next page will scale in (zoom in). By default, its true.
                        bookFlipPageTransformer.setEnableScale(true);
                        //
                        //// The amount of scale the page will zoom. By default, its 5 percent.
                        bookFlipPageTransformer.setScaleAmountPercent(5f);
                        //
                        //// Assign the page transformer to the ViewPager.
                        pagecurl_view.setPageTransformer(true, bookFlipPageTransformer);

                        pDialog.cancel();
//                    showCustomDialogSuccessOk("Success", "Login Success");
                    } else {
//                    showCustomDialogFailedOk("Sorry", "Wrong Crediantials");
                        pDialog.cancel();
                    }
                } else {
                    pDialog.cancel();
                    Toast.makeText(FlipBook.this, "Server Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PageData> call, Throwable t) {
                pDialog.cancel();
                Log.d("on Failure", "" + t.getLocalizedMessage());

            }
        });

    }

    public void alertError(String message) {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wrong);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

        new SweetAlertDialog(FlipBook.this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setContentText(message)
                .show();
    }

    @Override
    public void onBackPressed() {
        Pref pref = new Pref(getApplicationContext());
        Intent intent = new Intent(FlipBook.this, BookLanding.class);
        intent.putExtra("bookid", pref.getBookId());
        startActivity(intent);
    }

}
