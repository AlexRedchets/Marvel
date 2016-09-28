package com.azvk.marvel.model;

import io.realm.annotations.PrimaryKey;

public class MarvelRespond {

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
