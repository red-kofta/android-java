package com.example.l3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ReadGame game = new ReadGame(getIntent().getStringExtra("game_name"),
                getIntent().getStringExtra("genre"),
                getIntent().getStringExtra("year"),
                getIntent().getStringExtra("developer"),
                getIntent().getStringExtra("publisher"),
                getIntent().getStringExtra("platforms"),
                getIntent().getStringExtra("description"));
        InfoAdapter adapter = new InfoAdapter(game);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        recyclerView.setAdapter(adapter);
    }
}