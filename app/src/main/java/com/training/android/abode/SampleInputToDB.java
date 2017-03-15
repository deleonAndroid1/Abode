package com.training.android.abode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.training.android.abode.Data.ApartmentsData;
import com.training.android.abode.R;

public class SampleInputToDB extends AppCompatActivity {

    EditText mtvTitle, mtvPrice, mtvDesc,mtvAddress, mtvLocation, mtvCond, mtvBed, mtvBath;
    Button mbtnADD;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessagesDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_input_to_db);

        mtvTitle = (EditText) findViewById(R.id.etTitle);
        mtvPrice = (EditText) findViewById(R.id.etPrice);
        mtvDesc = (EditText) findViewById(R.id.etDesc);
        mtvAddress = (EditText) findViewById(R.id.etAddress);
        mtvLocation = (EditText) findViewById(R.id.etLocation);
        mtvCond = (EditText) findViewById(R.id.etCondition);
        mtvBath = (EditText) findViewById(R.id.etBath);
        mtvBed = (EditText) findViewById(R.id.etBed);
        mbtnADD = (Button) findViewById(R.id.btnADD);



        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("Apartments");


        mbtnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApartmentsData apartmentsData = new ApartmentsData(mtvTitle.getText().toString()
                        , mtvDesc.getText().toString()
                        , mtvCond.getText().toString()
                        , mtvLocation.getText().toString()
                        , mtvAddress.getText().toString()
                        , Double.valueOf(mtvPrice.getText().toString())
                        , Integer.valueOf(mtvBed.getText().toString())
                        , Integer.valueOf(mtvBath.getText().toString()));

                mMessagesDatabaseReference.push().setValue(apartmentsData);
            }
        });

    }
}
