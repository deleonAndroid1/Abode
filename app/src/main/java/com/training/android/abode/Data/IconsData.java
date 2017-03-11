package com.training.android.abode.Data;

public class IconsData {

    int ImgId;
    String name;

    public IconsData(int imgId, String name) {
        ImgId = imgId;
        this.name = name;
    }

    public int getImgId() {
        return ImgId;
    }

    public void setImgId(int imgId) {
        ImgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
