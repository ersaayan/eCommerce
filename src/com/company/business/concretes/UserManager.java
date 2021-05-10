package com.company.business.concretes;

import com.company.business.abstracts.UserService;
import com.company.dataAccess.abstracts.UserDao;
import com.company.entities.concretes.User;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager implements UserService {

    private UserDao userDao;

    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;

    }

    private boolean isValid(User user) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user.getEmail());

        if (user.getName() == null || user.getLastname() == null
                || user.getEmail() == null || user.getPass() == null) {
            System.out.println("Boş bırakılmaz");
            return false;
        } else {
            if (!matcher.matches()) {
                System.out.println("E-mail Hatalı");
                return false;
            } else {
                if (user.getName().length() < 2 && user.getLastname().length() < 2) {
                    if (user.getPass().length() < 6) {
                        System.out.println("Şifreniz en az 6 haneli olmalıdır.");
                        return false;
                    }
                }

            }
        }
        return true;
    }
    @Override
    public void add(User user) {
        if(isValid(user) && !ifEmailExists(user)){
            userDao.add(user);
            return;
        }
    }

    @Override
    public void update(User user) {
        if(isValid(user) && !ifEmailExists(user)){
            userDao.update(user);
            return;
        }
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User get(int id) {
        return userDao.get(id);
    }

    @Override
    public boolean ifEmailExists(User user) {
        return userDao.isMailMatch(user);
    }

    @Override
    public boolean ifPasswordExists(User user) {
        return userDao.isPasswordMatch(user);
    }
}
