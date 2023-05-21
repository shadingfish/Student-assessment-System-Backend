package com.babybus.stu.eval.service.material;

import com.babybus.stu.eval.mapper.material.CompetitionMapper;
import com.babybus.stu.eval.model.material.Competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService {
    @Autowired
    private CompetitionMapper competitionMapper;

    public Integer insertCompetition(Competition competition) {
        return competitionMapper.insertCompetition(competition);
    }
    public List<Competition> getCompetitionList(Integer stuId) {
        return competitionMapper.getCompetitionList(stuId);
    }
    public Competition getCompetitionById(Integer matId) {
        return competitionMapper.getCompetitionById(matId);
    }
    public Integer updateCompetition(Competition competition) {
        return competitionMapper.updateCompetition(competition);
    }
    public Integer deleteCompetitionById(Integer matId) {
        return competitionMapper.deleteCompetitionById(matId);
    }
}
