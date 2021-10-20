package com.mariapublishers.digimariaandroid.model.video;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Videolist {

    @SerializedName("booksid")
    @Expose
    private String booksid;
    @SerializedName("bookvideoid")
    @Expose
    private Integer bookvideoid;
    @SerializedName("bookvideoname")
    @Expose
    private String bookvideoname;
    @SerializedName("bookvideopath")
    @Expose
    private String bookvideopath;
    @SerializedName("imagecover")
    @Expose
    private String imagecover;
    @SerializedName("videotype")
    @Expose
    private Integer videotype;

    public String getBooksid() {
        return booksid;
    }

    public void setBooksid(String booksid) {
        this.booksid = booksid;
    }

    public Integer getBookvideoid() {
        return bookvideoid;
    }

    public void setBookvideoid(Integer bookvideoid) {
        this.bookvideoid = bookvideoid;
    }

    public String getBookvideoname() {
        return bookvideoname;
    }

    public void setBookvideoname(String bookvideoname) {
        this.bookvideoname = bookvideoname;
    }

    public String getBookvideopath() {
        return bookvideopath;
    }

    public void setBookvideopath(String bookvideopath) {
        this.bookvideopath = bookvideopath;
    }

    public String getImagecover() {
        return imagecover;
    }

    public void setImagecover(String imagecover) {
        this.imagecover = imagecover;
    }

    public Integer getVideotype() {
        return videotype;
    }

    public void setVideotype(Integer videotype) {
        this.videotype = videotype;
    }

}
