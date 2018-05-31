package com.zjingwen.szptcoins.service.impl;

import com.zjingwen.szptcoins.mapper.WalletMapper;
import com.zjingwen.szptcoins.pojo.Wallet;
import com.zjingwen.szptcoins.pojo.WalletExample;
import com.zjingwen.szptcoins.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    WalletMapper walletMapper;

    @Override
    public void add(Wallet w) {
        walletMapper.insert(w);
    }

    @Override
    public void delete(int uid) {
        walletMapper.deleteByUid(uid);
    }

    @Override
    public void update(Wallet w) {
        walletMapper.updateByUidSelective(w);
    }

    @Override
    public Wallet get(int uid) {
        WalletExample example = new WalletExample();
        example.createCriteria().andUidEqualTo(uid);
        List<Wallet> result = walletMapper.selectByExample(example);
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }
}
