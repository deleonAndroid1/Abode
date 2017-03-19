package com.training.android.abode.Adapter;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
    private String user, email;

    public ApartmentsAdapter(Context mContext, List<ApartmentsData> mApartments, String user, String email) {
        this.mContext = mContext;
        this.mApartments = mApartments;
        this.user = user;
        this.email = email;
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

                    i.putExtra("Title", apartmentsData.getTitle());
                    i.putExtra("Desc", apartmentsData.getDescription());
                    i.putExtra("Cond", apartmentsData.getCondition());
                    i.putExtra("Location", apartmentsData.getLocation());
                    i.putExtra("Address", apartmentsData.getAddress());
                    i.putExtra("Price", apartmentsData.getApartmentPrice());
                    i.putExtra("NumBath", apartmentsData.getNumofBaths());
                    i.putExtra("NumBeds", apartmentsData.getNumofBeds());
                    i.putExtra("LandLordName", apartmentsData.getLandlordName());
                    i.putExtra("Contact", apartmentsData.getLandlordContact());
                    i.putExtra("Email", apartmentsData.getLandlordEmail());
                    i.putExtra("ID", apartmentsData.getApartmentID());
                    i.putExtra("TenantName", user);
                    i.putExtra("TenantEmail", email);

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


        ImageView mRecyclerImage;
        TextView mTvTitle, mTvPrice, mTvAddress;

        public ViewHolder(View view) {
            super(view);

            mRecyclerImage = (ImageView) view.findViewById(R.id.imgRecycler);
            mTvTitle = (TextView) view.findViewById(R.id.tvTitle);
            mTvPrice = (TextView) view.findViewById(R.id.tvRecyclerPrice);
            mTvAddress = (TextView) view.findViewById(R.id.tvRecyclerAddress);


        }
    }
}
