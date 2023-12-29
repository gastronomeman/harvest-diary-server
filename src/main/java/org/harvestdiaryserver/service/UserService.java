package org.harvestdiaryserver.service;

import org.harvestdiaryserver.pojo.User;

public interface UserService {
    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);

    void register(User user);

    User getUserByUserId(User user);
}
