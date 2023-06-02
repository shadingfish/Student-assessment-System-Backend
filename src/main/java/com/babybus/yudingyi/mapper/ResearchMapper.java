package com.babybus.yudingyi.mapper;

import com.babybus.yudingyi.model.DTO.Research.CheckResearch;
import com.babybus.yudingyi.model.DTO.Research.ReturnResearch;
import com.babybus.yudingyi.model.Research;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ResearchMapper {
    int storeResReq(List<Research> res_list);
    List<CheckResearch> checkResearch();
    List<ReturnResearch> getResearchList(@Param("stu_id") int stu_id);
    int giveResearchScore(@Param("stu_id") int stu_id, @Param("research_score") int research_score);
    int deleteResearch(@Param("mat_id") int mat_id);
    List<Research> retrieveResearch(@Param("stu_id") int stu_id);
}
