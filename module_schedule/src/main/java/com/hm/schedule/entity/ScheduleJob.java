package com.hm.schedule.entity;


/**
 * 定时任务
 */
public class ScheduleJob {
    /**
     * 状态-禁用
     */
    public final static String STATUS_DISABLE = "0";
    /**
     * 状态-启用
     */
    public final static String STATUS_NORMAL = "1";
    /**
     * 状态-暂停
     */
    public final static String STATUS_PAUSE = "2";

    /**
     * 任务ID
     */
    private String jobId;
    /**
     * 任务名称
     */
    private String jobName;
    /**
     * 任务分组
     */
    private String jobGroup;
    /**
     * 任务状态 0禁用 1启用 2删除
     */
    private String jobStatus;
    /**
     * 任务运行时间表达式
     */
    private String cronExpression;
    /**
     * 任务描述
     */
    private String description;
    /**
     * 任务类
     */
    private String targetTask;
    /**
     * 是否并发 0禁用 1启用
     */
    private String concurrent;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTargetTask() {
        return targetTask;
    }

    public void setTargetTask(String targetTask) {
        this.targetTask = targetTask;
    }

    public String getConcurrent() {
        return concurrent;
    }

    public void setConcurrent(String concurrent) {
        this.concurrent = concurrent;
    }
}
