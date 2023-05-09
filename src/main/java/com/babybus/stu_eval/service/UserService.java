package com.babybus.stu_eval.service;

import com.babybus.stu_eval.mapper.UserMapper;
import com.babybus.stu_eval.model.CommonResult;
import com.babybus.stu_eval.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> findUserByName(String name) {
        return userMapper.selectByName(name);
    }

    // 返回登录结果
    public CommonResult<Boolean> checkLogin(String username, String password) {
        User user = userMapper.checkLogin(username, password);
        CommonResult<Boolean> res = new CommonResult<>(false);
        if (user != null) {
            res.setData(true);
        }

        return res;
    }
}
