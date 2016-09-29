package com.azvk.marvel.model;

import io.realm.RealmObject;

public class Items extends RealmObject{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
