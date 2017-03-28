package com.ethanco.retrofit2_0test;

import retrofit.Call;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

/**
 *byte factory
 *@author:juanqiang
 *created at:2017/3/28 上午8:29
 *
 */

public interface APIService {
    @GET("weather")
    Call<Weather> loadeather(@Query("cityname") String cityname,@Query("key") String apiKey);
    /**
     * retrofit 支持 rxjava 整合
     * 这种方法适用于新接口
     */
    @GET("weather")
    Observable<Weather> getWeatherData(@Query("cityname") String cityname, @Query("key") String apiKey);


    @POST("/")
    Observable<byte[]> byteTest(@Body byte[] aa);
}
