package com.myapplication.mainForActive;

/**
 * Represent interface for actions on Active
 */
public interface ActiveContract {
    interface MvpViewActive{
        void showEditPage();
        void showClearView();
    }

    interface PresenterActive{
        void handleEditClick();
        void handleClearClick();
    }
}
