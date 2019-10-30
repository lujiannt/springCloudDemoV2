package com.hm.moduleuser.service.impl;

import com.hm.moduleuser.mapper.UserMapper;
import com.hm.moduleuser.service.UserService;
import com.hm.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByName(String userName) {
        return userMapper.selectUserByName(userName);
    }

    @Override
    public User findUserByNameAndPwd(String username, String password) {
        return userMapper.selectUserByNameAndPwd(username, password);
    }

    @Override
    public List<Integer> findRoleIdsByUserId(int userId) {
        return userMapper.selectRoleIdsByUserId(userId);
    }

    @Override
    public List<String> findUrlByRoleId(int roleId) {
        return userMapper.selectUrlByRoleId(roleId);
    }
}
