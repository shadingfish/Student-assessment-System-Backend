package com.babybus.common.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class Faculty extends BaseUser {
    String depart; // 部门
    String job; // 职位

    public Faculty(int id, String cardId, String name, String role, int roleId, String password, String status, Date birthday, String gender, String phone, String email, String depart, String job) {
        super(id, cardId, name, role, roleId, password, status, birthday, gender, phone, email);
        this.depart = depart;
        this.job = job;
    }

    public Faculty() {
    }
}
