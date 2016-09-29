package com.azvk.marvel.model;

import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class BookModel {

    private String title;
    private List<Images> images;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }
}
