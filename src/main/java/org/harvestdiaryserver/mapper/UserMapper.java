package org.harvestdiaryserver.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.harvestdiaryserver.pojo.User;

@Mapper
public interface UserMapper {

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Select("select *from user_info where user_number = #{userNumber} and password = #{password}")
    User getByUserNumberAndPassword(User user);
}
