package com.hepeng.baselibrary.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GsonUtil {


    private static Gson gson = new Gson();

    //对象转成json字符串
    public static <T> String parseBeanToJson(T cls) {
        return gson.toJson(cls, new TypeToken<T>() {
        }.getType());
    }

    //json字符串转对象
    public static <T> T parseJsonToBean(String json, Class<T> cls) {
        T t = null;
        try {
            t = gson.fromJson(json, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    //把集合转成json字符串
    public static <T> String pareseListToJson(List<T> list) {
        return gson.toJson(list, new TypeToken<List<T>>() {
        }.getType());
    }

    //把json字符串变成集合
    public static <T> List<T> parseJsonToList(String json) {
        List<T> list = gson.fromJson(json, new TypeToken<List<T>>() {
        }.getType());
        return list;
    }


    //把json字符串变成map
    public static HashMap<String, Object> parseJsonToMap(String json) {
        Type type = new TypeToken<HashMap<String, Object>>() {
        }.getType();
        HashMap<String, Object> map = null;
        try {
            map = gson.fromJson(json, type);
        } catch (Exception e) {
        }
        return map;
    }

    //把一个map变成json字符串
    public static String parseMapToJson(Map<?, ?> map) {
        try {
            return gson.toJson(map);
        } catch (Exception e) {
        }
        return null;
    }

    //获取json串中某个字段的值，注意，只能获取同一层级的value
    public static String getFieldValue(String json, String key) {
        if (TextUtils.isEmpty(json))
            return null;
        if (!json.contains(key))
            return "";
        JSONObject jsonObject = null;
        String value = null;
        try {
            jsonObject = new JSONObject(json);
            value = jsonObject.getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return value;
    }

    //格式化json
    public static String jsonFormatter(String uglyJSONString) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(uglyJSONString);
        String prettyJsonString = gson.toJson(je);
        return prettyJsonString;
    }
}
