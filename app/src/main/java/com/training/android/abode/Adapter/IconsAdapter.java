package com.training.android.abode.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.training.android.abode.Data.IconsData;
import com.training.android.abode.R;

import java.util.List;

public class IconsAdapter extends ArrayAdapter<IconsData> {

    private Context mContext;
    private int         mResource;
    private List<IconsData> mImg;


    public IconsAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<IconsData> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
        mImg = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(mResource,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        IconsData iconsData = mImg.get(position);
        if (iconsData != null){
            if (viewHolder.mImgIcon != null){
                viewHolder.mImgIcon.setImageResource(iconsData.getImgId());
            }
            if (viewHolder.mtvTitle != null){
                viewHolder.mtvTitle.setText(iconsData.getName());
            }
        }

        return convertView;
    }

    public static class ViewHolder{

        ImageView mImgIcon;
        TextView mtvTitle;

        public ViewHolder(View view){
            mImgIcon = (ImageView) view.findViewById(R.id.imgIcon);
            mtvTitle = (TextView) view.findViewById(R.id.tvIconTitle);
        }
    }
}
