package com.hm.moduleuser.service;

import com.hm.user.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    /**
     * 根据用户名称查找用户
     *
     * @param userName
     * @return
     */
    User findUserByName(String userName);

    /**
     * 根据用户名密码查询用户
     *
     * @param username
     * @param password
     * @return
     */
    User findUserByNameAndPwd(String username, String password);

    /**
     * 根据用户id查询用户角色
     *
     * @param userId
     * @return
     */
    List<Integer> findRoleIdsByUserId(int userId);

    /**
     * 根据角色id查询对应url
     *
     * @param roleId
     * @return
     */
    List<String> findUrlByRoleId(int roleId);
}
