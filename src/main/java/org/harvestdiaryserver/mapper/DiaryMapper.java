package org.harvestdiaryserver.mapper;

import org.apache.ibatis.annotations.*;
import org.harvestdiaryserver.pojo.Diary;

import java.util.List;

@Mapper
public interface DiaryMapper {
    @Select("select *from user_diaries where user_id = #{userId} and time = #{time}")
    Diary selectDiary(Diary diary);

    @Insert("insert into user_diaries values (#{userId}, #{time}, #{color}, #{fontSize}, #{title}, #{content})")
    void addDiary(Diary diary);

    @Update("update user_diaries set color = #{color}, font_size = #{fontSize}, title = #{title}, content = #{content} " +
            "where user_id = #{userId} and time = #{time}")
    void updateDiary(Diary diary);

    @Delete("delete from user_diaries where time = #{time} and user_id = #{userId}")
    void delDiary(Diary diary);

    @Select("select * from user_diaries where user_id = #{userId}")
    List<Diary> getDiaries(String userId);

    @Delete("delete from user_diaries where user_id = #{userId}")
    void delDiaries(String userId);
}
