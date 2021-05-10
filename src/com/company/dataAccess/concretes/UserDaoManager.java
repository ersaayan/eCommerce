package com.company.dataAccess.concretes;

import com.company.dataAccess.abstracts.UserDao;
import com.company.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoManager implements UserDao {
    private List<User> users;

    public UserDaoManager() {
        super();
        this.users = new ArrayList<User>();
    }

    @Override
    public void add(User user) {
        users.add(user);
        System.out.println(user.getEmail() + " Kayit Oldu");
    }

    @Override
    public void delete(User user) {
        User updatedUser = users.stream().filter(u -> u.getId() == user.getId()).findFirst().get();
        users.remove(updatedUser);
    }

    @Override
    public void update(User user) {
        User updatedUser = users.stream().filter(u -> u.getId() == user.getId()).findFirst().get();
        System.out.println(updatedUser.toString());
        updatedUser.setId(user.getId());
        updatedUser.setName(user.getName());
        updatedUser.setLastname(user.getLastname());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPass(user.getPass());
        System.out.println( updatedUser.toString() + " Güncellendi");
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User get(int id) {
        return users.stream().filter(u -> u.getId() == id).findFirst().get();
    }

    @Override
    public List<String> getEmails() {
        List<String>  emails = new ArrayList<String>();
        for (User user : users) {
            emails.add(user.getEmail());
        }
        return emails;
    }

    @Override
    public boolean isMailMatch(User user) {
        return getEmails().stream().anyMatch(x -> x == user.getEmail());
    }

    @Override
    public boolean isPasswordMatch(User user) {
        return users.stream().anyMatch(user_ -> user_.getPass() == user.getPass());
    }
}
