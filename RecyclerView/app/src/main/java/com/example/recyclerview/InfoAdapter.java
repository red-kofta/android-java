package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder> {
    private final String game_name;
    private final String genre;
    private final String year;
    private final String developer;
    private final String publisher;
    private final String platforms;
    private final String description;

    public InfoAdapter(String game_name, String genre, String year, String developer,
                       String publisher, String platforms, String description) {
        this.game_name = game_name;
        this.genre = genre;
        this.year = year;
        this.developer = developer;
        this.publisher = publisher;
        this.platforms = platforms;
        this.description = description;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new InfoViewHolder(layoutInflater.inflate(R.layout.list_item_info, parent, false));
    }

    @Override
    public void onBindViewHolder( @NonNull InfoViewHolder holder, int position) {
        holder.game_names.setText(game_name);
        holder.genres.setText("Жанр: " + genre);
        holder.years.setText("Год выхода: " + year);
        holder.developers.setText("Разработчик: " + developer);
        holder.publishers.setText("Издатель: " + publisher);
        holder.platformss.setText("Платформы: " + platforms);
        holder.descriptions.setText("Краткое описание: " + description);
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
