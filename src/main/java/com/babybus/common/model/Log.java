package com.babybus.common.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.sql.Timestamp;

@Data
@ApiModel(description = "系统日志")
public class Log {
    private int logId;
    private int userId;
    private Timestamp createTime;
    private String type;
    private String level;
    private String content;

    public Log(int logId, int userId, Timestamp createTime, String type, String level, String content) {
        this.logId = logId;
        this.userId = userId;
        this.createTime = createTime;
        this.type = type;
        this.level = level;
        this.content = content;
    }
}
