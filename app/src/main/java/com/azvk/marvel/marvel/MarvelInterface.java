package com.azvk.marvel.marvel;

import com.azvk.marvel.model.MarvelRespond;

public interface MarvelInterface {

    interface View{

        void onComplete(MarvelRespond data);

        void onError(String message);
    }

    interface Presenter{

        void fetchData();

        void fetchDataDB();
    }
}
