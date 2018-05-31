package com.zjingwen.szptcoins.mapper;

import com.zjingwen.szptcoins.pojo.Court;
import com.zjingwen.szptcoins.pojo.CourtExample;

import java.util.List;

public interface CourtMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Court record);

    int insertSelective(Court record);

    List<Court> selectByExample(CourtExample example);

    Court selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Court record);

    int updateByPrimaryKey(Court record);
}