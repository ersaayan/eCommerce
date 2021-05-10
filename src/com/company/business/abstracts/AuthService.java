package com.company.business.abstracts;

import com.company.entities.concretes.User;

public interface AuthService {
    void signIn(User user);
    void signWithGoogleService(User user);
    void signUp(User user);
    void verify(User user, String code);
}
