package com.gnosed.demo.dao;

import com.gnosed.demo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);

    User findUserByUsernameAndPassword(String username, String password);
}
