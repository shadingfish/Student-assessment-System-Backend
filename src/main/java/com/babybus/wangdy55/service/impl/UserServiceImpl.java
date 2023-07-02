package com.babybus.wangdy55.service.impl;

import com.babybus.wangdy55.service.UserService;
import com.babybus.yudingyi.mapper.UserMapper;
import com.babybus.yudingyi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserByCardId(String cardId) {
        return userMapper.getUserByCardId(cardId);
    }
}
