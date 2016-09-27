package com.azvk.marvel.marvel;

import java.util.List;

public interface MarvelInterface {

    interface View{

        void onComplete(List<MarvelModel> data);

        void onError(String message);
    }

    interface Presenter{

        void fetchData();

        void fetchDataDB();
    }
}
