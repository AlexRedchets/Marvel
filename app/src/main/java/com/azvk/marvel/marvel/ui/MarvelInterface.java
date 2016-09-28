package com.azvk.marvel.marvel.ui;

import com.azvk.marvel.model.BookModel;
import com.azvk.marvel.model.MarvelRespond;

import java.util.List;

public interface MarvelInterface {

    interface View{

        void onComplete(List<BookModel> data);

        void onError(String message);
    }

    interface Presenter{

        void fetchData();

        void fetchDataDB();
    }
}
