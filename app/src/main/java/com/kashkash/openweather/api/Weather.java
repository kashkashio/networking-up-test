package com.kashkash.openweather.api;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by tsahkashkash on 25/06/16.
 */
public class Weather {
    @SerializedName("weather")
    public ArrayList<WeatherData> weatherApiObject;

    @SerializedName("name")
    public String currentCityName;

    @SerializedName("main")
    public WeatherMain weatherMainObject;

    @SerializedName("wind")
    public WeatherWind weatherWind;
}
