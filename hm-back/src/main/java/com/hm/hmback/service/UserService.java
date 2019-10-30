package com.hm.hmback.service;

import com.hm.commons.model.Result;
import com.hm.hmback.service.fallback.UserFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service("userService")
@FeignClient(value = "module-user", fallback = UserFallBack.class)
public interface UserService {

    /**
     * 根据用户名称查找用户
     *
     * @param userName
     * @return
     */
    @RequestMapping("/user/findUserByName")
    Result findUserByName(@RequestParam("userName") String userName);

    /**
     * 根据用户名密码查询用户
     *
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("/user/findUserByNameAndPwd")
    Result findUserByNameAndPwd(@RequestParam("username") String userName, @RequestParam("password") String password);

    /**
     * 根据用户id查询用户角色
     *
     * @param userId
     * @return
     */
    @RequestMapping("/user/findRoleIdsByUserId")
    Result findRoleIdsByUserId(@RequestParam("userId") int userId);

    /**
     * 根据角色id查询对应url
     *
     * @param roleId
     * @return
     */
    @RequestMapping("/user/findUrlByRoleId")
    Result findUrlByRoleId(@RequestParam("roleId") int roleId);
}
