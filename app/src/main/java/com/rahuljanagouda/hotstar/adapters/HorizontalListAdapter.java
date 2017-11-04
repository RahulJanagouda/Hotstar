package com.rahuljanagouda.hotstar.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rahuljanagouda.hotstar.DummyContent;
import com.rahuljanagouda.hotstar.R;

/**
 * Created by rahuljanagouda on 04/11/17.
 */

public class HorizontalListAdapter extends RecyclerView.Adapter<HorizontalListAdapter.HorizontalViewHolder> {


    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizontal_list_item, parent, false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder holder, int position) {
        holder.cardImage.setImageResource(R.drawable.placeholder);
        holder.cardTitle.setText(holder.itemView.getContext().getString(R.string.place_holder)+"_1");
    }

    @Override
    public int getItemCount() {
        return 25;
    }

    class HorizontalViewHolder extends RecyclerView.ViewHolder {
        ImageView cardImage;
        TextView cardTitle;
        public HorizontalViewHolder(View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.image);
            cardTitle = itemView.findViewById(R.id.text);
        }
    }
}
