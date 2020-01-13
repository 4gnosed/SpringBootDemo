package com.gnosed.demo.controller;

import com.gnosed.demo.pojo.User;
import com.gnosed.demo.result.Result;
import com.gnosed.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    private IUserService IUserService;

    /**
     * 登录验证
     *
     * @param requestUser
     * @param session
     * @return
     */
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session) {
        String username = requestUser.getUsername();
        String password = requestUser.getPassword();
        User user = IUserService.get(username, password);

        if (user != null) {
            //保持登录状态
            session.setAttribute("user", user);
            return new Result(200);
        } else {
            return new Result(400);
        }
    }
}
