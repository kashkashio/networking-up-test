package com.kashkash.openweather.api;

import android.util.Log;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.kashkash.openweather.event.*;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by tsahkashkash on 25/06/16.
 */

public class OpenWeatherApiServiceProvider {

    private static final String TAG = OpenWeatherApiServiceProvider.class.getName();

    private OpenWeatherApiService mApi;
    private Bus mBus;

    public OpenWeatherApiServiceProvider(OpenWeatherApiService api, Bus bus) {
        this.mApi = api;
        this.mBus = bus;
    }

    @Subscribe
    public void onLoadWeathers(final GetWeatherEvent event) {
        mApi.getWeatherList(event.ids,event.units,event.appid, new Callback<WeatherList>() {
            @Override
            public void success(WeatherList response, Response rawResponse) {
                mBus.post(new GetWeatherEventOk(response));
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, error.toString(), error);
                mBus.post(new GetWeatherEventFailed());
            }
        });
    }

}
