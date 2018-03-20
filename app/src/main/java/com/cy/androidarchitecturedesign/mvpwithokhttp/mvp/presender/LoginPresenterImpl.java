package com.cy.androidarchitecturedesign.mvpwithokhttp.mvp.presender;

import com.cy.androidarchitecturedesign.mvpwithokhttp.mvp.model.LoginInteractor;
import com.cy.androidarchitecturedesign.mvpwithokhttp.mvp.model.LoginInteractorImpl;
import com.cy.androidarchitecturedesign.mvpwithokhttp.mvp.model.OnLoginListener;
import com.cy.androidarchitecturedesign.mvpwithokhttp.mvp.view.LoginView;

/**
 * 交互实现 它是联通model和View的类，所以应当有View与model的引用
 */

public class LoginPresenterImpl implements LoginPresenter, OnLoginListener {

    private LoginView mLoginView;
    private LoginInteractor mLoginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.mLoginView = loginView;
        this.mLoginInteractor = new LoginInteractorImpl();

    }

    @Override
    public void validateCredentials(String username, String password) {
        if (mLoginView!=null) {
            mLoginView.showProgress();
        }
        mLoginInteractor.login(username,password,this);
    }

    @Override
    public void onDestroy() {
        mLoginView = null;
    }


    // listener
    @Override
    public void onSuccess() {
        if (mLoginView != null) {
            mLoginView.navigateToHome();
        }
    }

    @Override
    public void onError() {
        if (mLoginView != null) {
            mLoginView.setError();
            mLoginView.hideProgress();
        }
    }
}
