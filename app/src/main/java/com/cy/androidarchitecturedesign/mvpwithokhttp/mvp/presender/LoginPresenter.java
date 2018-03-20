package com.cy.androidarchitecturedesign.mvpwithokhttp.mvp.presender;

/**
 * 交互
 */

public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void onDestroy();
}
