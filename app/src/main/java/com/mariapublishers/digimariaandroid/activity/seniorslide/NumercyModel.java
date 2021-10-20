package com.mariapublishers.digimariaandroid.activity.seniorslide;

public class NumercyModel {
    String firsttext,texttext,audiofile;
    int id;

    public NumercyModel(String firsttext, String texttext, String audiofile, int id) {
        this.firsttext = firsttext;
        this.texttext = texttext;
        this.audiofile = audiofile;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirsttext() {
        return firsttext;
    }

    public void setFirsttext(String firsttext) {
        this.firsttext = firsttext;
    }

    public String getTexttext() {
        return texttext;
    }

    public void setTexttext(String texttext) {
        this.texttext = texttext;
    }

    public String getAudiofile() {
        return audiofile;
    }

    public void setAudiofile(String audiofile) {
        this.audiofile = audiofile;
    }
}
