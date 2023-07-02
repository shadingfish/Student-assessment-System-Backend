package com.babybus.wangdy55.service.impl;

import com.babybus.wangdy55.mapper.MenuMapper;
import com.babybus.wangdy55.model.Menu;
import com.babybus.wangdy55.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper mapper;

    public List<Menu> getMenuList(Integer roleId) {
        List<Menu> rawList = mapper.getMenuList(roleId);
        List<Menu> resList = new ArrayList<>();
        List<List<Menu>> childrenList = new ArrayList<>();
        Map<String, List<Menu>> parentChildren = new HashMap<>();

        rawList.forEach(menu -> {
            // 若该菜单为一级菜单（组件名为 layout）
            if (menu.getComponent().equals("/layout")) {
                resList.add(menu);
                parentChildren.put(menu.getPath(), new ArrayList<>());
            } else {
                // 为二级菜单，需添加到一级菜单的 children 列表
                String path = menu.getPath();
                int secondSlashIndex = path.indexOf("/", path.indexOf("/") + 1);
                String parentPath = path.substring(0, secondSlashIndex);
                try {
                    List<Menu> children = parentChildren.get(parentPath);
                    children.add(menu);
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        });

        for (int i = 0; i < resList.size(); i++) {
            Menu parent = resList.get(i);
            List<Menu> children = parentChildren.get(parent.getPath());
            parent.setChildren(children);
        }

        return resList;
    }
}
