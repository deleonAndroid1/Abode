package com.training.android.abode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Lenovo on 3/12/2017.
 */

public class Profile extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

        public void tenantProfile (View v) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }



}
