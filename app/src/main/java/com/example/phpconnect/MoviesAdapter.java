package com.example.phpconnect;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private Context context;
    private List<Movie> movies;

    public MoviesAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.movieName.setText(movies.get(position).getMovieName());
        holder.movieGenre.setText(movies.get(position).getMovieGenre());
        Glide.with(context).load(movies.get(position).getImageLink()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView movieName;
        public TextView movieGenre;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            movieName = itemView.findViewById(R.id.moviename);
            imageView = itemView.findViewById(R.id.image);
            movieGenre = itemView.findViewById(R.id.genre);
        }
    }


}
