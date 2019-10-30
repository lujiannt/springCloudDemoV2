package com.hm.commons.model;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class Result implements Serializable {
    /**
     * 状态码-正常-200
     */
    public final static int CODE_NORMAL = 200;

    /**
     * 结果-成功
     */
    public final static String STATUS_SUCCESS = "SUCCESS";
    /**
     * 结果-失败
     */
    public final static String STATUS_FAILURE = "FAILURE";

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 结果
     */
    private String status;
    /**
     * 消息
     */
    private String massege;
    /**
     * 数据对象
     */
    private Object result;

    /**
     * 无参构造器
     */
    public Result() {
        super();
    }

    /**
     * 返回全部信息即状态，状态码，消息，数据对象
     *
     * @param code
     * @param status
     * @param massege
     * @param result
     */
    public Result(Integer code, String status, String massege, Object result) {
        this.code = code;
        this.status = status;
        this.massege = massege;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMassege() {
        return massege;
    }

    public void setMassege(String massege) {
        this.massege = massege;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * 返回实体对象
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getResult(Class<T> clazz) {
        String jsonStr = JSONObject.toJSONString(result);
        return JSONObject.parseObject(jsonStr, clazz);
    }

}
