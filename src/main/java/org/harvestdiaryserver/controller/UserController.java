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

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        log.info("用户登录：{}", user);
        User u = userService.login(user);
        if (u != null){
            return Result.success();
        }

        return Result.error("用户名密码错误");
    }

}
