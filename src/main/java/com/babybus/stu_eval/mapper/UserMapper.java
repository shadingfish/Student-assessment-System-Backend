package com.babybus.stu_eval.mapper;

import com.babybus.stu_eval.model.User;
import com.babybus.stu_eval.model.yudingyi.CheckResearch;
import com.babybus.stu_eval.model.yudingyi.Research;
import com.babybus.stu_eval.model.yudingyi.ReturnResearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> selectByName(@Param("name") String name);
    User checkLogin(@Param("username") String username, @Param("password") String password);
    int storeResReq(List<Research> res_list);
    List<CheckResearch> checkResearch();
    List<ReturnResearch> getResearchList(@Param("stu_id") int stu_id);
    int giveResearchScore(@Param("stu_id") int stu_id, @Param("research_score") int research_score);
}
