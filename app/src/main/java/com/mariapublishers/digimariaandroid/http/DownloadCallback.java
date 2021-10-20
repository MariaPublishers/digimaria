package com.mariapublishers.digimariaandroid.http;

public interface DownloadCallback
    {
        void onDownloadInterrupted(String cause);
        void onDownloadCompleted(String json);
    }