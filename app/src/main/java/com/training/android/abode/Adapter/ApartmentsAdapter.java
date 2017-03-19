package com.training.android.abode.Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.training.android.abode.Data.ApartmentsData;
import com.training.android.abode.Maps.ViewSearchedApartments;
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
    public void onBindViewHolder(final ViewHolder Holder, final int position) {
        final ApartmentsData apartmentsData = mApartments.get(position);

        if (apartmentsData != null) {
//            if (Holder.mTvTitle != null)
//                Holder.mTvTitle.setText(apartmentsData.getTitle());
//
//            if (Holder.mTvDesc != null)
//                Holder.mTvDesc.setText(apartmentsData.getDescription());
//
//            if (Holder.mTvCond != null)
//                Holder.mTvCond.setText(apartmentsData.getCondition());
//
//            if (Holder.mTvAddress != null)
//                Holder.mTvAddress.setText(apartmentsData.getAddress());
//
//            if (Holder.mTvLocation != null)
//                Holder.mTvLocation.setText(apartmentsData.getLocation());
//
//            if (Holder.mTvPrice != null)
//                Holder.mTvPrice.setText(apartmentsData.getPrice() + "");
//
//            if (Holder.mTvNumBaths != null)
//                Holder.mTvNumBaths.setText(apartmentsData.getNumofBaths());
//
//            if (Holder.mTvNumBeds != null)
//                Holder.mTvNumBeds.setText(apartmentsData.getNumofBeds());
            Holder.mTvTitle.setText(apartmentsData.getTitle());
            Holder.mTvPrice.setText("Price: " + apartmentsData.getApartmentPrice());
            Holder.mTvAddress.setText(apartmentsData.getAddress());
        }


        Holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, ViewSearchedApartments.class);
                if (apartmentsData != null) {
                    i.putExtra("Title",apartmentsData.getTitle());
                }
                if (apartmentsData != null) {
                    i.putExtra("Desc",apartmentsData.getDescription());
                }
                if (apartmentsData != null) {
                    i.putExtra("Cond",apartmentsData.getCondition());
                }
                if (apartmentsData != null) {
                    i.putExtra("Location",apartmentsData.getLocation());
                }
                if (apartmentsData != null) {
                    i.putExtra("Address",apartmentsData.getAddress());
                }
                if (apartmentsData != null) {
                    i.putExtra("Price",apartmentsData.getApartmentPrice());
                }
                if (apartmentsData != null) {
                    i.putExtra("NumBath",apartmentsData.getNumofBaths());
                }
                if (apartmentsData != null) {
                    i.putExtra("NumBeds",apartmentsData.getNumofBeds());
                }
                if (apartmentsData != null) {
                    i.putExtra("LandLordName",apartmentsData.getLandlordName());
                }
                if (apartmentsData != null) {
                    i.putExtra("Contact",apartmentsData.getLandlordContact());
                }
                if (apartmentsData != null) {
                    i.putExtra("Email",apartmentsData.getLandlordEmail());
                }
                mContext.startActivity(i);
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

//        TextView mTvTitle, mTvDesc, mTvCond, mTvAddress, mTvLocation, mTvPrice, mTvNumBaths, mTvNumBeds;

        ImageView mRecyclerImage;
        TextView mTvTitle, mTvPrice, mTvAddress;

        public ViewHolder(View view) {
            super(view);

            mRecyclerImage = (ImageView) view.findViewById(R.id.imgRecycler);
            mTvTitle = (TextView) view.findViewById(R.id.tvTitle);
            mTvPrice = (TextView) view.findViewById(R.id.tvRecyclerPrice);
            mTvAddress = (TextView) view.findViewById(R.id.tvRecyclerAddress);
//            mTvTitle = (TextView) view.findViewById(R.id.tvRecyclerTitle);
//            mTvDesc = (TextView) view.findViewById(R.id.tvDescription);
//            mTvCond = (TextView) view.findViewById(R.id.tvCondition);
//            mTvLocation = (TextView) view.findViewById(R.id.tvLocation);
//            mTvAddress = (TextView) view.findViewById(R.id.tvAddress);
//            mTvPrice = (TextView) view.findViewById(R.id.tvPrice);
//            mTvNumBaths = (TextView) view.findViewById(R.id.tvNumofBaths);
//            mTvNumBeds = (TextView) view.findViewById(R.id.tvNumofBeds);

        }
    }
}
