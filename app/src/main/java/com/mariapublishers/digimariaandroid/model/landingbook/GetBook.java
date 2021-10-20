package com.mariapublishers.digimariaandroid.model.landingbook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetBook {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("landingbookdata")
    @Expose
    private List<Landingbookdatum> landingbookdata = null;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public List<Landingbookdatum> getLandingbookdata() {
        return landingbookdata;
    }

    public void setLandingbookdata(List<Landingbookdatum> landingbookdata) {
        this.landingbookdata = landingbookdata;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
