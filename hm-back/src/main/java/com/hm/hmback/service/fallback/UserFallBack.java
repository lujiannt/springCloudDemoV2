package com.hm.hmback.service.fallback;

import com.hm.commons.model.Result;
import com.hm.commons.utils.ResultUtils;
import com.hm.hmback.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserFallBack implements UserService {
    @Override
    public Result findUserByName(String userName) {
        return ResultUtils.buidFailureResult("unknow error");
    }

    @Override
    public Result findUserByNameAndPwd(String userName, String password) {
        return ResultUtils.buidFailureResult("unknow error");
    }

    @Override
    public Result findRoleIdsByUserId(int userId) {
        return ResultUtils.buidFailureResult("unknow error");
    }

    @Override
    public Result findUrlByRoleId(int roleId) {
        return ResultUtils.buidFailureResult("unknow error");
    }
}
