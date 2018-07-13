package com.aldominium.marvelheroes.Api;

import com.aldominium.marvelheroes.Models.Basic;
import com.aldominium.marvelheroes.Models.Data;
import com.aldominium.marvelheroes.Models.SuperHero;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Marvel {

    String BASE_URL = "https://gateway.marvel.com/";

    String API_KEY = "apikey";
    String API_KEY_VALUE = "1bb0e647772926d7e0c938406f8202dc";


    String TIME_STAMP_KEY = "ts";
    String TIME_STAMP_VALUE = "1";

    String HASH_KEY = "hash";
    String HASH_VALUE = "e762cedc252cb80dd50e3cda962c78b6";

    @GET("v1/public/series/{seriesId}/characters?")
    Call<Basic<Data<ArrayList<SuperHero>>>> getHeroes(@Path("seriesId") int seriesId);

    @GET("v1/public/series/{seriesId}/characters?")
    Call<Basic<Data<ArrayList<SuperHero>>>> getHeroes(@Path("seriesId") int seriesId, @Query("orderBy") String sort);
}
