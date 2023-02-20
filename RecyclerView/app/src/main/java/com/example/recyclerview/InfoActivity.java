package com.example.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        int c_id = getIntent().getIntExtra("c_id", 0);

        String[] game_name = getResources().getStringArray(R.array.games);
        String[] genre = getResources().getStringArray(R.array.genre);
        String[] year = getResources().getStringArray(R.array.year);
        String[] developer = getResources().getStringArray(R.array.developer);
        String[] publisher = getResources().getStringArray(R.array.publisher);
        String[] platforms = getResources().getStringArray(R.array.platforms);
        String[] description = getResources().getStringArray(R.array.description);

        InfoAdapter adapter = new InfoAdapter(game_name[c_id], genre[c_id], year[c_id],
                developer[c_id], publisher[c_id], platforms[c_id], description[c_id]);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        recyclerView.setAdapter(adapter);
    }
}