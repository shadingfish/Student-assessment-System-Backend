package com.babybus.yudingyi.service;

import com.babybus.yudingyi.mapper.PracticeMapper;
import com.babybus.yudingyi.model.DTO.Check;
import com.babybus.yudingyi.model.Practice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticeService {
    @Autowired
    private PracticeMapper practiceMapper;

    public Integer insertPractice(Practice practice) {
        return practiceMapper.insertPractice(practice);
    }
    public List<Practice> getPracticeList(Integer stuId) {
        return practiceMapper.getPracticeList(stuId);
    }
    public Practice getPracticeById(Integer matId) {
        return practiceMapper.getPracticeById(matId);
    }
    public Integer updatePractice(Practice practice) {
        return practiceMapper.updatePractice(practice);
    }
    public Integer deletePracticeById(Integer matId) {
        return practiceMapper.deletePracticeById(matId);
    }
    public List<Check> checkPractice(int id){
        return  practiceMapper.checkPractice(id);
    }
    public int givePracticeScore(int stu_id, int research_score){
        return  practiceMapper.givePracticeScore(stu_id, research_score);
    };
}
