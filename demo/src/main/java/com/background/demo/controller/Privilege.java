package com.background.demo.controller;

import com.background.demo.entity.Pivilege;
import com.background.demo.entity.Role;
import com.background.demo.interceptor.UserLoginToken;
import com.background.demo.service.PrivilegeService;
import com.background.demo.util.BasicTree;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class Privilege {

    @Resource
    PrivilegeService ps;

    public Privilege() {
    }
    @UserLoginToken
    @RequestMapping("/allPrivilege")
    public Object backPrivilege(@RequestParam(value = "type") String type){
        System.out.println(type);
        List<Pivilege> list = ps.selectAll();
        Map m = new HashMap<String, Object>();
        if(type.equals("list")){
            System.out.println(type);
            Map m1 = new HashMap<String, Object>();
            m1.put("msg","获取权限列表成功");
            m1.put("status",200);
            Map m2 = new HashMap<String, Object>();
            for(int i=0;i<list.size();i++){
                m2.put(i,list.get(i));
            }
            m.put("data",m2);
            m.put("meta",m1);
            return m;
        }else if(type.equals("tree")){
            List<BasicTree> list2 =new ArrayList() ;
            List<BasicTree> list3=new ArrayList() ;
            for(int i=0;i<list.size();i++){
                BasicTree bt  = new BasicTree();
                bt.createNode(list.get(i));
                list3.add(bt);
                if(list.get(i).is_parent==1) {
                list2.add(bt);}
            }
            for(int i=0;i<list2.size();i++){
                for(int j=0;j<list3.size();j++){
                    if(list3.get(j).data.parent_id==list2.get(i).data.priv_id)
                        list2.get(i).children.add(list3.get(j));
                }
            }
            List<BasicTree> temp = new ArrayList<BasicTree>();
            for (int i = 0; i < list2.size(); i++) {
                if (check(list2.get(i).data.parent_id, list)==false) {
                    temp.add(list2.get(i));
                }
            }
            System.out.println(temp);
            Map m1 = new HashMap<String, Object>();
            m1.put("msg","获取权限列表成功");
            m1.put("status",200);
            m.put("priv_id",temp.get(0).data.parent_id);
            m.put("name",temp.get(0).data.name);
            m.put("code",temp.get(0).data.code);
            m.put("url",temp.get(0).data.url);
            m.put("parent_id",temp.get(0).data.parent_id);
            m.put("created",temp.get(0).data.created);
            m.put("updated",temp.get(0).data.updated);
            m.put("is_parent",temp.get(0).data.is_parent);
            m.put("children",temp.get(0).children);
            m.put("meta",m1);
            return m;
        }
        return m;
    }

    @UserLoginToken
    @RequestMapping("/role")
    public Object role(){
        Map m = new HashMap<String, Object>();
        List<Role> list3=ps.selectRole();
        m.put("data",list3);
        Map m1 = new HashMap<String, Object>();
        m1.put("msg","获取权限列表成功");
        m1.put("status",200);
        m.put("meta",m1);
        return m;
    }
    public boolean check(int id,List<Pivilege> list){

        for(int i=0;i<list.size();i++){
            System.out.println("id "+id+" "+"list "+list.get(i).priv_id);
            if(id==list.get(i).priv_id){
                System.out.println("存在，删除");
                System.out.println("============================================");
                return true;
            }
        }
        return false;
    }
    @UserLoginToken
    @RequestMapping("/userPrivilege")
    public Object userPrivilege() {
        List<Role> list3=ps.selectRole();
        Map m = new HashMap<String, Object>();
        for(int n=0;n<list3.size();n++) {
            List<Pivilege> list4 = null;
            list4=ps.selectRolePri(list3.get(n).getRole_id());
            List<BasicTree> temp = new ArrayList<BasicTree>();
            List<BasicTree> temp2 = new ArrayList<BasicTree>();
            for (int j = 0; j < list4.size(); j++) {
                BasicTree bt = new BasicTree();
                bt.createNode(list4.get(j));
                temp.add(bt);
                if (list4.get(j).is_parent == 1) {
                    temp2.add(bt);
                }
            }
            for (int i = 0; i < temp2.size(); i++) {
                for (int j = 0; j < temp.size(); j++) {
                    if (temp.get(j).data.parent_id == temp2.get(i).data.priv_id) {
                        temp2.get(i).children.add(temp.get(j));
                    }
                }
            }
            List<BasicTree> temp3 = new ArrayList<BasicTree>();
            for (int i = 0; i < temp2.size(); i++) {
                if (!check(temp2.get(i).data.parent_id, list4)) {
                    temp3.add(temp2.get(i));
                }
            }
            Map m2 = new HashMap<String, Object>();
            m2.put("role_id",list3.get(n).getRole_id());
            m2.put("name",list3.get(n).getName());
            m2.put("code",list3.get(n).getCode());
            m2.put("description",list3.get(n).getDescription());
            Map m3 = new HashMap<String, Object>();
            m3.put("data",temp3);
            m2.put("data",m3);
            m.put(n,m2);
        }
        Map m1 = new HashMap<String, Object>();
        m1.put("msg", "获取权限列表成功");
        m1.put("status", 200);

        m.put("meta", m1);
        return m;
     //  return temp;
    }
    @UserLoginToken
    @RequestMapping("/increasePriv")
    public Object increasePriv(@RequestParam("role_id") int role_id,@RequestParam("privilege_id") int privilege_id){
        Map m = new HashMap<String, Object>();
        if(ps.insertPriv(role_id,privilege_id)>0){
            Map m1 = new HashMap<String, Object>();
            m1.put("msg","添加成功");
            m1.put("status",200);
            m.put("data",null);
            m.put("meta",m1);
            return m;
        }
        return m;
    }

    @UserLoginToken
    @RequestMapping(value="/deletePriv",method = RequestMethod.DELETE)
    public Object deletePriv(@RequestParam("role_id") int role_id,@RequestParam("privilege_id") int privilege_id){
        Map m = new HashMap<String, Object>();
        if(ps.deletePriv(role_id,privilege_id)>0){
            Map m1 = new HashMap<String, Object>();
            m1.put("msg","删除成功");
            m1.put("status",200);
            m.put("data",null);
            m.put("meta",m1);
            return m;
        }
        return m;
    }
}
