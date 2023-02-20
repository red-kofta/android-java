package com.example.l3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class AsyncInfo extends AsyncTask<String, Void, List> {
    Context context;
    private Listener Listener;
    public List<ReadGame> list;

    AsyncInfo (Context context, Listener listener) {
        this.context = context;
        this.Listener = listener;
    }

    protected List doInBackground(String... params) {
        URL mmoURL = null;
        try {
            mmoURL = new URL("https://www.mmobomb.com/api1/games");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpsURLConnection urlConnection = null;
        JsonReader jsonReader = null;
        try {
            urlConnection = (HttpsURLConnection) mmoURL.openConnection();
            if (urlConnection.getResponseCode() == 200) {
                InputStream responseBody = urlConnection.getInputStream();
                ReaderMMO readerMMO = new ReaderMMO();
                this.list = readerMMO.readJsonStream(responseBody);
            }
            return this.list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(List ls) {
        Listener.passJSONGet(ls);
    }
}
