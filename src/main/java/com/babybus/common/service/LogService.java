package com.babybus.common.service;

import com.babybus.common.mapper.LogMapper;
import com.babybus.common.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    @Autowired
    private LogMapper logMapper;

    public Integer insertLog(Log log) {
        return logMapper.insertLog(log);
    }
    public List<Log> getLogList() {
        return logMapper.getLogList();
    }
    public Log getLogById(Integer userId) {
        return logMapper.getLogById(userId);
    }
    public Integer updateLog(Log log) {
        Log origin = getLogById(log.getUserId());

        if (origin == null) {
            return 0;
        }

        return logMapper.updateLog(log);
    }
    public Integer deleteLogById(Integer userId) {
        return logMapper.deleteLogById(userId);
    }
}
