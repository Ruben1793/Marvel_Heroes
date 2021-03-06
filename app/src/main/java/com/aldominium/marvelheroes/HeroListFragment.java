package com.aldominium.marvelheroes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aldominium.marvelheroes.Models.SuperHero;

import java.util.ArrayList;


public class HeroListFragment extends Fragment {

    public static final String TAG = HeroListFragment.class.getSimpleName();
    public static final String HERO_DETAIL_FRAGMENT = "HERO_DETAIL_FRAGMENT";
    public static final String SUPER_HERO = "SUPER_HERO";
    ArrayList<SuperHero> superHeroes;
    RecyclerView recyclerView;

    public HeroListFragment(){}

    public interface HeroClickListener{
        void HeroClicked(SuperHero superHero);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (getArguments() != null){
            superHeroes = bundle.getParcelableArrayList(MainActivity.HERO_LIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hero_list, container, false);
        recyclerView = view.findViewById(R.id.superHeroesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        HeroListAdapter heroListAdapter = new HeroListAdapter(superHeroes, getContext(), new HeroClickListener() {
            @Override
            public void HeroClicked(SuperHero superHero) {
                //Cambiar de Fragment
                goToHeroDetailFragment(superHero);
            }
        });
        recyclerView.setAdapter(heroListAdapter);
        return view;
    }

    private void goToHeroDetailFragment(SuperHero superHero) {
        HeroDetailFragment heroDetailFragment = new HeroDetailFragment();

        FragmentManager fragmentManager = getFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putParcelable(SUPER_HERO, superHero);
        heroDetailFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeholder, heroDetailFragment, HERO_DETAIL_FRAGMENT);
        fragmentTransaction.addToBackStack(HERO_DETAIL_FRAGMENT);
        fragmentTransaction.commit();
    }

}
