package com.wall_dough.poto.models.items;

/**
 * Created by andrew on 5/30/16.
 */
public class Review {

    private String username;
    private int rating;
    private String title;
    private String content;

    private String getUsername() { return this.username; }
    private void setUsername(String username) { this.username = username; }

    public int getRating() { return this.rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getTitle() { return this.title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return this.content; }
    public void setContent(String content) { this.content = content; }
}
