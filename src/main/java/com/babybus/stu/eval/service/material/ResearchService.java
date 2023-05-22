package com.babybus.stu.eval.service.material;

import com.babybus.stu.eval.mapper.material.ResearchMapper;
import com.babybus.stu.eval.model.common.DTO.Research.CheckResearch;
import com.babybus.stu.eval.model.common.DTO.Research.ReturnResearch;
import com.babybus.stu.eval.model.material.Research;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResearchService {
    @Autowired
    private ResearchMapper researchMapper;

    public int storeResReq(List<Research> res_list){
        return researchMapper.storeResReq(res_list);
    }

    public List<CheckResearch> checkResearch(){
        return  researchMapper.checkResearch();
    }

    public List<ReturnResearch> getResearchList(int stu_id){
        return  researchMapper.getResearchList(stu_id);
    };

    public int giveResearchScore(int stu_id, int research_score){
        return  researchMapper.giveResearchScore(stu_id, research_score);
    };

    public int deleteResearch(int mat_id){
        return  researchMapper.deleteResearch(mat_id);
    };

    public List<Research> retrieveResearch(int stu_id){
        return  researchMapper.retrieveResearch(stu_id);
    };
}
