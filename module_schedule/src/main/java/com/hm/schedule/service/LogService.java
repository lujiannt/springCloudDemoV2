package com.hm.schedule.service;

import com.hm.schedule.entity.ScheduleLog;

public interface LogService {
    /**
     * 新增日志
     *
     * @param log
     * @return
     */
    int addScheduleLog(ScheduleLog log);
}
