package org.harvestdiaryserver.mapper;


import org.apache.ibatis.annotations.Delete;
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

    @Insert("insert into user_info values (#{userId}, #{username}, #{password}, #{phone})")
    void addUser(User user);

    @Select("select *from user_info where user_id = #{userId}")
    User getUserByUserId(User user);

    @Select("select *from user_info where phone = #{phone}")
    User getUserByUserPhone(User user);

    @Select("select *from user_info where username = #{username} and phone = #{phone}")
    User getUserByUsernameAndPhone(User user);

    @Delete("delete from user_info where user_id = #{userId} and username = #{username} and " +
            " password = #{password} and phone = #{phone}")
    void delUser(User user);
}
