package com.myapplication.login;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * handling data
 */
public class LoginData {
    private String email;
    private String password;

    public LoginData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isValid() {
        if (TextUtils.isEmpty(email)) {
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            return false;
        }

        if (password.length() < 5) {
            return false;
        }

        return true;
    }
}
