package com.zjingwen.szptcoins.mapper;

import com.zjingwen.szptcoins.pojo.Academy;
import com.zjingwen.szptcoins.pojo.AcademyExample;

import java.util.List;

public interface AcademyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Academy record);

    int insertSelective(Academy record);

    List<Academy> selectByExample(AcademyExample example);

    Academy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Academy record);

    int updateByPrimaryKey(Academy record);
}