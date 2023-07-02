package com.babybus.common.service;

import com.babybus.common.mapper.FacultyMapper;
import com.babybus.common.model.user.Faculty;
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
        Faculty origin = getFacultyById(faculty.getId());

        if (origin == null) {
            return 0;
        }

        return facultyMapper.updateFaculty(faculty);
    }
    public Integer deleteFacultyById(Integer userId) {
        return facultyMapper.deleteFacultyById(userId);
    }
    public List<Faculty> getFacultyByRole(String role) {
        return facultyMapper.getFacultyByRole(role);
    }
}
