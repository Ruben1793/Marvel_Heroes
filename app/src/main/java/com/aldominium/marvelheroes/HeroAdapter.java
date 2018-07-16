package com.aldominium.marvelheroes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aldominium.marvelheroes.Models.SuperHero;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.MyViewHolder>{

    ArrayList<SuperHero> superHeroArrayList;
    Context context;

    public HeroAdapter(ArrayList superHeroArrayList, Context context, HeroListFragment.HeroClickListener heroClickListener){
        this.superHeroArrayList = superHeroArrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hero_list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SuperHero superHero = superHeroArrayList.get(position);
        holder.heroDetailNameTextView.setText(superHero.getName());
        //holder.heroPictureImageView.setImageResource(superHero.getThumbnail());

        Picasso.with(context).load(superHero.getThumbnail().getFullPath()).into(holder.heroPictureImageView);

    }

    @Override
    public int getItemCount() {
        return superHeroArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView heroPictureImageView;
        public TextView heroDetailNameTextView;

        public MyViewHolder(View itemView) {
            super(itemView);

            heroPictureImageView = itemView.findViewById(R.id.heroPictureImageView);
            heroDetailNameTextView = itemView.findViewById(R.id.heroDetailNameTextView);
        }
    }
}
