package com.company.core;

import com.company.googleAuthService.GoogleAuthManager;

public class GoogleServiceAdapter {
    public void signIn(String email, String password) {
        GoogleAuthManager googleAuth = new GoogleAuthManager();
        googleAuth.sign(email, password);
    }
}
