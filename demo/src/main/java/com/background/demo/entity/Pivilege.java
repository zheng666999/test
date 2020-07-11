package com.background.demo.entity;

import org.springframework.stereotype.Component;

@Component
public class Pivilege {
    public int priv_id;
    public String name;
    public String code;
    public String url;
    public int  parent_id;
    public String created;
    public String updated;
    public int is_parent;

    public void setPriv_id(int priv_id) {
        this.priv_id = priv_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public void setIs_parent(int is_parent) {
        this.is_parent = is_parent;
    }

    public int getPriv_id() {
        return priv_id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getUrl() {
        return url;
    }

    public int getParent_id() {
        return parent_id;
    }

    public String getCreated() {
        return created;
    }

    public String getUpdated() {
        return updated;
    }

    public int getIs_parent() {
        return is_parent;
    }
}
