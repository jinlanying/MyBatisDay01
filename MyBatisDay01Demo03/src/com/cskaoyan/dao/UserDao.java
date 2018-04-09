package com.cskaoyan.dao;

import com.cskaoyan.bean.Result;
import com.cskaoyan.bean.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface UserDao {
    User findUserById(int id) throws IOException;

    List<User> findUserByName(String username) throws IOException;

    void insertUser(User user) throws IOException;

    List<User> findPasswordByUsername(String username) throws IOException;

    User findUserByPasswordAndUsername(HashMap map) throws IOException;

    Result findUserById2(int id) throws IOException;

    List<User> findUserByNames(List<String> usernames);
    List<User> findUserByNames2(List<String> usernames);


}
