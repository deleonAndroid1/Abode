package com.training.android.abode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

public class Contract extends AppCompatActivity {
    private ImageView mContract;
    FirebaseStorage storage;
    StorageReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);
        mContract=(ImageView) findViewById(R.id.contract);
        storage = FirebaseStorage.getInstance();
        myRef = storage.getReferenceFromUrl("gs://abode-6588e.appspot.com").child("rental agreement.png");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            final File localFile = File.createTempFile("images", "png");
            myRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//                    Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
//                    mContract.setImageBitmap(bitmap);
                    String contracturl = String.valueOf(myRef.getDownloadUrl());
                    Picasso.with(Contract.this).load(contracturl).into(mContract);

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    Toast.makeText(Contract.this, "Failed to load the image.", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (IOException e ) {}
    }
}
