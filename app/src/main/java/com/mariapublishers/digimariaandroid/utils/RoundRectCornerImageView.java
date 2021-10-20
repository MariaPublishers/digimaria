package com.mariapublishers.digimariaandroid.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;


@SuppressLint("AppCompatCustomView")
public class RoundRectCornerImageView extends ImageView {
    public RoundRectCornerImageView(Context context) {
        super(context);
    }

    public RoundRectCornerImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundRectCornerImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RoundRectCornerImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        float radius = 0.1f;
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        RoundedBitmapDrawable rid = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        rid.setCornerRadius(bitmap.getWidth() * radius);
        super.setImageDrawable(rid);
    }
}
