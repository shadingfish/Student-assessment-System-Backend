package com.babybus.stu.eval.service.evaluation;

import com.babybus.stu.eval.mapper.evaluation.ExportMapper;
import com.babybus.stu.eval.model.common.DTO.Export.AllEvalView;
import com.babybus.stu.eval.model.common.DTO.Export.ExportEvalResult;
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
