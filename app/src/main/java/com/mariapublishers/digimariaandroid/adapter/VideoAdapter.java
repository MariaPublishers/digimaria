package com.mariapublishers.digimariaandroid.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.service.Config;

import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

// The adapter class which
// extends RecyclerView Adapter
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ProductViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;
    private OnNoteListerner monNoteListerner;

    //we are storing all the products in a list
    private List<Video> productList;

    //getting the context and product list with constructor
    public VideoAdapter(Context mCtx, List<Video> productList, OnNoteListerner onNoteListerner) {
        this.mCtx = mCtx;
        this.productList = productList;
        this.monNoteListerner = onNoteListerner;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.video_card, null);
        return new ProductViewHolder(view, monNoteListerner);
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, final int position) {
        //getting the product of the specified position
        final Video product = productList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.getTitle());

        YouTubeThumbnailView imageview_book = holder.imageView;
        imageview_book.initialize(Config.YOUTUBE_API_KEY, new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, final YouTubeThumbnailLoader youTubeThumbnailLoader) {
                youTubeThumbnailLoader.setVideo(productList.get(position).getLink());

                youTubeThumbnailLoader.setOnThumbnailLoadedListener(new YouTubeThumbnailLoader.OnThumbnailLoadedListener() {
                    @Override
                    public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                        //when thumbnail loaded successfully release the thumbnail loader as we are showing thumbnail in adapter
                        youTubeThumbnailLoader.release();
                    }

                    @Override
                    public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {
                        //print or show error when thumbnail load failed
                        Log.e(TAG, "Youtube Thumbnail Error");
                    }
                });
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });

//        Glide.with(mCtx)
//                .load(product.getImage())
//                .addListener(new RequestListener<Drawable>() {
//                    @Override
//                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                        Log.e(TAG, "onLoadFailed: " + e.getMessage());
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                        Log.d(TAG, "onResourceReady: " );
//                        return false;
//                    }
//                })
//                .into(imageview_book);

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewTitle;
        YouTubeThumbnailView imageView;
        CardView dym_card;
        ViewGroup viewGroup;
        OnNoteListerner onNoteListerner;

        public ProductViewHolder(View itemView, OnNoteListerner onNoteListerner) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.image_text);
            imageView = itemView.findViewById(R.id.image_video);
            dym_card = itemView.findViewById(R.id.dym_card);
            viewGroup = itemView.findViewById(android.R.id.content);
            this.onNoteListerner = onNoteListerner;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            Log.d(TAG, "onClick: " + productList.get(getAdapterPosition()).getId());
            onNoteListerner.onNoteClick(productList.get(getAdapterPosition()).getLink(), productList.get(getAdapterPosition()).getTitle());
        }

    }

    public interface OnNoteListerner {
        void onNoteClick(String position, String title);
    }
    
}
