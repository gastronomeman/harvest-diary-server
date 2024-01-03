package org.harvestdiaryserver.service.impl;

import org.harvestdiaryserver.mapper.UserMapper;
import org.harvestdiaryserver.pojo.User;
import org.harvestdiaryserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userMapper.getByUserNumberAndPassword(user);
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User getUserByUsernameAndPhone(User user) {
        return userMapper.getUserByUsernameAndPhone(user);
    }

    @Override
    public void delUser(User user) {
        userMapper.delUser(user);
    }

    @Override
    public User getUserByUserId(User user) {
        return userMapper.getUserByUserId(user);
    }

    @Override
    public User getUserByUserPhone(User user) {
        return userMapper.getUserByUserPhone(user);
    }
}
