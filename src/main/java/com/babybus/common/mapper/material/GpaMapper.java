package com.babybus.common.mapper.material;

import com.babybus.common.model.material.Gpa;
import com.babybus.common.model.user.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GpaMapper {
    Integer insertGpa(Gpa gpa); // 插入科研成果记录
    Gpa getGpaById(Integer gpaId); // 根据ID，获取一条科研成果记录
    List<Gpa> getGpaList(Integer stuId); // 根据学生ID，获取科研成果记录列表
    Integer updateGpa(Gpa gpa); // 根据学生ID更新对应科研成果记录
    Integer deleteGpaById(Integer gpaId); // 根据ID，删除对应科研成果记录

//    @Select("select * from gpas limit #{start}, #{pageSize}")
    List<Gpa> listGpaPage(Integer start, Integer pageSize);

//    @Select("select count(*) from gpas")
    Long countGpa();
}
