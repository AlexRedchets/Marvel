package com.azvk.marvel.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class BookModel extends RealmObject {

    @PrimaryKey
    private String title;
    private String format;
    private int pageCount;
    private RealmList<Images> images;
    private RealmList<Prices> prices;
    private Creators creators;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public RealmList<Images> getImages() {
        return images;
    }

    public void setImages(RealmList<Images> images) {
        this.images = images;
    }

    public RealmList<Prices> getPrices() {
        return prices;
    }

    public void setPrices(RealmList<Prices> prices) {
        this.prices = prices;
    }

    public Creators getCreators() {
        return creators;
    }

    public void setCreators(Creators creators) {
        this.creators = creators;
    }
}
