package com.hm.schedule.mapper;

import com.hm.schedule.entity.ScheduleJob;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobMapper {
    /**
     * 根据名称查询job
     *
     * @param name
     * @return
     */
    ScheduleJob selectJobByName(String name);

    /**
     * 列出所有job
     *
     * @return
     */
    List<ScheduleJob> selectJobs();

    /**
     * 插入job
     *
     * @param job
     * @return
     */
    int insertJob(ScheduleJob job);

    /**
     * 根据id查询job
     *
     * @param jobId
     * @return
     */
    ScheduleJob selectJobById(String jobId);

    /**
     * 更新任务
     *
     * @param job
     * @return
     */
    int updateJob(ScheduleJob job);

    /**
     * 更新任务状态为删除
     *
     * @param jobId
     * @return
     */
    int removeJob(String jobId);

    /**
     * 更新任务状态为暂停
     *
     * @param jobId
     * @return
     */
    int updateJobToPause(String jobId);

    /**
     * 更新任务状态为启用
     *
     * @param jobId
     * @return
     */
    int updateJobToEnable(String jobId);
}
