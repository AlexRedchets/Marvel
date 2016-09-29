package com.azvk.marvel.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Prices extends RealmObject{

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
