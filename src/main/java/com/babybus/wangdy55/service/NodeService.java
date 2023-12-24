package com.babybus.wangdy55.service;

public interface NodeService {
    // 根据学工号 (cardId) 判断用户是否有访问 node 的权限
    Boolean checkNode(String cardId, String path) throws Exception;
}
