package com.cy.androidarchitecturedesign.mvcwithvolley.model;

/**
 * Created by Mb on 2017/11/3.
 *  请求网络数据接口
 */

public interface WeatherModel {
    void getWeather(String cityNumber,OnWeatherListener listener );
}
