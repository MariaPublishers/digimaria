package com.mariapublishers.digimariaandroid.model.landingbook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Landingbookdatum {

    @SerializedName("booktitle")
    @Expose
    private String booktitle;
    @SerializedName("subjectname")
    @Expose
    private String subjectname;
    @SerializedName("languagename")
    @Expose
    private String languagename;
    @SerializedName("bookid")
    @Expose
    private Integer bookid;
    @SerializedName("bookcover")
    @Expose
    private String bookcover;

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getLanguagename() {
        return languagename;
    }

    public void setLanguagename(String languagename) {
        this.languagename = languagename;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookcover() {
        return bookcover;
    }

    public void setBookcover(String bookcover) {
        this.bookcover = bookcover;
    }

}
