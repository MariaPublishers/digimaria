package com.mariapublishers.digimariaandroid.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIUrl {

    private static Retrofit retrofit = null;
    // Base URL
//    public static final String BASE_URL = "http://10.0.2.2:8000/api/v1/";
//    public static final String BASE_URL = "http://103.228.83.70/mariaerp/public/api/v1/";
    public static final String BASE_URL = "https://digimaria.com/ERP/public/api/v1/";
    public static final String BASE_URL_2 = "https://digimaria.com/ERP/public/api/v2/";
    public static final String PUBLICATION_URL = "https://digimaria.com/ERP/";//"https://digimaria.com/ERP/public/"; //"http://3.228.186.6/";

    public static APIService getService() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(APIService.class);
    }

}
