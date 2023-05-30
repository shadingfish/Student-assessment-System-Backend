package com.babybus.common.mapper;

import com.babybus.common.model.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LogMapper {
    Integer insertLog(Log log);
    List<Log> getLogList();
    Log getLogById(@Param("userId") Integer userId);
    Integer updateLog(Log log);
    Integer deleteLogById(Integer userId);
}
