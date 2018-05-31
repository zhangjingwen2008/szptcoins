package com.zjingwen.szptcoins.mapper;

import com.zjingwen.szptcoins.pojo.Message;
import com.zjingwen.szptcoins.pojo.MessageExample;

import java.util.List;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExampleWithBLOBs(MessageExample example);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKeyWithBLOBs(Message record);

    int updateByPrimaryKey(Message record);
}