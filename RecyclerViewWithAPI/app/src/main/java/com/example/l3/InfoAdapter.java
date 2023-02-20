package com.example.l3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder> {
    private final ReadGame game;

    public InfoAdapter(ReadGame game) {
        this.game = game;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @NonNull
    @Override
    public InfoAdapter.InfoViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new InfoViewHolder(layoutInflater.inflate(R.layout.list_item_info, parent, false));
    }

    @Override
    public void onBindViewHolder( @NonNull InfoAdapter.InfoViewHolder holder, int position) {
        holder.game_names.setText(game.game_name);
        holder.genres.setText("Жанр: " + game.genre);
        holder.years.setText("Год выхода: " + game.year);
        holder.developers.setText("Разработчик: " + game.developer);
        holder.publishers.setText("Издатель: " + game.publisher);
        holder.platformss.setText("Платформы: " + game.platforms);
        holder.descriptions.setText("Краткое описание: " + game.description);
    }

    static class InfoViewHolder extends RecyclerView.ViewHolder {
        TextView game_names;
        TextView genres;
        TextView years;
        TextView developers;
        TextView publishers;
        TextView platformss;
        TextView descriptions;
        public InfoViewHolder( @NonNull View itemView) {
            super(itemView);
            game_names = itemView.findViewById(R.id.game_name);
            genres = itemView.findViewById(R.id.genre);
            years = itemView.findViewById(R.id.year);
            developers = itemView.findViewById(R.id.developer);
            publishers = itemView.findViewById(R.id.publisher);
            platformss = itemView.findViewById(R.id.platforms);
            descriptions = itemView.findViewById(R.id.description);
        }
    }
}
