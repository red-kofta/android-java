package com.example.l3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.CourseViewHolder> {
    private final List<ReadGame> info;
    private final Context context;

    public CoursesAdapter(List<ReadGame> info, Context context) {
        this.info = info;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return info.size();
    }

    @NonNull
    @Override
    public CoursesAdapter.CourseViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new CourseViewHolder(layoutInflater.inflate(R.layout.list_item_course, parent, false));
    }

    @Override
    public void onBindViewHolder( @NonNull CoursesAdapter.CourseViewHolder holder, int position) {
        ReadGame game = info.get(position);
        holder.header.setText(game.game_name);

        Picasso.get().load(game.img_url).into(holder.img);

        //нажатие на элемент
        holder.itemView.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, InfoActivity.class);
                i.putExtra("game_name", game.game_name);
                i.putExtra("genre", game.genre);
                i.putExtra("year", game.year);
                i.putExtra("developer", game.developer);
                i.putExtra("publisher", game.publisher);
                i.putExtra("platforms", game.platforms);
                i.putExtra("description", game.description);
                context.startActivity(i);
            }
        });
    }

    static class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView header;
        ImageView img;
        public CourseViewHolder( @NonNull View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.header);
            img = itemView.findViewById(R.id.img);
        }
    }
}
