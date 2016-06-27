package com.kashkash.openweather;

import android.app.Application;
import android.content.Context;

import com.kashkash.openweather.api.OpenWeatherApiService;
import com.kashkash.openweather.api.OpenWeatherApiServiceProvider;
import com.squareup.otto.Bus;
import com.kashkash.openweather.api.ApiConstants;
import com.kashkash.openweather.util.BusProvider;
import retrofit.RestAdapter;

/**
 * Created by tsahkashkash on 25/06/16.
 */

public class OpenWeatherApplication extends Application{
    private static OpenWeatherApplication mInstance;
    private static Context mAppContext;

    private OpenWeatherApiServiceProvider mOpenWeatherService;
    private Bus bus = BusProvider.getInstance();

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        this.setAppContext(getApplicationContext());
        mOpenWeatherService = new OpenWeatherApiServiceProvider(buildApi(), bus);
        bus.register(mOpenWeatherService);
        bus.register(this); //listen to "global" events
    }

    private OpenWeatherApiService buildApi() {
        return new RestAdapter.Builder()
                .setEndpoint(ApiConstants.OPEN_WEATHER_URL)
                .build()
                .create(OpenWeatherApiService.class);
    }

    public static OpenWeatherApplication getInstance(){
        return mInstance;
    }
    public static Context getAppContext() {
        return mAppContext;
    }
    public void setAppContext(Context mAppContext) {
        this.mAppContext = mAppContext;
    }


}