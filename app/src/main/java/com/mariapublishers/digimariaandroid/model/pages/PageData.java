package com.mariapublishers.digimariaandroid.model.pages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PageData {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("imagepath")
    @Expose
    private List<Imagepath> imagepath = null;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public List<Imagepath> getImagepath() {
        return imagepath;
    }

    public void setImagepath(List<Imagepath> imagepath) {
        this.imagepath = imagepath;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
