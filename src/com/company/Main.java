package com.company;

import com.company.business.concretes.AuthManager;
import com.company.business.concretes.UserManager;
import com.company.dataAccess.concretes.UserDaoManager;
import com.company.entities.concretes.User;

public class Main {

    public static void main(String[] args) {
        User user = new User(1,"Eren","Savk","eren@gmail.com","1234567");
        User user1 = new User(2,"Deniz","Tozlutepe","deniz@gmail.com","1234567");
        User user2 = new User(1,"Engin","Demiroğ","engin@gmail.com","1234567");
        UserManager manager = new UserManager(new UserDaoManager());
        AuthManager auth = new AuthManager(manager);
        auth.signUp(user);
        auth.verify(user, user.getVerifyCode());
        auth.signWithGoogleService(user);
        manager.update(user2);
    }
}
