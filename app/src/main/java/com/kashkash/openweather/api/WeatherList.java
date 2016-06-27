package com.kashkash.openweather.api;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
/**
 * Created by tsahkashkash on 25/06/16.
 */
public class WeatherList {
    @SerializedName("list")
    public ArrayList<Weather> weathers;
}
