package com.gnosed.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gnosed.demo.pojo.User;

public interface IUserService extends IService<User> {
    User list(String username, String password);

    User listByName(String username) ;

    boolean add(User user);
}
