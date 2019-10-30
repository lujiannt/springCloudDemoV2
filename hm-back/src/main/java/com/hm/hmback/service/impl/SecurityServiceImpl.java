package com.hm.hmback.service.impl;

import com.hm.commons.model.Result;
import com.hm.hmback.service.SecurityService;
import com.hm.hmback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("securityService")
public class SecurityServiceImpl implements SecurityService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails findUserByNameAndPwd(String username, String password) {
        Result result_user = userService.findUserByNameAndPwd(username, password);
        com.hm.user.model.User user = null;
        if (result_user.getStatus().equals(Result.STATUS_SUCCESS)) {
            user = result_user.getResult(com.hm.user.model.User.class);
        }

        if (user == null) {
            throw new RuntimeException("user is null");
        }

        // 添加角色
        List<Integer> roleIds = null;
        List<GrantedAuthority> authorities = new ArrayList<>();

        Result result_role = userService.findRoleIdsByUserId(user.getId());
        if (result_role.getStatus().equals(Result.STATUS_SUCCESS)) {
            roleIds = (List<Integer>) result_role.getResult();

            for (int i = 0; i < roleIds.size(); i++) {
                Integer roleId = roleIds.get(i);
                authorities.add(new SimpleGrantedAuthority(String.valueOf(roleId)));
            }
        }

        User myUser = new User(user.getUserName(), user.getPassword(), authorities);
        return myUser;
    }

}
