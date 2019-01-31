package com.example.amitc.pvrathome;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import static android.content.Context.DOWNLOAD_SERVICE;

public class download_movies_popup extends AppCompatDialogFragment {
    Context context;
    String movieurl;
    public download_movies_popup()
    {

    }

    @SuppressLint("ValidFragment")
    public download_movies_popup(String url, Context c)
    {
        movieurl = url;
        context = c;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.download_movies_popup, null);

        builder.setView(view)
               .setTitle("Select quality: ");

        Button four = view.findViewById(R.id.four_eighty_p);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(movieurl);
                DownloadManager downloadManager;
                downloadManager = (DownloadManager)context.getSystemService(DOWNLOAD_SERVICE);
                DownloadManager.Request request = new DownloadManager.Request(uri);

                //Setting title of request
                request.setTitle("Data Download");

                //Setting description of request
                request.setDescription("Android Data download using DownloadManager.");

                request.setDestinationInExternalFilesDir(getContext(),
                        Environment.DIRECTORY_DOWNLOADS,"you.mp4");
                //downloadReference = downloadManager.enqueue(request);
                downloadManager.enqueue(request);
                  getDialog().cancel();
            }
        });

        Button seven = view.findViewById(R.id.seven_twenty_p);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(movieurl);
                DownloadManager downloadManager;
                downloadManager = (DownloadManager)context.getSystemService(DOWNLOAD_SERVICE);
                DownloadManager.Request request = new DownloadManager.Request(uri);

                //Setting title of request
                request.setTitle("Data Download");

                //Setting description of request
                request.setDescription("Android Data download using DownloadManager.");

                request.setDestinationInExternalFilesDir(getContext(),
                        Environment.DIRECTORY_DOWNLOADS,"you.mp4");
                //downloadReference = downloadManager.enqueue(request);
                downloadManager.enqueue(request);
                getDialog().cancel();
            }
        });

        Button ten = view.findViewById(R.id.ten_eighty_p);
        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(movieurl);
                DownloadManager downloadManager;
                downloadManager = (DownloadManager)context.getSystemService(DOWNLOAD_SERVICE);
                DownloadManager.Request request = new DownloadManager.Request(uri);

                //Setting title of request
                request.setTitle("Data Download");

                //Setting description of request
                request.setDescription("Android Data download using DownloadManager.");

                request.setDestinationInExternalFilesDir(getContext(),
                        Environment.DIRECTORY_DOWNLOADS,"you.mp4");
                //downloadReference = downloadManager.enqueue(request);
                downloadManager.enqueue(request);
                getDialog().cancel();
            }
        });

        return builder.create();
    }
}
