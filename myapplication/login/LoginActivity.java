package com.myapplication.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.myapplication.R;
import com.myapplication.databinding.ActivityLoginBinding;

/**
 * LoginActivity - represented a login page <br>
 *  created using MVP pattern on TDD
 * @author Anna Fetsun [DA - 61]
 * @version 1.0.1
 *
 * data: 11/25/2019 for creating doxygen
 *
 */

public class LoginActivity extends AppCompatActivity implements LoginView.loginMVP{

    private LoginPresenter loginPresenter;
    private Button loginButton;
    private EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresenter(this);
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setPresenter(loginPresenter);

        loginButton = findViewById(R.id.login);
        email = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton.setEnabled(true);
    }

    @Override
    public void showActivity() {
        String message = email.getText().toString().trim();
        String pass = password.getText().toString().trim();

        LoginData credentials = new LoginData(message, pass);
        //loginPresenter.login(credentials);

        if (credentials.isValid()){
            Toast.makeText(this, "right", Toast.LENGTH_LONG).show();
            Intent intentToLoginForm = new Intent("android.intent.action.ActiveActivity");
            startActivity(intentToLoginForm);
        } else {
            email.setError("Invalid data");
            Toast.makeText(this, "not right", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        loginButton.setEnabled(true);
    }

//    @Override
//    public void addEmail(String message) {
//    }
//
//    @Override
//    public void addPassword(String message) {
//
//    }

//    @Override
//    public void enableButton() {
//        loginButton.setEnabled(true);
//        Toast.makeText(this, "right", Toast.LENGTH_LONG).show();
//        Intent intentToLoginForm = new Intent("android.intent.action.ActiveActivity");
//        startActivity(intentToLoginForm);
//    }
//
//    @Override
//    public void disableButton() {
//        loginButton.setEnabled(false);
//        Toast.makeText(this, "not right", Toast.LENGTH_LONG).show();
//    }

//
//    public void method(){
//        String message = email.getText().toString().trim();
//        String pass = password.getText().toString().trim();
//        if (!message.isEmpty() && !pass.isEmpty()) {
//            enableButton();
//            Intent intentToLoginForm = new Intent("android.intent.action.ActiveActivity");
//            startActivity(intentToLoginForm);
//        } else {
//            disableButton();
//        }
//
//    }


}
