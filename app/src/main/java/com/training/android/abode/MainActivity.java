package com.training.android.abode;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.training.android.abode.Adapter.IconsAdapter;
import com.training.android.abode.Controller.Controller;
import com.training.android.abode.Data.TenantData;
import com.training.android.abode.Maps.SearchforAparts;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    public static final int RC_SIGN_IN = 1;
    LocationManager locationManager;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mUsersDatabaseReference;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private String userName, Email, url;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mUsersDatabaseReference = mFirebaseDatabase.getReference("Data").child("Users").child("Tenant");

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    //user is signed out
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setTheme(R.style.FullscreenTheme)
                                    .setLogo(R.drawable.logo101)
                                    .setProviders(Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                            new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                                    .build(), RC_SIGN_IN);
                } else {
                    userName = user.getDisplayName();
                    Email = user.getEmail();
                    url = String.valueOf(user.getPhotoUrl());
                }
            }
        };

        GridView mGridView = (GridView) findViewById(R.id.grid_icons);
        Controller controller = new Controller();
        ListAdapter adapter = new IconsAdapter(this, R.layout.icon_layout, controller.getmIconsData());
        mGridView.setAdapter(adapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int j, long l) {

                String position = String.valueOf(j);

                Toast.makeText(MainActivity.this, position, Toast.LENGTH_SHORT).show();

                switch (position) {
                    case "0":
                        Intent q = new Intent(MainActivity.this, Profile.class);
                        q.putExtra("User", userName);
                        q.putExtra("Email", Email);
                        q.putExtra("url", url);
                        startActivity(q);
                        break;

                    case "1":
                        Intent m = new Intent(MainActivity.this, ApartmentActivity.class);
                        startActivity(m);
                        break;
                    case "2":
                        Intent a = new Intent(MainActivity.this, MailboxActivity.class);
                        startActivity(a);
                        break;
                    case "3":
                        Intent b = new Intent(MainActivity.this, SearchforAparts.class);
                        b.putExtra("User", userName);
                        b.putExtra("Email", Email);
                        startActivity(b);

                        break;
                    case "4":
                        Intent i = new Intent(MainActivity.this, NoticeBoard.class);
                        startActivity(i);
                        break;
                    case "5":
                        Toast.makeText(MainActivity.this, userName, Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainActivity.this, Email, Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainActivity.this, url, Toast.LENGTH_SHORT).show();
                        break;


                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.sign_out_menu:
                //sign out
                AuthUI.getInstance().signOut(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                String key = mUsersDatabaseReference.getKey();
                Toast.makeText(MainActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
                TenantData tenantData = new TenantData(userName, Email, url, 123);
                mUsersDatabaseReference.child("Tenant2").setValue(tenantData) ;
            } else {
                Toast.makeText(this, "Signed in canceled", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAuthStateListener != null) {
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }


    private boolean checkLocation() {
        if (!isLocationEnabled())
            showAlert();
        return isLocationEnabled();
    }

    private void showAlert() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Enable Location")
                .setMessage("Please Enable Location and Set Mode to High Accuracy to use this app")
                .setPositiveButton("Location Settings", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(myIntent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    }
                });
        dialog.show();
    }

    private boolean isLocationEnabled() {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AuthUI.getInstance().signOut(this);

    }
}
