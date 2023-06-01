package com.babybus.stu.eval.yudingyi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper {
    Integer insertRole(String name);
    List<String> getRoleList();
    String getRoleById(@Param("id") Integer id);
    int getIdByRole(String name);
}
