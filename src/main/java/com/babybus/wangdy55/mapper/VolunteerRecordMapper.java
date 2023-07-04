package com.babybus.wangdy55.mapper;

import com.babybus.wangdy55.model.DTO.EvalRecordDto;
import com.babybus.wangdy55.model.DTO.VolunteerRecordDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VolunteerRecordMapper {
    List<VolunteerRecordDto> getVolunteerRecordList();
    Integer updateVolunteerRecord(@Param("record") EvalRecordDto record);
}
