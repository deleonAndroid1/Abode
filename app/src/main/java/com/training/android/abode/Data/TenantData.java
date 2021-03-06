package com.training.android.abode.Data;



/**
 * Created by Dyste on 3/19/2017.
 */

public class TenantData {

    private String Name, Email, TenantID;
    private String imgURL;
    private String Contact;

    public TenantData() {
    }

    public TenantData(String name, String email, String imgURL, String contact) {
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

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }
}
