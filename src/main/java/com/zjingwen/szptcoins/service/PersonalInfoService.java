package com.zjingwen.szptcoins.service;

import com.zjingwen.szptcoins.pojo.PersonalInfo;

public interface PersonalInfoService {

    void add(PersonalInfo personalInfo);

    void delete(int uid);

    void update(PersonalInfo personalInfo);

//    void updateByUid(PersonalInfo personalInfo);

    PersonalInfo get(int id);

    int getLevel(int stuNum);

    int getMaxStuNum();

}
