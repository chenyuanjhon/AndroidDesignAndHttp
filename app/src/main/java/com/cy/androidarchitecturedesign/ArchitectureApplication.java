package com.cy.androidarchitecturedesign;

import android.app.Application;

import com.cy.androidarchitecturedesign.mvcwithvolley.volley.VolleyRequestQueue;

/**
 * Created by Mb on 2017/11/1.
 * application
 */

public class ArchitectureApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VolleyRequestQueue.volleyQueueConfig(this);
    }
}
