package com.background.demo.entity;

import org.springframework.stereotype.Component;

@Component
public class UserRole {
    private int user_id;
    private int role_id;
    private String created;
    private    String    updated;

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public String getCreated() {
        return created;
    }

    public String getUpdated() {
        return updated;
    }
}
