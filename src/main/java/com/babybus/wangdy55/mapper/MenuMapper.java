package com.babybus.wangdy55.mapper;

import com.babybus.wangdy55.model.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuMapper {
    List<Menu> getMenuList(Integer roleId);
}
