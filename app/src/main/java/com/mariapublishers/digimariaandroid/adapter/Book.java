package com.mariapublishers.digimariaandroid.adapter;

import com.mariapublishers.digimariaandroid.model.book.Bookdatum;

public class Book {

    private String id;
    private String title;
    private String shortdesc;
    private String image;
    private Bookdatum bookdatum;

    public Book(String id, String title, String shortdesc, String image, Bookdatum bookdatum) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.image = image;
        this.bookdatum = bookdatum;
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

    public Bookdatum getBookdatum() {
        return bookdatum;
    }
}
