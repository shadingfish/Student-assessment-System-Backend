package com.babybus.stu.eval.service.material;

import com.babybus.stu.eval.mapper.material.ResearchAchieveMapper;
import com.babybus.stu.eval.model.material.ResearchAchieve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResearchAchieveService {
    @Autowired
    private ResearchAchieveMapper researchAchieveMapper;

    public Integer insertResearchAchieve(ResearchAchieve researchAchieve) {
        return researchAchieveMapper.insertResearchAchieve(researchAchieve);
    }
    public List<ResearchAchieve> getResearchAchieveList(Integer stuId) {
        return researchAchieveMapper.getResearchAchieveList(stuId);
    }
    public ResearchAchieve getResearchAchieveById(Integer matId) {
        return researchAchieveMapper.getResearchAchieveById(matId);
    }
    public Integer updateResearchAchieve(ResearchAchieve researchAchieve) {
        return researchAchieveMapper.updateResearchAchieve(researchAchieve);
    }
    public Integer deleteResearchAchieveById(Integer matId) {
        return researchAchieveMapper.deleteResearchAchieveById(matId);
    }
}
