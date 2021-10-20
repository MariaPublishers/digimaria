package com.mariapublishers.digimariaandroid.model.usedbooks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsedBookData {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
