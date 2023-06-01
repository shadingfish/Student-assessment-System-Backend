package com.babybus.stu.eval.yudingyi.model;


import lombok.Data;

@Data
public class User {
    private int id;
    private String cardId;
    private String password;
    private int roleId;

    public User(int id, String cardId, String password, int roleId) {
        this.id = id;
        this.cardId = cardId;
        this.password = password;
        this.roleId = roleId;
    }

    public User() {
    }
}
