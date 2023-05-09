package com.babybus.stu_eval.controller;

import com.babybus.stu_eval.service.UserService;
import com.babybus.stu_eval.model.User;
import com.babybus.stu_eval.model.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public CommonResult<Boolean> checkLogin(@RequestParam(value = "username") String username,
                                            @RequestParam(value = "password") String password)
    {
        return userService.checkLogin(username, password);
    }

    @GetMapping("/users")
    public List<User> getUserByName(@RequestParam(value = "name") String name) {
        return userService.findUserByName(name);
    }
}
