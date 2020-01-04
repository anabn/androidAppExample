package com.myapplication.login;

import android.view.View;
/**
 * Responsible for handling actions from the View and updating the UI as required.
 */

public class LoginPresenter implements LoginView.loginPresenter {

    private LoginView.loginMVP mvpView;

    public LoginPresenter(LoginView.loginMVP view){
        mvpView = view;
    }

    @Override
    public void sendLogin(View view) {
        mvpView.showActivity();
    }
//    @Override
//    public void sendEmail(String message) {
//        if (message != null && !message.isEmpty()){
//            mvpView.addEmail(message);
//        }
//
//    }
//
//    @Override
//    public void sendPassword(String message) {
//        if (message != null && !message.isEmpty()){
//            mvpView.addPassword(message);
//        }

//    }


//    @Override
//    public void login(LoginData data) {
//        if (data.isValid()){
////            System.out.println("heelllloo");
//            mvpView.enableButton();
//        } else {
////            System.out.println("not heellloo");
//            mvpView.disableButton();
//        }
//    }

}
