package org.harvestdiaryserver.mapper;


import org.apache.ibatis.annotations.Insert;
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
    @Select("select *from user_info where user_id = #{userId} and password = #{password}")
    User getByUserNumberAndPassword(User user);

    @Insert("insert into user_info values (#{userNumber}, #{username}, #{password}, #{phone})")
    void addUser(User user);

    @Select("select *from user_info where user_id = #{userId}")
    User getUserByUserId(User user);
}
