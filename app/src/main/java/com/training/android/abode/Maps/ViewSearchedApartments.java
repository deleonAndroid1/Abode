package com.training.android.abode.Maps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.training.android.abode.Data.ApartmentsData;
import com.training.android.abode.R;

public class ViewSearchedApartments extends AppCompatActivity {

    TextView mtvTitle, mtvPrice, mtvDesc, mtvAddress, mtvLocation, mtvCond, mtvBed, mtvBath, mtvLName, mtvLContact, mtvLEmail;


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
        mtvAddress = (TextView) findViewById(R.id.tvAddress);
        mtvPrice = (TextView) findViewById(R.id.tvPrice);
        mtvLName = (TextView) findViewById(R.id.tvLandlordName);
        mtvLContact = (TextView) findViewById(R.id.tvLandlordContact);
        mtvLEmail = (TextView) findViewById(R.id.tvLandlordEmail);

        Intent i = getIntent();
        Bundle data = i.getExtras();

        mtvTitle.setText(data.getString("Title"));
        mtvDesc.setText(data.getString("Desc"));
        mtvLocation.setText("Location: " + data.getString("Location"));
        mtvCond.setText("Condition: " + data.getString("Cond"));
        mtvBed.setText("Number of Bedroom: " + String.valueOf(data.get("NumBeds")));
        mtvBath.setText("Number of Bathroom: " + String.valueOf(data.get("NumBath")));
        mtvAddress.setText("Address: " + data.getString("Address"));
        mtvPrice.setText("Php " + String.valueOf(data.get("Price")));
        mtvLName.setText("Name: " + data.getString("LandLordName"));
        mtvLEmail.setText("Email: " + data.getString("Email"));
        mtvLContact.setText("Contact: " + data.getString("Contact"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.view_map, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = getIntent();
        Bundle data = i.getExtras();

        switch (item.getItemId()) {
            case R.id.ViewMaps:
                Intent x = new Intent(ViewSearchedApartments.this, SearchApartmentsMaps.class);
                x.putExtra("Address", data.getString("Address"));
                x.putExtra("Location", data.getString("Location"));
                startActivity(x);
        }

        return super.onOptionsItemSelected(item);
    }
}
