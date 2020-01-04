package com.myapplication;

import android.text.TextUtils;
import android.view.View;

import com.myapplication.login.LoginActivity;
import com.myapplication.login.LoginData;
import com.myapplication.login.LoginPresenter;
import com.myapplication.login.LoginView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginActivityTest {
    private static final String LOCAL_EMAIL = "anyEmail@gmail.com";
    private static final String LOCAL_PASSWORD = "12345";
    private View context;
    private LoginView.loginPresenter loginPresenter;


    private LoginData loginCredentials = new LoginData(
            "anyExample@gmail.com",
            "123456");

    private TextUtils textUtils;
    @Mock
    private LoginView.loginMVP loginMVP;

    @Mock
    private LoginData data;

//    @Captor
//    private ArgumentCaptor<LoginData> loginArgumentCaptor;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        loginPresenter = new LoginPresenter(loginMVP);

    }


    @Test
    public void checkedButton(){
        loginPresenter.sendLogin(context);
        verify(loginMVP).showActivity();
    }


    @Test
    public void withParam(){
        Comparable c = mock(Comparable.class);
        when(c.compareTo("Test")).thenReturn(1);
        assertEquals(1, c.compareTo("Test"));
    }

    @After
    public void tearDown() throws Exception {
    }

}