package com.background.demo.controller;

import com.background.demo.entity.Store;
import com.background.demo.interceptor.UserLoginToken;
import com.background.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class DealStore {
    @Autowired
    StoreService ss;

    @UserLoginToken
    @RequestMapping("/insertStore")
    public Object increaseUser(@RequestBody Store store, HttpServletResponse response){
        Map m = new HashMap<String, Object>();
        /*int num = us.selectToatal();
        user.setUser_id(num+2);*/
        System.out.println(store.getStore_id());
        System.out.println(store.getStore_manager_id());
        if(ss.insertStore(store)){
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
    @RequestMapping(value="/deleteStore",method = RequestMethod.DELETE)
    public Object deleteUser(@RequestParam(value="store_id") int id, HttpServletResponse response){
        Map m = new HashMap<String, Object>();
        if(ss.findStoreById(id)!=null){
            Store store =new Store();
            store.setStore_id(id);
            if(ss.deleteStore(store)){
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
    @RequestMapping(value="/updateStore",method = RequestMethod.PUT)
    public Object updateUser(Store store , HttpServletResponse response){
        Map m = new HashMap<String, Object>();
        if(ss.findStoreById(store.getStore_id())!=null){
            if(store.getActive()!=null){
                if(ss.updateActive(store)){
                    Map m1 = new HashMap<String, Object>();
                    m1.put("msg","修改成功");
                    m1.put("status",200);
                    m.put("data",null);
                    m.put("meta",m1);
                    return m;
                }
            }else{
                if(ss.updateConf(store)){
                    Map m1 = new HashMap<String, Object>();
                    System.out.println(store.getStore_id());
                    System.out.println(store.getStore_name());
                    if(ss.updateConf(store)){
                    m1.put("msg","修改成功");
                    m1.put("status",200);
                    m.put("data",null);
                    m.put("meta",m1);
                    return m;}
                }
            }
        }
        return m;
    }

}
