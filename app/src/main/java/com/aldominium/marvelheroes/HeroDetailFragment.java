package com.aldominium.marvelheroes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aldominium.marvelheroes.Models.SuperHero;
import com.squareup.picasso.Picasso;

public class HeroDetailFragment extends Fragment {

    SuperHero superHero;
    TextView heroNameTextVew;
    TextView heroDescriptionTextView;
    ImageView heroPictureImageView;


    public HeroDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            superHero = getArguments().getParcelable(HeroListFragment.SUPER_HERO);
            Toast.makeText(getContext(), "Heroe Obtenido: " + superHero.getName(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hero_detail, container, false);
        heroNameTextVew = view.findViewById(R.id.heroDetailTitleTextView);
        heroDescriptionTextView = view.findViewById(R.id.heroDetailDescriptionTextView);
        heroPictureImageView = view.findViewById(R.id.heroDetailThumbnailTextView);

        heroNameTextVew.setText(superHero.getName());
        heroDescriptionTextView.setText(superHero.getDescription());
        Picasso.with(getContext()).load(superHero.getThumbnail().getFullPath()).into(heroPictureImageView);
        
        return view;
    }

}
