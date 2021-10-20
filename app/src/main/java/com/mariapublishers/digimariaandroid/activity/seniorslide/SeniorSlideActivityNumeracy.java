package com.mariapublishers.digimariaandroid.activity.seniorslide;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.activity.base.BaseActivity;
import com.mariapublishers.digimariaandroid.activity.seniorflashcard.SeniorFlashCard14;
import com.mariapublishers.digimariaandroid.prefference.Pref;
import com.mariapublishers.digimariaandroid.service.MusicService;

import java.util.ArrayList;
import java.util.List;

import static android.media.MediaPlayer.create;

public class SeniorSlideActivityNumeracy extends BaseActivity {
    ArrayList<NumercyModel> numercyModels = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeracy);
        RecyclerView recycler_view = findViewById(R.id.recycler_view);
        ImageView toback = findViewById(R.id.toback);

        toback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeniorSlideActivityNumeracy.this, SlideShowMain.class);
                intent.putExtra("bookid", pref.getBookId());
                startActivity(intent);
            }
        });
        currentContext = SeniorSlideActivityNumeracy.this;
        TextView off = findViewById(R.id.off);
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
                        stopService(new Intent(SeniorSlideActivityNumeracy.this, MusicService.class));
                    } else if (volval.equals("0")) {
                        pref.setVolumeval("1");
                        volval = pref.getVolumeval();
                        volumenote.setImageResource(R.drawable.volumeup);
                        startService(new Intent(SeniorSlideActivityNumeracy.this, MusicService.class));
                    }
                } else {
                    pref.setVolumeval("1");
                    volumenote.setImageResource(R.drawable.volumeup);
                    startService(new Intent(SeniorSlideActivityNumeracy.this, MusicService.class));
                }

            }
        });
        TextView book_name_header = findViewById(R.id.book_name_header);
        book_name_header.setText("Slideshow - Numeracy");

        if (volval.equals("1")) {
            volumenote.setImageResource(R.drawable.volumeup);
        } else {
            volumenote.setImageResource(R.drawable.volumeoff);
        }
        numercyModels.add(new NumercyModel("1", "ONE", "https://digimaria.com/ERP/public/mobileasset/raw/raw/one.m4a", 1));
        numercyModels.add(new NumercyModel("2", "two", "https://digimaria.com/ERP/public/mobileasset/raw/raw/two.m4a", 2));
        numercyModels.add(new NumercyModel("3", "three", "https://digimaria.com/ERP/public/mobileasset/raw/raw/three.m4a", 1));
        numercyModels.add(new NumercyModel("4", "four", "https://digimaria.com/ERP/public/mobileasset/raw/raw/four.m4a", 1));
        numercyModels.add(new NumercyModel("5", "five", "https://digimaria.com/ERP/public/mobileasset/raw/raw/five.m4a", 1));
        numercyModels.add(new NumercyModel("6", "six", "https://digimaria.com/ERP/public/mobileasset/raw/raw/six.m4a", 1));
        numercyModels.add(new NumercyModel("7", "seven", "https://digimaria.com/ERP/public/mobileasset/raw/raw/seven.m4a", 2));
        numercyModels.add(new NumercyModel("8", "eight", "https://digimaria.com/ERP/public/mobileasset/raw/raw/eight.m4a", 1));
        numercyModels.add(new NumercyModel("9", "nine", "https://digimaria.com/ERP/public/mobileasset/raw/raw/nine.m4a", 1));
        numercyModels.add(new NumercyModel("10", "ten", "https://digimaria.com/ERP/public/mobileasset/raw/raw/ten.m4a", 1));

        numercyModels.add(new NumercyModel("11", "eleven", "https://digimaria.com/ERP/public/mobileasset/raw/raw/eleven.m4a", 1));
        numercyModels.add(new NumercyModel("12", "twelve", "https://digimaria.com/ERP/public/mobileasset/raw/raw/twelve.m4a", 2));
        numercyModels.add(new NumercyModel("13", "thirteen", "https://digimaria.com/ERP/public/mobileasset/raw/raw/thirteen.m4a", 1));
        numercyModels.add(new NumercyModel("14", "fourteen", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fourteen.m4a", 1));
        numercyModels.add(new NumercyModel("15", "fifteen", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fifteen.m4a", 1));
        numercyModels.add(new NumercyModel("16", "sixteen", "https://digimaria.com/ERP/public/mobileasset/raw/raw/sixteen.m4a", 1));
        numercyModels.add(new NumercyModel("17", "seventeen", "https://digimaria.com/ERP/public/mobileasset/raw/raw/seventeen.m4a", 2));
        numercyModels.add(new NumercyModel("18", "eighteen", "https://digimaria.com/ERP/public/mobileasset/raw/raw/eighteen.m4a", 1));
        numercyModels.add(new NumercyModel("19", "nineteen", "https://digimaria.com/ERP/public/mobileasset/raw/raw/nineteen.m4a", 1));
        numercyModels.add(new NumercyModel("20", "twenty", "https://digimaria.com/ERP/public/mobileasset/raw/raw/twenty.m4a", 1));

        numercyModels.add(new NumercyModel("21", "twenty-one", "https://digimaria.com/ERP/public/mobileasset/raw/raw/twentyone.m4a", 1));
        numercyModels.add(new NumercyModel("22", "twenty-two", "https://digimaria.com/ERP/public/mobileasset/raw/raw/twentytwo.m4a", 2));
        numercyModels.add(new NumercyModel("23", "twenty-three", "https://digimaria.com/ERP/public/mobileasset/raw/raw/twentythree.m4a", 1));
        numercyModels.add(new NumercyModel("24", "twenty-four", "https://digimaria.com/ERP/public/mobileasset/raw/raw/twentyfour.m4a", 1));
        numercyModels.add(new NumercyModel("25", "twenty-five", "https://digimaria.com/ERP/public/mobileasset/raw/raw/twentyfive.m4a", 1));
        numercyModels.add(new NumercyModel("26", "twenty-six", "https://digimaria.com/ERP/public/mobileasset/raw/raw/twentysix.m4a", 1));
        numercyModels.add(new NumercyModel("27", "twenty-seven", "https://digimaria.com/ERP/public/mobileasset/raw/raw/twentyseven.m4a", 2));
        numercyModels.add(new NumercyModel("28", "twenty-eight", "https://digimaria.com/ERP/public/mobileasset/raw/raw/twentyeight.m4a", 1));
        numercyModels.add(new NumercyModel("29", "twenty-nine", "https://digimaria.com/ERP/public/mobileasset/raw/raw/twentynine.m4a", 1));
        numercyModels.add(new NumercyModel("30", "thirty", "https://digimaria.com/ERP/public/mobileasset/raw/raw/thirty.m4a", 1));

        numercyModels.add(new NumercyModel("31", "thirty-one", "https://digimaria.com/ERP/public/mobileasset/raw/raw/thirtyone.m4a", 1));
        numercyModels.add(new NumercyModel("32", "thirty-two", "https://digimaria.com/ERP/public/mobileasset/raw/raw/thirtytwo.m4a", 2));
        numercyModels.add(new NumercyModel("33", "thirty-three", "https://digimaria.com/ERP/public/mobileasset/raw/raw/thirtythree.m4a", 1));
        numercyModels.add(new NumercyModel("34", "thirty-four", "https://digimaria.com/ERP/public/mobileasset/raw/raw/thirtyfour.m4a", 1));
        numercyModels.add(new NumercyModel("35", "thirty-five", "https://digimaria.com/ERP/public/mobileasset/raw/raw/thirtyfive.m4a", 1));
        numercyModels.add(new NumercyModel("36", "thirty-six", "https://digimaria.com/ERP/public/mobileasset/raw/raw/thirtysix.m4a", 1));
        numercyModels.add(new NumercyModel("37", "thirty-seven", "https://digimaria.com/ERP/public/mobileasset/raw/raw/thirtyseven.m4a", 2));
        numercyModels.add(new NumercyModel("38", "thirty-eight", "https://digimaria.com/ERP/public/mobileasset/raw/raw/thirtyeight.m4a", 1));
        numercyModels.add(new NumercyModel("39", "thirty-nine", "https://digimaria.com/ERP/public/mobileasset/raw/raw/thirtynine.m4a", 1));
        numercyModels.add(new NumercyModel("40", "forty", "https://digimaria.com/ERP/public/mobileasset/raw/raw/forty.m4a", 1));

        numercyModels.add(new NumercyModel("41", "forty-one", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fortyone.m4a", 1));
        numercyModels.add(new NumercyModel("42", "forty-two", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fortytwo.m4a", 2));
        numercyModels.add(new NumercyModel("43", "forty-three", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fortythree.m4a", 1));
        numercyModels.add(new NumercyModel("44", "forty-four", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fortyfour.m4a", 1));
        numercyModels.add(new NumercyModel("45", "forty-five", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fortyfive.m4a", 1));
        numercyModels.add(new NumercyModel("46", "forty-six", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fortysix.m4a", 1));
        numercyModels.add(new NumercyModel("47", "forty-seven", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fortyseven.m4a", 2));
        numercyModels.add(new NumercyModel("48", "forty-eight", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fortyeight.m4a", 1));
        numercyModels.add(new NumercyModel("49", "forty-nine", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fortynine.m4a", 1));
        numercyModels.add(new NumercyModel("50", "fifty", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fifty.m4a", 1));


        numercyModels.add(new NumercyModel("51", "fifty-one", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fiftyone.m4a", 1));
        numercyModels.add(new NumercyModel("52", "fifty-two", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fiftytwo.m4a", 2));
        numercyModels.add(new NumercyModel("53", "fifty-three", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fiftythree.m4a", 1));
        numercyModels.add(new NumercyModel("54", "fifty-four", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fiftyfour.m4a", 1));
        numercyModels.add(new NumercyModel("55", "fifty-five", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fiftyfive.m4a", 1));
        numercyModels.add(new NumercyModel("56", "fifty-six", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fiftysix.m4a", 1));
        numercyModels.add(new NumercyModel("57", "fifty-seven", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fiftyseven.m4a", 2));
        numercyModels.add(new NumercyModel("58", "fifty-eight", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fiftyeight.m4a", 1));
        numercyModels.add(new NumercyModel("59", "fifty-nine", "https://digimaria.com/ERP/public/mobileasset/raw/raw/fiftynine.m4a", 1));
        numercyModels.add(new NumercyModel("60", "sixty", "https://digimaria.com/ERP/public/mobileasset/raw/raw/sixty.m4a", 1));

        numercyModels.add(new NumercyModel("61", "sixty-one", "https://digimaria.com/ERP/public/mobileasset/raw/raw/sixtyone.m4a", 1));
        numercyModels.add(new NumercyModel("62", "sixty-two", "https://digimaria.com/ERP/public/mobileasset/raw/raw/sixtytwo.m4a", 2));
        numercyModels.add(new NumercyModel("63", "sixty-three", "https://digimaria.com/ERP/public/mobileasset/raw/raw/sixtythree.m4a", 1));
        numercyModels.add(new NumercyModel("64", "sixty-four", "https://digimaria.com/ERP/public/mobileasset/raw/raw/sixtyfour.m4a", 1));
        numercyModels.add(new NumercyModel("65", "sixty-five", "https://digimaria.com/ERP/public/mobileasset/raw/raw/sixtyfive.m4a", 1));
        numercyModels.add(new NumercyModel("66", "sixty-six", "https://digimaria.com/ERP/public/mobileasset/raw/raw/sixtysix.m4a", 1));
        numercyModels.add(new NumercyModel("67", "sixty-seven", "https://digimaria.com/ERP/public/mobileasset/raw/raw/sixtyseven.m4a", 2));
        numercyModels.add(new NumercyModel("68", "sixty-eight", "https://digimaria.com/ERP/public/mobileasset/raw/raw/sixtyeight.m4a", 1));
        numercyModels.add(new NumercyModel("69", "sixty-nine", "https://digimaria.com/ERP/public/mobileasset/raw/raw/sixtynine.m4a", 1));
        numercyModels.add(new NumercyModel("70", "seventy", "https://digimaria.com/ERP/public/mobileasset/raw/raw/seventy.m4a", 1));

        numercyModels.add(new NumercyModel("71", "seventy-one", "https://digimaria.com/ERP/public/mobileasset/raw/raw/seventyone.m4a", 1));
        numercyModels.add(new NumercyModel("72", "seventy-two", "https://digimaria.com/ERP/public/mobileasset/raw/raw/seventytwo.m4a", 2));
        numercyModels.add(new NumercyModel("73", "seventy-three", "https://digimaria.com/ERP/public/mobileasset/raw/raw/seventythree.m4a", 1));
        numercyModels.add(new NumercyModel("74", "seventy-four", "https://digimaria.com/ERP/public/mobileasset/raw/raw/seventyfour.m4a", 1));
        numercyModels.add(new NumercyModel("75", "seventy-five", "https://digimaria.com/ERP/public/mobileasset/raw/raw/seventyfive.m4a", 1));
        numercyModels.add(new NumercyModel("76", "seventy-six", "https://digimaria.com/ERP/public/mobileasset/raw/raw/seventysix.m4a", 1));
        numercyModels.add(new NumercyModel("77", "seventy-seven", "https://digimaria.com/ERP/public/mobileasset/raw/raw/seventyseven.m4a", 2));
        numercyModels.add(new NumercyModel("78", "seventy-eight", "https://digimaria.com/ERP/public/mobileasset/raw/raw/seventyeight.m4a", 1));
        numercyModels.add(new NumercyModel("79", "seventy-nine", "https://digimaria.com/ERP/public/mobileasset/raw/raw/seventynine.m4a", 1));
        numercyModels.add(new NumercyModel("80", "eighty", "https://digimaria.com/ERP/public/mobileasset/raw/raw/eighty.m4a", 1));

        numercyModels.add(new NumercyModel("81", "eighty-one", "https://digimaria.com/ERP/public/mobileasset/raw/raw/eightyone.m4a", 1));
        numercyModels.add(new NumercyModel("82", "eighty-two", "https://digimaria.com/ERP/public/mobileasset/raw/raw/eightytwo.m4a", 2));
        numercyModels.add(new NumercyModel("83", "eighty-three", "https://digimaria.com/ERP/public/mobileasset/raw/raw/eightythree.m4a", 1));
        numercyModels.add(new NumercyModel("84", "eighty-four", "https://digimaria.com/ERP/public/mobileasset/raw/raw/eightyfour.m4a", 1));
        numercyModels.add(new NumercyModel("85", "eighty-five", "https://digimaria.com/ERP/public/mobileasset/raw/raw/eightyfive.m4a", 1));
        numercyModels.add(new NumercyModel("86", "eighty-six", "https://digimaria.com/ERP/public/mobileasset/raw/raw/eightysix.m4a", 1));
        numercyModels.add(new NumercyModel("87", "eighty-seven", "https://digimaria.com/ERP/public/mobileasset/raw/raw/eightyseven.m4a", 2));
        numercyModels.add(new NumercyModel("88", "eighty-eight", "https://digimaria.com/ERP/public/mobileasset/raw/raw/eightyeight.m4a", 1));
        numercyModels.add(new NumercyModel("89", "eighty-nine", "https://digimaria.com/ERP/public/mobileasset/raw/raw/eightynine.m4a", 1));
        numercyModels.add(new NumercyModel("90", "ninety", "https://digimaria.com/ERP/public/mobileasset/raw/raw/ninety.m4a", 1));

        numercyModels.add(new NumercyModel("91", "ninety-one", "https://digimaria.com/ERP/public/mobileasset/raw/raw/ninetyone.m4a", 1));
        numercyModels.add(new NumercyModel("92", "ninety-two", "https://digimaria.com/ERP/public/mobileasset/raw/raw/ninetytwo.m4a", 2));
        numercyModels.add(new NumercyModel("93", "ninety-three", "https://digimaria.com/ERP/public/mobileasset/raw/raw/ninetythree.m4a", 1));
        numercyModels.add(new NumercyModel("94", "ninety-four", "https://digimaria.com/ERP/public/mobileasset/raw/raw/ninetyfour.m4a", 1));
        numercyModels.add(new NumercyModel("95", "ninety-five", "https://digimaria.com/ERP/public/mobileasset/raw/raw/ninetyfive.m4a", 1));
        numercyModels.add(new NumercyModel("96", "ninety-six", "https://digimaria.com/ERP/public/mobileasset/raw/raw/ninetysix.m4a", 1));
        numercyModels.add(new NumercyModel("97", "ninety-seven", "https://digimaria.com/ERP/public/mobileasset/raw/raw/ninetyseven.m4a", 2));
        numercyModels.add(new NumercyModel("98", "ninety-eight", "https://digimaria.com/ERP/public/mobileasset/raw/raw/ninetyeight.m4a", 1));
        numercyModels.add(new NumercyModel("99", "ninety-nine", "https://digimaria.com/ERP/public/mobileasset/raw/raw/ninetynine.m4a", 1));
        numercyModels.add(new NumercyModel("100", "one hundred", "https://digimaria.com/ERP/public/mobileasset/raw/raw/onehundred.m4a", 1));


        NumercyAdapter mAdapter = new NumercyAdapter(SeniorSlideActivityNumeracy.this, numercyModels);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        recycler_view.setLayoutManager(gridLayoutManager);


        recycler_view.setHasFixedSize(true);
        //  madapter = new HeaderAdapter(MainActivity.this);
        recycler_view.setAdapter(mAdapter);
    }

    public class NumercyAdapter extends RecyclerView.Adapter<NumercyAdapter.MyViewHolder> {

        private List<NumercyModel> zoneList;
        private Context context;

        public class MyViewHolder extends RecyclerView.ViewHolder {

            public TextView text, textmain, texttext;
            Button closee;
            LinearLayout aa_layout;

            public MyViewHolder(View view) {
                super(view);

                aa_layout = (LinearLayout) view.findViewById(R.id.aa_layout);
                text = (TextView) view.findViewById(R.id.text);
                textmain = (TextView) view.findViewById(R.id.textmain);
                texttext = (TextView) view.findViewById(R.id.texttext);
                closee = (Button) view.findViewById(R.id.closee);

            }
        }


        public NumercyAdapter(Context context, List<NumercyModel> moviesList) {
            this.zoneList = moviesList;
            this.context = context;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.include_slideshow_2ten_layout, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            NumercyModel movie = zoneList.get(position);

            holder.text.setText("" + movie.getFirsttext());
            holder.textmain.setText("" + movie.getFirsttext());
            holder.texttext.setText("" + movie.getTexttext());
            holder.aa_layout.setTag(movie.getId());
            holder.aa_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    buildDialog11(R.style.DialogAnimation, movie.getFirsttext(), movie.getTexttext(), movie.getAudiofile());
                }
            });

        }

        public void buildDialog11(int animationSource, String subtextsubtext, String text, String daudio) {
            LayoutInflater inflater = getLayoutInflater();
            View alertLayout = inflater.inflate(R.layout.include_slideshow_3ten_layout, null);
            final TextView textView = alertLayout.findViewById(R.id.text);
            final TextView textmain = alertLayout.findViewById(R.id.textmain);
            final TextView texttext = alertLayout.findViewById(R.id.texttext);
            final Button closee = alertLayout.findViewById(R.id.closee);

            textView.setText("" + subtextsubtext);
            textmain.setText("" + subtextsubtext);
            texttext.setText("" + text);
            final MediaPlayer mp = new MediaPlayer();
            try {
                mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mp.setDataSource(daudio);
                // mPlayer.setDataSource(audioUrl);
                mp.prepare();
                mp.start();
            } catch (Exception e) {
                // handle exception
            }


            //     mp.start();
            AlertDialog.Builder alert = new AlertDialog.Builder(SeniorSlideActivityNumeracy.this);
            alert.setView(alertLayout);
            alert.setCancelable(false);
            AlertDialog dialog = alert.create();
            dialog.getWindow().getAttributes().windowAnimations = animationSource;
            dialog.show();
            closee.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        if (mp != null) {
                            mp.stop();
                        }
                    }
                    dialog.dismiss();
                }
            });
        }


        @Override
        public int getItemCount() {
            return zoneList.size();
        }

        private void buildDialog11(int animationSource, String subtextsubtext, Drawable drawable) {

        }
    }


}
