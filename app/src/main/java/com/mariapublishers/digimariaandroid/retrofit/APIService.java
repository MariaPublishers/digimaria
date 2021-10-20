package com.mariapublishers.digimariaandroid.retrofit;

import com.mariapublishers.digimariaandroid.model.arvideo.ArData;
import com.mariapublishers.digimariaandroid.model.book.BookData;
import com.mariapublishers.digimariaandroid.model.landingbook.GetBook;
import com.mariapublishers.digimariaandroid.model.licence.LicenceData;
import com.mariapublishers.digimariaandroid.model.login.LoginData;
import com.mariapublishers.digimariaandroid.model.pages.PageData;
import com.mariapublishers.digimariaandroid.model.search.SearchData;
import com.mariapublishers.digimariaandroid.model.usedbooks.UsedBookData;
import com.mariapublishers.digimariaandroid.model.video.VideoData;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIService {

    @FormUrlEncoded
    @POST("licencekey")
    Call<LicenceData> licenceKey(@FieldMap HashMap<String, String> fields);

    @FormUrlEncoded
    @POST("login")
    Call<LoginData> userLogin(@FieldMap HashMap<String, String> fields);

//    @FormUrlEncoded
    @GET("getbook")
    Call<BookData> getbookData();

    @FormUrlEncoded
    @POST("search")
    Call<SearchData> searchData(@FieldMap HashMap<String, String> fields);

    @FormUrlEncoded
    @POST("listvideo")
    Call<VideoData> getVideo(@Header("Authorization") String value, @FieldMap HashMap<String, String> fields);

    @FormUrlEncoded
    @POST("arvideo")
    Call<ArData> getAR(@Header("Authorization") String value, @FieldMap HashMap<String, String> fields);

    @FormUrlEncoded
    @POST("bookdata")
    Call<GetBook> bookData(@Header("Authorization") String value, @FieldMap HashMap<String, String> fields);

    @FormUrlEncoded
    @POST("callpage")
    Call<PageData> pageData(@Header("Authorization") String value, @FieldMap HashMap<String, String> fields);

    @FormUrlEncoded
    @POST("usedbooks")
    Call<UsedBookData> usedbookData(@FieldMap HashMap<String, String> fields);

}
