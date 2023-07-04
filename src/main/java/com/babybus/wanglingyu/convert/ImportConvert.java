package com.babybus.wanglingyu.convert;

import com.babybus.common.model.EvalResult;
import com.babybus.common.model.material.Gpa;
import com.babybus.common.model.user.Faculty;
import com.babybus.common.model.user.Student;
import com.babybus.wanglingyu.model.FacultyImportExcel;
import com.babybus.wanglingyu.model.GpaImportExcel;
import com.babybus.wanglingyu.model.StudentImportExcel;
import com.babybus.yudingyi.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ImportConvert {
    @Autowired
    RoleMapper roleMapper;
    public static Student excel2student(StudentImportExcel studentImportExcel) {
        Student student = new Student();
        student.setCardId(studentImportExcel.getCardId());
        student.setName(studentImportExcel.getName());

        student.setSchool(studentImportExcel.getSchool());
        student.setGrade(Integer.valueOf(studentImportExcel.getGrade()));
        student.setClas(studentImportExcel.getClas());
        student.setMajor(studentImportExcel.getMajor());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            student.setBirthday(dateFormat.parse(studentImportExcel.getBirthday()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        student.setGender(studentImportExcel.getGender());
        student.setPhone(studentImportExcel.getPhone());
        student.setEmail(studentImportExcel.getEmail());

        student.setRoleId(1);
        student.setRole("学生");

        return student;
    }

    public static Faculty excel2faculty(FacultyImportExcel facultyImportExcel) {
        Faculty faculty = new Faculty();
        faculty.setCardId(facultyImportExcel.getCardId());
        faculty.setName(facultyImportExcel.getName());
        faculty.setRole(facultyImportExcel.getRole());
        faculty.setRoleId(Integer.valueOf(facultyImportExcel.getRole()));


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            faculty.setBirthday(dateFormat.parse(facultyImportExcel.getBirthday()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        faculty.setGender(facultyImportExcel.getGender());
        faculty.setPhone(facultyImportExcel.getPhone());
        faculty.setEmail(facultyImportExcel.getEmail());


        faculty.setDepart(facultyImportExcel.getDepart());
        faculty.setJob(facultyImportExcel.getJob());

        return faculty;
    }

    public static Gpa excel2gpa(GpaImportExcel gpaImportExcel) {
        Gpa gpa = new Gpa();
        gpa.setAcYear(gpaImportExcel.getAcYear());
        gpa.setGpa(Double.valueOf(gpaImportExcel.getGpa()));
        gpa.setRanking(Integer.valueOf(gpaImportExcel.getRanking()));
        gpa.setBase(Integer.valueOf(gpaImportExcel.getBase()));
        return gpa;
    }

    public static EvalResult excel2result(StudentImportExcel excel) {
        EvalResult evalResult = new EvalResult();
        evalResult.setCardId(excel.getCardId());
        evalResult.setAcYear(excel.getAcYear());
        evalResult.setScholarship(excel.getScholarship());
        return evalResult;
    }


}