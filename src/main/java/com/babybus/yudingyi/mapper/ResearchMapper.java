package com.babybus.yudingyi.mapper;

import com.babybus.yudingyi.model.DTO.Check;
import com.babybus.yudingyi.model.Research;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ResearchMapper {
    int storeResReq(Research research);
    List<Check> checkResearch(int id);
    List<Research> getResearchList(@Param("stu_id") int stu_id);
    int giveResearchScore(@Param("stu_id") int stu_id, @Param("research_score") int research_score);
    int deleteResearch(@Param("id") int id);
    Research getById(@Param("id") int id);
}
