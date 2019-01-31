package com.example.amitc.pvrathome;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.*;
import android.view.*;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class request_tab extends AppCompatActivity {
    private Button b;
    private EditText subjec, compose;
    private Spinner category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_tab);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        category = findViewById(R.id.request);
        subjec = findViewById(R.id.subject);
        compose = findViewById(R.id.compose);

        b = findViewById(R.id.send);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = category.getSelectedItem().toString();
                subject += " -> ";
                subject += subjec.getText().toString();

                String desc = compose.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"pvrhomeapp@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, desc);
                intent.setType("message/rfc822");

                startActivity(Intent.createChooser(intent, "Select Email App"));
            }
        });
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
