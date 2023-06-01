package com.babybus.wangdy55.controller;

import com.babybus.common.model.CommonResult;
import com.babybus.wangdy55.service.NodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "结点权限")
@RestController
@RequestMapping("/node")
public class TestNodeController {
    @Autowired
    private NodeService nodeService;

    @ApiOperation("判断用户是否具有所请求结点的权限")
    @GetMapping
    CommonResult<Boolean> checkNode(String cardId, String path) {
        try {
            nodeService.checkNode(cardId, path);
            return CommonResult.success(true, "具有权限");
        } catch (NotFoundException e){
            return CommonResult.error(404, e.getMessage());
        } catch (Exception e) {
            return CommonResult.error(403, e.getMessage());
        }
    }
}
