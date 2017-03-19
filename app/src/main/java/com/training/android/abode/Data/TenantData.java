package com.training.android.abode.Data;

import android.net.Uri;


/**
 * Created by Dyste on 3/19/2017.
 */

public class TenantData {

    private String Name, Email;
    private Uri imgURL;
    private long Contact;

    public TenantData(String name, String email, Uri imgURL, long contact) {
        Name = name;
        Email = email;
        this.imgURL = imgURL;
        Contact = contact;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Uri getImgURL() {
        return imgURL;
    }

    public void setImgURL(Uri imgURL) {
        this.imgURL = imgURL;
    }

    public long getContact() {
        return Contact;
    }

    public void setContact(long contact) {
        Contact = contact;
    }
}
