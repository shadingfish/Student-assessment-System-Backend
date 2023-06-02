package com.babybus.yudingyi.service;

import com.babybus.yudingyi.mapper.ExportMapper;
import com.babybus.yudingyi.model.DTO.Export.AllEvalView;
import com.babybus.yudingyi.model.DTO.Export.ExportEvalResult;
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
