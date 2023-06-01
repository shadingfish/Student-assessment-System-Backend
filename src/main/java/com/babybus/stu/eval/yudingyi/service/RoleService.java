package com.babybus.stu.eval.yudingyi.service;

import com.babybus.stu.eval.yudingyi.mapper.RoleMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    Integer insertRole(String name) {
        return roleMapper.insertRole(name);
    }
    List<String> getRoleList() {
        return roleMapper.getRoleList();
    }

    String getRoleById(@Param("id") Integer id) {
        return roleMapper.getRoleById(id);
    }

    int getIdByRole(String name) {
        return roleMapper.getIdByRole(name);
    }
}
