package com.yahu.live.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.yahu.live.TCApplication;
import com.yahu.live.bean.MixUserInfo;

public  class ConfigUtils {

    public static void setUrl(String url){
        SharedPreferences sh= TCApplication.getInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sh.edit();
        editor.putString("url",url);
        editor.apply();
    }

    public static String  getUrl(){
        SharedPreferences sh= TCApplication.getInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
        return sh.getString("url","");
    }


    public static void setApiUrl(String url){
        SharedPreferences sh= TCApplication.getInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sh.edit();
        editor.putString("apiUrl",url);
        editor.apply();
    }

    public static String getApiUrl(){
        SharedPreferences sh= TCApplication.getInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
        return sh.getString("apiUrl","");
    }

    public static void setUser(MixUserInfo userInfo ){
        SharedPreferences sh= TCApplication.getInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sh.edit();
        editor.putString("user_info",new Gson().toJson(userInfo));
        editor.apply();
    }


    public static MixUserInfo getUser(){
        SharedPreferences sh= TCApplication.getInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
        String data =sh.getString("user_info","");
        MixUserInfo userInfo= new Gson().fromJson(data, MixUserInfo.class);
        if(userInfo==null){
            userInfo= new MixUserInfo();
        }
        return userInfo;
    }
}
