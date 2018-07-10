package com.aldominium.marvelheroes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call<Basic<Data<ArrayList<SuperHero>>>> superHeroesCall = MarvelService.getMarveApi().getHeroes(354);

        superHeroesCall.enqueue(new Callback<Basic<Data<ArrayList<SuperHero>>>>() {
            @Override
            public void onResponse(Call<Basic<Data<ArrayList<SuperHero>>>> call, Response<Basic<Data<ArrayList<SuperHero>>>> response) {
                Toast.makeText(MainActivity.this, "Hero Name: " + response.body().getData().getResults().get(0).getName(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Basic<Data<ArrayList<SuperHero>>>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error en la llamada " , Toast.LENGTH_SHORT).show();

            }
        });
    }
}
