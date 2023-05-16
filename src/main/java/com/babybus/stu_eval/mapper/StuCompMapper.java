package com.babybus.stu_eval.mapper;

import com.babybus.stu_eval.model.StuComp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuCompMapper {
    void insert(@Param("name") String name);//根据名字插入获奖记录
    List<StuComp> getAllByName(@Param("name") String name);//根据名字返回竞赛获奖记录
    void deleteCom(@Param("toString") String toString);//删除特定字段的竞赛记录


}
