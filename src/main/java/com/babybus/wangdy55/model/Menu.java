package com.babybus.wangdy55.model;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    String path;
    String name;
    String component;
    List<Menu> children;
}
