package com.kashkash.openweather.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tsahkashkash on 27/06/16.
 */
public class WeatherMain {

    @SerializedName("temp")
    public String currentTemp;

    @SerializedName("humidity")
    public String currentHumidity;

}
