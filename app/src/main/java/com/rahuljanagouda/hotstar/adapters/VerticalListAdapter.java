package com.rahuljanagouda.hotstar.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rahuljanagouda.hotstar.R;

/**
 * Created by rahuljanagouda on 04/11/17.
 */

public class VerticalListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int BANNER_VIEW_TYPE = 100;
    private static final int ROW_VIEW_TYPE = 200;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case BANNER_VIEW_TYPE:
                View bannerView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.horizontal_list, parent, false);
                return new BannerViewHolder(bannerView);

            case ROW_VIEW_TYPE:
                View rowView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.horizontal_list, parent, false);
                return new HorizontalListViewHolder(rowView);

            default:
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.horizontal_list, parent, false);
                return new HorizontalListViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        RecyclerView.LayoutManager layoutManager
                = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        switch (holder.getItemViewType()) {
            case BANNER_VIEW_TYPE:
                BannerViewHolder a
                        = (BannerViewHolder) holder;
                a.horizontalList.
                        setLayoutManager(layoutManager);

                if (a.horizontalList.getOnFlingListener() == null) {
                    SnapHelper snapHelper = new LinearSnapHelper();
                    snapHelper.attachToRecyclerView(a.horizontalList);
                }
                a.horizontalList.setHasFixedSize(true);
                a.horizontalList.setNestedScrollingEnabled(false);
                a.horizontalList.setAdapter(new BannerAdapter());
                a.horizontalListTitle.setVisibility(View.GONE);
                break;
            case ROW_VIEW_TYPE:
                HorizontalListViewHolder horizontalListViewHolder
                        = (HorizontalListViewHolder) holder;
                horizontalListViewHolder.horizontalList.
                        setLayoutManager(layoutManager);

                if (horizontalListViewHolder.horizontalList.getOnFlingListener() == null) {
                    SnapHelper snapHelper = new LinearSnapHelper();
                    snapHelper.attachToRecyclerView(horizontalListViewHolder.horizontalList);
                }
                horizontalListViewHolder.horizontalList.setHasFixedSize(true);
                horizontalListViewHolder.horizontalList.setNestedScrollingEnabled(false);

                horizontalListViewHolder.horizontalList
                        .setAdapter(new HorizontalListAdapter());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public int getItemViewType(int position) {
        return position==0?BANNER_VIEW_TYPE:ROW_VIEW_TYPE;
    }

    class HorizontalListViewHolder extends RecyclerView.ViewHolder {
        RecyclerView horizontalList;
        TextView horizontalListTitle;
        public HorizontalListViewHolder(View itemView) {
            super(itemView);
            horizontalList = itemView.findViewById(R.id.horizontalList);
            horizontalListTitle = itemView.findViewById(R.id.horizontalListTitle);
        }
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        RecyclerView horizontalList;
        TextView horizontalListTitle;

        public BannerViewHolder(View itemView) {
            super(itemView);
            horizontalList = itemView.findViewById(R.id.horizontalList);
            horizontalListTitle = itemView.findViewById(R.id.horizontalListTitle);
        }
    }

}
