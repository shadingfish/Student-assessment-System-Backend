package com.babybus.common.service.material;

import com.babybus.common.mapper.StudentMapper;
import com.babybus.common.mapper.material.GpaMapper;
import com.babybus.common.model.material.Gpa;
import com.babybus.wanglingyu.convert.ImportConvert;
import com.babybus.wanglingyu.model.GpaImportExcel;
import com.babybus.wanglingyu.model.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GpaService {
    @Autowired
    private GpaMapper gpaMapper;

    @Autowired
    private StudentMapper studentMapper;


    public Integer insertGpa(Gpa gpa) {
        return gpaMapper.insertGpa(gpa);
    }
    public Gpa getGpaById(Integer gpaId) {
        return gpaMapper.getGpaById(gpaId);
    }
    public List<Gpa> getGpaList(Integer stuId) {
        return gpaMapper.getGpaList(stuId);
    }
    public Integer updateGpa(Gpa gpa) {
        return gpaMapper.updateGpa(gpa);
    }
    public Integer deleteGpaById(Integer gpaId) {
        return gpaMapper.deleteGpaById(gpaId);
    }

    public PageBean getPage(Integer page, Integer pageSize) {
        Long count = gpaMapper.countGpa();
        Integer start = (page - 1) * pageSize;
        List<Gpa> gpaList = gpaMapper.listGpaPage(start, pageSize);
        PageBean pageBean = new PageBean(count , gpaList);
        return pageBean;
    }

    public void importGpaList(List<GpaImportExcel> list) {

        list.forEach(gpaImportExcel -> {
            if (gpaImportExcel != null) {
                Gpa gpa = new Gpa();
                gpa.setCardId(gpaImportExcel.getCardId());
                gpa.setStuId(studentMapper.getStudentByCardId(gpaImportExcel.getCardId()).getId());
                gpa.setAcYear(gpaImportExcel.getAcYear());
                gpa.setGpa(Double.valueOf(gpaImportExcel.getGpa()));
                gpa.setRanking(Integer.valueOf(gpaImportExcel.getRanking()));
                gpa.setBase(Integer.valueOf(gpaImportExcel.getBase()));
                gpa.setConfirmStatus("未确认");

                gpaMapper.insertGpa(gpa);

            }
        });


    }
}
