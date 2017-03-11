package com.training.android.abode.Controller;

import com.training.android.abode.Data.IconsData;
import com.training.android.abode.R;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public List<IconsData> mIconsData;

    public Controller() {
        mIconsData = new ArrayList<>();
        mIconsData.add(new IconsData(R.drawable.user, "Profile"));
        mIconsData.add(new IconsData(R.drawable.home, "My Apartment"));
        mIconsData.add(new IconsData(R.drawable.mailbox, "Mail Box"));
        mIconsData.add(new IconsData(R.drawable.map_location, "View Apartments"));
        mIconsData.add(new IconsData(R.drawable.pin_post, "Notice Board"));
        mIconsData.add(new IconsData(R.drawable.credit_card, "Payment"));
        mIconsData.add(new IconsData(R.drawable.contract, "Contract"));
    }


    public List<IconsData> getmIconsData() {
        return mIconsData;
    }


}
