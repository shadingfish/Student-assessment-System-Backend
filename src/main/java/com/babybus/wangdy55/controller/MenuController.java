package com.babybus.wangdy55.controller;

import com.babybus.common.model.CommonResult;
import com.babybus.wangdy55.model.Menu;
import com.babybus.wangdy55.service.MenuService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "前端菜单")
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService service;

    @GetMapping
    public CommonResult<List<Menu>> getMenuList(Integer roleId) {
        List<Menu> list = service.getMenuList(roleId);

        return CommonResult.success(list, "获取成功");
    }
}
