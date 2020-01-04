package com.myapplication.login;

import android.view.View;

/**
 * Represent interface for actions
 */

public interface LoginView {
    interface loginMVP{
        void showActivity();
//        void addEmail(String message);
//        void addPassword(String message);
//        void enableButton();
//        void disableButton();

    }

    interface loginPresenter{
        void sendLogin(View view);
//        void sendEmail(String message);
//        void sendPassword(String message);
//        void sendLogin(List list);
//        void login(LoginData data);
    }


//    interface LoginListener {
//        void onSuccess();
//        void onFailure(String message);
//    }

}
