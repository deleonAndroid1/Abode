package com.training.android.abode;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;
import com.training.android.abode.Data.TenantData;

/**
 * Created by Lenovo on 3/12/2017.
 */

public class Profile extends AppCompatActivity {

    private TextView mTvProfName, mTvProfEmail, mtvProfContact;
    private ImageView mIvProfPic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        mIvProfPic = (ImageView) findViewById(R.id.ivProfPic);
        mTvProfName = (TextView) findViewById(R.id.tvProfName);
        mTvProfEmail = (TextView) findViewById(R.id.tvProfEmail);

        Intent i = getIntent();
        Bundle data = i.getExtras();

        mTvProfName.setText(data.getString("User"));
        mTvProfEmail.setText(data.getString("Email"));
        Picasso.with(Profile.this).load(data.getString("url")).into(mIvProfPic);

    }


}
