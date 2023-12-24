package com.babybus.wangdy55.service;

import com.babybus.wangdy55.model.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenuList(Integer roleId);
}
