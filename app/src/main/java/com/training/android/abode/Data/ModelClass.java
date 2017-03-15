package com.training.android.abode.Data;

/**
 * Created by Hillary Briones on 3/15/2017.
 */

public class ModelClass {
    String title,image,desc;

    public ModelClass(String title,String image,String desc){
        this.image=image;
        this.title=title;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
