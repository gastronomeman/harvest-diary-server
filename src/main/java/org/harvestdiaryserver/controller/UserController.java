package org.harvestdiaryserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.harvestdiaryserver.pojo.Result;
import org.harvestdiaryserver.pojo.User;

import org.harvestdiaryserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录验证
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        log.info("用户登录：{}", user);
        User u = userService.login(user);
        if (u != null){
            return Result.success();
        }
        return Result.error("用户名密码错误");
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        log.info("注册用户：{}", user);
        if (userService.getUserByUserId(user) == null){
            userService.register(user);
            return Result.success("注册成功");
        }
        return Result.error("账号已存在");
    }
}
