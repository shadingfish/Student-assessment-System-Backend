package com.babybus.stu.eval.yudingyi.service;

import com.babybus.stu.eval.yudingyi.mapper.ExportMapper;
import com.babybus.stu.eval.yudingyi.model.DTO.Export.AllEvalView;
import com.babybus.stu.eval.yudingyi.model.DTO.Export.ExportEvalResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExportService {
    @Autowired
    private ExportMapper exportMapper;

    public List<ExportEvalResult> exportTable(String table_name){
        return  exportMapper.exportTable(table_name);
    };

    public List<AllEvalView> exportView(){
        return exportMapper.exportView();
    }
}
