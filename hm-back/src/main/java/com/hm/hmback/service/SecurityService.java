package com.hm.hmback.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface SecurityService {
    /**
     * 根据用户名密码查询用户信息
     *
     * @param username
     * @param password
     * @return
     */
    UserDetails findUserByNameAndPwd(String username, String password);
}
