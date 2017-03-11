package com.training.android.abode.Samples;

/**
 * Created by Dyste on 3/10/2017.
 */

public class SampleInputObject {

    private String Title, Description, Location, Condition, Bed, Bath;

    public SampleInputObject() {
    }

    public SampleInputObject(String title, String description, String location, String condition, String bed, String bath) {
        Title = title;
        Description = description;
        Location = location;
        Condition = condition;
        Bed = bed;
        Bath = bath;
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

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getCondition() {
        return Condition;
    }

    public void setCondition(String condition) {
        Condition = condition;
    }

    public String getBed() {
        return Bed;
    }

    public void setBed(String bed) {
        Bed = bed;
    }

    public String getBath() {
        return Bath;
    }

    public void setBath(String bath) {
        Bath = bath;
    }
}
