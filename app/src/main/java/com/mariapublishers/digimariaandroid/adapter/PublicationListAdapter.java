package com.mariapublishers.digimariaandroid.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.mariapublishers.digimariaandroid.R;
import com.mariapublishers.digimariaandroid.retrofit.APIUrl;

import org.json.JSONObject;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

// The adapter class which
// extends RecyclerView Adapter
public class PublicationListAdapter extends RecyclerView.Adapter<PublicationListAdapter.PublicationViewHolder> {

    ArrayList<JSONObject> array, copyarray;
    Context context;
    String contentView;
    public PublicationListAdapter(Context context, ArrayList<JSONObject> arr,String contentView) {
        array = arr;
        this.context = context;
        this.contentView=contentView;
        copyarray = new ArrayList<>();
        copyarray.addAll(array);
    }

    @NonNull
    @Override
    public PublicationListAdapter.PublicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (contentView.equals("dashboard"))
            return new PublicationViewHolder(inflater.inflate(R.layout.item_pubilication, parent, false));
        else
            return new PublicationViewHolder(inflater.inflate(R.layout.item_publication_list, parent, false));

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PublicationListAdapter.PublicationViewHolder holder, int position) {
        try {
            JSONObject object = array.get(position);
            holder.textViewTitle.setText(object.getString("booktitle"));
            if (contentView.equals("dashboard"))
                holder.textViewLanguage.setText(object.getString("subjectname")+"\n"+object.getString("classname"));
            else
                holder.textViewLanguage.setText(object.getString("subjectname")+" | "+object.getString("classname"));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });

            if (object.getString("bookcover")!=null && object.getString("bookcover").length()>0) {
                RequestOptions myOptions = new RequestOptions();
                if (contentView.equals("dashboard"))
                    myOptions.format(DecodeFormat.PREFER_ARGB_8888).override(300, 200);
                else
                    myOptions.fitCenter().format(DecodeFormat.PREFER_ARGB_8888).override(Target.SIZE_ORIGINAL);
                String url = APIUrl.PUBLICATION_URL + object.getString("bookcover");
                Glide.with(context)
                        .load(url)
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
                        }).apply(myOptions)
                        .into(holder.imageView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    public void filter(String charText, LinearLayout nothing) {
        try {
            array.clear();
            if (charText.length() == 0) {
                array.addAll(copyarray);
            } else {
                for (JSONObject object : copyarray) {
                    if (object.getString("booktitle").toLowerCase().contains(charText)
                            || object.getString("subjectname").toLowerCase().contains(charText)
                            || object.getString("classname").toLowerCase().contains(charText)) {
                        array.add(object);
                    }
                }
            }
            nothing.setVisibility(array.size()==0?View.VISIBLE:View.GONE);
            notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class PublicationViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewLanguage;
        ImageView imageView;

        public PublicationViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.title_tv);
            textViewLanguage = itemView.findViewById(R.id.language_tv);
            imageView = itemView.findViewById(R.id.image);
        }
    }

}