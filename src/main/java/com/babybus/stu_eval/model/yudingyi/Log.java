package com.babybus.stu_eval.model.yudingyi;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.sql.Timestamp;

@Data
@ApiModel(description = "系统日志")
public class Log {
    private int log_id;
    private int user_id;
    private java.sql.Timestamp create_time;
    private String type;
    private String level;
    private String content;

    public Log(int log_id, int user_id, Timestamp create_time, String type, String level, String content) {
        this.log_id = log_id;
        this.user_id = user_id;
        this.create_time = create_time;
        this.type = type;
        this.level = level;
        this.content = content;
    }

    public Log(){}
}
