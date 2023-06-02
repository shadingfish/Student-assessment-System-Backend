package com.babybus.wuqile.mapper;


import com.babybus.wuqile.model.StuSum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface StuSumMapper {
    List<StuSum> getAll();//评委：获取学生成绩总表信息
    List<StuSum> getByStuID(@Param("stu_id") int stu_id);//学生：获取自己的总表记录
}
