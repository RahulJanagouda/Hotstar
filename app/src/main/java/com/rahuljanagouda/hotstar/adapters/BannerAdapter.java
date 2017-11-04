package com.rahuljanagouda.hotstar.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rahuljanagouda.hotstar.R;

/**
 * Created by rahuljanagouda on 04/11/17.
 */

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.HorizontalViewHolder> {


    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.banner_item, parent, false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder holder, int position) {
        holder.cardImage.setImageResource(R.drawable.placeholder);
    }

    @Override
    public int getItemCount() {
        return 25;
    }

    class HorizontalViewHolder extends RecyclerView.ViewHolder {
        ImageView cardImage;
        public HorizontalViewHolder(View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.image);
        }
    }
}
