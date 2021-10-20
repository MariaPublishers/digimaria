package com.mariapublishers.digimariaandroid.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.adapter.Book;

import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

// The adapter class which
// extends RecyclerView Adapter
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ProductViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;
    private OnNoteListerner monNoteListerner;

    //we are storing all the products in a list
    private List<Book> productList;

    //getting the context and product list with constructor
    public BookAdapter(Context mCtx, List<Book> productList, OnNoteListerner onNoteListerner) {
        this.mCtx = mCtx;
        this.productList = productList;
        this.monNoteListerner = onNoteListerner;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_design, null);
        return new ProductViewHolder(view, monNoteListerner);
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, final int position) {
        //getting the product of the specified position
        Book product = productList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewShortDesc.setText(product.getShortdesc());

        ImageView imageview_book = holder.imageView;
        Glide.with(mCtx)
                .load(product.getImage())
                .addListener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Log.e(TAG, "onLoadFailed: " + e.getMessage());
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        Log.d(TAG, "onResourceReady: ");
                        return false;
                    }
                }).apply(new RequestOptions()
                .fitCenter()
                .format(DecodeFormat.PREFER_ARGB_8888)
                .override(Target.SIZE_ORIGINAL))
                .into(imageview_book);

//        container.addView(itemView, 0);

//        try {
//            Log.d(TAG, "onBindViewHolder try: " + product.getImage());
//            URL url = new URL(product.getImage());
//            Log.d(TAG, "onBindViewHolder url: " + url);
//            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//            if (bmp != null) {
//                holder.imageView.setImageBitmap(bmp);
//            }
//        } catch (Exception e) {
//            Log.d(TAG, "onBindViewHolder exception: " + e.getMessage());
//        }

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewTitle, textViewShortDesc;
        ImageView imageView;
        CardView dym_card;
        ViewGroup viewGroup;
        OnNoteListerner onNoteListerner;

        public ProductViewHolder(View itemView, OnNoteListerner onNoteListerner) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.bookname);
            textViewShortDesc = itemView.findViewById(R.id.language);
            imageView = itemView.findViewById(R.id.bookimage);
            dym_card = itemView.findViewById(R.id.dyn_card);
            viewGroup = itemView.findViewById(android.R.id.content);
            this.onNoteListerner = onNoteListerner;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick: " + productList.get(getAdapterPosition()).getId());
//            onNoteListerner.onNoteClick(productList.get(getAdapterPosition()).getId());
            onNoteListerner.onNoteClick(String.valueOf(getAdapterPosition()));
        }

    }

    public interface OnNoteListerner {
        void onNoteClick(String position);
    }

}
