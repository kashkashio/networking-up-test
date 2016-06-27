package com.kashkash.openweather.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kashkash.openweather.api.ApiConstants;
import com.kashkash.openweather.api.WeatherList;
import com.squareup.picasso.Picasso;
import com.kashkash.openweather.R;


/**
 * Created by tsahkashkash on 25/06/16.
 */

public class WeatherAdapter extends BaseAdapter {

    private Context mContext;
    private WeatherList weatherList;

    public WindowManager wm;
    public Display display;
    public DisplayMetrics metrics;


    public WeatherAdapter(Context mContext, WeatherList weatherList) {
        this.mContext = mContext;
        this.weatherList = weatherList;
        this.wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        this.display = wm.getDefaultDisplay();
        this.metrics = new DisplayMetrics();
        display.getMetrics(metrics);
    }

    public void setWeatherList(WeatherList weatherList) {
        this.weatherList = weatherList;
    }

    @Override
    public int getCount() {
        if (weatherList.weathers != null) {
            return weatherList.weathers.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        final ViewHolder holder;

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(R.layout.row_weather, parent, false);
            holder = new ViewHolder();
            holder.currentCityName = (TextView) row.findViewById(R.id.current_city_name);
            holder.degreesText = (TextView) row.findViewById(R.id.degrees_text);
            holder.currentCityWeatherDescription = (TextView) row.findViewById(R.id.weather_description);
            holder.weatherIcon = (ImageView) row.findViewById(R.id.weather_icon);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        double tempsDblValue = Double.parseDouble(weatherList.weathers.get(position).weatherMainObject.currentTemp);
        int tempsFloored = (int)Math.floor(tempsDblValue+0.5);

        holder.currentCityName.setText(weatherList.weathers.get(position).currentCityName);
        holder.degreesText.setText(String.valueOf(tempsFloored));
        holder.currentCityWeatherDescription.setText(weatherList.weathers.get(position).weatherApiObject.get(0).weatherDescription);
        Picasso.with(mContext).load(ApiConstants.WEATHER_ICON_URL+weatherList.weathers.get(position).weatherApiObject.get(0).weatherIcon+".png").into(holder.weatherIcon);

        return row;
    }

    static class ViewHolder {
        TextView degreesText;
        TextView currentCityWeatherDescription;
        ImageView weatherIcon;
        TextView currentCityName;
    }

}