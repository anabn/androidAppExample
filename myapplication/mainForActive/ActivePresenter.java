package com.myapplication.mainForActive;

/**
 * Responsible for handling actions from the View and updating the UI as required.
 */

public class ActivePresenter implements ActiveContract.PresenterActive{

    private ActiveContract.MvpViewActive mvpActive;

    ActivePresenter(ActiveContract.MvpViewActive view){
        mvpActive = view;
    }

    @Override
    public void handleEditClick(){
        mvpActive.showEditPage();
    }

    @Override
    public void handleClearClick() {
        mvpActive.showClearView();
    }
}
