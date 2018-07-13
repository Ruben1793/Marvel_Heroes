package com.aldominium.marvelheroes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.aldominium.marvelheroes.Api.MarvelService;
import com.aldominium.marvelheroes.Models.Basic;
import com.aldominium.marvelheroes.Models.Data;
import com.aldominium.marvelheroes.Models.SuperHero;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final int AVENGERS_COMIC_ID = 354;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call<Basic<Data<ArrayList<SuperHero>>>> superHeroesCall = MarvelService.getMarveApi().getHeroes(AVENGERS_COMIC_ID, "-name");

        superHeroesCall.enqueue(new Callback<Basic<Data<ArrayList<SuperHero>>>>() {
            @Override
            public void onResponse(Call<Basic<Data<ArrayList<SuperHero>>>> call, Response<Basic<Data<ArrayList<SuperHero>>>> response) {
                Toast.makeText(MainActivity.this, "Hero Name: " + response.body().getData().getResults().get(0).getName(),
                        Toast.LENGTH_LONG).show();
                Log.d("RESPONSE:", "Hero Name: " + response.body().getData().getResults().get(0).getName());
            }

            @Override
            public void onFailure(Call<Basic<Data<ArrayList<SuperHero>>>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error en la llamada " , Toast.LENGTH_SHORT).show();

            }
        });
    }
}
