package com.zjingwen.szptcoins.service.impl;

import com.zjingwen.szptcoins.mapper.UserMapper;
import com.zjingwen.szptcoins.pojo.User;
import com.zjingwen.szptcoins.pojo.UserExample;
import com.zjingwen.szptcoins.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void add(User u) {
        userMapper.insert(u);
    }

    @Override
    public void delete(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(User c) {
        userMapper.updateByPrimaryKeySelective(c);
    }

    @Override
    public User get(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User get(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> result = userMapper.selectByExample(example);
        if (!result.isEmpty()) {
            return result.get(0);
        }
        return null;
    }

    @Override
    public User get(String username, String password) {
        UserExample example = new UserExample();
        example.createCriteria()
                .andUsernameEqualTo(username)
                .andPasswordEqualTo(password);
        List<User> result = userMapper.selectByExample(example);
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    @Override
    public boolean isExist(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> result = userMapper.selectByExample(example);
        if (!result.isEmpty()) {
            return true;
        }
        return false;
    }
}
