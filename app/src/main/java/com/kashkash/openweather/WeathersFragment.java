package com.kashkash.openweather;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kashkash.openweather.api.ApiConstants;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.kashkash.openweather.api.WeatherList;
import com.kashkash.openweather.event.*;
import com.kashkash.openweather.util.BusProvider;
import com.kashkash.openweather.util.WeatherAdapter;

import static com.kashkash.openweather.util.Util.makeToast;

/**
 * Created by tsahkashkash on 25/06/16.
 */

public class WeathersFragment extends ListFragment {

    private Bus mBus;

    private WeatherAdapter brandAdapter;

    public WeathersFragment mFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_weathers, container, false);
        brandAdapter = new WeatherAdapter(getActivity(), new WeatherList());
        this.mFragment = this;
        setListAdapter(brandAdapter);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        getBus().register(this);
        getBus().post(new GetWeatherEvent(ApiConstants.FINAL_COUNTRIES_QUERY,ApiConstants.PREFFERED_METRICS, ApiConstants.API_KEY));
    }

    @Override
    public void onStop() {
        super.onStop();
        getBus().unregister(this);
    }

    @Subscribe
    public void onGetWeatherEventOk (final GetWeatherEventOk event) {
        brandAdapter.setWeatherList(event.weatherList);
        brandAdapter.notifyDataSetChanged();
    }

    @Subscribe
    public void onGetWeatherEventFailed(GetWeatherEventFailed event) {
        makeToast(getActivity(), "Weather get failed");
    }

    private Bus getBus() {
        if (mBus == null) {
            mBus = BusProvider.getInstance();
        }
        return mBus;
    }

    public void setBus(Bus bus) {
        mBus = bus;
    }

}
