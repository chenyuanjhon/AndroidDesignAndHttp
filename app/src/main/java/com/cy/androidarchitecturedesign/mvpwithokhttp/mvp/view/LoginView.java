package com.cy.androidarchitecturedesign.mvpwithokhttp.mvp.view;

/**
 * Created by Mb on 2017/11/8.
 * view 与 presenter 的通信接口
 */

public interface LoginView {
    void showProgress();
    void hideProgress();
    void setError();
    void navigateToHome();
}
