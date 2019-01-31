package com.example.amitc.pvrathome;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.*;
import android.view.*;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

public class music_tab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_tab);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M)
        {
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
                        startActivity(new Intent(music_tab.this, MainActivity.class));
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
                        startActivity(new Intent(music_tab.this, movies_tab.class));
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
                        startActivity(new Intent(music_tab.this, series_tab.class));
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
                        startActivity(new Intent(music_tab.this, specials_tab.class));
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
                        startActivity(new Intent(music_tab.this, favorite_tab.class));
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
                        startActivity(new Intent(music_tab.this, downloaded_tab.class));
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
                    startActivity(new Intent(music_tab.this, MainActivity.class));
                }
            });
            ImageView btn1 = (ImageView)findViewById(R.id.series_button);
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(music_tab.this, series_tab.class));
                }
            });
            ImageView btn2 = (ImageView)findViewById(R.id.movie_button);
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(music_tab.this, movies_tab.class));
                }
            });
            ImageView btn3 = (ImageView)findViewById(R.id.specials_button);
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(music_tab.this, specials_tab.class));
                }
            });
            ImageView btn4 = (ImageView)findViewById(R.id.favorites_button);
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(music_tab.this, favorite_tab.class));
                }
            });
            ImageView btn5 = (ImageView)findViewById(R.id.downloads_button);
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(music_tab.this, downloaded_tab.class));
                }
            });

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
