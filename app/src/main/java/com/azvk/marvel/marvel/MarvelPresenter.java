package com.azvk.marvel.marvel;

import android.util.Log;

import com.azvk.marvel.DigestUtils;
import com.azvk.marvel.MarvelClient;
import com.azvk.marvel.marvel.ui.MarvelInterface;
import com.azvk.marvel.model.BookModel;

import javax.inject.Inject;

import io.realm.Realm;
import retrofit2.Retrofit;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MarvelPresenter implements MarvelInterface.Presenter{

    private Retrofit retrofit;
    private MarvelInterface.View view;
    private Realm realm;

    private static final String TAG = MarvelPresenter.class.getSimpleName();
    private static final String API_KEY = "01fdd5eea27a50607e18d9dc5864933e";
    private static final String PRIVATE_KEY = "02ef461fb953d3750f0e60e00bf7d2f8b731462d";

    @Inject
    public MarvelPresenter(Retrofit retrofit, MarvelInterface.View view, Realm realm) {
        this.retrofit = retrofit;
        this.view = view;
        this.realm = realm;
    }

    @Override
    public void fetchData() {
        Integer limit = 15;
        long ts = System.currentTimeMillis();
        String hash = DigestUtils.md5Hex(ts + PRIVATE_KEY + API_KEY);
        retrofit.create(MarvelClient.class).getRepos(limit, ts, API_KEY, hash)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(repos -> {
                            Log.e(TAG, "Successfully got data");

                            realm.beginTransaction();
                            if (realm != null){
                                realm.deleteAll();
                            }
                            realm.copyToRealmOrUpdate(repos.getData().getResults());
                            realm.commitTransaction();

                            view.onComplete(repos.getData().getResults());
                        },
                        throwable -> {
                            Log.e("Error", throwable.getMessage());
                            view.onError(throwable.getMessage());
                        });

    }

    @Override
    public void fetchDataDB() {
        Log.e(TAG, "Getting data from DB");
        view.onComplete(realm.where(BookModel.class).findAll());
    }
}
