package com.hm.hmback.config.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * 开启权限控制
 */
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class PermissionConfig extends GlobalMethodSecurityConfiguration {
    @Autowired
    private MyPermissionEvaluator myPermissionEvaluator;

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(myPermissionEvaluator);
        return expressionHandler;
        //return super.createExpressionHandler();
    }


}