package com.example.amitc.pvrathome;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.provider.BaseColumns;



import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CitySuggestionProvider extends ContentProvider {

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    ArrayList<String> names;

    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        if (names == null || names.isEmpty()){
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://www.dropbox.com/s/ofzv2j16vq9ofmq/100MovieList.json?dl=1")
                    .build();
            try {
                Response response = client.newCall(request).execute();
                String jsonString = response.body().string();
                JSONObject jsonObject = new JSONObject(jsonString);
                JSONArray array = jsonObject.getJSONArray("movies");

                names = new ArrayList<>();

                int lenght = array.length();
                for (int i = 0; i < lenght; i++) {
                    JSONObject o = array.getJSONObject(i);
                    String name = o.getString("name");

                    names.add(name);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        MatrixCursor cursor = new MatrixCursor(
                new String[] {
                        BaseColumns._ID,
                        SearchManager.SUGGEST_COLUMN_TEXT_1,
                        SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID
                }
        );
        if (names != null) {
            String query = uri.getLastPathSegment().toUpperCase();
            int limit = Integer.parseInt(uri.getQueryParameter(SearchManager.SUGGEST_PARAMETER_LIMIT));

            int lenght = names.size();
            for (int i = 0; i < lenght && cursor.getCount() < limit; i++) {
                String name = names.get(i);


                if (name.toUpperCase().contains(query)){
                    cursor.addRow(new Object[]{i, name, i});
                }
            }
        }
        return cursor;
    }
}

