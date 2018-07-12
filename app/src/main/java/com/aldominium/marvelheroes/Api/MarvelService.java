package com.aldominium.marvelheroes.Api;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MarvelService {

    public static Marvel getMarveApi(){

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originRequest = chain.request();
                HttpUrl originalUrl = originRequest.url();
                HttpUrl httpUrl = originalUrl.newBuilder()
                        .addQueryParameter(Marvel.API_KEY, Marvel.API_KEY_VALUE)
                        .addQueryParameter(Marvel.TIME_STAMP_KEY, Marvel.TIME_STAMP_VALUE)
                        .addQueryParameter(Marvel.HASH_KEY, Marvel.HASH_VALUE)
                        .build();
                Request.Builder requestBuilder = originRequest.newBuilder().url(httpUrl);
                return chain.proceed(requestBuilder.build());
            }
        }).build();

        return new Retrofit.Builder()
                .baseUrl(Marvel.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Marvel.class);


    }
}
