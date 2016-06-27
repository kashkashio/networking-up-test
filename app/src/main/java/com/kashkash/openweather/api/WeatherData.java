package com.kashkash.openweather.api;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.Streams;

import java.util.ArrayList;

/**
 * Created by tsahkashkash on 26/06/16.
 */
public class WeatherData {

    @SerializedName("main")
    public String weatherMainStatus;

    @SerializedName("description")
    public String weatherDescription;

    @SerializedName("icon")
    public String weatherIcon;


}
