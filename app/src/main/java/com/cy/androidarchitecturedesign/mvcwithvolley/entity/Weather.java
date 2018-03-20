package com.cy.androidarchitecturedesign.mvcwithvolley.entity;

/**
 * Created by Mb on 2017/11/3.
 *  weather 完全一样了
 *  为什么weatherinfo 必须要声明为这样的？？？？？？？
 * 这个字段对应的是 JSON 数据的第一个字段
 *
 */

public class Weather {

    private WeatherInfo weatherinfo;

    public WeatherInfo getWeatherinfo() {
        return weatherinfo;
    }

    public void setWeatherinfo(WeatherInfo weatherInfo) {
        weatherinfo = weatherInfo;
    }
}
