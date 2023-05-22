package com.babybus.stu.eval.mapper.material;

import com.babybus.stu.eval.model.common.DTO.Research.CheckResearch;
import com.babybus.stu.eval.model.common.DTO.Research.ReturnResearch;
import com.babybus.stu.eval.model.material.Research;
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
