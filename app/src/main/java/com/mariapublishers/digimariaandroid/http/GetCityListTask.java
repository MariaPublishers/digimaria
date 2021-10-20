package com.mariapublishers.digimariaandroid.http;

import android.os.AsyncTask;
import android.util.Log;

import com.mariapublishers.digimariaandroid.retrofit.APIUrl;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * Created by VTECH on 23/04/18.
 */
public class GetCityListTask extends AsyncTask<Void,Void,String> {
    private DownloadCallback callback;


    public GetCityListTask(DownloadCallback downloadCallback) {
        try {
            this.callback=downloadCallback;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Override
    protected String doInBackground(Void... strings) {
        try {
            HttpClient httpClient = new DefaultHttpClient();
            try {
                HttpGet request = new HttpGet(APIUrl.BASE_URL_2 +"getcity");
                request.addHeader("Accept", "application/json");
                httpClient.getConnectionManager().getSchemeRegistry().register( new Scheme("https", SSLSocketFactory.getSocketFactory(), 443) );
                HttpResponse response = httpClient.execute(request);
                return EntityUtils.toString(response.getEntity(), "UTF-8");
            } catch (Throwable ex) {
                ex.printStackTrace();
                callback.onDownloadInterrupted("Connection Failed");
                return null;

            } finally {
                httpClient.getConnectionManager().shutdown();

            }
        } catch (Throwable e) {
            e.printStackTrace();
            callback.onDownloadInterrupted("Connection Failed");
            return null;

        }
    }

    @Override
    protected void onPostExecute(String json) {
        try {
            super.onPostExecute(json);
            callback.onDownloadCompleted(json);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
