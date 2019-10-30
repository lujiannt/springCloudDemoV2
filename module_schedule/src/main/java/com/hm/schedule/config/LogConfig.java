package com.hm.schedule.config;

import com.hm.schedule.entity.ScheduleLog;
import com.hm.schedule.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogConfig {
    @Autowired
    private LogService logService;

    //开始时间戳
    private long start;

    @Pointcut("execution(public * com.hm.schedule.task..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        start = System.currentTimeMillis();
    }

    @After("webLog()")
    public void doAfter(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        JobExecutionContext context = (JobExecutionContext) args[0];

        ScheduleLog log = new ScheduleLog();
        log.setTaskClassName(context.getJobDetail().getJobClass().getName());
        log.setCreateTime(context.getFireTime());
        log.setResult(ScheduleLog.RESULT_SUCCESS);
        log.setCostTime(System.currentTimeMillis() - start);
        logService.addScheduleLog(log);
    }

    @AfterThrowing("webLog()")
    public void afterThrowing(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        JobExecutionContext context = (JobExecutionContext) args[0];
        ScheduleLog log = new ScheduleLog();
        log.setTaskClassName(context.getJobDetail().getJobClass().getName());
        log.setCreateTime(context.getFireTime());
        log.setResult(ScheduleLog.RESULT_FAILURE);
        log.setCostTime(System.currentTimeMillis() - start);
        logService.addScheduleLog(log);
    }

}