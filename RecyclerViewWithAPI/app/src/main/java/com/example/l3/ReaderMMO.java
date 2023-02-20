package com.example.l3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Message;
import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class ReaderMMO {
    public List<ReadGame> readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readMessagesArray(reader);
        } finally {
            reader.close();
        }
    }

    public List<ReadGame> readMessagesArray(JsonReader reader) throws IOException {
        List<ReadGame> messages = new ArrayList<ReadGame>();

        reader.beginArray();
        while (reader.hasNext()) {
            messages.add(readMessage(reader));
        }
        reader.endArray();
        return messages;
    }



    public ReadGame readMessage(JsonReader reader) throws IOException {
        String game_name = null;
        String img_url = null;
        String genre = null;
        String year = null;
        String developer = null;
        String publisher = null;
        String platforms = null;
        String description = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("title")) {
                game_name = reader.nextString();
            } else if (name.equals("thumbnail")) {
                img_url = reader.nextString();
            } else if (name.equals("genre")) {
                genre = reader.nextString();
            } else if (name.equals("release_date")) {
                year = reader.nextString();
            } else if (name.equals("developer")) {
                developer = reader.nextString();
            } else if (name.equals("publisher")) {
                publisher = reader.nextString();
            } else if (name.equals("platforms")) {
                platforms = reader.nextString();
            } else if (name.equals("short_description")) {
                description = reader.nextString();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();

        return new ReadGame(game_name, img_url, genre, year, developer, publisher, platforms,
                description);
    }
}


