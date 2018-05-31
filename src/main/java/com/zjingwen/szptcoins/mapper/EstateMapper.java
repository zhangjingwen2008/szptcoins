package com.zjingwen.szptcoins.mapper;

import com.zjingwen.szptcoins.pojo.Estate;
import com.zjingwen.szptcoins.pojo.EstateExample;

import java.util.List;

public interface EstateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Estate record);

    int insertSelective(Estate record);

    List<Estate> selectByExample(EstateExample example);

    Estate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Estate record);

    int updateByUid(Estate record);

    int updateByPrimaryKey(Estate record);
}