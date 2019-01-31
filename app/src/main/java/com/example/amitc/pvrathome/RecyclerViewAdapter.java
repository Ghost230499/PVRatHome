package com.example.amitc.pvrathome;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> m_name;
    private ArrayList<String> m_year;
    private ArrayList<String> m_genre;
    private ArrayList<String> m_images;
    private ArrayList<String> m_desc;
    private ArrayList<String> m_director;
    private ArrayList<String> m_rating;
    private ArrayList<String> m_stars;

    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> m_name, ArrayList<String> m_year, ArrayList<String> m_genre, ArrayList<String> m_desc, ArrayList<String> m_director, ArrayList<String> m_rating, ArrayList<String> m_stars, ArrayList<String> images, Context mContext) {
        this.m_name = m_name;
        this.m_year = m_year;
        this.m_genre = m_genre;
        this.m_desc = m_desc;
        this.m_director = m_director;
        this.m_rating = m_rating;
        this.m_stars = m_stars;
        this.mContext = mContext;
        this.m_images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(mContext, msms.class);
                intent.putExtra("names", m_name.get(i));
                intent.putExtra("genres", m_genre.get(i));
                intent.putExtra("years", m_year.get(i));
                intent.putExtra("stars", m_stars.get(i));
                intent.putExtra("decs", m_desc.get(i));
                intent.putExtra("direcs", m_director.get(i));
                intent.putExtra("ratings", m_rating.get(i));
                intent.putExtra("img1", m_images.get(i));

                mContext.startActivity(intent);
            }
        });

        viewHolder.names.setText(m_name.get(i));
        viewHolder.years.setText(m_year.get(i));
        viewHolder.genres.setText(m_genre.get(i));

        final ProgressDialog progressDialog1 = new ProgressDialog(mContext);
        progressDialog1.setMessage("Fetching Data...");
        progressDialog1.setCancelable(false);
        progressDialog1.show();

        Glide.with(mContext)
                .load(m_images.get(i))
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
                .into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    viewHolder.parentLayout.setBackground(resource);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return m_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout parentLayout;
        TextView names;
        TextView years;
        TextView genres;
        ImageView img1;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.dabba);
            names = itemView.findViewById(R.id.m_name);
            years = itemView.findViewById(R.id.m_year);
            genres = itemView.findViewById(R.id.m_genre);
            img1 = itemView.findViewById(R.id.msms_image);
        }
    }
}
