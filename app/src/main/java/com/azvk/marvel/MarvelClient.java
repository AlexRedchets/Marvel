package com.azvk.marvel;

import com.azvk.marvel.marvel.MarvelModel;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface MarvelClient {
    @GET("comics?")
    Observable<List<MarvelModel>> getRepos(
            @Query("limit") int limit,
            @Query("ts") long ts,
            @Query("apikey") String apikey,
            @Query("hash") String hash
    );
}
