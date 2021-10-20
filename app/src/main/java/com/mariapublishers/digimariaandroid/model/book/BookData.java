package com.mariapublishers.digimariaandroid.model.book;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookData {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("bookdata")
    @Expose
    private List<Bookdatum> bookdata = null;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public List<Bookdatum> getBookdata() {
        return bookdata;
    }

    public void setBookdata(List<Bookdatum> bookdata) {
        this.bookdata = bookdata;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
