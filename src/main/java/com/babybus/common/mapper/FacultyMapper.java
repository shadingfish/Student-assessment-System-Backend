package com.babybus.common.mapper;

import com.babybus.common.model.user.Faculty;
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
