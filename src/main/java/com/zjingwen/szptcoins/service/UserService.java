package com.zjingwen.szptcoins.service;

import com.zjingwen.szptcoins.pojo.User;

public interface UserService {

    void add(User u);

    void delete(int id);

    void update(User c);

    User get(int id);

    User get(String username);

    User get(String username, String password);

    boolean isExist(String username);


}
