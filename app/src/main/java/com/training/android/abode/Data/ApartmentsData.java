package com.training.android.abode.Data;

/**
 * Created by Dyste on 3/12/2017.
 */

public class ApartmentsData {

    private String Title, Description, Condition, Location, Address, LandlordName,LandlordContact,LandlordEmail;
    private int NumofBaths, NumofBeds, ApartmentPrice;
    public ApartmentsData() {
    }

    public ApartmentsData(String title, String description, String condition, String location, String address
            , int numofBaths, int numofBeds, int apartmentPrice, String landlordName, String landlordContact, String landlordEmail) {
        Title = title;
        Description = description;
        Condition = condition;
        Location = location;
        Address = address;
        NumofBaths = numofBaths;
        NumofBeds = numofBeds;
        ApartmentPrice = apartmentPrice;
        LandlordName = landlordName;
        LandlordContact = landlordContact;
        LandlordEmail = landlordEmail;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCondition() {
        return Condition;
    }

    public void setCondition(String condition) {
        Condition = condition;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getNumofBaths() {
        return NumofBaths;
    }

    public void setNumofBaths(int numofBaths) {
        NumofBaths = numofBaths;
    }

    public int getNumofBeds() {
        return NumofBeds;
    }

    public void setNumofBeds(int numofBeds) {
        NumofBeds = numofBeds;
    }

    public int getApartmentPrice() {
        return ApartmentPrice;
    }

    public void setApartmentPrice(int apartmentPrice) {
        ApartmentPrice = apartmentPrice;
    }

    public String getLandlordName() {
        return LandlordName;
    }

    public void setLandlordName(String landlordName) {
        LandlordName = landlordName;
    }

    public String getLandlordContact() {
        return LandlordContact;
    }

    public void setLandlordContact(String landlordContact) {
        LandlordContact = landlordContact;
    }

    public String getLandlordEmail() {
        return LandlordEmail;
    }

    public void setLandlordEmail(String landlordEmail) {
        LandlordEmail = landlordEmail;
    }
}
