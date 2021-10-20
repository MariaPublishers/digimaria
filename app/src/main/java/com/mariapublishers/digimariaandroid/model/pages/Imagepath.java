package com.mariapublishers.digimariaandroid.model.pages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Imagepath {

    @SerializedName("bookimgpath")
    @Expose
    private String bookimgpath;

    public String getBookimgpath() {
        return bookimgpath;
    }

    public void setBookimgpath(String bookimgpath) {
        this.bookimgpath = bookimgpath;
    }

}
