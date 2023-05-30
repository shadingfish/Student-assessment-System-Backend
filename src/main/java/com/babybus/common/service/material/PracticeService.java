package com.babybus.common.service.material;

import com.babybus.common.mapper.material.PracticeMapper;
import com.babybus.common.model.material.Practice;
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
}
