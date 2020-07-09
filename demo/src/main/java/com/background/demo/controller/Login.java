package com.background.demo.controller;

import com.background.demo.entity.User;
import com.background.demo.interceptor.UserLoginToken;
import com.background.demo.service.TokenService;
import com.background.demo.service.UserService;
import com.background.demo.util.TokenUtil;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class Login {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    // 登录

    @RequestMapping("/login")
    public Object login(@RequestBody User user, HttpServletResponse response) {
        Map m = new HashMap<String, Object>();
        System.out.println(user.getUserid());
        //User userForBase = user;
        //userForBase.setUser_id(Integer.parseInt(user.getUserid()));
        // System.out.println(userService.login(userForBase));
        User userForBase = userService.login(user);
        System.out.println(userForBase.getUser_id());
        if (userForBase.getUsername()==null) {
            m.put("message", "登录失败,密码错误");
            return m;
        } else {
            String token = tokenService.getToken(user);
            Map m1 = new HashMap<String, Object>();
            m1.put("id",userForBase.getUser_id());
            m1.put("username",userForBase.getUsername());
            m1.put("token",token);
            Map m2 = new HashMap<String, Object>();
            m2.put("msg","登陆成功");
            m2.put("status","200");
            m.put("data",m1);
            m.put("meta",m2);
            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);
            return m;
        }
    }

    /***
     * 这个请求需要验证token才能访问
     * @return String 返回类型
     */
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {

        // 取出token中带的用户id 进行操作
        System.out.println(TokenUtil.getTokenUserId());

        return "你已通过验证";
    }
}
