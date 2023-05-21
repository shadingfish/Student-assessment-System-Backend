package com.babybus.stu.eval.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = true)
public class Faculty extends User {
    String depart; // 部门
    String job; // 职位
}
