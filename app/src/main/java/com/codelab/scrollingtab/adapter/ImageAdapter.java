package com.codelab.scrollingtab.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.codelab.scrollingtab.R;

import java.util.ArrayList;

/**
 * Created by Ashiq on 8/3/16.
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private ArrayList<String> arrayList;
    private Context mContext;

    public ImageAdapter(ArrayList<String> arrayList, Context context) {
        this.arrayList = arrayList;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_image, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {

        final String thumbUrl = arrayList.get(i);

        Glide.with(mContext)
                .load(thumbUrl)
                .fitCenter()
                .placeholder(R.drawable.ic_file_photo)
                .crossFade()
                .into(viewHolder.imageThumbView);


    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageThumbView;

        ViewHolder(View itemView) {
            super(itemView);
            imageThumbView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

}
