package com.hm.schedule.service;

import com.hm.schedule.entity.ScheduleJob;

import java.util.List;

public interface JobService {
    /**
     * 根据任务名查询定时任务
     *
     * @param name
     * @return
     */
    ScheduleJob getScheduleJobByName(String name);

    /**
     * 查询所有定时任务
     *
     * @return
     */
    List<ScheduleJob> listScheduleJob();

    /**
     * 新增定时任务
     *
     * @param job
     * @return
     */
    boolean addJob(ScheduleJob job);

    /**
     * 暂停定时任务
     *
     * @param jobId
     * @return
     */
    boolean pauseJob(String jobId);

    /**
     * 恢复定时任务
     *
     * @param jobId
     * @return
     */
    boolean resumejob(String jobId);

    /**
     * 更新任务
     *
     * @param job
     * @return
     */
    boolean modifyJob(ScheduleJob job);

    /**
     * 禁用任务
     *
     * @param jobId
     * @return
     */
    boolean removeJob(String jobId);

    /**
     * 启用任务 【注意：此接口并不等于恢复任务接口，二者针对数据库不一样】
     *
     * @param jobId
     * @return
     */
    boolean enableJob(String jobId);
}
