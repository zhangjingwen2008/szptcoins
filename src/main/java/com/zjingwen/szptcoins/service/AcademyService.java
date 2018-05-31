package com.zjingwen.szptcoins.service;

import com.zjingwen.szptcoins.pojo.Academy;

public interface AcademyService {

    void add(Academy a);

    void delete(int id);

    void update(Academy a);

    Academy get(int id);
}
