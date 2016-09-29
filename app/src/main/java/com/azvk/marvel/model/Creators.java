package com.azvk.marvel.model;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Creators extends RealmObject {

    private RealmList<Items> items;
    private int returned;

    public RealmList<Items> getItems() {
        return items;
    }

    public void setItems(RealmList<Items> items) {
        this.items = items;
    }

    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }
}
