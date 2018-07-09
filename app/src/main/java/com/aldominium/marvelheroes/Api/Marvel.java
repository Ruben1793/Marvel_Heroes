package com.aldominium.marvelheroes.Api;

import com.aldominium.marvelheroes.Models.Basic;
import com.aldominium.marvelheroes.Models.Data;
import com.aldominium.marvelheroes.Models.SuperHero;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Marvel {

    @GET("v1/public/series/{seriesId}/characters?apikey=1bb0e647772926d7e0c938406f8202dc&ts=1&hash=e762cedc252cb80dd50e3cda962c78b6")
    Call<Basic<Data<ArrayList<SuperHero>>>> getHeroes(@Path("seriesId") int seriesId);
}
