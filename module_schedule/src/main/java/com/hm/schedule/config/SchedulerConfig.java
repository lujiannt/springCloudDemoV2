package com.hm.schedule.config;


import org.springframework.boot.autoconfigure.quartz.SchedulerFactoryBeanCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * schedule配置
 */
@Configuration
public class SchedulerConfig implements SchedulerFactoryBeanCustomizer {

    @Override
    public void customize(SchedulerFactoryBean schedulerFactoryBean) {
        //启动延迟时间
        schedulerFactoryBean.setStartupDelay(2);
        //服务器启动自动启用定时器
        schedulerFactoryBean.setAutoStartup(false);
        //开启动态更新定时器
        schedulerFactoryBean.setOverwriteExistingJobs(true);
    }
}