package com.azvk.marvel;

import com.azvk.marvel.model.MarvelRespond;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface MarvelClient {
    @GET("comics?")
    Observable<MarvelRespond> getRepos(
            @Query("limit") int limit,
            @Query("ts") long ts,
            @Query("apikey") String apikey,
            @Query("hash") String hash
    );
}
