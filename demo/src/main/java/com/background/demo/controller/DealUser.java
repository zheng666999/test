package com.background.demo.controller;

import com.background.demo.entity.User;
import com.background.demo.interceptor.UserLoginToken;
import com.background.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class DealUser {
    @Autowired
    UserService us;

    @UserLoginToken
    @RequestMapping("/increase")
    public Object increaseUser(@RequestBody User user, HttpServletResponse response){
        Map m = new HashMap<String, Object>();
        int num = us.selectToatal();
        user.setUser_id(num+2);
        System.out.println(user.getUser_id());
        System.out.println(user.getUsername());
        if(us.insertStudent(user)){
            Map m1 = new HashMap<String, Object>();
            m1.put("msg","创建成功");
            m1.put("status",200);
            m.put("data",null);
            m.put("meta",m1);
            return m;
        }
        return m;
    }

    @UserLoginToken
    @RequestMapping(value="/delete",method = RequestMethod.DELETE)
    public Object deleteUser(@RequestParam(value="user_id") int id, HttpServletResponse response){
        Map m = new HashMap<String, Object>();
        if(us.findUserById(id)!=null){
            User user  = new User();
            user.setUser_id(id);
            if(us.deleteStudent(user)){
                Map m1 = new HashMap<String, Object>();
                m1.put("msg","删除成功");
                m1.put("status",200);
                m.put("data",null);
                m.put("meta",m1);
                return m;
            }
        }
        return m;
    }

    @UserLoginToken
    @RequestMapping(value="/update",method = RequestMethod.PUT)
    public Object updateUser(User user, HttpServletResponse response){
        Map m = new HashMap<String, Object>();
        if(us.findUserById(user.getUser_id())!=null){
            if(user.getActive()!=null){
                if(us.updateActive(user)){
                    Map m1 = new HashMap<String, Object>();
                    m1.put("msg","修改成功");
                    m1.put("status",200);
                    m.put("data",null);
                    m.put("meta",m1);
                    return m;
                }
            }else{
                if(us.updateConf(user)){
                    Map m1 = new HashMap<String, Object>();
                    m1.put("msg","修改成功");
                    m1.put("status",200);
                    m.put("data",null);
                    m.put("meta",m1);
                    return m;
                }
            }
        }
        return m;
    }

}
