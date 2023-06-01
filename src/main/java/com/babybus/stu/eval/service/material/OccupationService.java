package com.babybus.stu.eval.service.material;

import com.babybus.stu.eval.mapper.material.OccupationMapper;
import com.babybus.stu.eval.model.material.Occupation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccupationService {
    @Autowired
    private OccupationMapper occupationMapper;

    public Integer insertOccupation(Occupation occupation) {
        return occupationMapper.insertOccupation(occupation);
    }
    public List<Occupation> getOccupationList(Integer stuId) {
        return occupationMapper.getOccupationList(stuId);
    }
    public Occupation getOccupationById(Integer matId) {
        return occupationMapper.getOccupationById(matId);
    }
    public Integer updateOccupation(Occupation occupation) {
        return occupationMapper.updateOccupation(occupation);
    }
    public Integer deleteOccupationById(Integer matId) {
        return occupationMapper.deleteOccupationById(matId);
    }
}
