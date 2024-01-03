package org.harvestdiaryserver.service.impl;

import org.harvestdiaryserver.mapper.DiaryMapper;
import org.harvestdiaryserver.pojo.Diary;
import org.harvestdiaryserver.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {
    @Autowired
    private DiaryMapper diaryMapper;

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

    @Override
    public void delDiary(Diary diary) {
        diaryMapper.delDiary(diary);
    }

    @Override
    public List<Diary> getDiaries(String userId) {
        return diaryMapper.getDiaries(userId);
    }

    @Override
    public void delDiaries(String userId) {
        diaryMapper.delDiaries(userId);
    }
}
