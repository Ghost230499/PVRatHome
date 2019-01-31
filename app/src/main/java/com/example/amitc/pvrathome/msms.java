package com.example.amitc.pvrathome;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class msms extends AppCompatActivity {
    String img_src;
    Button button;
    Button button1;
    private ArrayList<String> m_name3 = new ArrayList<>();
    private ArrayList<String> m_release_year3 = new ArrayList<>();
    private ArrayList<String> m_genre3 = new ArrayList<>();
    private ArrayList<String> m_director3 = new ArrayList<>();
    private ArrayList<String> m_rating3 = new ArrayList<>();
    private ArrayList<String> m_actor3 = new ArrayList<>();
    private ArrayList<String> m_desc3 = new ArrayList<>();
    private ArrayList<String> m_imgsrc3 = new ArrayList<>();
    StringRequest stringRequest;
    Context mContext;
    String url_all = "https://www.dropbox.com/s/ofzv2j16vq9ofmq/100MovieList.json?dl=1";
    String movieurl = "http://85.25.210.46/downloads/Batti.Gul.Meter.Chalu.2018.Cam.mkv?st=YKruDtG9lQwYvOJQN7t_Rw&e=1539319418";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.msms);

//        Button button = findViewById(R.id.watch_now);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setDataAndType(Uri.parse(movieurl), "video/mp4");
//                startActivity(intent);
//            }
//        });
//
//        Button button1 = findViewById(R.id.download);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //long downloadReference;
//                Uri uri = Uri.parse(movieurl);
//                DownloadManager downloadManager;
//                downloadManager = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);
//                DownloadManager.Request request = new DownloadManager.Request(uri);
//
//                //Setting title of request
//                request.setTitle("Data Download");
//
//                //Setting description of request
//                request.setDescription("Android Data download using DownloadManager.");
//
//                request.setDestinationInExternalFilesDir(msms.this,
//                        Environment.DIRECTORY_DOWNLOADS,"you.mp4");
//                //downloadReference = downloadManager.enqueue(request);
//                downloadManager.enqueue(request);
//
//            }
//        });

        button = findViewById(R.id.download);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download_movies_popup a = new download_movies_popup(movieurl, mContext);
                a.show(getSupportFragmentManager(), "Download");
            }
        });

        button1 = findViewById(R.id.watch_now);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stream_movies_popup a = new stream_movies_popup(movieurl);
                a.show(getSupportFragmentManager(), "Stream");
            }
        });

        new getIncomingIntent().execute();

        ImageView imageView = findViewById(R.id.msms_image);

        mContext = this;

        Glide.with(this)
                .load(img_src)
                .apply(new RequestOptions()
                        .placeholder(R.drawable.rec)
                        .dontAnimate()
                        .error(R.drawable.movies_dark))
                .into(imageView);

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);

        } else if (Intent.ACTION_VIEW.equals(intent.getAction())) {

            String uri = intent.getDataString();
            final int index = Integer.parseInt(uri.replaceAll("[^0-9]", ""));
            //

            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Fetching Data...");
            progressDialog.setCancelable(false);
            progressDialog.show();
            stringRequest = new StringRequest(Request.Method.GET,
                    url_all,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {
                            progressDialog.dismiss();
                            try {
                                JSONObject jsonObject = new JSONObject(s);
                                JSONArray array = jsonObject.getJSONArray("movies");

                                for (int i = 0; i < array.length(); i++) {
                                    JSONObject o = array.getJSONObject(i);
                                    String name = o.getString("name");
                                    String year = o.getString("year");
                                    String genre = o.getString("genre");
                                    String rating = o.getString("rating");
                                    String director = o.getString("directors_name");
                                    String actor = o.getString("cast");
                                    String img_src = o.getString("poster_src");
                                    String desc = o.getString("description");

                                    m_name3.add(name);
                                    m_release_year3.add(year);
                                    m_genre3.add(genre);
                                    m_rating3.add(rating);
                                    m_director3.add(director);
                                    m_actor3.add(actor);
                                    m_imgsrc3.add(img_src);
                                    m_desc3.add(desc);
                                }

                                TextView m_name = findViewById(R.id.msms_name);
                                m_name.setText(m_name3.get(index));

                                TextView m_name1 = findViewById(R.id.msms_name1);
                                m_name1.setText(m_name3.get(index));
                                //        TextView m_year = (TextView) findViewById(R.id.msms_year);
                                //        m_year.setText(year);

                                TextView m_genre = findViewById(R.id.msms_genre);
                                m_genre.setText(m_genre3.get(index));

                                TextView m_rating = findViewById(R.id.msms_rating);
                                m_rating.setText(m_rating3.get(index));

                                TextView m_desc = findViewById(R.id.msms_desc);
                                m_desc.setText(m_desc3.get(index));

                                TextView m_direc = findViewById(R.id.msms_direc);
                                m_direc.setText(m_director3.get(index));

                                TextView m_actor = findViewById(R.id.msms_actor);
                                m_actor.setText(m_actor3.get(index));

                                ImageView imageView = findViewById(R.id.msms_image);

                                final ProgressDialog progressDialog1 = new ProgressDialog(mContext);
                                progressDialog1.setMessage("Fetching Data...");
                                progressDialog1.setCancelable(false);
                                progressDialog1.show();

                                Glide.with(mContext)
                                        .load(m_imgsrc3.get(index))
                                        .listener(new RequestListener<Drawable>() {
                                            @Override
                                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                                return false;
                                            }

                                            @Override
                                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                                progressDialog1.dismiss();
                                                return false;
                                            }
                                        })
                                        .apply(new RequestOptions()
                                                .placeholder(R.drawable.rec)
                                                .dontAnimate()
                                                .error(R.drawable.movies_dark))
                                        .into(imageView);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Check Internet", Toast.LENGTH_SHORT).show();
                        }
                    });

            RequestQueue requestQueue = Volley.newRequestQueue(msms.this);
            requestQueue.add(stringRequest);
        }

    }

    public class getIncomingIntent extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            String name = getIntent().getStringExtra("names");
//            String year = getIntent().getStringExtra("years");
            String genre = getIntent().getStringExtra("genres");
            String rating = getIntent().getStringExtra("ratings");
            String desc = getIntent().getStringExtra("decs");
            String director = getIntent().getStringExtra("direcs");
            String actor = getIntent().getStringExtra("stars");
            img_src = getIntent().getStringExtra("img1");


            TextView m_name = findViewById(R.id.msms_name);
            m_name.setText(name);

            TextView m_name1 = findViewById(R.id.msms_name1);
            m_name1.setText(name);
            //        TextView m_year = (TextView) findViewById(R.id.msms_year);
            //        m_year.setText(year);

            TextView m_genre = findViewById(R.id.msms_genre);
            m_genre.setText(genre);

            TextView m_rating = findViewById(R.id.msms_rating);
            m_rating.setText(rating);

            TextView m_desc = findViewById(R.id.msms_desc);
            m_desc.setText(desc);

            TextView m_direc = findViewById(R.id.msms_direc);
            m_direc.setText(director);

            TextView m_actor = findViewById(R.id.msms_actor);
            m_actor.setText(actor);

            return null;
        }
    }
}