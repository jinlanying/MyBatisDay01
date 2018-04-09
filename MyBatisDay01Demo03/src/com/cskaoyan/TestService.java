package com.cskaoyan;

import com.cskaoyan.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.cskaoyan.service.UserService;

import java.io.IOException;
import java.util.HashMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestService {

    @Autowired
    UserService userService;

    @Test
    public void test01() throws IOException {
        HashMap<String, String> login = new HashMap<>();
        login.put("username:", "bb");
        login.put("password:", "234");
        User user = userService.findUserByPasswordAndUsername(login);
        System.out.println("user: " + user);
    }

}
