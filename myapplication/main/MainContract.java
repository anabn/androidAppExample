package com.myapplication.main;

import android.view.View;


/**
 * Represent interface for actions on Main
 * @see MainActivity - the main screen
 * @see MainPresenter - controller
 */
public interface MainContract {
    interface MvpView {
        void showCreateActivity();
        void showActiveActivity();
        void showReadActivity();
        void showLoginForm();
    }

    interface Presenter {
        void handleCreateButtonClick(View view);
        void handleActiveButtonClick(View view);
        void handleReadButtonClick(View view);
        void handleLoginFormClick(View view);
    }
}
