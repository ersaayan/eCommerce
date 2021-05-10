package com.company.business.abstracts;

import com.company.entities.concretes.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void update(User user);
    void delete(User user);
    List<User> getAll();
    User get(int id);
    boolean ifEmailExists(User user);
    boolean ifPasswordExists(User user);
}
