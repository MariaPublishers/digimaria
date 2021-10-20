package com.mariapublishers.digimariaandroid.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.mariapublishers.digimariaandroid.R;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class ViewPagerAdapter extends PagerAdapter {

    private static final String TAG = "Adapter";
    Activity activity;
    ArrayList<String> image;
    LayoutInflater inflater;
    SweetAlertDialog pDialog;
    private int xDelta;
    private int yDelta;

    //todo: string array list

    public ViewPagerAdapter(Activity activity, ArrayList<String> image) {
        this.activity = activity;
        this.image = image;
        inflater = (LayoutInflater)activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        //todo: array list size
//        Log.d(TAG, "getCount: " + image.size());
        return image.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View itemView = inflater.inflate(R.layout.viewpager_item,container,false);

//        pDialog = new SweetAlertDialog(activity, SweetAlertDialog.PROGRESS_TYPE);
//        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
//        pDialog.setTitleText("Loading ...");
//        pDialog.setCancelable(false);
//        pDialog.show();

        final ImageView imageview_book = itemView.findViewById(R.id.imageview_book);
        Glide.with(activity)
                    .load(image.get(position))
                    .addListener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            Log.e(TAG, "onLoadFailed: " + e.getMessage());
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                            Log.d(TAG, "onResourceReady: " + position);
                            return false;
                        }
                    })
                    .into(imageview_book);
        container.addView(itemView, 0);

//        pDialog.cancel();
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}
