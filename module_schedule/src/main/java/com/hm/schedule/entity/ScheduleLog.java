package com.hm.schedule.entity;

import java.util.Date;

/**
 * 定时任务日志
 */
public class ScheduleLog {
    /**
     * 任务结果-成功
     */
    public static final String RESULT_SUCCESS = "SUCCESS";
    /**
     * 任务结果-失败
     */
    public static final String RESULT_FAILURE = "FAILURE";

    /**
     * 名称
     */
    private String triggerName;
    /**
     * 任务类名
     */
    private String taskClassName;
    /**
     * 执行日期
     */
    private Date createTime;
    /**
     * 备注
     */
    private String remark;
    /**
     * 操作耗时(毫秒级别)
     */
    private long costTime;
    /**
     * 任务结果
     */
    private String result;

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTaskClassName() {
        return taskClassName;
    }

    public void setTaskClassName(String taskClassName) {
        this.taskClassName = taskClassName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public long getCostTime() {
        return costTime;
    }

    public void setCostTime(long costTime) {
        this.costTime = costTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
