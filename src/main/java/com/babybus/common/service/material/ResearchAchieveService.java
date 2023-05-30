package com.babybus.common.service.material;

import com.babybus.common.mapper.material.ResearchAchieveMapper;
import com.babybus.common.model.material.ResearchAchieve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResearchAchieveService {
    @Autowired
    private ResearchAchieveMapper researchAchieveMapper;

    public Integer insertResearchAchieve(ResearchAchieve research) {
        return researchAchieveMapper.insertResearchAchieve(research);
    }
    public List<ResearchAchieve> getResearchAchieveList(Integer stuId) {
        return researchAchieveMapper.getResearchAchieveList(stuId);
    }
    public ResearchAchieve getResearchAchieveById(Integer matId) {
        return researchAchieveMapper.getResearchAchieveById(matId);
    }
    public Integer updateResearchAchieve(ResearchAchieve research) {
        return researchAchieveMapper.updateResearchAchieve(research);
    }
    public Integer deleteResearchAchieveById(Integer matId) {
        return researchAchieveMapper.deleteResearchAchieveById(matId);
    }
}
