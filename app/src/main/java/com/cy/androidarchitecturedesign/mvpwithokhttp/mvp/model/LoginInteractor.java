package com.cy.androidarchitecturedesign.mvpwithokhttp.mvp.model;

/**
 * Created by Mb on 2017/11/8.
 * 交互事件，登陆
 */

public interface LoginInteractor {
    void login(String name,String password,OnLoginListener onLoginListener);
}
