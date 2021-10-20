package com.mariapublishers.digimariaandroid.model.video;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoData {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("videolist")
    @Expose
    private List<Videolist> videolist = null;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public List<Videolist> getVideolist() {
        return videolist;
    }

    public void setVideolist(List<Videolist> videolist) {
        this.videolist = videolist;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
