package com.zjingwen.szptcoins.service.impl;

import com.zjingwen.szptcoins.mapper.MajorMapper;
import com.zjingwen.szptcoins.pojo.Major;
import com.zjingwen.szptcoins.pojo.MajorExample;
import com.zjingwen.szptcoins.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    MajorMapper majorMapper;

    @Override
    public void add(Major major) {
        majorMapper.insert(major);
    }

    @Override
    public void delete(int id) {
        majorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Major major) {
        majorMapper.updateByPrimaryKeySelective(major);
    }

    @Override
    public Major get(int id) {
        MajorExample example = new MajorExample();
        example.createCriteria().andIdEqualTo(id);
        List<Major> result = majorMapper.selectByExample(example);
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }
}
