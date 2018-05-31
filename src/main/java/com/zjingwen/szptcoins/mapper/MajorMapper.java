package com.zjingwen.szptcoins.mapper;

import com.zjingwen.szptcoins.pojo.Major;
import com.zjingwen.szptcoins.pojo.MajorExample;

import java.util.List;

public interface MajorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Major record);

    int insertSelective(Major record);

    List<Major> selectByExample(MajorExample example);

    Major selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
}