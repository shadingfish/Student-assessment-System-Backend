package com.babybus.common.service.material;

import com.babybus.common.mapper.material.CompetitionMapper;
import com.babybus.common.model.material.Competition;
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
    public List<Competition> getCompetitionListByCardId(String card_id) {
        return competitionMapper.getCompetitionListByCardId(card_id);
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
