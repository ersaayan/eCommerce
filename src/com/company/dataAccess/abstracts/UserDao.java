package com.company.dataAccess.abstracts;

import com.company.entities.concretes.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void delete(User user);
    void update(User user);
    List<User> getAll();
    User get(int id);
    List<String> getEmails();
    boolean isMailMatch(User user);
    boolean isPasswordMatch(User user);
}
