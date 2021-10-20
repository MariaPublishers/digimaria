package com.mariapublishers.digimariaandroid.prefference;

import android.content.Context;
import android.content.SharedPreferences;

public class Pref {

    // shared preferences keys
    private static final int ModePrivate = 0;

    private static final String TOKEN = "TOKEN";
    private static final String USER_ID = "USER_ID";
    private static final String BOOK_ID = "BOOK_ID";
    private static final String USER_NAME = "USER_NAME";
    private static final String USER_EMAIL = "USER_EMAIL";
    private static final String USER_MOBILE = "USER_MOBILE";
    private static final String USER_ROLE = "USER_ROLE";
    private static final String LOGIN_STATUS = "LOGIN_STATUS";
    private static final String FCM_TOKEN = "FCM_TOKEN";
    private static final String BOOKONE = "BOOKONE";
    private static final String BOOKTWO = "BOOKTWO";
    private static final String BOOKTHREE = "BOOKTHREE";
    private static final String CLASSONE = "CLASSONE";
    private static final String CLASSTWO = "CLASSTWO";
    private static final String CLASSTHREE = "CLASSTHREE";
    private static final String CLASSID = "CLASSID";
    private static final String VOLUMEVAL = "VOLUMEVAL";
    private static final String MUSICVAL = "MUSICVAL";
    private static final String TO_LAT = "TO_LAT";
    private static final String TO_LNG = "TO_LNG";
    private static final String TO_ADDS = "TO_ADDS";
    String fcm_token;

    private static final String PREFERENCES_NAME = "SharedPrefManager";

    private SharedPreferences sharedPreferences;

    /**
     * constructor
     *
     * @param context
     */
    public Pref(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, ModePrivate);
    }

    /**
     * method to set string prefs
     *
     * @param mobile
     * @param token
     * @param name
     * @param email
     * @param fcmtoken
     */
    public void setLogin(String token, String name, String email, String mobile, String fcmtoken) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOKEN, token);
        editor.putString(USER_NAME, name);
        editor.putString(USER_EMAIL, email);
        editor.putString(USER_MOBILE, mobile);
        editor.putString(FCM_TOKEN, fcmtoken);
        editor.putInt(LOGIN_STATUS, 1);
        editor.apply();
    }

    /**
     * method to set string prefs
     *
     * @param classthree
     * @param classtwo
     * @param classone
     */
    public void setClassID(String classone, String classtwo, String classthree) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(CLASSONE, classone);
        editor.putString(CLASSTWO, classtwo);
        editor.putString(CLASSTHREE, classthree);
        editor.apply();
    }

    /**
     * method to set string prefs
     *
     * @param classid
     */
    public void setClassid(String classid) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(CLASSID, classid);
        editor.apply();
    }

    /**
     * method to set string prefs
     *
     * @param volume
     */
    public void setVolumeval(String volume) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(VOLUMEVAL, volume);
        editor.apply();
    }

    /**
     * method to set string prefs
     *
     * @param volume
     */
    public void setMusicval(String volume) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(MUSICVAL, volume);
        editor.apply();
    }

    public String getMusicval() {
        return sharedPreferences.getString(MUSICVAL, null);
    }

    public String getClassid() {
        return sharedPreferences.getString(CLASSID, null);
    }

    public String getVolumeval() {
        return sharedPreferences.getString(VOLUMEVAL, "1");//null
    }

    public void setSplashScreen(String val) {
        sharedPreferences.edit().putString("SPLASH_SCREEN_LOADING", val).apply();
    }
    public String getSplashScreen() {
        return sharedPreferences.getString("SPLASH_SCREEN_LOADING", "0");
    }
    public String getClassone() {
        return sharedPreferences.getString(CLASSONE, null);
    }

    public String getClasstwo() {
        return sharedPreferences.getString(CLASSTWO, null);
    }

    public String getClassthree() {
        return sharedPreferences.getString(CLASSTHREE, null);
    }


    /**
     * method to set string prefs
     *
     * @param bookthree
     * @param booktwo
     * @param bookone
     */
    public void setBooksID(String bookone, String booktwo, String bookthree) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(BOOKONE, bookone);
        editor.putString(BOOKTWO, booktwo);
        editor.putString(BOOKTHREE, bookthree);
        editor.apply();
    }

    public String getBookone() {
        return sharedPreferences.getString(BOOKONE, null);
    }

    public String getBooktwo() {
        return sharedPreferences.getString(BOOKTWO, null);
    }

    public String getBookthree() {
        return sharedPreferences.getString(BOOKTHREE, null);
    }

    public void setBookId(String bookId) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(BOOK_ID, bookId);
        editor.apply();
    }

    public String getBookId() {
        return sharedPreferences.getString(BOOK_ID, null);
    }

    public String getToken() {
        return sharedPreferences.getString(TOKEN, null);
    }

    public String getFcmToken() {
        return sharedPreferences.getString(FCM_TOKEN, null);
    }

    public int getLoginStatus() {
        return sharedPreferences.getInt(LOGIN_STATUS, 0);
    }

    public String getUserRole() {
        return sharedPreferences.getString(USER_ROLE, null);
    }

    /**
     * method to clear all prefs
     */
    public void clearPrefs() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}

