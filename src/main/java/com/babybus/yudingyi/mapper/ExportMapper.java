package com.babybus.yudingyi.mapper;

import com.babybus.yudingyi.model.DTO.Export.AllEvalView;
import com.babybus.yudingyi.model.DTO.Export.ExportEvalResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExportMapper {
    List<ExportEvalResult> exportTable(@Param("table_name") String table_name);
    List<AllEvalView> exportView();
}
