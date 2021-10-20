package com.mariapublishers.digimariaandroid.http;

import android.os.AsyncTask;

import com.mariapublishers.digimariaandroid.retrofit.APIUrl;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
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
public class GetBookIDTask extends AsyncTask<String,Void,String> {
    private DownloadCallback callback;


    public GetBookIDTask(DownloadCallback downloadCallback) {
        try {
            this.callback=downloadCallback;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Override
    protected String doInBackground(String... strings) {
        try {
            HttpClient httpClient = new DefaultHttpClient();
            try {
                HttpPost request = new HttpPost(APIUrl.BASE_URL_2+"getsubject");
                request.setHeader("x-token-id", strings[2]);
                JSONObject jObj = new JSONObject();
                jObj.put("student_id", strings[0]);
                jObj.put("school_id", strings[1]);
                StringEntity params = new StringEntity(jObj.toString());
                request.addHeader("content-type", "application/json");
                request.addHeader("Accept", "application/json");
                request.setEntity(params);
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
