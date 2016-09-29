package com.azvk.marvel.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Images extends RealmObject{

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
