package com.kashkash.openweather.api;
import retrofit.Callback;
import retrofit.http.*;
/**
 * Created by tsahkashkash on 25/06/16.
 */
public interface OpenWeatherApiService {

    @GET(ApiConstants.WEATHER_PER_COUNTRY_URL)
    void getWeatherList(
            @Query("id") String ids,
            @Query("units") String units,
            @Query("APPID") String appid,
            Callback<WeatherList> callback
    );


}
