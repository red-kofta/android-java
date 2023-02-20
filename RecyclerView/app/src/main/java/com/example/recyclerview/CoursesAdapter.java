package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.CourseViewHolder> {
    private final String[] courses;
    private final int[] images;
    private final Context context;

    public CoursesAdapter(String[] courses, int[] images, Context context) {
        this.courses = courses;
        this.images = images;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return courses.length;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new CourseViewHolder(layoutInflater.inflate(R.layout.list_item_course, parent, false));
    }

    @Override
    public void onBindViewHolder( @NonNull CourseViewHolder holder, int position) {
        String course = courses[position];
        holder.header.setText(course);

        Drawable image = holder.img.getResources().getDrawable(images[position]);
        holder.img.setImageDrawable(image);

        int count_id = position;

        //нажатие на элемент
        holder.itemView.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, InfoActivity.class);
                i.putExtra("c_id", count_id);
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
