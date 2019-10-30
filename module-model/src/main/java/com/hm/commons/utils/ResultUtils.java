package com.hm.commons.utils;

import com.hm.commons.model.Result;

public class ResultUtils {
    /**
     * 通用-返回正确result
     *
     * @param result 返回的对象
     * @return
     */
    public static Result buidSuccessResult(Object result) {
        return new Result(Result.CODE_NORMAL, Result.STATUS_SUCCESS, null, result);
    }

    /**
     * 通用-返回错误result
     *
     * @param errMsg 错误信息
     * @return
     */
    public static Result buidFailureResult(String errMsg) {
        return new Result(Result.CODE_NORMAL, Result.STATUS_FAILURE, errMsg, null);
    }
}
