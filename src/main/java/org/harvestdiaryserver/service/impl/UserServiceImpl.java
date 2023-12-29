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
}
