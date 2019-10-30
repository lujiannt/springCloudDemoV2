package com.hm.schedule.service.serviceImpl;

import com.hm.schedule.entity.ScheduleLog;
import com.hm.schedule.mapper.LogMapper;
import com.hm.schedule.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("logService")
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public int addScheduleLog(ScheduleLog log) {
        return logMapper.insertLog(log);
    }
}
