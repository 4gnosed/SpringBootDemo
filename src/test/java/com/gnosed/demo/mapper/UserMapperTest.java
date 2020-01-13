package com.gnosed.demo.mapper;

import com.gnosed.demo.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void list() {
        List<User> users = userMapper.selectList(null);
        Assert.assertEquals(users.size(), 3);
        users.forEach(System.out::println);
    }

    @Test
    public void getById() {
        User user = userMapper.selectById("1");
        Assert.assertNotNull(user);
        System.out.println(user);
    }

}