package com.zjingwen.szptcoins.mapper;

import com.zjingwen.szptcoins.pojo.Transaction;
import com.zjingwen.szptcoins.pojo.TransactionExample;

import java.util.List;

public interface TransactionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    List<Transaction> selectByExample(TransactionExample example);

    Transaction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);
}