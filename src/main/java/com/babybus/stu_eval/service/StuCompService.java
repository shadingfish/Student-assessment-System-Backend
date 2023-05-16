package com.babybus.stu_eval.service;

import com.babybus.stu_eval.mapper.StuCompMapper;
import com.babybus.stu_eval.model.StuComp;

import java.util.List;

public class StuCompService {
    private StuCompMapper stucompmapper;
    public List<StuComp> findall(String name){
        return stucompmapper.getAllByName(name);
    }
    public void Insert(StuComp stucomp){
        stucompmapper.insert(stucomp);
    }
}
