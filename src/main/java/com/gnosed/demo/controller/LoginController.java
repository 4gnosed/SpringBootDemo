package com.gnosed.demo.controller;

import com.gnosed.demo.pojo.User;
import com.gnosed.demo.result.Result;
import com.gnosed.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session) {
        String username = requestUser.getUsername();
        String password = requestUser.getPassword();
        User user = userService.get(username, password);

/*        if(Objects.equals(username, "admin") && Objects.equals(password, "123")){
            return new Result(200);
        }else {
            System.out.println("账号或密码错误");
            return new Result(400);
        }*/
        if (user != null) {
            //保持登录状态
            session.setAttribute("user", user);
            return new Result(200);
        } else {
            return new Result(400);
        }
    }
}
