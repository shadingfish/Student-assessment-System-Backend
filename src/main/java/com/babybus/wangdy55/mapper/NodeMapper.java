package com.babybus.wangdy55.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface NodeMapper {
    Integer getNode(String path);
    Boolean checkNode(String cardId, String path);
}
