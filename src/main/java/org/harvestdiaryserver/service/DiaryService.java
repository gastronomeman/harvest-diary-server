package org.harvestdiaryserver.service;

import org.harvestdiaryserver.pojo.Diary;

public interface DiaryService {

    Diary selectDiary(Diary diary);

    void addDiary(Diary diary);

    void updateDiary(Diary diary);
}
