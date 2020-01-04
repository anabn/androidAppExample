package com.myapplication.main;

import android.view.View;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Local Unit test for the Main Presenter
 */
public class MainPresenterTest {

    @Mock
    private MainContract.MvpView mvpView;

    private MainPresenter mainPresenter;

    private View context;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mainPresenter = new MainPresenter(mvpView);

    }

//    @Test
//    public void

    @Test
    public void handleCreateButtonClick() {
        mainPresenter.handleCreateButtonClick(context);
        verify(mvpView).showCreateActivity();
    }

    @Test
    public void handleActiveButtonClick() {
        mainPresenter.handleActiveButtonClick(context);
        verify(mvpView).showActiveActivity();
    }

    @Test
    public void handleReadButtonClick() {
        mainPresenter.handleReadButtonClick(context);
        verify(mvpView).showReadActivity();
    }

    @Test
    public void handleLoginForm(){
        mainPresenter.handleLoginFormClick(context);
        verify(mvpView).showLoginForm();
    }

}