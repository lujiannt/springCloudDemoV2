package com.hm.schedule.controller;

import com.hm.schedule.entity.ScheduleJob;
import com.hm.schedule.service.JobService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/job")
public class JobController {
    @Autowired
    private JobService jobService;

    /**
     * 新增定时任务
     *
     * @param job
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public boolean addJob(ScheduleJob job) {
        boolean flag = false;
        try {
            flag = jobService.addJob(job);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return flag;
        }
    }

    /**
     * 暂停任务
     *
     * @param jobId 任务id
     * @return
     */
    @RequestMapping(value = "/pause")
    @ResponseBody
    public boolean pauseJob(String jobId) {
        boolean flag = false;
        try {
            flag = jobService.pauseJob(jobId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return flag;
        }
    }

    /**
     * 恢复任务
     *
     * @param jobId 任务id
     * @return
     */
    @RequestMapping(value = "/resume")
    @ResponseBody
    public boolean resumeJob(String jobId) {
        boolean flag = false;
        try {
            flag = jobService.resumejob(jobId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return flag;
        }
    }

    /**
     * 更新任务
     *
     * @param job
     * @return
     */
    @RequestMapping(value = "/modify")
    @ResponseBody
    public boolean modify(ScheduleJob job) {
        boolean flag = false;
        try {
            if (StringUtils.isNotBlank(job.getJobId())) {
                flag = jobService.modifyJob(job);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return flag;
        }
    }

    /**
     * 禁用任务 【注意】逻辑删除
     *
     * @param jobId 任务id
     * @return
     */
    @RequestMapping(value = "/remove")
    @ResponseBody
    public boolean removeJob(String jobId) {
        boolean flag = false;
        try {
            flag = jobService.removeJob(jobId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return flag;
        }
    }

    /**
     * 重新启用任务
     *
     * @param jobId 任务id
     * @return
     */
    @RequestMapping(value = "/enable")
    @ResponseBody
    public boolean enableJob(String jobId) {
        boolean flag = false;
        try {
            flag = jobService.enableJob(jobId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return flag;
        }
    }
}

