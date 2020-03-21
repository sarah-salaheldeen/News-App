package com.example.newsapp;

public class News {
    String mStoryTitle;
    String mSection;
    String mAuthor;
    String mDate;
    private String mUrl;

    public News(String title, String section, String author, String date, String url){
        this.mStoryTitle = title;
        this.mSection = section;
        this.mAuthor = author;
        this.mDate = date;
        mUrl = url;
    }

    public String getmStoryTitle() {
        return mStoryTitle;
    }

    public String getmSection() {
        return mSection;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public String getmDate() {
        return mDate;
    }

    public String getUrl() { return mUrl; }
}
