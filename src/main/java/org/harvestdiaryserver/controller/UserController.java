package org.harvestdiaryserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.harvestdiaryserver.mapper.DiaryMapper;
import org.harvestdiaryserver.pojo.Diary;
import org.harvestdiaryserver.pojo.Result;
import org.harvestdiaryserver.pojo.User;

import org.harvestdiaryserver.service.DiaryService;
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
    @Autowired
    private DiaryService diaryService;

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
            log.info("用户登录：{}", u);
            return Result.success(u);
        }
        return Result.error("error3");
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        log.info("注册用户：{}", user);
        if (userService.getUserByUserId(user) != null){
            return Result.error("error1");
        }
        if (userService.getUserByUserPhone(user) != null){
            return Result.error("error2");
        }
        userService.addUser(user);
        return Result.success("注册成功");

    }

    @PostMapping("/findPassword")
    public Result findPassword(@RequestBody User user){
        if (userService.getUserByUsernameAndPhone(user) == null){
            return Result.error("error4");
        }
        return Result.success(userService.getUserByUsernameAndPhone(user));
    }

    @PostMapping("/delUser")
    public Result delUser(@RequestBody User user){
        userService.delUser(user);
        diaryService.delDiaries(user.getUserId());
        return Result.success();
    }

}

