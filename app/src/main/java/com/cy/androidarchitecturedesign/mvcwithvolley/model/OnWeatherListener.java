package com.cy.androidarchitecturedesign.mvcwithvolley.model;

import com.cy.androidarchitecturedesign.mvcwithvolley.entity.Weather;

/**
 * Created by Mb on 2017/11/3.
 * 请求结果接口
 */

public interface OnWeatherListener {
    void onSuccess(Weather weather);
    void onError();
}
