package com.example.amitc.pvrathome;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class stream_movies_popup extends AppCompatDialogFragment {

    String movieurl;

    public stream_movies_popup()
    {

    }

    @SuppressLint("ValidFragment")
    public stream_movies_popup(String link)
    {
        movieurl = link;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.download_movies_popup, null);

        builder.setView(view)
                .setTitle("Select quality: ");

        Button four = view.findViewById(R.id.four_eighty_p);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse(movieurl), "video/mp4");
                startActivity(intent);
                getDialog().cancel();
            }
        });

        Button seven = view.findViewById(R.id.seven_twenty_p);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse(movieurl), "video/mp4");
                startActivity(intent);
                getDialog().cancel();
            }
        });

        Button ten = view.findViewById(R.id.ten_eighty_p);
        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse(movieurl), "video/mp4");
                startActivity(intent);
                getDialog().cancel();
            }
        });

        return builder.create();
    }
}
