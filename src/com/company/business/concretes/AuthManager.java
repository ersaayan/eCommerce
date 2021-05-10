package com.company.business.concretes;

import com.company.business.abstracts.AuthService;
import com.company.business.abstracts.UserService;
import com.company.core.GoogleServiceAdapter;
import com.company.entities.concretes.User;

public class AuthManager implements AuthService {

    private UserService userService;

    public AuthManager(UserService userService){
        super();
        this.userService = userService;
    }

    private boolean checkUserForLogin(User user) {
        if(user.isVerified() && !(user.getEmail().isBlank() && user.getEmail() == null) && !(user.getPass().isBlank() && user.getPass() == null) ) {
            return true;
        }
        return false;
    }

    @Override
    public void signIn(User user) {
        if(checkUserForLogin(user)){
            if(userService.ifEmailExists(user) && userService.ifPasswordExists(user)){
                System.out.println("Giriş yapıldı");
            }else{
                System.out.println("Email veya şifre uyumlu değil");
            }
            return;
        }
        System.out.println("Doğrulanmamış Hesap");

    }

    @Override
    public void signWithGoogleService(User user) {
        user.setVerified(true);
        if(checkUserForLogin(user)) {
            GoogleServiceAdapter googleApi = new GoogleServiceAdapter();
            googleApi.signIn(user.getEmail(), user.getPass());
            userService.add(user);
            return;
        }
        System.out.println("Doğrulanmamış Hesap");
    }

    @Override
    public void signUp(User user) {
        userService.add(user);
        int random = (int)Math.floor(Math.random()*9999);
        String dogrulamaKodu = user.getName().substring(0, 1)+user.getId()+user.getLastname().substring(0, 1)+random;
        System.out.println("Doğrulama Kodu: "+dogrulamaKodu);
        user.setVerifyCode(dogrulamaKodu);
    }

    @Override
    public void verify(User user, String code) {
        User verifiedUser = userService.get(user.getId());
        if(verifiedUser.getVerifyCode() == code) {
            verifiedUser.setVerified(true);
            System.out.println("Kod doğrulandı");
            return;
        }
        System.out.println("Doğrulama kodu hatalı");
    }
}
