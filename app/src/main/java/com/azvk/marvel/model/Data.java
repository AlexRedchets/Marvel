package com.azvk.marvel.model;

import java.util.List;

public class Data {

    List<BookModel> results;

    public Data(List<BookModel> results) {
        this.results = results;
    }

    public List<BookModel> getResults() {
        return results;
    }

    public void setResults(List<BookModel> results) {
        this.results = results;
    }
}
