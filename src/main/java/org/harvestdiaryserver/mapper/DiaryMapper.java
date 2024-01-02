package org.harvestdiaryserver.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.harvestdiaryserver.pojo.Diary;

@Mapper
public interface DiaryMapper {
    @Select("select *from user_diaries where user_id = #{userId} and time = #{time}")
    Diary selectDiary(Diary diary);

    @Insert("insert into user_diaries values (#{userId}, #{time}, #{color}, #{fontSize}, #{title}, #{content})")
    void addDiary(Diary diary);

    @Update("update user_diaries set color = #{color}, font_size = #{fontSize}, title = #{title}, content = #{content} " +
            "where user_id = #{userId} and time = #{time}")
    void updateDiary(Diary diary);
}
