package com.cy.androidarchitecturedesign.mvcwithvolley.volley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

/**
 * Created by Mb on 2017/11/4.
 */

public class VolleyRequestQueue {

    private static RequestQueue sRequestQueue;

    private VolleyRequestQueue() {
    }

    /**
     * @param context 上下文
     * @Description new 一个请求列队
     */
    public static void volleyQueueConfig(Context context) {
        sRequestQueue = Volley.newRequestQueue(context);
    }

    /**
     * @Description 获取单例
     */
    public static VolleyRequestQueue newInstance() {
        if (sRequestQueue == null) {
            throw new NullPointerException("Call buildRequestQueue method first.");
        }
        return new VolleyRequestQueue();
    }

    /**
     * @return GsonRequest<T>
     * @Description
     */
    public <T> GsonRequest<T> newGsonRequest(String url, Class<T> aClass,
                                             Response.Listener<T> listener,
                                             Response.ErrorListener errorListener) {
        GsonRequest<T> tGsonRequest = new GsonRequest<>( url, aClass, listener, errorListener);
        sRequestQueue.add(tGsonRequest);
        return tGsonRequest;
    }

}
