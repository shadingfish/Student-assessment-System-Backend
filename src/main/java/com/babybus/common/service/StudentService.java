package com.babybus.common.service;

import com.babybus.common.mapper.EvalResultMapper;
import com.babybus.common.mapper.StudentMapper;
import com.babybus.common.model.EvalResult;
import com.babybus.common.model.user.Student;
import com.babybus.wanglingyu.convert.ImportConvert;
import com.babybus.wanglingyu.mapper.RoleUserMapper;
import com.babybus.wanglingyu.model.PageBean;
import com.babybus.wanglingyu.model.StudentImportExcel;
import com.babybus.yudingyi.mapper.UserMapper;
import com.babybus.yudingyi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EvalResultMapper evalResultMapper;
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

    public PageBean getPage(Integer page, Integer pageSize) {
        Long count = studentMapper.countStudent();
        Integer start = (page - 1) * pageSize;

        List<Student> studentList = studentMapper.listStudentPage(start, pageSize);
        PageBean pageBean = new PageBean(count , studentList);
        return pageBean;
    }

    public void importStudentList(List<StudentImportExcel> list) {

        list.forEach(studentImportExcel -> {
            if (studentImportExcel != null) {


                Student student = ImportConvert.excel2student(studentImportExcel);
                studentMapper.insertStudent(student);
                Integer studentId = student.getId();


                User user = new User();
                user.setCardId(student.getCardId());
                user.setPassword(student.getPassword());
                user.setRoleId(student.getRoleId());
                userMapper.insertUser(user);

                roleUserMapper.insertRoleUser(student.getRoleId(), student.getCardId());

                EvalResult evalResult = ImportConvert.excel2result(studentImportExcel);
                evalResult.setStuId(studentId);
                evalResultMapper.insertEvalResult(evalResult);

            }
        });

    }
}
