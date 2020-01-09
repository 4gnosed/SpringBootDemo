package com.gnosed.demo.service;

import com.gnosed.demo.dao.UserDao;
import com.gnosed.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public boolean isExist(String username) {
        User user = userDao.findUserByUsername(username);
        return user != null;
    }

    public User getByName(String username) {
        return userDao.findUserByUsername(username);
    }

    public User get(String username, String password) {
        return userDao.findUserByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userDao.save(user);
    }
}
