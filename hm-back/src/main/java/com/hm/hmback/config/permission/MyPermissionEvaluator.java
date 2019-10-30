package com.hm.hmback.config.permission;

import com.hm.commons.model.Result;
import com.hm.hmback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义权限过滤器
 */
@Configuration
public class MyPermissionEvaluator implements PermissionEvaluator {
    @Autowired
    private UserService userService;

    /**
     * 通过请求过来的url和数据库中的角色对应url来对应校验权限
     *
     * @param authentication
     * @param targetUrl
     * @param targetPermission
     * @return
     */
    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object targetPermission) {
        System.out.println("第一个hasPermission : targetUrl : " + targetUrl);
        System.out.println("第一个hasPermission : targetPermission : " + targetPermission);

        if (authentication.isAuthenticated()) {
            UserDetails user = (UserDetails) authentication.getPrincipal();
            //管理員
//            if (user.getUsername().equals("admin")) {
//                return true;
//            }

            // 遍历用户所有角色
            for (GrantedAuthority authority : user.getAuthorities()) {
                String roleId = authority.getAuthority();
                // 得到角色所有的url权限indRoleIdsByUserId()
                List<String> urls = null;
                Result result = userService.findUrlByRoleId(Integer.parseInt(roleId));
                if (result.getStatus().equals(Result.STATUS_SUCCESS)) {
                    urls = (List<String>) result.getResult();

                    // 遍历permissionList
                    for (String resource : urls) {
                        // 如果访问的Url和权限用户符合的话，返回true
                        if (targetUrl.equals(resource)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object targetPermission) {
        System.out.println("第二个hasPermission： targetId=" + targetId);
        System.out.println("第二个hasPermission： targetType=" + targetType);
        System.out.println("第二个hasPermission： targetPermission=" + targetPermission);
        return false;
    }
}
