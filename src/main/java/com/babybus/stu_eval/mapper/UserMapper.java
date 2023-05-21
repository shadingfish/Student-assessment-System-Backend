package com.babybus.stu_eval.mapper;

import com.babybus.stu_eval.model.Export.AllEvalView;
import com.babybus.stu_eval.model.Export.EvalResult;
import com.babybus.stu_eval.model.User;
import com.babybus.stu_eval.model.Research.CheckResearch;
import com.babybus.stu_eval.model.Research.Research;
import com.babybus.stu_eval.model.Research.ReturnResearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
    int deleteResearch(@Param("mat_id") int mat_id);
    List<Research> retrieveResearch(@Param("stu_id") int stu_id);
    List<EvalResult> exportTable(@Param("table_name") String table_name);
    List<AllEvalView> exportView();
}
