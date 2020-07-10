package com.background.demo.controller;

import com.background.demo.entity.Page;
import com.background.demo.entity.Store;
import com.background.demo.entity.User;
import com.background.demo.interceptor.UserLoginToken;
import com.background.demo.service.StoreService;
import com.background.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class DividePage2 {
    @Autowired
    StoreService ss;

    @UserLoginToken
    @RequestMapping("/dividePage2")
    public Object DividePage(Page page , HttpServletResponse response){
        int num = ss.selectToatal();
        Map m = new HashMap<String, Object>();
        if(page.getQuery()!=null){
            Store store =ss.findStoreById(Integer.valueOf(page.getQuery()));
            if (store!=null){
//                Map m1 = new HashMap<String, Object>();
//                m1.put("users",user);
                Map m1 = new HashMap<String, Object>();
                m1.put("msg","获取成功");
                m1.put("status",200);
                Map m2 = new HashMap<String, Object>();
                System.out.println(num);
                m2.put("total",num);
                m2.put("pagenum",page.getPagenum());
                m2.put("stores",store);
                m.put("data",m2);
                m.put("meta",m1);
                return m;
            }
        }
        else{
            List list = ss.selectByPage(page);
            Map m1 = new HashMap<String, Object>();
            m1.put("msg","获取成功");
            m1.put("status",200);
            Map m2 = new HashMap<String, Object>();
            for(int i=0;i<list.size();i++){
                m2.put(i,list.get(i));
            }
            Map m3 = new HashMap<String, Object>();
            m3.put("total",num);
            m3.put("pagenum",page.getPagenum());
            m3.put("stores",m2);
            m.put("data",m3);
            m.put("meta",m1);
            return m;
        }

        return m;
    }
}
