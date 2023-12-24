package com.babybus.yudingyi.service;

import com.babybus.yudingyi.mapper.ResearchMapper;
import com.babybus.yudingyi.model.DTO.Check;
import com.babybus.yudingyi.model.Research;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResearchService {
    @Autowired
    private ResearchMapper researchMapper;

    public int storeResReq(Research research){
        return researchMapper.storeResReq(research);
    }

    public List<Check> checkResearch(int id){
        return  researchMapper.checkResearch(id);
    }

    public List<Research> getResearchList(int stu_id){
        return  researchMapper.getResearchList(stu_id);
    };

    public int giveResearchScore(int stu_id, int research_score){
        return  researchMapper.giveResearchScore(stu_id, research_score);
    };
    public int deleteResearch(int id){
        return  researchMapper.deleteResearch(id);
    };
    public Research getById(int id) {
        return  researchMapper.getById(id);
    };
}
