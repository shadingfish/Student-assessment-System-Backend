package com.babybus.yudingyi.service;

import com.babybus.yudingyi.mapper.ResearchMapper;
import com.babybus.yudingyi.model.DTO.Research.CheckResearch;
import com.babybus.yudingyi.model.DTO.Research.ReturnResearch;
import com.babybus.yudingyi.model.Research;
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

    public List<Research> getResearchList(int id){
        return  researchMapper.getResearchList(id);
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
