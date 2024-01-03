package org.harvestdiaryserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.harvestdiaryserver.pojo.Diary;
import org.harvestdiaryserver.pojo.Result;
import org.harvestdiaryserver.pojo.User;
import org.harvestdiaryserver.service.DiaryService;
import org.harvestdiaryserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/diary")
public class DiaryController {
    @Autowired
    private DiaryService diaryService;
    @Autowired
    private UserService userService;

    @PostMapping("/write")
    public Result writeDiary(@RequestBody Diary diary) {
        Diary d = diaryService.selectDiary(diary);
        User u = new User();
        u.setUserId(diary.getUserId());
        u = userService.getUserByUserId(u);
        if (u != null) {
            if (d == null) {
                diaryService.addDiary(diary);
            } else {
                diaryService.updateDiary(diary);
            }
            return Result.success();
        }
        return Result.error("error5");
    }

    @PostMapping("/del")
    public Result delDiary(@RequestBody Diary diary) {
        Diary d = diaryService.selectDiary(diary);
        if (d != null) {
            diaryService.delDiary(diary);
            return Result.success();
        }
        return Result.error("error6");
    }

    @PostMapping("/getDiary")
    public Result getDiary(@RequestBody String userId) {
        List<Diary> list = diaryService.getDiaries(userId);
        return Result.success(list);
    }

    @PostMapping("/setDiary")
    public Result setDiary(@RequestBody List<Diary> list){
        for (Diary diary : list) {
            writeDiary(diary);
        }
        return Result.success();
    }

}
