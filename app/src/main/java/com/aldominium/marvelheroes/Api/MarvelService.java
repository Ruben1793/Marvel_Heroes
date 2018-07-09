package com.aldominium.marvelheroes.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MarvelService {

    public static Marvel getMarveApi(){
        return new Retrofit.Builder()
                .baseUrl(Marvel.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Marvel.class);
    }
}
