package com.babybus.common.service;

import com.babybus.common.mapper.FacultyMapper;
import com.babybus.common.model.user.Faculty;
import com.babybus.wanglingyu.convert.ImportConvert;
import com.babybus.wanglingyu.mapper.RoleUserMapper;
import com.babybus.wanglingyu.model.FacultyImportExcel;
import com.babybus.wanglingyu.model.PageBean;
import com.babybus.yudingyi.mapper.UserMapper;
import com.babybus.yudingyi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    @Autowired
    private FacultyMapper facultyMapper;
    @Autowired
    private RoleUserMapper roleUserMapper;

    @Autowired
    private UserMapper userMapper;

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

    public PageBean getPage(Integer page, Integer pageSize) {
        Long count = facultyMapper.countFaculty();
        Integer start = (page - 1) * pageSize;
        List<Faculty> facultyList = facultyMapper.listFacultyPage(start, pageSize);
        PageBean pageBean = new PageBean(count , facultyList);
        return pageBean;
    }

    public void importFacultyList(List<FacultyImportExcel> list) {

        list.forEach(facultyImportExcel -> {
            if (facultyImportExcel != null) {
                Faculty faculty = ImportConvert.excel2faculty(facultyImportExcel);
                facultyMapper.insertFaculty(faculty);

                User user = new User();
                user.setCardId(faculty.getCardId());
                user.setPassword(faculty.getPassword());
                user.setRoleId(faculty.getRoleId());
                userMapper.insertUser(user);

                roleUserMapper.insertRoleUser(faculty.getRoleId(), faculty.getCardId());
            }
        });


    }
}
