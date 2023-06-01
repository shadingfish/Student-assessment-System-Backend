package com.babybus.yudingyi.mapper;

import com.babybus.yudingyi.model.User;
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
