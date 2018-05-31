package com.zjingwen.szptcoins.mapper;

import com.zjingwen.szptcoins.pojo.User;
import com.zjingwen.szptcoins.pojo.UserExample;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}