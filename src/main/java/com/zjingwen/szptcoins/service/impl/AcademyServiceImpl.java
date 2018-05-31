package com.zjingwen.szptcoins.service.impl;

import com.zjingwen.szptcoins.mapper.AcademyMapper;
import com.zjingwen.szptcoins.pojo.Academy;
import com.zjingwen.szptcoins.pojo.AcademyExample;
import com.zjingwen.szptcoins.service.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.List;

@Service
public class AcademyServiceImpl implements AcademyService {

    @Autowired
    AcademyMapper academyMapper;

    @Override
    public void add(Academy a) {
        academyMapper.insert(a);
    }

    @Override
    public void delete(int id) {
        academyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Academy a) {
        academyMapper.updateByPrimaryKeySelective(a);
    }

    @Override
    public Academy get(int id) {
        AcademyExample example = new AcademyExample();
        example.createCriteria().andIdEqualTo(id);
        List<Academy> result = academyMapper.selectByExample(example);
        if (result.isEmpty()) {
            return null;
        }

        return result.get(0);
    }
}
