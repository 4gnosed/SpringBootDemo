package com.gnosed.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gnosed.demo.constant.Constant;
import com.gnosed.demo.mapper.UserMapper;
import com.gnosed.demo.pojo.User;
import com.gnosed.demo.util.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class IUserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User get(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Constant.USERNAME, username).eq(Constant.PASSWORD, password);
        return getUser(username, queryWrapper);
    }

    @Override
    public User getByName(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq(Constant.USERNAME, username);
        return getUser(username, queryWrapper);
    }

    @Override
    public boolean add(User user) {
        ExceptionUtil.notNull(user, "User must be not null");
        String username = user.getUsername();
        if (getByName(username) == null) {
            return save(user);
        }
        return false;
    }

    private User getUser(String username, QueryWrapper<User> queryWrapper) {
        List<User> list = list(queryWrapper);
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() > 1) {
            log.error("getByName获取到多个User，username={}", username);
        }
        return list.get(0);
    }
}
