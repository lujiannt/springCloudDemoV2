package com.hm.moduleuser.controller;

import com.hm.commons.model.Result;
import com.hm.commons.utils.ResultUtils;
import com.hm.moduleuser.service.UserService;
import com.hm.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 根据用户名查找用户 -- Test
     *
     * @param userName
     * @return
     */
    @RequestMapping("/findUserByName")
    @ResponseBody
    public Result findUserByName(@RequestParam("userName") String userName) {
        Result result = null;
        User user = userService.findUserByName(userName);
        if (user != null) {
            result = ResultUtils.buidSuccessResult(user);
        } else {
            result = ResultUtils.buidFailureResult("未找到user");
        }
        return result;
    }

    /**
     * 根据用户名密码查找用户
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/findUserByNameAndPwd")
    @ResponseBody
    public Result findUserByNameAndPwd(String username, String password) {
        Result result = null;
        User user = userService.findUserByNameAndPwd(username, password);
        if (user != null) {
            result = ResultUtils.buidSuccessResult(user);
        } else {
            result = ResultUtils.buidFailureResult("未找到user");
        }
        return result;
    }

    /**
     * 根据用户id查询用户角色Id
     *
     * @param userId
     * @return
     */
    @RequestMapping("/findRoleIdsByUserId")
    @ResponseBody
    public Result findRoleByUserId(@RequestParam("userId") int userId) {
        Result result = null;
        List<Integer> roleIds = userService.findRoleIdsByUserId(userId);
        if (roleIds != null) {
            result = ResultUtils.buidSuccessResult(roleIds);
        } else {
            result = ResultUtils.buidFailureResult("未找到");
        }
        return result;
    }

    /**
     * @param roleId
     * @return
     */
    @RequestMapping("/findUrlByRoleId")
    @ResponseBody
    public Result findUrlByRoleId(@RequestParam("roleId") int roleId) {
        Result result = null;
        List<String> urls = userService.findUrlByRoleId(roleId);
        if (urls != null) {
            result = ResultUtils.buidSuccessResult(urls);
        } else {
            result = ResultUtils.buidFailureResult("未找到");
        }
        return result;
    }
}
