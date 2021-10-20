package com.mariapublishers.digimariaandroid.activity.mainprocess;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.adapter.Book;
import com.mariapublishers.digimariaandroid.adapter.BookAdapter;
import com.mariapublishers.digimariaandroid.service.MusicService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.mariapublishers.digimariaandroid.activity.mainprocess.Dashboard.searchBookList;

public class SearchActivity extends BaseActivity {

    private static final String TAG = "hrhw";
    RecyclerView recyclerView;
    HashMap<String, String> hashMap;
    List<Book> BookList;
    EditText searchkeyword;
    LinearLayout nothing;
    TextView wentwrong, noting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        currentContext = SearchActivity.this;

        searchkeyword = findViewById(R.id.searchkeyword);
        searchkeyword.setFocusable(true);
        searchkeyword.requestFocus();

        nothing = findViewById(R.id.nothing);
        wentwrong = findViewById(R.id.wentwrong);
        noting = findViewById(R.id.noting);
        noting.setText("Nothing found");
        wentwrong.setText("No book found with this search");

        hashMap = new HashMap<>();

        //initializing the productlist
        //initializing the Booklist
        BookList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager HorizontalLayout = new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(HorizontalLayout);
        BooksAdapter adapter = new BooksAdapter(searchBookList, this);
        recyclerView.setAdapter(adapter);

        searchkeyword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //
            }

            @Override
            public void afterTextChanged(Editable s) {
                adapter.filter(s.toString().toLowerCase());
            }
        });

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
                        stopService(new Intent(SearchActivity.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SearchActivity.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    if (pref.getMusicval() != null) {
                        if (pref.getMusicval().equals("0")) {
                            pref.setVolumeval("0");
                            volval = pref.getVolumeval();
                            volumenote.setImageResource(R.drawable.volumeoff);
                            stopService(new Intent(SearchActivity.this, MusicService.class));
                            pref.setMusicval("1");
                        } else {
                            pref.setVolumeval("0");
                            volval = pref.getVolumeval();
                            volumenote.setImageResource(R.drawable.volumeoff);
                            stopService(new Intent(SearchActivity.this, MusicService.class));
                            pref.setMusicval("1");
                        }
                    } else {
                        Log.d(TAG, "onCreate: null");
                    }
                }

            }
        });

        if (volval != null) {
            if (volval.equals("1")) {
                volumenote.setImageResource(R.drawable.volumeup);
            } else {
                volumenote.setImageResource(R.drawable.volumeoff);
            }
        } else {
            volumenote.setImageResource(R.drawable.volumeup);
        }

        if (volval != null) {
            if (pref.getMusicval() != null) {
                if (pref.getMusicval().equals("0")) {
                    if (volval.equals("1")) {
                        Log.d(TAG, "onCreate: ok running");
//                        getApplicationContext().startService(new Intent(this, MusicService.class));
                    } else {
                        Log.d(TAG, "onCreate: stop running");
//                        getApplicationContext().stopService(new Intent(this, MusicService.class));
                    }
                    pref.setMusicval("1");
                } else {
                    Log.d(TAG, "onCreate: on other");
                }
            } else {
                Log.d(TAG, "onCreate: null");
            }
        } else {
//            getApplicationContext().startService(new Intent(this, MusicService.class));
            Log.d(TAG, "onCreate: this on major error");
        }

        ImageView menu_btn = findViewById(R.id.menu_btn);
        menu_btn.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.back));
        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        findViewById(R.id.home_some).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public static void setIdVal(String position_id) {
        Log.d(TAG, "setIdVal: " + position_id);
    }


    class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.Holder> {
        ArrayList<SearchBooksBean> array, copyarray;
        Context context;

        BooksAdapter(ArrayList<SearchBooksBean> arr, Context context) {
            array = arr;
            this.context = context;
            copyarray = new ArrayList<>();
            copyarray.addAll(array);
        }

        @NonNull
        @Override
        public BooksAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            return new BooksAdapter.Holder(inflater.inflate(R.layout.item_search_content, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull BooksAdapter.Holder holder, int position) {
            try {
                SearchBooksBean bean = array.get(position);

                holder.boolTitle.setText(bean.getBookTitle());
                holder.subject.setText(bean.getSubject());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                            startActivity(new Intent(SearchActivity.this, AssetActivity.class)
                                    .putExtra("color", bean.getColor())
                                    .putExtra("drawable", bean.getIcon())
                                    .putExtra("SubjectName", bean.getSubject())
                                    .putExtra("AssetId", bean.getBookId()));
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void filter(String charText) {
            try {
                array.clear();
                if (charText.length() == 0) {
                    array.addAll(copyarray);
                } else {
                    for (SearchBooksBean bean : copyarray) {
                        if (bean.getBookTitle().toLowerCase().contains(charText)
                                || bean.getSubject().toLowerCase().contains(charText)) {
                            array.add(bean);
                        }
                    }
                }
                nothing.setVisibility(array.size()==0?View.VISIBLE:View.GONE);
                notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        @Override
        public int getItemCount() {
            return array.size();
        }

        class Holder extends RecyclerView.ViewHolder {
            TextView boolTitle, subject;
//            ImageView icon;

            public Holder(@NonNull View itemView) {
                super(itemView);
                boolTitle = itemView.findViewById(R.id.title);
                subject = itemView.findViewById(R.id.subjects);

            }
        }
    }
}
