package com.mariapublishers.digimariaandroid.model.arvideo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArData {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("arlist")
    @Expose
    private Arlist arlist;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Arlist getArlist() {
        return arlist;
    }

    public void setArlist(Arlist arlist) {
        this.arlist = arlist;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
