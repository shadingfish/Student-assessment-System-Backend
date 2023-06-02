package com.babybus.wuqile.mapper;


import com.babybus.wuqile.model.StuComp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Mapper
@Repository
public interface StuCompMapper {
    void ViewerInsert(@RequestBody StuComp stuComp);//评委：根据材料id插入评审意见
    List<StuComp> getAll();//评委：返回所有竞赛获奖记录
    void deleteCom(@Param("mat_id") int mat_id);//学生：删除特定字段的竞赛记录
    void insertRecord(@RequestBody StuComp stuComp);//学生：增加/修改新的竞赛记录
    List<StuComp> getAllByStuID(@Param("stu_id")int stu_id);//学生：查询自身所有提交过的记录
}
