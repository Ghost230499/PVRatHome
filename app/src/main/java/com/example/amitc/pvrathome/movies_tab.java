package com.example.amitc.pvrathome;

import android.annotation.TargetApi;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

import com.bumptech.glide.load.model.Model;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class movies_tab extends AppCompatActivity implements SearchView.OnQueryTextListener{

    Toolbar toolbar;

    private static final String url_newest = "https://www.dropbox.com/s/oeutfdvpmmtzikm/NewestMovies.json?dl=1";
    private static final String url_hottest = "https://www.dropbox.com/s/45xopes03s1iyse/Movie.json?dl=1";

    private ArrayList<String> m_name = new ArrayList<>();
    private ArrayList<String> m_release_year = new ArrayList<>();
    private ArrayList<String> m_genre = new ArrayList<>();
    private ArrayList<String> m_desc = new ArrayList<>();
    private ArrayList<String> m_director = new ArrayList<>();
    private ArrayList<String> m_rating = new ArrayList<>();
    private ArrayList<String> m_actor = new ArrayList<>();
    private ArrayList<String> m_imgsrc = new ArrayList<>();
    Context mContext;


    StringRequest stringRequest;
    StringRequest stringRequest1;

    private ArrayList<String> m_name1 = new ArrayList<>();
    private ArrayList<String> m_release_year1 = new ArrayList<>();
    private ArrayList<String> m_genre1 = new ArrayList<>();
    private ArrayList<String> m_director1 = new ArrayList<>();
    private ArrayList<String> m_rating1 = new ArrayList<>();
    private ArrayList<String> m_actor1 = new ArrayList<>();
    private ArrayList<String> m_desc1 = new ArrayList<>();
    private ArrayList<String> m_imgsrc1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_tab);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            ImageView postBackground = (ImageView) findViewById(R.id.home_button);
            Drawable image; //this could be any image of your choice
            {
                image = getDrawable(R.drawable.home_dark);
                RippleDrawable rippledImage = null;
                rippledImage = new RippleDrawable(ColorStateList.valueOf(getColor(R.color.light_white)), image, null);
                postBackground.setImageDrawable(rippledImage);
            }
            postBackground.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(movies_tab.this, MainActivity.class));
                        }
                    }, 100); //delay 100 milliseconds to see the effect.
                }
            });

            ImageView postBackground1 = (ImageView) findViewById(R.id.movie_button);
            Drawable image1; //this could be any image of your choice
            {
                image1 = getDrawable(R.drawable.movies_dark);
                RippleDrawable rippledImage = null;
                rippledImage = new RippleDrawable(ColorStateList.valueOf(getColor(R.color.light_white)), image1, null);
                postBackground1.setImageDrawable(rippledImage);
            }
            postBackground1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                        }
                    }, 100); //delay 100 milliseconds to see the effect.
                }
            });

            ImageView postBackground2 = (ImageView) findViewById(R.id.series_button);
            Drawable image2; //this could be any image of your choice
            {
                image2 = getDrawable(R.drawable.series_dark);
                RippleDrawable rippledImage = null;
                rippledImage = new RippleDrawable(ColorStateList.valueOf(getColor(R.color.light_white)), image2, null);
                postBackground2.setImageDrawable(rippledImage);
            }
            postBackground2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(movies_tab.this, series_tab.class));
                        }
                    }, 100); //delay 100 milliseconds to see the effect.
                }
            });

            ImageView postBackground3 = (ImageView) findViewById(R.id.specials_button);
            Drawable image3; //this could be any image of your choice
            {
                image3 = getDrawable(R.drawable.specials_dark);
                RippleDrawable rippledImage = null;
                rippledImage = new RippleDrawable(ColorStateList.valueOf(getColor(R.color.light_white)), image3, null);
                postBackground3.setImageDrawable(rippledImage);
            }
            postBackground3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(movies_tab.this, specials_tab.class));
                        }
                    }, 100); //delay 100 milliseconds to see the effect.
                }
            });

            ImageView postBackground4 = (ImageView) findViewById(R.id.actors_button);
            Drawable image4; //this could be any image of your choice
            {
                image4 = getDrawable(R.drawable.music_dark);
                RippleDrawable rippledImage = null;
                rippledImage = new RippleDrawable(ColorStateList.valueOf(getColor(R.color.light_white)), image4, null);
                postBackground4.setImageDrawable(rippledImage);
            }
            postBackground4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(movies_tab.this, music_tab.class));
                        }
                    }, 100); //delay 100 milliseconds to see the effect.
                }
            });

            ImageView postBackground5 = (ImageView) findViewById(R.id.favorites_button);
            Drawable image5; //this could be any image of your choice
            {
                image5 = getDrawable(R.drawable.favourite_dark);
                RippleDrawable rippledImage = null;
                rippledImage = new RippleDrawable(ColorStateList.valueOf(getColor(R.color.light_white)), image5, null);
                postBackground5.setImageDrawable(rippledImage);
            }
            postBackground5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(movies_tab.this, favorite_tab.class));
                        }
                    }, 100); //delay 100 milliseconds to see the effect.
                }
            });

            ImageView postBackground6 = (ImageView) findViewById(R.id.downloads_button);
            Drawable image6; //this could be any image of your choice
            image6 = getDrawable(R.drawable.downloads_dark);
            RippleDrawable rippledImage = null;
            rippledImage = new RippleDrawable(ColorStateList.valueOf(getColor(R.color.light_white)), image6, null);
            postBackground6.setImageDrawable(rippledImage);
            postBackground6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(movies_tab.this, downloaded_tab.class));
                        }
                    }, 100); //delay 100 milliseconds to see the effect.
                }
            });
        }
        else
        {
            ImageView btn = (ImageView)findViewById(R.id.home_button);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(movies_tab.this, MainActivity.class));
                }
            });
            ImageView btn1 = (ImageView)findViewById(R.id.series_button);
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(movies_tab.this, series_tab.class));
                }
            });
            ImageView btn2 = (ImageView)findViewById(R.id.actors_button);
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(movies_tab.this, music_tab.class));
                }
            });
            ImageView btn3 = (ImageView)findViewById(R.id.specials_button);
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(movies_tab.this, specials_tab.class));
                }
            });
            ImageView btn4 = (ImageView)findViewById(R.id.favorites_button);
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(movies_tab.this, favorite_tab.class));
                }
            });
            ImageView btn5 = (ImageView)findViewById(R.id.downloads_button);
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(movies_tab.this, downloaded_tab.class));
                }
            });

        }



        mContext = this;

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching Hottest Movies...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        stringRequest = new StringRequest(Request.Method.GET,
                url_hottest,
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

                                m_name.add(name);
                                m_release_year.add(year);
                                m_genre.add(genre);
                                m_rating.add(rating);
                                m_director.add(director);
                                m_actor.add(actor);
                                m_imgsrc.add(img_src);
                                m_desc.add(desc);

                            }
                            RecyclerView recyclerView = findViewById(R.id.newest);
                            RecyclerViewAdapter adapter = new RecyclerViewAdapter(m_name, m_release_year, m_genre, m_desc, m_director, m_rating, m_actor, m_imgsrc,mContext);
                            recyclerView.setAdapter(adapter);
                            recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
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

        final ProgressDialog progressDialog1 = new ProgressDialog(this);
        progressDialog1.setMessage("Fetching Newest Movies...");
        progressDialog1.setCancelable(false);
        progressDialog1.show();

        stringRequest1 = new StringRequest(Request.Method.GET,
                url_newest,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        progressDialog1.dismiss();
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

                                m_name1.add(name);
                                m_release_year1.add(year);
                                m_genre1.add(genre);
                                m_rating1.add(rating);
                                m_director1.add(director);
                                m_actor1.add(actor);
                                m_imgsrc1.add(img_src);
                                m_desc1.add(desc);
                            }
                            RecyclerView recyclerView = findViewById(R.id.hottest);
                            RecyclerViewAdapter adapter = new RecyclerViewAdapter(m_name1, m_release_year1, m_genre1, m_desc1, m_director1, m_rating1, m_actor1, m_imgsrc1, mContext);
                            recyclerView.setAdapter(adapter);
                            recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        RequestQueue requestQueue1 = Volley.newRequestQueue(this);
        requestQueue1.add(stringRequest1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(this, msms.class)));
        searchView.setIconifiedByDefault(false);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}