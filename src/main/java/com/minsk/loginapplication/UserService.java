package com.minsk.loginapplication;

import com.minsk.loginapplication.UserDao;
import com.minsk.loginapplication.User;

import java.util.List;

public class UserService {

    private UserDao usersDao = new UserDao();

    public UserService() {
    }
    
    public List<User> findUser(String login) {
        return usersDao.findUser(login);
    }
    
    public void saveUser(User user) {
        usersDao.save(user);
    }

    public void deleteUser(User user) {
        usersDao.delete(user);
    }

    public void updateUser(User user) {
        usersDao.update(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAll();
    }


}