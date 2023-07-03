package com.babybus.yudingyi.mapper;

import com.babybus.yudingyi.model.DTO.Check;
import com.babybus.yudingyi.model.Practice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PracticeMapper {
    Integer insertPractice(Practice practice); // 插入社会实践记录
    List<Practice> getPracticeList(Integer stuId); // 根据学生ID，获取社会实践记录列表
    Practice getPracticeById(Integer matId); // 根据学生ID和学年，获取一条社会实践记录
    Integer updatePractice(Practice practice); // 根据学生ID更新对应社会实践记录
    Integer deletePracticeById(Integer matId); // 根据学生ID和学年，删除对应社会实践记录
    List<Check> checkPractice(int id);
    int givePracticeScore(@Param("stu_id") int stu_id, @Param("practice_score") int practice_score);
}
