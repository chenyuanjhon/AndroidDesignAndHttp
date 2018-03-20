package com.cy.androidarchitecturedesign.mvpwithokhttp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cy.androidarchitecturedesign.R;
import com.cy.androidarchitecturedesign.mvpwithokhttp.mvp.view.LoginActivity;
import com.cy.androidarchitecturedesign.mvpwithokhttp.okhttp.OkHttpActivity;

public class MvpAndOkHttpActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_and_ok_http);
        mIntent = new Intent();
        initView();
    }

    private void initView() {
        View okView = findViewById(R.id.ok_mvp_view1);
        okView.setOnClickListener(this);
        View mvpView = findViewById(R.id.ok_mvp_view2);
        mvpView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ok_mvp_view1:
                mIntent.setClass(this, OkHttpActivity.class);
                break;
            case R.id.ok_mvp_view2:
                mIntent.setClass(this, LoginActivity.class);
                break;
        }
        startActivity(mIntent);
    }
}
