package com.cy.androidarchitecturedesign.mvpwithokhttp.mvp.model;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by Mb on 2017/11/8.
 * 登陆的实现
 */

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(final String name, final String password, final OnLoginListener onLoginListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
                    onLoginListener.onError();
                } else {
                    onLoginListener.onSuccess();
                }
            }
        }, 2000);
    }
}
