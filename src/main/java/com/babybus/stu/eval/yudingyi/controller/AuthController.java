package com.babybus.stu.eval.yudingyi.controller;


import com.babybus.stu.eval.mapper.user.FacultyMapper;
import com.babybus.stu.eval.mapper.user.StudentMapper;
import com.babybus.stu.eval.model.common.CommonResult;
import com.babybus.stu.eval.model.common.VO.LoginReqVo;
import com.babybus.stu.eval.model.user.Faculty;
import com.babybus.stu.eval.model.user.Student;
import com.babybus.stu.eval.yudingyi.mapper.RoleMapper;
import com.babybus.stu.eval.yudingyi.mapper.UserMapper;
import com.babybus.stu.eval.yudingyi.model.User;
import com.babybus.stu.eval.yudingyi.model.VO.FacultyVO;
import com.babybus.stu.eval.yudingyi.model.VO.StudentVO;
import com.babybus.stu.eval.yudingyi.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@ResponseBody
@RequestMapping("/auth/")
public class AuthController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    FacultyMapper facultyMapper;

    @CrossOrigin
    @PostMapping("/login")
    public CommonResult<?> login(@RequestBody LoginReqVo loginReqVo) {
        System.out.println(loginReqVo);
        String cardId = loginReqVo.getCardId();

        User user = userMapper.getUserByCardId(cardId);

        if (user == null) {
            System.out.println("未找到用户");
            return CommonResult.error(50007,"登录失败，账号密码不正确");
        }

        System.out.println("找到的用户为：" + user);

        if (!loginReqVo.getPassword().equals(user.getPassword())) {
            System.out.println("登录失败，账号密码不正确");
            return CommonResult.error(50007,"登录失败，账号密码不正确");
        }

        System.out.println("登录成功");
        String token = jwtTokenUtil.generateAccessToken(cardId);

//        // 生成访问令牌和刷新令牌
//        String accessToken = jwtTokenUtil.generateAccessToken(cardId);
//        String refreshToken = jwtTokenUtil.generateRefreshToken(cardId);
//        TokenResponse token_resp = new TokenResponse(accessToken,refreshToken);

//        BigInteger user_id = user.getId();
//        System.out.println("角色ID: " + user_id);
//        List<RoleNodeUrl> roleNodeUrlList = userMapper.findRole(user_id);
//        System.out.println("角色权限表: \n" + roleNodeUrlList);
//
//        String userKey = user_id.toString();
////        redisService.deleteValue(userKey);
//        if(!redisService.isValidToken(userKey)){
//            Set<String> permissionUrls = new HashSet<>();
//            for (RoleNodeUrl roleNodeUrl : roleNodeUrlList) {
//                permissionUrls.add(roleNodeUrl.getUrl());
//            }
//            for (String permissionUrl : permissionUrls) {
//                redisService.rpush(userKey, permissionUrl);
//            }
//            System.out.print("初始化Redis信息，");
//        }else{
//            System.out.print("Redis已初始化信息，");
//        }
//        System.out.println("Redis权限表：" + redisService.getListValues(userKey));
//
//        Object[] data = {"用户ID: " + user.getId(), "权限表: " , roleNodeUrlList};
//
//        CommonResult<Object[]> result = CommonResult.success(data);

        return CommonResult.success(token, "登录成功，生成学号对应token。");
    }

    @CrossOrigin
    @PostMapping("/studentRegister")
    public CommonResult<?> studentRegister(@RequestBody StudentVO studentVO) {

        System.out.println("接收到前端VO: " + studentVO.toString() + "。 开始查找用户");
        Student foundUser = studentMapper.getStudentByCardId(studentVO.getCardId());
        System.out.println(foundUser);

        if (foundUser != null) {
            System.out.println("获取到用户" + foundUser);
            return CommonResult.error(50003,"用户已存在");
        }

        System.out.println("用户不存在可以注册。");

        Student student = new Student(0, studentVO.getCardId(), studentVO.getName(), studentVO.getRole(), 1, studentVO.getPassword(), "正常", studentVO.getBirthday(), studentVO.getGender(), studentVO.getPhone(), studentVO.getEmail(), studentVO.getSchool(), Integer.parseInt(studentVO.getGrade()), studentVO.getStuClass(), studentVO.getMajor());

        try{
            // 将用户信息保存到数据库
            studentMapper.insertStudent(student);
            userMapper.insertUser(new User(0, studentVO.getCardId(), studentVO.getPassword(), 1));
        }catch (Exception e) {
            // 处理插入失败的情况
            System.out.println(e.getMessage());
            System.out.println("用户注册失败。");
            return CommonResult.error(50003,"User registration failed");
        }

        System.out.println("用户注册成功。");
        return CommonResult.success(student, "User registered successfully");
    }

    @CrossOrigin
    @PostMapping("/facultyRegister")
    public CommonResult<?> facultyRegister(@RequestBody FacultyVO facultyVO) {

        System.out.println("接收到前端VO: " + facultyVO.toString() + "。 开始查找用户");
        Faculty foundUser = facultyMapper.getFacultyByCardId(facultyVO.getCardId());

        if (foundUser != null) {
            return CommonResult.error(50003,"用户已存在");
        }

        int roleId = roleMapper.getIdByRole(facultyVO.getRole());
        System.out.println("角色ID为" + roleId);

        Faculty faculty = new Faculty(0, facultyVO.getCardId(), facultyVO.getName(), facultyVO.getRole(), roleId, facultyVO.getPassword(), "正常", facultyVO.getBirthday(), facultyVO.getGender(), facultyVO.getPhone(), facultyVO.getEmail(), facultyVO.getDepart(), facultyVO.getJob());

        try{
            // 将用户信息保存到数据库
            facultyMapper.insertFaculty(faculty);
            userMapper.insertUser(new User(0, facultyVO.getCardId(), facultyVO.getPassword(), roleId));
        }catch (Exception e) {
            // 处理插入失败的情况
            System.out.println(e.toString());
            return CommonResult.error(50003,"User registration failed");
        }
        return CommonResult.success(faculty, "User registered successfully");
    }

}
