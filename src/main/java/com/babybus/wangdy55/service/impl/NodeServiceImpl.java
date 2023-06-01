package com.babybus.wangdy55.service.impl;

import com.babybus.wangdy55.mapper.NodeMapper;
import com.babybus.wangdy55.service.NodeService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeServiceImpl implements NodeService {
    @Autowired
    NodeMapper mapper;



    public Boolean checkNode(String cardId, String path) throws Exception {
        Integer matched = mapper.getNode(path);
        if (matched == 0) {
            throw new NotFoundException("请求路径不存在");
        }
        Boolean permission = mapper.checkNode(cardId, path);
        if (!permission) {
            throw new Exception("权限不足");
        }
        return true;
    }
}
