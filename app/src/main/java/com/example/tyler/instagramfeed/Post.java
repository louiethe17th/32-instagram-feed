package com.example.tyler.instagramfeed;

public class Post {
    public String author;
    public String imageUrl;
    public String description;

    public Post(String author, String description, String url){
        this.author = author;
        this.description = description;
        this.imageUrl = url;
    }


}
