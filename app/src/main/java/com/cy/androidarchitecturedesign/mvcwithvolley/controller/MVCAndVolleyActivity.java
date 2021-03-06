package com.cy.androidarchitecturedesign.mvcwithvolley.controller;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cy.androidarchitecturedesign.R;
import com.cy.androidarchitecturedesign.mvcwithvolley.entity.Weather;
import com.cy.androidarchitecturedesign.mvcwithvolley.entity.WeatherInfo;
import com.cy.androidarchitecturedesign.mvcwithvolley.model.OnWeatherListener;
import com.cy.androidarchitecturedesign.mvcwithvolley.model.WeatherModel;
import com.cy.androidarchitecturedesign.mvcwithvolley.model.WeatherModelImpl;

/**
 * 完全一样
 */

public class MVCAndVolleyActivity extends AppCompatActivity implements View.OnClickListener, OnWeatherListener {
    private static final String TAG = "GsonRequest";


    private WeatherModel weatherModel;
    private Dialog loadingDialog;
    private EditText cityNOInput;
    private TextView city;
    private TextView cityNO;
    private TextView temp;
    private TextView wd;
    private TextView ws;
    private TextView sd;
    private TextView wse;
    private TextView time;
    private TextView njd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc_and_volley);
        weatherModel = new WeatherModelImpl();
        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {
        cityNOInput = findView(R.id.et_city_no);
        city = findView(R.id.tv_city);
        cityNO = findView(R.id.tv_city_no);
        temp = findView(R.id.tv_temp);
        wd = findView(R.id.tv_WD);
        ws = findView(R.id.tv_WS);
        sd = findView(R.id.tv_SD);
        wse = findView(R.id.tv_WSE);
        time = findView(R.id.tv_time);
        njd = findView(R.id.tv_njd);
        findView(R.id.btn_go).setOnClickListener(this);

        loadingDialog = new ProgressDialog(this);
        loadingDialog.setTitle("加载天气中...");


    }

    /**
     * 显示结果
     *
     * @param weather
     */
    public void displayResult(Weather weather) {
        WeatherInfo weatherInfo = weather.getWeatherinfo();
        city.setText(weatherInfo.getCity());
        cityNO.setText(weatherInfo.getCityid());
        temp.setText(weatherInfo.getTemp());
        wd.setText(weatherInfo.getWD());
        ws.setText(weatherInfo.getWS());
        sd.setText(weatherInfo.getSD());
        wse.setText(weatherInfo.getWSE());
        time.setText(weatherInfo.getTime());
        njd.setText(weatherInfo.getNjd());
    }

    /**
     * 隐藏进度对话框
     */
    public void hideLoadingDialog() {
        loadingDialog.dismiss();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_go:
                loadingDialog.show();
                weatherModel.getWeather(cityNOInput.getText().toString().trim(), this);
                break;
        }
    }

    @Override
    public void onSuccess(Weather weather) {
        hideLoadingDialog();
        displayResult(weather);
    }

    @Override
    public void onError() {
        hideLoadingDialog();
        Toast.makeText(this, "获取天气信息失败", Toast.LENGTH_SHORT).show();
    }

    private <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

}
