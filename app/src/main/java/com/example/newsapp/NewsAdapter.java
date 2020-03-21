package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    List<News> newsList;
    RecyclerView mRecyclerView;
    Context mContext;

    public static class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        TextView sectionTextView;
        TextView authorTextView;
        TextView dateTextView;

        public NewsViewHolder(View itemView){
            super(itemView);
            titleTextView =itemView.findViewById(R.id.title_text_view);
            sectionTextView =itemView.findViewById(R.id.section_text_view);
            authorTextView =itemView.findViewById(R.id.author_text_view);
            dateTextView =itemView.findViewById(R.id.date_text_view);
        }
    }

    public NewsAdapter(List<News>newsList, RecyclerView rcv, Context context){
        this.newsList = newsList;
        mRecyclerView = rcv;
        mContext = context;
    }

    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int itemPosition = mRecyclerView.getChildLayoutPosition(v);
            News item = newsList.get(itemPosition);

            // Convert the String URL into a URI object (to pass into the Intent constructor)
            Uri storyUri = Uri.parse(item.getUrl());

            // Create a new intent to view the earthquake URI
            Intent websiteIntent = new Intent(Intent.ACTION_VIEW, storyUri);

            // Send the intent to launch a new activity
            mContext.startActivity(websiteIntent);
        }
    };

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        v.setOnClickListener(mOnClickListener);
        return new NewsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News currentStory = newsList.get(position);

        holder.titleTextView.setText(currentStory.getmStoryTitle());
        holder.sectionTextView.setText(currentStory.getmSection());
        holder.authorTextView.setText(currentStory.getmAuthor());
        holder.dateTextView.setText(currentStory.getmDate());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public void clear(){
        this.newsList.clear();
    }
}
