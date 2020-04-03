package com.yahu.live.retrofit;


import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SmsService {
    @POST("api/v1/Generic/SMS")
    Observable<HttpResponse<Void>> send(@Query("id") String phone, @Query("tp") int tp);
}
