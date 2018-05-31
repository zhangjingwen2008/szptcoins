package com.zjingwen.szptcoins.service.impl;

import com.zjingwen.szptcoins.mapper.EstateMapper;
import com.zjingwen.szptcoins.pojo.Estate;
import com.zjingwen.szptcoins.pojo.EstateExample;
import com.zjingwen.szptcoins.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstateServiceImpl implements EstateService {

    @Autowired
    EstateMapper estateMapper;

    @Override
    public void add(Estate e) {
        estateMapper.insert(e);
    }

    @Override
    public void delete(int id) {
        estateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Estate e) {
        estateMapper.updateByUid(e);
    }

    @Override
    public Estate get(int uid) {
        EstateExample example = new EstateExample();
        example.createCriteria().andUidEqualTo(uid);
        List<Estate> result = estateMapper.selectByExample(example);
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }
}
