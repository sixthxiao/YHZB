package com.yahu.live.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.widget.Toast;


import com.google.gson.Gson;
import com.yahu.live.TCApplication;
import com.yahu.live.TCGlobalConfig;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/**
 * author: zhu.px
 * time  : 2018/1/5
 * desc  :
 */
public class Utils {
    @SuppressLint("StaticFieldLeak")
    private static Application sApplication;

    static WeakReference<Activity> sTopActivityWeakRef;
    static List<Activity> sActivityList = new LinkedList<>();

    public static Context getContext() {
        return TCApplication.getInstance();
    }

    private static Application.ActivityLifecycleCallbacks mCallbacks = new Application.ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {
            sActivityList.add(activity);
            setTopActivityWeakRef(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {
            setTopActivityWeakRef(activity);
        }

        @Override
        public void onActivityResumed(Activity activity) {
            setTopActivityWeakRef(activity);
        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            sActivityList.remove(activity);
        }
    };

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param app 应用
     */
    public static void init(@NonNull final Application app) {
        Utils.sApplication = app;
        app.registerActivityLifecycleCallbacks(mCallbacks);
    }

    /**
     * 获取 Application
     *
     * @return Application
     */
    public static Application getApp() {
        if (sApplication != null) return sApplication;
        throw new NullPointerException("u should init first");
    }

    private static void setTopActivityWeakRef(Activity activity) {
        if (sTopActivityWeakRef == null || !activity.equals(sTopActivityWeakRef.get())) {
            sTopActivityWeakRef = new WeakReference<>(activity);
        }
    }

    /**
     * 2个对象的转换
     * @param modelA
     * @param bClass
     * @param <A>
     * @param <B>
     * @return
     */
    public static <A, B> B modelA2B(A modelA, Class<B> bClass) {
        try {
            Gson gson = new Gson();
            String gsonA = gson.toJson(modelA);
//            String jsonString = JSONObject.toJSONString(modelA);
            B instanceB = gson.fromJson(gsonA, bClass);

            return instanceB;
        } catch (Exception e) {
            return null;
        }
    }

    public static void showMsg(String msg) {
        if (msg != null && !msg.equals("")) {
            Toast toast = Toast.makeText(sApplication, msg, Toast.LENGTH_LONG);
            toast.setText(msg);
            toast.show();
        }
    }


    public static String[] getStringArray(int res) {
        return getContext().getResources().getStringArray(res);
    }

    public static int getDrawableResourceIdByName(String name) {
        int id = getContext().getResources().getIdentifier(name, "drawable", getContext().getPackageName());
        return id;
    }

}
