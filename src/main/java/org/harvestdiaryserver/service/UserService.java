package org.harvestdiaryserver.service;

import org.harvestdiaryserver.pojo.User;

public interface UserService {
    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);

    User getUserByUserId(User user);

    User getUserByUserPhone(User user);

    void addUser(User user);
}
