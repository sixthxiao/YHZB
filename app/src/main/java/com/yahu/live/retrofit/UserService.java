package com.yahu.live.retrofit;


import com.yahu.live.bean.MixUserInfo;
import com.yahu.live.bean.VerifyInfo;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserService {
    @POST("api/v1/Passport/Login")
    Observable<HttpResponse<MixUserInfo>> login(@Body VerifyInfo body);

    @POST("api/v1/Passport/Register")
    Observable<HttpResponse<MixUserInfo>> register(@Body VerifyInfo body);

    @GET("api/v2/Security/Info")
    Observable<HttpResponse<MixUserInfo>> userInfo();

    @POST("api/v2/Security/Info")
    Observable<HttpResponse<Void>> userInfo(String nickName);

    @GET("api/v1/Version/Download")
    Observable<HttpResponse<MixUserInfo>> download(@Query("id") Integer page);

    @GET("")
    Observable<HttpResponse<String>> downloadSet();

}
