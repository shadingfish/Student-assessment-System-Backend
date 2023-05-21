package com.babybus.stu.eval.service.user;

import com.babybus.stu.eval.mapper.user.FacultyMapper;
import com.babybus.stu.eval.model.user.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    @Autowired
    private FacultyMapper facultyMapper;

    public Integer insertFaculty(Faculty faculty) {
        return facultyMapper.insertFaculty(faculty);
    }
    public List<Faculty> getFacultyList() {
        return facultyMapper.getFacultyList();
    }
    public Faculty getFacultyById(Integer userId) {
        return facultyMapper.getFacultyById(userId);
    }
    public Faculty getFacultyByCardId(String cardId) {
        return facultyMapper.getFacultyByCardId(cardId);
    }
    public Integer updateFaculty(Faculty faculty) {
        Faculty origin = getFacultyById(faculty.getUserId());

        if (origin == null) {
            return 0;
        }

        return facultyMapper.updateFaculty(faculty);
    }
    public Integer deleteFacultyById(Integer userId) {
        return facultyMapper.deleteFacultyById(userId);
    }
}
