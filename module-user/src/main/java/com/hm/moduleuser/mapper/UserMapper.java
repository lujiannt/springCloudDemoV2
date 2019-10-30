package com.hm.moduleuser.mapper;

import com.hm.user.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    /**
     * 根据用户名称查找用户
     *
     * @param userName
     * @return
     */
    User selectUserByName(String userName);

    /**
     * 根据用户名密码查询用户
     *
     * @param username
     * @param password
     * @return
     */
    User selectUserByNameAndPwd(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户id查询用户角色
     * selectRoleByUserId
     *
     * @param userId
     * @return
     */
    List<Integer> selectRoleIdsByUserId(int userId);

    /**
     * 根据角色id查询url
     *
     * @param roleId
     * @return
     */
    List<String> selectUrlByRoleId(int roleId);
}
