package com.babybus.stu_eval.mapper;

import com.babybus.stu_eval.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> selectByName(@Param("name") String name);
    User checkLogin(@Param("username") String username, @Param("password") String password);
}
