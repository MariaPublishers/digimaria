package com.mariapublishers.digimariaandroid.adapter;

public class Video {

    private String id;
    private String title;
    private String link;
    private String image;

    public Video(String id, String title, String link, String image) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getImage() {
        return image;
    }

}
