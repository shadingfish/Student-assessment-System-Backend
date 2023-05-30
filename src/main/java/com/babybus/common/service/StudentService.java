package com.babybus.common.service;


import com.babybus.common.mapper.StudentMapper;
import com.babybus.common.model.user.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public Integer insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }
    public List<Student> getStudentList() {
        return studentMapper.getStudentList();
    }
    public Student getStudentById(Integer userId) {
        return studentMapper.getStudentById(userId);
    }
    public Student getStudentByCardId(String cardId) {
        return studentMapper.getStudentByCardId(cardId);
    }
    public Integer updateStudent(Student student) {
        Student origin = getStudentById(student.getId());

        if (origin == null) {
            return 0;
        }

        return studentMapper.updateStudent(student);
    }
    public Integer deleteStudentById(Integer userId) {
        return studentMapper.deleteStudentById(userId);
    }
}
