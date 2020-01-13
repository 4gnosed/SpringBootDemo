package com.gnosed.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gnosed.demo.pojo.User;

public interface IUserService extends IService<User> {
    User get(String username, String password);

    User getByName(String username) ;

    boolean add(User user);
}
