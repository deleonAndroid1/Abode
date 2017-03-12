package com.training.android.abode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.training.android.abode.Samples.SampleInputObject;

public class ViewSearchedApartments extends AppCompatActivity {

    TextView mtvTitle, mtvDesc, mtvLocation, mtvCond, mtvBed, mtvBath;
    private ChildEventListener mChildEventListener;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessagesDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_searched_apartments);


        mtvTitle = (TextView) findViewById(R.id.tvTitle);
        mtvDesc = (TextView) findViewById(R.id.tvDescription);
        mtvLocation = (TextView) findViewById(R.id.tvLocation);
        mtvCond = (TextView) findViewById(R.id.tvCondition);
        mtvBath = (TextView) findViewById(R.id.tvNumofBaths);
        mtvBed = (TextView) findViewById(R.id.tvNumofBeds);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("Apartments");

        if (mChildEventListener == null) {
            mChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    SampleInputObject sampleInputObject = dataSnapshot.getValue(SampleInputObject.class);
                    mtvTitle.setText(sampleInputObject.getTitle());
                    mtvDesc.setText(sampleInputObject.getDescription());
                    mtvLocation.setText(sampleInputObject.getLocation());
                    mtvCond.setText(sampleInputObject.getCondition());
                    mtvBed.setText(sampleInputObject.getBed());
                    mtvBath.setText(sampleInputObject.getBath());
                }


                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            };
            mMessagesDatabaseReference.addChildEventListener(mChildEventListener);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.view_map, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.ViewMaps:
                Intent i = new Intent(ViewSearchedApartments.this, SearchApartmentsMaps.class);
                startActivity(i);
        }


        return super.onOptionsItemSelected(item);
    }
}
