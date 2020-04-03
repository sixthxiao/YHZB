package com.hepeng.baselibrary.retrofit;

import android.util.Log;

import com.hepeng.baselibrary.base.BaseApplication;
import com.hepeng.baselibrary.utils.NetUtils;
import com.hepeng.baselibrary.utils.SPUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 请求头设置
 */
public class RetrofitFactory {

    public static final String CACHE_NAME = "apkNameHttpCache";
    public static String BASE_URL = HttpApi.baseUrl;
    private static final int DEFAULT_CONNECT_TIMEOUT = 20;
    private static final int DEFAULT_WRITE_TIMEOUT = 20;
    private static final int DEFAULT_READ_TIMEOUT = 20;
    private Retrofit retrofit;
    private HttpApi httpApi;
    private OkHttpClient.Builder okHttpBuilder;

    public RetrofitFactory() {
        okHttpBuilder = new OkHttpClient.Builder();

        //设置缓存
        File cachefile = new File(BaseApplication.appContext.getExternalCacheDir(), CACHE_NAME);
        Cache cache = new Cache(cachefile, 1024 * 1024 * 5);
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!NetUtils.isNetworkConnected()) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (NetUtils.isNetworkConnected()) {
                    int maxAge = 0;
                    //有网络时，设置缓存超时时间0个小时
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader(CACHE_NAME)//清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .build();
                } else {
                    //无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader(CACHE_NAME)
                            .build();
                }
                return response;
            }
        };
//        okHttpBuilder.cache(cache).addInterceptor(cacheInterceptor);

        //设置头信息
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder requestBuilder = originalRequest.newBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("Content-Type", "application/json; charset=utf-8")
//                        .header("client-agent", json.toString())
//                        .header("Authorization", TCApplication.getUserInfo().getToken())
////
//                        .addHeader("AUTHTOKEN", SPUtils.getInstance(BaseApplication.appContext).getToken())
//                        .addHeader("LOGINTYPE", "3")
//                        .addHeader("SOURCE", "gyzx-web-app")
                        .method(originalRequest.method(), originalRequest.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
        okHttpBuilder.addInterceptor(headerInterceptor);

        //设置 Debug Log 模式
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("httpInfo=====", message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpBuilder.addInterceptor(loggingInterceptor);

        //设置超时和重新连接
        okHttpBuilder.connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS);
        okHttpBuilder.readTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS);
        //错误重连
        okHttpBuilder.retryOnConnectionFailure(true);

        retrofit = new Retrofit.Builder()
                .client(okHttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())//json转换成JavaBean
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://api.yhjg.qianhaijifen.com/")
                .build();
        httpApi = retrofit.create(HttpApi.class);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final RetrofitFactory INSTANCE = new RetrofitFactory();

    }

    //获取单例
    public static RetrofitFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 获取retrofit
     *
     * @return
     */
    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void changeBaseUrl(String baseUrl) {
        retrofit = new Retrofit.Builder()
                .client(okHttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
        httpApi = retrofit.create(HttpApi.class);
    }

    /**
     * 获取httpService
     *
     * @return
     */
    public HttpApi getHttpApi() {
        return httpApi;
    }
}
