package com.babybus.stu.eval.yudingyi.mapper;

import com.babybus.stu.eval.yudingyi.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    Integer insertUser(User user);
    List<User> getUserList();
    User getUserByCardId(@Param("card_id") String card_id);
}
