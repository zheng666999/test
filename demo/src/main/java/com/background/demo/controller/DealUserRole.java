package com.background.demo.controller;

import com.background.demo.entity.UserRole;
import com.background.demo.service.UserRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class DealUserRole {

    @Resource
    UserRoleService urs;
    @Resource
    UserRole ur;

    @RequestMapping("/getRoleFromId")
    public Object getRoleFromId(@RequestParam("user_id") int user_id){
        Map m = new HashMap<String, Object>();
       ur= urs.getUserRole(user_id);
        Map m1 = new HashMap<String, Object>();
        m1.put("msg","查询成功");
        m1.put("status",200);
        Map m2 = new HashMap<String, Object>();
        m2.put("user_id",ur.getUser_id());
        m2.put("role_id",ur.getRole_id());
        m.put("data",m2);
        m.put("meta",m1);
        return m;
    }

    @RequestMapping("/insertRoleAndId")
    public Object insertRoleAndId(@RequestParam("user_id") int user_id,@RequestParam("role_id") int role_id){
        Map m = new HashMap<String, Object>();
        if(urs.insertUserRole(user_id, role_id)>0){
        Map m1 = new HashMap<String, Object>();
        m1.put("msg","查询成功");
        m1.put("status",200);
        m.put("data",null);
        m.put("meta",m1);
        return m;}
        return m;
    }

    @RequestMapping(value="/updateRoleFromId",method = RequestMethod.PUT)
    public Object updateRoleFromId(@RequestParam("user_id") int user_id,@RequestParam("role_id") int role_id){
        Map m = new HashMap<String, Object>();
        if(urs.updateUserRole(user_id, role_id)>0){
        Map m1 = new HashMap<String, Object>();
        m1.put("msg","设置角色成功");
        m1.put("status",200);
        m.put("data",null);
        m.put("meta",m1);
        return m;}
        return m;
    }
}
