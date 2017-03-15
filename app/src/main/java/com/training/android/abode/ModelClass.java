package com.training.android.abode;

/**
 * Created by Hillary Briones on 3/15/2017.
 */

public class ModelClass {
    String title,image;
    public ModelClass(String title,String image){
        this.image=image;
        this.title=title;
    }

    public ModelClass() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
