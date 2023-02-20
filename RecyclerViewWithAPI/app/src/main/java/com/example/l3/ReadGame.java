package com.example.l3;

import android.graphics.Bitmap;

public class ReadGame{
    public String game_name ;
    public String img_url;
    public String genre;
    public String year;
    public String developer;
    public String publisher;
    public String platforms;
    public String description;

    public ReadGame(String game_name, String img_url, String genre, String year, String developer,
                    String publisher, String platforms, String description){
        this.game_name = game_name;
        this.img_url = img_url;
        this.genre = genre;
        this.year = year;
        this.developer = developer;
        this.publisher = publisher;
        this.platforms = platforms;
        this.description = description;
    }

    public ReadGame(String game_name, String genre, String year, String developer,
                    String publisher, String platforms, String description){
        this.game_name = game_name;
        this.genre = genre;
        this.year = year;
        this.developer = developer;
        this.publisher = publisher;
        this.platforms = platforms;
        this.description = description;
    }
}
