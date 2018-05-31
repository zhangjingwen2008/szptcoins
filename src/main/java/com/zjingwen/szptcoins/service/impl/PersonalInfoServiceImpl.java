package com.zjingwen.szptcoins.service.impl;

import com.zjingwen.szptcoins.mapper.PersonalInfoMapper;
import com.zjingwen.szptcoins.pojo.PersonalInfo;
import com.zjingwen.szptcoins.pojo.PersonalInfoExample;
import com.zjingwen.szptcoins.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {

    @Autowired
    PersonalInfoMapper personalInfoMapper;

    @Override
    public void add(PersonalInfo personalInfo) {
        personalInfoMapper.insert(personalInfo);
    }

    @Override
    public void delete(int uid) {
        personalInfoMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public void update(PersonalInfo personalInfo) {
//        personalInfoMapper.updateByPrimaryKeySelective(personalInfo);
        personalInfoMapper.updateByUidSelective(personalInfo);
    }

    @Override
    public int getMaxStuNum() {
        return personalInfoMapper.getMaxStuNum();
    }

    @Override
    public PersonalInfo get(int id) {
        PersonalInfoExample example = new PersonalInfoExample();
        example.createCriteria().andUIdEqualTo(id);
        List<PersonalInfo> result = personalInfoMapper.selectByExample(example);

        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    @Override
    public int getLevel(int stuNum) {
        String s = String.valueOf(stuNum);
        String sYear = 20 + s.substring(0, 2);

        Calendar c = Calendar.getInstance();
        int now = c.get(Calendar.YEAR);

        int level = now - Integer.parseInt(sYear);
        return level;
    }
}
