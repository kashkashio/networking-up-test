package com.kashkash.openweather.event;

/**
 * Created by tsahkashkash on 25/06/16.
 */
public class GetWeatherEvent {

    public final String ids;
    public final String units;
    public final String appid;

    public GetWeatherEvent(String ids, String units, String appid) {
        this.ids = ids;
        this.units = units;
        this.appid = appid;
    }

}
