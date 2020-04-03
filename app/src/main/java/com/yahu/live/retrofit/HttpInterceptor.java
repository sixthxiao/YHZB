package com.yahu.live.retrofit;

import android.os.Build;
import androidx.annotation.NonNull;


import com.yahu.live.TCApplication;
import com.yahu.live.TCGlobalConfig;
import com.yahu.live.utils.Utils;
import com.yahu.live.BuildConfig;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 2018年9月25日 17:19:38 从MKM2.0复制而来改造后的请求拦截器
 * 加密请求参数
 */

public class HttpInterceptor implements Interceptor {

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        String host = request.url().host();
        Response response;
        if (TCGlobalConfig.API_URL.contains(host)) {
            response= chain.proceed(getRequest(chain));
        } else {
            response= chain.proceed(request);
        }
        if(response.code()==403){
            Utils.showMsg("网络错误");
        }
        return response;
    }

    private Request getRequest(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        JSONObject json=new JSONObject();
        try {
            json.put("company", "yhjg");
            json.put("support", "jiahang");
            json.put("version", BuildConfig.VERSION_NAME);
            json.put("version-sn", BuildConfig.VERSION_CODE);
            json.put("system", "android");
            json.put("device", Build.BRAND + ";" + Build.DEVICE);
            json.put("source", "api");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return request.newBuilder()
                .header("client-agent", json.toString())
                .header("Authorization", TCApplication.getUserInfo().getToken())
                .build();
    }

}
