package org.harvestdiaryserver.service;

import org.harvestdiaryserver.pojo.Diary;

import java.util.List;

public interface DiaryService {

    Diary selectDiary(Diary diary);

    void addDiary(Diary diary);

    void updateDiary(Diary diary);

    void delDiary(Diary diary);

    List<Diary> getDiaries(String userId);

    void delDiaries(String userId);
}
