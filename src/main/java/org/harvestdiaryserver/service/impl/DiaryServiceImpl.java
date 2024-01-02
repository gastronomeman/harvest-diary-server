package org.harvestdiaryserver.service.impl;

import org.harvestdiaryserver.mapper.DiaryMapper;
import org.harvestdiaryserver.pojo.Diary;
import org.harvestdiaryserver.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryServiceImpl implements DiaryService {
    @Autowired
    DiaryMapper diaryMapper;

    @Override
    public Diary selectDiary(Diary diary) {
        return diaryMapper.selectDiary(diary);
    }

    @Override
    public void addDiary(Diary diary) {
        diaryMapper.addDiary(diary);
    }

    @Override
    public void updateDiary(Diary diary) {
        diaryMapper.updateDiary(diary);
    }
}
