package com.babybus.common.mapper;

import com.babybus.common.model.user.Faculty;
import com.babybus.common.model.user.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FacultyMapper {
    Integer insertFaculty(Faculty faculty);
    List<Faculty> getFacultyList();
    Faculty getFacultyById(@Param("userId") Integer userId);
    Faculty getFacultyByCardId(String cardId);
    List<Faculty> getFacultyByRole(String role);
    Integer updateFaculty(Faculty faculty);
    Integer deleteFacultyById(Integer userId);

//    @Select("select * from faculties limit #{start}, #{pageSize}")
    List<Faculty> listFacultyPage(Integer start, Integer pageSize);

//    @Select("select count(*) from faculties")
    Long countFaculty();
}
