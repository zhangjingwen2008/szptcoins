package com.zjingwen.szptcoins.service;

import com.zjingwen.szptcoins.pojo.Estate;

public interface EstateService {

    void add(Estate e);

    void delete(int id);

    void update(Estate e);

    Estate get(int uid);


}
