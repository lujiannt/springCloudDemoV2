package com.hm.hmback.config;

import com.hm.hmback.config.handler.LoginFailHandler;
import com.hm.hmback.config.handler.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * 动态从数据库校验用户
 */

@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityServerConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private LoginFailHandler loginFailHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/login", "/logout", "/403")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                //配置登出
                .logout()
                .logoutUrl("/logout")
                .and()
                //自定义登录页面
                .formLogin()
                .loginPage("http://localhost:8080/#/login")
//                .loginPage("/user/openTologin")
                .loginProcessingUrl("/login")
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailHandler)
                .permitAll()
                .and()
                .logout().logoutUrl("/logout").permitAll()
                .and()
                .headers().frameOptions().sameOrigin();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("auth configure");
        //启用自定义登录处理器，动态从数据库比对用户名密码并返回UserDetails给Security
        auth.authenticationProvider(new MySecurityAuthProvider());
    }

    /**
     * 密码编码
     *
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /**
     * 注入AuthenticationManager
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }
}
