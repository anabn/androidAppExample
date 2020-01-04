package com.myapplication.main;

import android.view.View;
import android.widget.Toast;

/**
 * Responsible for handling actions from the View and updating the UI as required.
 */
public class MainPresenter implements MainContract.Presenter {

    private MainContract.MvpView mvpView;

    /**
     * @see MainContract.MvpView
     * @param view - based on MainContract.class (interface - mvpView)
     */
    MainPresenter(MainContract.MvpView view){
        mvpView = view;
    }

    //////          Presenter methods          //////

    /**
     * @see MainContract.Presenter - interface for  methods
     * @see MainContract.MvpView - paramenters are based on this interface
     * @see #handleCreateButtonClick(View) - handler for clicking the button Create
     * @param view - type View to create Create Activity
     *
     * */
    @Override
    public void handleCreateButtonClick(View view) {
        mvpView.showCreateActivity();
    }

    /**
     * @see MainContract.Presenter#handleActiveButtonClick(View)  - interface for  methods
     * @see MainContract.MvpView#showActiveActivity()  - parameters are based on this interface
     * @see #handleActiveButtonClick(View) - handler for clicking the button Active
     * @param view - type View
     */
    @Override
    public void handleActiveButtonClick(View view) {
        mvpView.showActiveActivity();
    }

    /**
     * @see MainContract.Presenter#handleReadButtonClick(View)  - interface for  methods
     * @see MainContract.MvpView#showReadActivity() - interface for parameters
     * @see #handleReadButtonClick(View) - handler for clicking the button Read
     * @param view - type View to Read activity
     */
    @Override
    public void handleReadButtonClick(View view) {
        mvpView.showReadActivity();
    }

    /**
     * @see MainContract.Presenter#handleLoginFormClick(View) - handler for clicking the button loginForm
     * @see MainContract.MvpView#showLoginForm() - - interface for parameters
     * @param view - type View to login activity
     */
    @Override
    public void handleLoginFormClick(View view) {
        mvpView.showLoginForm();
    }

    //View view
}
