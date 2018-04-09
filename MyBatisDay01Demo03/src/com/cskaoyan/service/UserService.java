package com.cskaoyan.service;

import com.cskaoyan.bean.User;

import java.io.IOException;
import java.util.HashMap;

public interface UserService {

    User findUserByPasswordAndUsername(HashMap map) throws IOException;

}
