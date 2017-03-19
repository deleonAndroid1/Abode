package com.training.android.abode.Data;

/**
 * Created by Hillary Briones on 3/15/2017.
 */

public class ModelClass {
    private String Title, imgUrl, Description;

    public ModelClass() {
    }

    public ModelClass(String title, String imgUrl, String description) {

        Title = title;
        this.imgUrl = imgUrl;
        Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
