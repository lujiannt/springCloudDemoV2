package com.hm.schedule.mapper;

import com.hm.schedule.entity.ScheduleLog;
import org.springframework.stereotype.Repository;

@Repository
public interface LogMapper {
    int insertLog(ScheduleLog log);
}
