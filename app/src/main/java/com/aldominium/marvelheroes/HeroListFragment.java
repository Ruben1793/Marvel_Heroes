package com.aldominium.marvelheroes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aldominium.marvelheroes.Models.SuperHero;

import java.util.ArrayList;


public class HeroListFragment extends Fragment {

    public static final String TAG = HeroListFragment.class.getSimpleName();
    ArrayList<SuperHero> superHeroes;
    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        superHeroes = bundle.getParcelableArrayList(MainActivity.HERO_LIST);
        if (superHeroes == null ){
            Log.d(TAG, "NO HAY SUPERHEROES EN EL BUNDLE");
        }

        Toast.makeText(getContext(),"El primer superheroe es: " + superHeroes.get(0).getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hero_list, container, false);
        recyclerView = view.findViewById(R.id.superHeroesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        HeroAdapter heroAdapter = new HeroAdapter(superHeroes, getContext());
        recyclerView.setAdapter(heroAdapter);
        return view;
    }

}
