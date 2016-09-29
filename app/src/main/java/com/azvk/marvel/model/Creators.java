package com.azvk.marvel.model;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Creators extends RealmObject {

    private RealmList<Items> items;

    public RealmList<Items> getItems() {
        return items;
    }

    public void setItems(RealmList<Items> items) {
        this.items = items;
    }
}
