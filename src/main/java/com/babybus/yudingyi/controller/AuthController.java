package com.babybus.yudingyi.controller;



import com.babybus.common.mapper.FacultyMapper;
import com.babybus.common.mapper.StudentMapper;
import com.babybus.common.model.CommonResult;
import com.babybus.common.model.user.Faculty;
import com.babybus.common.model.user.Student;
import com.babybus.yudingyi.model.VO.Auth.LoginReqVo;
import com.babybus.yudingyi.mapper.RoleMapper;
import com.babybus.yudingyi.mapper.UserMapper;
import com.babybus.yudingyi.model.User;
import com.babybus.yudingyi.model.VO.Auth.FacultyVO;
import com.babybus.yudingyi.model.VO.Auth.StudentVO;
import com.babybus.yudingyi.util.JwtTokenUtil;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;


@CrossOrigin(origins = "http://localhost:8888")
@RestController
@ResponseBody
@RequestMapping("/auth/")
public class AuthController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @CrossOrigin
    @GetMapping("/captcha")
    public void showCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 生成验证码文本
        String captchaText = defaultKaptcha.createText();


        // 将验证码文本存储在会话中，以供后续验证
        HttpSession session = request.getSession(true);
        session.setAttribute("captcha", captchaText);
        System.out.println("获得Session：" + session);
        System.out.println("保存验证码：" + session.getAttribute("captcha"));


        // 生成验证码图片
        BufferedImage captchaImage = defaultKaptcha.createImage(captchaText);

        // 将验证码图片写入响应
        response.setContentType("image/png");
        try (OutputStream outputStream = response.getOutputStream()) {
            ImageIO.write(captchaImage, "png", outputStream);
            outputStream.flush();
        }
    }
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
    public CommonResult<?> login(HttpServletRequest request, @RequestBody LoginReqVo loginReqVo) {
        HttpSession session = request.getSession(false);
        System.out.println("获得Session：" + session);
        String storedCaptcha = (String) session.getAttribute("captcha");
        System.out.println("Session中的验证码：" + storedCaptcha);
        System.out.println("获得登录请求体：" + loginReqVo);
        request.getSession().removeAttribute("captcha"); // 删除会话中的验证码
        String cardId = loginReqVo.getCardId();
        String captchaText = loginReqVo.getCaptchaText();

        if (captchaText.equalsIgnoreCase(storedCaptcha)){
            System.out.println("验证码正确，执行登录逻辑");
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

            return CommonResult.success(token, "登录成功，生成学号对应token。");

        }else{
            System.out.println("验证码错误，显示错误消息");
            return CommonResult.error(50003, "验证码错误。");
        }
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
