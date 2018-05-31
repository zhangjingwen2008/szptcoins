package com.zjingwen.szptcoins.mapper;

import com.zjingwen.szptcoins.pojo.Wallet;
import com.zjingwen.szptcoins.pojo.WalletExample;
import java.util.List;

public interface WalletMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Wallet record);

    int insertSelective(Wallet record);

    List<Wallet> selectByExample(WalletExample example);

    Wallet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wallet record);

    int updateByPrimaryKey(Wallet record);

    //自己添加的
    int deleteByUid(Integer uid);
    int updateByUidSelective(Wallet record);
}