package com.training.android.abode.Data;

/**
 * Created by Dyste on 3/12/2017.
 */

public class ApartmentsData {

    private String Title, Description, Condition, Location, Address;
    private double price;
    private int NumofBaths, NumofBeds;

    public ApartmentsData() {
    }

    public ApartmentsData(String title, String description, String condition, String location, String address, double price, int numofBaths, int numofBeds) {
        Title = title;
        Description = description;
        Condition = condition;
        Location = location;
        Address = address;
        this.price = price;
        NumofBaths = numofBaths;
        NumofBeds = numofBeds;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
}
