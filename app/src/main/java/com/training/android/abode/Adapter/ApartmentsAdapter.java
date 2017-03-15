package com.training.android.abode.Adapter;


import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.training.android.abode.Data.ApartmentsData;
import com.training.android.abode.R;

import java.util.List;

public class ApartmentsAdapter extends RecyclerView.Adapter<ApartmentsAdapter.ViewHolder> {

    private Context mContext;
    private ViewHolder holder;
    private List<ApartmentsData> mApartments;


    public ApartmentsAdapter(Context mContext, List<ApartmentsData> mApartments) {
        this.mContext = mContext;
        this.mApartments = mApartments;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        mContext = parent.getContext();

        final View apartmentsLayout = LayoutInflater.from(mContext)
                .inflate(R.layout.searchfor_aparts_layout, null);

        holder = new ViewHolder(apartmentsLayout);


        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder Holder, int position) {

        ApartmentsData apartmentsData = mApartments.get(position);
        if (apartmentsData != null) {
            if (Holder.mTvTitle != null)
                Holder.mTvTitle.setText(apartmentsData.getTitle());

            if (Holder.mTvDesc != null)
                Holder.mTvDesc.setText(apartmentsData.getDescription());

            if (Holder.mTvCond != null)
                Holder.mTvCond.setText(apartmentsData.getCondition());

            if (Holder.mTvAddress != null)
                Holder.mTvAddress.setText(apartmentsData.getAddress());

            if (Holder.mTvLocation != null)
                Holder.mTvLocation.setText(apartmentsData.getLocation());

            if (Holder.mTvPrice != null)
                Holder.mTvPrice.setText(apartmentsData.getPrice() + "");

            if (Holder.mTvNumBaths != null)
                Holder.mTvNumBaths.setText(apartmentsData.getNumofBaths());

            if (Holder.mTvNumBeds != null)
                Holder.mTvNumBeds.setText(apartmentsData.getNumofBeds());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }


    @Override
    public int getItemCount() {
        return mApartments.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTvTitle, mTvDesc, mTvCond, mTvAddress, mTvLocation, mTvPrice, mTvNumBaths, mTvNumBeds;

        public ViewHolder(View view) {
            super(view);

            mTvTitle = (TextView) view.findViewById(R.id.tvRecyclerTitle);
            mTvDesc = (TextView) view.findViewById(R.id.tvDescription);
            mTvCond = (TextView) view.findViewById(R.id.tvCondition);
            mTvLocation = (TextView) view.findViewById(R.id.tvLocation);
            mTvAddress = (TextView) view.findViewById(R.id.tvAddress);
            mTvPrice = (TextView) view.findViewById(R.id.tvPrice);
            mTvNumBaths = (TextView) view.findViewById(R.id.tvNumofBaths);
            mTvNumBeds = (TextView) view.findViewById(R.id.tvNumofBeds);

        }
    }
}
