package com.background.demo.controller;

import com.background.demo.entity.Page;
import com.background.demo.entity.User;
import com.background.demo.interceptor.UserLoginToken;
import com.background.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class DividePage {
    @Autowired
    UserService us;

    @UserLoginToken
    @RequestMapping("/dividePage")
    public Object DividePage(Page page , HttpServletResponse response){
        Map m = new HashMap<String, Object>();
        if(page.getQuery()!=null){
            User user =us.findUserById(Integer.valueOf(page.getQuery()));
            if (user!=null){
//                Map m1 = new HashMap<String, Object>();
//                m1.put("users",user);
                Map m1 = new HashMap<String, Object>();
                m1.put("msg","获取成功");
                m1.put("status",200);
                Map m2 = new HashMap<String, Object>();
                m2.put("total",1);
                m2.put("pagenum",0);
                m2.put("users",user);
                m.put("data",m2);
                m.put("meta",m1);
                return m;
            }
        }
        else{
            List list = us.selectByPage(page);
            Map m1 = new HashMap<String, Object>();
            m1.put("msg","获取成功");
            m1.put("status",200);
            Map m2 = new HashMap<String, Object>();
            for(int i=0;i<list.size();i++){
                m2.put(i,list.get(i));
            }
            Map m3 = new HashMap<String, Object>();
            m3.put("total",1);
            m3.put("pagenum",0);
            m3.put("users",m2);
            m.put("data",m3);
            m.put("meta",m1);
            return m;
        }

        return m;
    }
}
