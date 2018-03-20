package com.cy.androidarchitecturedesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cy.androidarchitecturedesign.mvcwithvolley.controller.MVCAndVolleyActivity;
import com.cy.androidarchitecturedesign.mvpwithokhttp.MvpAndOkHttpActivity;
import com.cy.androidarchitecturedesign.mvvmwithbind.BindActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIntent = new Intent();
        initView();
    }

    private void initView() {
        View mvc = findViewById(R.id.textView);
        mvc.setOnClickListener(this);
        View mvp = findViewById(R.id.textView2);
        mvp.setOnClickListener(this);
        View mvvm = findViewById(R.id.textView3);
        mvvm.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView:
                mIntent.setClass(this, MVCAndVolleyActivity.class);
                break;
            case R.id.textView2:
                mIntent.setClass(this, MvpAndOkHttpActivity.class);
                break;
            case R.id.textView3:
                mIntent.setClass(this, BindActivity.class);
                break;
        }
        startActivity(mIntent);
    }
}
