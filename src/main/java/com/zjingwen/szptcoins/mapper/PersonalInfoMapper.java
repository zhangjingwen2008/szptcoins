package com.zjingwen.szptcoins.mapper;

import com.zjingwen.szptcoins.pojo.PersonalInfo;
import com.zjingwen.szptcoins.pojo.PersonalInfoExample;

import java.util.List;

public interface PersonalInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonalInfo record);

    int insertSelective(PersonalInfo record);

    List<PersonalInfo> selectByExample(PersonalInfoExample example);

    PersonalInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonalInfo record);

    int updateByPrimaryKey(PersonalInfo record);

    /*
    自己手动增加的
     */
    //根据uid获得个人信息条目
    int updateByUidSelective(PersonalInfo record);

    //获取最大学号
    int getMaxStuNum();

}