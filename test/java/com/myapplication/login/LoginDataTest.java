package com.myapplication.login;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


public class LoginDataTest {

    private static final String LOCAL_EMAIL = "anyEmail@gmail.com";
    private static final String LOCAL_PASSWORD = "12345";
    private LoginData loginData;


    private LoginData loginCredentials = new LoginData(
            "anyExample@gmail.com",
            "123456");

    @Mock
    private LoginView.loginMVP loginMVP;

    @Captor
    private ArgumentCaptor<LoginData> data;

//    @Mock
//    private LoginData data;

    //    @Captor
//    private ArgumentCaptor<LoginData> loginArgumentCaptor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);


    }
    @Test
    public void data_Null() {
        loginData = new LoginData(null, null);
        verify(loginMVP, never()).showActivity();
    }

    @Test
    public void data_Null_Email() {
        loginData = new LoginData(null, LOCAL_PASSWORD);
        verify(loginMVP, never()).showActivity();
    }

    @Test
    public void data_Null_Password() {
        loginData = new LoginData(LOCAL_EMAIL, null);
        verify(loginMVP, never()).showActivity();
    }


    @Test
    public void data_Empty() {
        loginData = new LoginData("", "");
        verify(loginMVP, never()).showActivity();
    }

    @Test
    public void data_Empty_Email() {
        loginData = new LoginData("", null);
        verify(loginMVP, never()).showActivity();
    }

    @Test
    public void data_Empty_Password() {
        loginData = new LoginData(null, "");
        verify(loginMVP, never()).showActivity();
    }


//    @Test
//    public void getPassword() {
//        loginData = new LoginData(LOCAL_EMAIL, LOCAL_PASSWORD);
//        verify(loginMVP).showActivity();
//
//    }

//    @Test
//    public void isValid_with_Null() {
//        loginData = new LoginData(LOCAL_EMAIL, LOCAL_PASSWORD);
//        boolean a = loginData.isValid();
//        assertEquals(true, a);
//        verify(loginMVP).showActivity();
//    }
}