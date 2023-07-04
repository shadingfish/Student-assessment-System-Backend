package com.babybus.wanglingyu.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Mapper
@Repository
public interface RoleUserMapper {

    @Insert("INSERT INTO role_user (role_id, card_id) VALUES (#{roleId}, #{cardId})) )")
    Integer insertRoleUser(int roleId, String cardId);
//    Integer updateRoleUserByCardId(int roleId, int cardId);
//    Integer deleteRoleUserByCardId(int cardId);

}