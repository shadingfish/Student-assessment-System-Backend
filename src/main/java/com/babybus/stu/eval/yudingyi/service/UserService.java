package com.babybus.stu.eval.yudingyi.service;

import com.babybus.stu.eval.yudingyi.mapper.RoleMapper;
import com.babybus.stu.eval.yudingyi.mapper.UserMapper;
import com.babybus.stu.eval.yudingyi.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }
    List<User> getUserList() {
        return userMapper.getUserList();
    }
    User getUserByCardId(@Param("card_id") String card_id) {
        return userMapper.getUserByCardId(card_id);
    }
}
