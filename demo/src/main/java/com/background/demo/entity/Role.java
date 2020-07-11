package com.background.demo.entity;

import org.springframework.stereotype.Component;

@Component
public class Role {
    private int role_id;
    private String name;
    private String code;
    private String description;

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRole_id() {
        return role_id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
