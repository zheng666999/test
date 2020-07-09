package com.background.demo.entity;

import org.springframework.stereotype.Component;

@Component()
public class User {
    private int user_id;
    private String userid;
    private String username;
    private String nickname;
    private String password;
    private String gender;
    private String email;
    private String phone;
    private String zip_code;
    private String location;
    private String age;
    private String country;
    private String detail_address;
    private String identity;
    private String active;
    private String code;
    private String updated;
    private String created;
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setZip_dode(String zip_dode) {
        this.zip_code = zip_dode;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDetail_address(String detail_address) {
        this.detail_address = detail_address;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public void setCreated(String created) {
        this.created = created;
    }



    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getPassword() {
        return password;
    }

    public String getCode() {
        return code;
    }

    public String getUsername() {
        return username;
    }

    public String getNickname() {
        return nickname;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getZip_dode() {
        return zip_code;
    }

    public String getLocation() {
        return location;
    }

    public String getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public String getDetail_address() {
        return detail_address;
    }

    public String getIdentity() {
        return identity;
    }

    public String getActive() {
        return active;
    }

    public String getUpdated() {
        return updated;
    }

    public String getCreated() {
        return created;
    }
}
