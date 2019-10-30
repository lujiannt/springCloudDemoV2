package com.example.webtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@CrossOrigin
@RequestMapping("/user")
public class UserController {


    /**
     * 跳转到用户信息页面
     *
     * @return
     */
    @RequestMapping("/login2")
    @ResponseBody
    public String login2(String username, String password) {
        System.out.println("username is " + username);
        System.out.println("password is " + password);
        return "SUCCESS";
    }


}
