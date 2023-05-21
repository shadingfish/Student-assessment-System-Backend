package com.babybus.stu.eval.service.material;

import com.babybus.stu.eval.mapper.material.GpaMapper;
import com.babybus.stu.eval.model.material.Gpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GpaService {
    @Autowired
    private GpaMapper gpaMapper;

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
}
