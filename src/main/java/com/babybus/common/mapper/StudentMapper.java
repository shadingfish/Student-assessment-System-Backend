package com.babybus.common.mapper;

import com.babybus.common.model.user.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    Integer insertStudent(Student student);
    List<Student> getStudentList();
    Student getStudentById(@Param("userId") Integer userId);
    Student getStudentByCardId(String cardId);
    Integer updateStudent(Student student);
    Integer deleteStudentById(Integer userId);
}
