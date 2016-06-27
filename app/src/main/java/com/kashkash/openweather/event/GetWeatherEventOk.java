package com.kashkash.openweather.event;
import com.kashkash.openweather.api.WeatherList;

/**
 * Created by tsahkashkash on 25/06/16.
 */
public class GetWeatherEventOk {

    public final WeatherList weatherList;

    public GetWeatherEventOk(WeatherList weathers) {
        this.weatherList = weathers;
    }

}
