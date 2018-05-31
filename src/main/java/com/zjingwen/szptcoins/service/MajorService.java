package com.zjingwen.szptcoins.service;

import com.zjingwen.szptcoins.pojo.Major;

public interface MajorService {

    void add(Major major);

    void delete(int id);

    void update(Major major);

    Major get(int id);

}
