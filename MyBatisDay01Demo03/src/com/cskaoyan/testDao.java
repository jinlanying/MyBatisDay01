package com.cskaoyan;

import com.cskaoyan.bean.Result;
import com.cskaoyan.bean.User;
import com.cskaoyan.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class testDao {


    @Autowired
    UserDao userDao;

    @Before
    public void before() throws IOException {

    }
    @After
    public void after(){

    }

    @Test
    public void DaoTest01() throws IOException {
        User userById = userDao.findUserById(7);
        
        System.out.println("user: " +userById);
    }

    @Test
    public void DaoTest02() throws IOException {
        List<User> userByName = userDao.findUserByName("%a%");
        System.out.println("userByName: " +userByName);
    }

    @Test
    public void DaoTest03() throws IOException {

        User user = new User();
        user.setUsername("mmm");
        user.setPassword("666");
        user.setEmail("vvv@cskaoyan.com");
        userDao.insertUser(user);

    }

    @Test
    public void DaoTest04() throws IOException {
        HashMap<String,String> parameter = new HashMap<>();
        parameter.put("username","bb");
        parameter.put("password","234");

        User userById = userDao.findUserByPasswordAndUsername(parameter);
        System.out.println("user: " +userById);
    }

    @Test
    public void DaoTest05() throws IOException {
        Result userById = userDao.findUserById2(7);
        System.out.println("user: " +userById);
    }

    @Test
    public void DaoTest06() throws IOException {
        List<String> usernames = new ArrayList<String>();
        usernames.add("aaa");
        usernames.add("bb");
        List<User> userByName = userDao.findUserByNames(usernames);
        System.out.println("userByName: " +userByName);
    }

    @Test
    public void DaoTest07() throws IOException {
        List<String> usernames = new ArrayList<String>();
        usernames.add("aaa");
        usernames.add("bb");
        usernames.add("cc");

        List<User> userByName = userDao.findUserByNames2(usernames);
        System.out.println("userByName: " +userByName);
    }

}
