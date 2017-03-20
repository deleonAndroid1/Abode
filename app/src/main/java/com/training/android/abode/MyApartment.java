package com.training.android.abode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.training.android.abode.Data.ApartmentsData;
import com.training.android.abode.Data.TenantData;

public class MyApartment extends AppCompatActivity {

    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mMyApartmentRef, mCurrentApartmentRef, mApartmentsRef;
    ChildEventListener mChildEventListener, mEventListener, mAparmentsListener;

    TextView mtvALandlordName, mtvALandlordContact, mtvMyApartmentAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_apartment);

        mtvALandlordName = (TextView) findViewById(R.id.tvALandlordName);
        mtvALandlordContact = (TextView) findViewById(R.id.tvALandlordContact);
        mtvMyApartmentAddress = (TextView) findViewById(R.id.tvMyApartmentAddress);

        Intent q = getIntent();
        Bundle data = q.getExtras();
        final String currentuseremail = data.getString("Email");

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMyApartmentRef = mFirebaseDatabase.getReference("Data").child("ListofTenantsperApart").child("List2").child("Tenants");

        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                TenantData tenantData = dataSnapshot.getValue(TenantData.class);
                String email = tenantData.getEmail();
                getMyCurrentApartment(currentuseremail, email);
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
        mMyApartmentRef.addChildEventListener(mChildEventListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.myapartment, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.ViewBulletin:
                Intent i = new Intent(MyApartment.this, NoticeBoard.class);
                startActivity(i);
                break;

            case R.id.ViewMyContract:
                Intent k = new Intent(MyApartment.this, Contract.class);
                startActivity(k);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getMyCurrentApartment(String currentemail, String emaill) {

        if (emaill.equals(currentemail)) {
            mCurrentApartmentRef = mFirebaseDatabase.getReference("Data").child("ListofTenantsperApart");
            mEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    mApartmentsRef = mFirebaseDatabase.getReference("Data").child("Apartments");
                    mAparmentsListener = new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                            ApartmentsData apartmentsData = dataSnapshot.getValue(ApartmentsData.class);
                            mtvALandlordName.setText(apartmentsData.getLandlordName());
                            mtvALandlordContact.setText(apartmentsData.getLandlordContact());
                            mtvMyApartmentAddress.setText(apartmentsData.getLocation());
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
                    mApartmentsRef.addChildEventListener(mAparmentsListener);
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
            mCurrentApartmentRef.addChildEventListener(mEventListener);
        }
    }
}
