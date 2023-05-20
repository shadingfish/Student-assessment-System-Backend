package com.babybus.stu_eval.service;

import com.babybus.stu_eval.mapper.UserMapper;
import com.babybus.stu_eval.model.CommonResult;
import com.babybus.stu_eval.model.User;
import com.babybus.stu_eval.model.yudingyi.CheckResearch;
import com.babybus.stu_eval.model.yudingyi.Research;
import com.babybus.stu_eval.model.yudingyi.ReturnResearch;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> findUserByName(String name) {
        return userMapper.selectByName(name);
    }

    // 返回登录结果
    public CommonResult<Boolean> checkLogin(String username, String password) {
        User user = userMapper.checkLogin(username, password);
        CommonResult<Boolean> res = new CommonResult<>(false);
        if (user != null) {
            res.setData(true);
        }

        return res;
    }
    public int storeResReq(List<Research> res_list){
        return userMapper.storeResReq(res_list);
    }

    public List<CheckResearch> checkResearch(){
        return  userMapper.checkResearch();
    }

    public List<ReturnResearch> getResearchList(int stu_id){
        return  userMapper.getResearchList(stu_id);
    };

    public int giveResearchScore(int stu_id, int research_score){
        return  userMapper.giveResearchScore(stu_id, research_score);
    };
}
