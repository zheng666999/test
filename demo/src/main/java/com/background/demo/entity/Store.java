package com.background.demo.entity;

import org.springframework.stereotype.Component;

@Component()
public class Store {
    public int  store_id;
    public int  store_manager_id;
    public String store_phone_num;
    public String store_telephone;
    public String store_name;
    public String store_position;

    public void setStore_phone_num(String store_phone_num) {
        this.store_phone_num = store_phone_num;
    }

    public void setStore_telephone(String store_telephone) {
        this.store_telephone = store_telephone;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public void setStore_position(String store_position) {
        this.store_position = store_position;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String created;
    public String updated;
    public String active;

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public int getStore_manager_id() {
        return store_manager_id;
    }

    public String getStore_phone_num() {
        return store_phone_num;
    }

    public String getStore_telephone() {
        return store_telephone;
    }

    public String getStore_name() {
        return store_name;
    }

    public String getStore_position() {
        return store_position;
    }

    public String getCreated() {
        return created;
    }

    public String getUpdated() {
        return updated;
    }

    public String getActive() {
        return active;
    }
}
