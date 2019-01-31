package com.example.amitc.pvrathome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.home);

        Button btn = (Button) findViewById(R.id.movies);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, movies_tab.class));
            }
        });

        Button btn1 = (Button) findViewById(R.id.tvseries);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, series_tab.class));
            }
        });

        Button btn2 = (Button) findViewById(R.id.specials);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, specials_tab.class));
            }
        });

        Button btn3 = (Button) findViewById(R.id.music);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, music_tab.class));
            }
        });

        Button btn4 = (Button) findViewById(R.id.favorite);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, favorite_tab.class));
            }
        });

        Button btn5 = (Button) findViewById(R.id.downloaded);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, downloaded_tab.class));
            }
        });

        Button btn8 = (Button) findViewById(R.id.settings);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, settings_tab.class));
            }
        });

        Button btn9 = (Button) findViewById(R.id.request);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, request_tab.class));
            }
        });
    }
}
