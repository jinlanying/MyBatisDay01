package com.cskaoyan.service.impl;

import com.cskaoyan.bean.User;
import com.cskaoyan.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cskaoyan.service.UserService;

import java.io.IOException;
import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;

    @Transactional  //使用事务的注解，当插入数据的时候要对service做事务管理
    @Override
    public User findUserByPasswordAndUsername(HashMap map) throws IOException {

        User user = dao.findUserByPasswordAndUsername(map);
        System.out.println("user: " + user);
        return user;
    }
}
