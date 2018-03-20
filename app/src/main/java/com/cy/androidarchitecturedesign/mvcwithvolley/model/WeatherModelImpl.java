package com.cy.androidarchitecturedesign.mvcwithvolley.model;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.cy.androidarchitecturedesign.mvcwithvolley.entity.Weather;
import com.cy.androidarchitecturedesign.mvcwithvolley.volley.VolleyRequestQueue;

/**
 * Created by Mb on 2017/11/3.
 * 天气信息接口的实现
 */

public class WeatherModelImpl implements WeatherModel {
    private static final String TAG = "GsonRequest";

    @Override
    public void getWeather(String cityNumber, final OnWeatherListener listener) {
        VolleyRequestQueue.newInstance().newGsonRequest(
                "http://www.weather.com.cn/data/sk/" + cityNumber + ".html", Weather.class,
                new Response.Listener<Weather>() {
                    @Override
                    public void onResponse(Weather response) {
                        Log.d(TAG, "onResponse: "+response.toString());
                        if (response != null) {
                            listener.onSuccess(response);
                        } else {
                            listener.onError();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError();
                    }
                });
    }


}
