package com.company.entities.concretes;

import com.company.entities.abstracts.Entity;

public class User implements Entity {

    private int id;
    private String name;
    private String lastname;
    private String email;
    private String pass;
    private boolean isVerified = false;
    private String verifyCode;

    @Override
    public String toString() {
        return "Id:"+id+" Email: " + email + " Full Name: " + name + " "+ lastname+ " şifre: "+pass + "\n";
    }

    public User(int id, String name, String lastname, String email, String pass) {
        super();
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.pass = pass;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
