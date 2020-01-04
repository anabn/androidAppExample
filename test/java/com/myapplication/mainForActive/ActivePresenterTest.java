package com.myapplication.mainForActive;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class ActivePresenterTest {

    @Mock
    private ActiveContract.MvpViewActive mvpActive;
    private ActivePresenter activePresenter;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        activePresenter = new ActivePresenter(mvpActive) ;
    }

    @Test
    public void handleEditClick() {
        activePresenter.handleEditClick();
        verify(mvpActive).showEditPage();
    }

    @Test
    public void handleClearClick() {
        activePresenter.handleClearClick();
        verify(mvpActive).showClearView();
    }
}