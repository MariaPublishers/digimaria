package com.mariapublishers.digimariaandroid.adapter;

public class BookSearch {

    private String id;
    private String title;
    private String shortdesc;
    private String image;

    public BookSearch(String id, String title, String shortdesc, String image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public String getImage() {
        return image;
    }

}
