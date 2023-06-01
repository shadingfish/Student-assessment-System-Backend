package com.babybus.stu.eval.mapper.user;

import com.babybus.stu.eval.model.user.Faculty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FacultyMapper {
    Integer insertFaculty(Faculty faculty);
    List<Faculty> getFacultyList();
    Faculty getFacultyById(@Param("userId") Integer userId);
    Faculty getFacultyByCardId(String cardId);
    Integer updateFaculty(Faculty faculty);
    Integer deleteFacultyById(Integer userId);
}
