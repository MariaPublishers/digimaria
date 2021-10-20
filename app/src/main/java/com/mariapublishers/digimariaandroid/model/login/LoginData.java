package com.mariapublishers.digimariaandroid.model.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginData {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("body_data")
    @Expose
    private BodyData bodyData;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public BodyData getBodyData() {
        return bodyData;
    }

    public void setBodyData(BodyData bodyData) {
        this.bodyData = bodyData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
