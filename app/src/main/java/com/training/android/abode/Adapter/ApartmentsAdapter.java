package com.training.android.abode.Adapter;


import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.training.android.abode.Data.ApartmentsData;
import com.training.android.abode.Data.IconsData;
import com.training.android.abode.R;

import java.util.List;

public class ApartmentsAdapter extends ArrayAdapter<ApartmentsData> {

    private Context mContext;
    private int mResource;
    private List<ApartmentsData> mApartments;


    public ApartmentsAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<ApartmentsData> objects) {
        super(context, resource, objects);

        mContext = context;
        mResource = resource;
        mApartments = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder Holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
            Holder = new ViewHolder(convertView);
            convertView.setTag(Holder);
        } else {
            Holder = (ViewHolder) convertView.getTag();
        }

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

        return super.getView(position, convertView, parent);
    }

    public static class ViewHolder {

        TextView mTvTitle, mTvDesc, mTvCond, mTvAddress, mTvLocation, mTvPrice, mTvNumBaths, mTvNumBeds;

        public ViewHolder(View view) {

            mTvTitle = (TextView) view.findViewById(R.id.tvTitle);
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
