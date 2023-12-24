package com.babybus.wangdy55.controller;

import com.babybus.common.model.CommonResult;
import com.babybus.wangdy55.model.Menu;
import com.babybus.wangdy55.service.MenuService;
import com.babybus.wangdy55.service.UserService;
import com.babybus.yudingyi.model.User;
import com.babybus.yudingyi.util.JwtTokenUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "前端菜单")
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService service;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping
    public CommonResult<List<Menu>> getMenuList(@RequestHeader("Authorization") String accessToken) {
        String cardId = jwtTokenUtil.getUsernameFromToken(accessToken);
        User user = userService.getUserByCardId(cardId);
        List<Menu> list = service.getMenuList(user.getRoleId());
        return CommonResult.success(list, "获取成功");
    }
}
