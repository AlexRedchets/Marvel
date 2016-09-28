package com.azvk.marvel.marvel;

import android.util.Log;

import com.azvk.marvel.DigestUtils;
import com.azvk.marvel.MarvelClient;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.http.PUT;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MarvelPresenter implements MarvelInterface.Presenter{

    private Retrofit retrofit;
    private MarvelInterface.View view;

    private static final String TAG = MarvelPresenter.class.getSimpleName();
    private static final String API_KEY = "01fdd5eea27a50607e18d9dc5864933e";
    private static final String PRIVATE_KEY = "02ef461fb953d3750f0e60e00bf7d2f8b731462d";

    @Inject
    public MarvelPresenter(Retrofit retrofit, MarvelInterface.View view) {
        this.retrofit = retrofit;
        this.view = view;
    }

    @Override
    public void fetchData() {
        Integer limit = 100;
        long ts = System.currentTimeMillis();
        String hash = DigestUtils.md5Hex(ts + PRIVATE_KEY + API_KEY);
        retrofit.create(MarvelClient.class).getRepos(limit, ts, API_KEY, hash)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(repos -> {
                            Log.e(TAG, "Successfully got data");

                            view.onComplete(repos);
                        },
                        throwable -> {
                            Log.e("Error", throwable.getMessage());
                            view.onError(throwable.getMessage());
                        });

    }

    @Override
    public void fetchDataDB() {

    }
}
