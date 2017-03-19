package com.training.android.abode.Maps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.training.android.abode.Adapter.ApartmentsAdapter;
import com.training.android.abode.Data.ApartmentsData;
import com.training.android.abode.R;

import java.util.ArrayList;

public class SearchforAparts extends AppCompatActivity {

    int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;
    private static final String TAG = "Error: SEARCH";
    private RecyclerView mRecycler;
    private ApartmentsAdapter mAdapter;
    private ArrayList<ApartmentsData> apartmentsDatas = new ArrayList<>();
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mApartmentsDatabaseReference;
    private ChildEventListener mChildEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchfor_aparts);

        mRecycler = (RecyclerView) findViewById(R.id.rvSearched);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mApartmentsDatabaseReference = mFirebaseDatabase.getReference("Data").child("Apartments");

        attachDatabaseReadListener();



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(this, data);

                LatLng latLng = place.getLatLng();
                Intent i = new Intent(this, SearchApartmentsMaps.class);
                Bundle args = new Bundle();
                args.putParcelable("latlng", latLng);
                i.putExtra("bundle", args);
                startActivity(i);
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(this, data);
                Toast.makeText(this, status.getStatus().toString(), Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_apart, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.search_aprt:

                try {
                    Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                            .build(this);
                    startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
                } catch (GooglePlayServicesRepairableException e) {
                    // TODO: Handle the error.
                } catch (GooglePlayServicesNotAvailableException e) {
                    // TODO: Handle the error.
                }
        }

        return super.onOptionsItemSelected(item);
    }

    private void attachDatabaseReadListener() {
        Intent b = getIntent();
        Bundle data = b.getExtras();

        final String TenantName = data.getString("User");
        final String TenantEmail = data.getString("Email");

        if (mChildEventListener == null) {
            mChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    String key = dataSnapshot.getKey();
                    ApartmentsData apartData = dataSnapshot.getValue(ApartmentsData.class);
                    apartData.setApartmentID(key);
                    apartmentsDatas.add(apartData);

                    mAdapter = new ApartmentsAdapter(getApplicationContext(), apartmentsDatas, TenantName, TenantEmail);
                    mRecycler.setAdapter(mAdapter);
                    mRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    ApartmentsData apartData = dataSnapshot.getValue(ApartmentsData.class);
                    apartmentsDatas.add(apartData);
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            };
            mApartmentsDatabaseReference.addChildEventListener(mChildEventListener);
        }

    }
}
