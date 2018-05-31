package com.zjingwen.szptcoins.service;

import com.zjingwen.szptcoins.pojo.Wallet;

public interface WalletService {

    void add(Wallet w);

    void delete(int uid);

    void update(Wallet w);

    Wallet get(int uid);
}
