package com.mariapublishers.digimariaandroid.model.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchData {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("searchresult")
    @Expose
    private List<Searchresult> searchresult = null;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public List<Searchresult> getSearchresult() {
        return searchresult;
    }

    public void setSearchresult(List<Searchresult> searchresult) {
        this.searchresult = searchresult;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
