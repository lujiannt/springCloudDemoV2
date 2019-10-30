package com.hm.hmback.controller;

import com.hm.commons.model.Result;
import com.hm.hmback.service.UserService;
import com.hm.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

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

    /**
     * admin 权限
     *
     * @return
     */

    @RequestMapping("/admin")
    @PreAuthorize("hasPermission('/user/admin','admin')")
    @ResponseBody
    public String admin() {
        return "ADMIN";
    }

    /**
     * LJ 权限
     *
     * @return
     */
    @RequestMapping("/lj")
    @PreAuthorize("hasPermission('/user/lj','lj')")
    @ResponseBody
    public String lj() {
        return "lj";
    }

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping("/openTologin")
    public String openTologin() {
        return "/user/login";
    }

    /**
     * feignDemo - 查找user模块的用户信息
     *
     * @return
     */
    @RequestMapping("/findUserByName")
    @ResponseBody
    public User findUserByName() {
        User user = null;
        Result result = userService.findUserByName("admin");
        if (result.getStatus().equals(Result.STATUS_SUCCESS)) {
            user = result.getResult(User.class);
        }
        return user;
    }

    /**
     * 跳转到用户信息页面
     *
     * @return
     */
    @RequestMapping("/openUserInfo")
    public String openUserInfo(Model model) {
        User user = null;
        Result result = userService.findUserByName("admin");
        if (result.getStatus().equals(Result.STATUS_SUCCESS)) {
            user = result.getResult(User.class);
        }

        model.addAttribute("user", user);
        return "/user/userInfo";
    }
}
