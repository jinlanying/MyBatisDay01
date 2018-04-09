package com.cskaoyan.controller;

import com.cskaoyan.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cskaoyan.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("login")
    public String login(HttpServletRequest request) throws IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(null != username &&null !=password && !username.isEmpty()&& !password.isEmpty()) {
            HashMap<String, String> login = new HashMap<>();
            login.put("username", username);
            login.put("password", password);


            User user = userService.findUserByPasswordAndUsername(login);

            if (user != null && password.equals(user.getPassword())) {
                request.getSession().setAttribute("user", user);
                return "redirect: user.jsp";
            }
            return "登陆异常,输入信息错误，请重新登陆";
        }else {
            return "输入信息不完整，请重新登陆";
        }

    }

}
